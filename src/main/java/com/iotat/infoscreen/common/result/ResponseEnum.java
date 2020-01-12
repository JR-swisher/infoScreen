package com.iotat.infoscreen.common.result;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ResponseEnum
 * @Package com.pang.mall.common.restful
 * @description: 统一返回包装的枚举对象
 * @date 2019/11/11 21:28
 */
public enum ResponseEnum {
    SUCCESS_OPTION(200, "操作成功", true),
    LOGIN_SUCCESS(200, "登录成功", true),
    REGISTER_SUCCESS(200, "注册成功", true),
    BAD_REQUEST(400, "参数错误", false),
    ILLEGAL_ARGUMENT(400, "参数不合法",false),
    NOT_MATCH(401, "账号密码不匹配符", false),
    NO_USER_EXIST(404, "用户不存在",false),
    REPEAT_USER(403, "用户名重复", false),
    REPEAT_STU_ID(403, "学号已经注册",false),
    NOT_LOGIN(401, "没有认证信息", false),
    SYSTEM_ERROR(500, "未知服务器系统异常", false);


    private int code;

    private String message;

    private boolean success;

    ResponseEnum(int code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
