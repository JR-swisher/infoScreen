package com.iotat.infoscreen.component;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.iotat.infoscreen.common.result.ResponseEnum;
import com.iotat.infoscreen.exception.UserActionException;
import com.iotat.infoscreen.util.token.Token;
import com.iotat.infoscreen.util.token.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description Token拦截器
 * @ClassName TokenInterceptor
 * @Author pang
 * @date 2020.01.10 20:29
 */
@Component
@Order
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RedisTool redis;
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LOGGER.debug("拦截到请求,requestPath={}", request.getRequestURI());
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Token token = handlerMethod.getMethodAnnotation(Token.class);
        // 如果不存在token注解，则通过认证
        if (token == null) {
            LOGGER.debug("拦截到的请求方法上不包含token注解，执行请求");
            return super.preHandle(request, response, handler);
        }
        // 如果存在token注解，则需要认证
        // 从Cookie中取出token
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            LOGGER.debug("无认证信息,requestPath={}", request.getRequestURI());
            throw new UserActionException("无认证信息", ResponseEnum.NOT_LOGIN);
        }
        Map<String, String> cookieMap = new HashMap<>();
        for (Cookie cookie : cookies) {
            cookieMap.put(cookie.getName(), cookie.getValue());
        }
        LOGGER.debug("将cookie保存为一个map,CookieMap={}", cookieMap);
        String tokenStr = cookieMap.get("token");
        LOGGER.debug("拦截到的请求方法上包含token，进行验证,token={}", tokenStr);
        if (tokenStr == null || tokenStr.isEmpty()) {
            LOGGER.debug("无认证信息,requestPath={}", request.getRequestURI());
            throw new UserActionException("无认证信息", ResponseEnum.NOT_LOGIN);
        }
        // 从redis中取出token
        Map<String, Object> info = null;
        try {
            info = redis.getHash(tokenStr);
        } catch (Exception e) {
            LOGGER.error("出错", e);
        }
        if (info != null && !info.isEmpty()) {
            request.setAttribute(String.valueOf(info.get("authorization")), info.get("value"));
            LOGGER.debug("redis中存在token，认证通过,attribute={},value={}", info.get("authorization"), info.get("value"));
            return super.preHandle(request, response, handler);
        }
        LOGGER.debug("redis中未找到token信息，尝试解析token={}", tokenStr);
        // 开始认证，如果认证出错，则直接抛出异常
        DecodedJWT decodedJWT = TokenUtil.parseJWT(tokenStr);
        // 认证通过，将token内保存的信息添加到请求中
        request.setAttribute(decodedJWT.getSubject(), decodedJWT.getAudience());
        LOGGER.debug("token认证通过,attribute={},value={}", decodedJWT.getSubject(), decodedJWT.getAudience());
        // 这里将token保存到redis中，提高后续性能
        redis.setHash(tokenStr, "authorization", decodedJWT.getSubject());
        redis.setHash(tokenStr, "value", decodedJWT.getAudience());
        long ttl = decodedJWT.getExpiresAt().getTime() - decodedJWT.getIssuedAt().getTime();
        redis.expire(tokenStr, ttl);
        LOGGER.debug("将token添加到redis中，token={},attribute={},value={},ttl={}", tokenStr, decodedJWT.getSubject(),
                decodedJWT.getAudience(), ttl);
        // 执行正常的操作
        return super.preHandle(request, response, handler);
    }
}
