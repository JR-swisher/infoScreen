package com.iotat.infoscreen.service;

import com.iotat.infoscreen.entity.Member;
import com.iotat.infoscreen.entity.StuComment;
import org.springframework.stereotype.Service;

/**
 * @Description 成员接口逻辑
 * @ClassName MemberService
 * @Author Jean
 * @date 2020.01.09 23:22
 */
@Service
public class MemberService {

    /**
     * 成员信息完善
     *
     * @param member
     * @return 注册成功返回true，失败抛出异常
     */
    public Boolean register(Member member) {
        return null;
    }

    /**
     * 更新成员信息
     *
     * @param member
     * @return 修改成功返回true
     */
    public Boolean updateMember(Member member) {
        return null;
    }

    /**
     * 发表评论
     *
     * @param comment
     * @return 发表成功返回true
     */
    public Boolean postComment(StuComment comment) {
        return null;
    }

}
