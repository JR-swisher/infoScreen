package com.iotat.infoscreen.mapper;

import com.iotat.infoscreen.entity.Member;
import com.iotat.infoscreen.entity.StuComment;

import java.util.ArrayList;
import java.util.Map;

/**
 * @Description 成员信息接口
 * @ClassName MemberMapper
 * @Author Jean
 * @date 2020.01.07 16:23
 */
public interface MemberMapper {

    /**
     * 根据成员ID查找成员信息和对应的项目和奖项
     *
     * @param memberId
     * @return 成员信息和项目及奖项
     */
    Map<String, Object> selectMemberById(long memberId);

    /**
     * 更新成员信息
     *
     * @param member
     * @return 修改成功返回1
     */
    int updateMember(Member member);

    /**
     * 获取所有评论
     *
     * @param receiver
     * @return 评论列表
     */
    ArrayList<StuComment> selectCommentByReceiver(String receiver);

    /**
     * 添加评论
     *
     * @param comment
     * @return 添加成功返回1
     */
    int addComment(StuComment comment);

    /**
     * 添加成员信息
     *
     * @param member
     * @return 添加成功返回1
     */
    int addMember(Member member);

}
