package com.iotat.infoscreen.mapper;

import com.iotat.infoscreen.entity.Award;
import com.iotat.infoscreen.entity.LabComment;
import com.iotat.infoscreen.entity.Member;
import com.iotat.infoscreen.entity.Project;

import java.util.ArrayList;

/**
 * @Description 实验室界面接口
 * @ClassName LabMapper
 * @Author Jean
 * @date 2020.01.07 16:23
 */
public interface LabMapper {

    /**
     * 获取所有成员信息
     *
     * @return 成员列表
     */
    ArrayList<Member> selectAllMember();

    /**
     * 获取所有评论
     *
     * @return 评论列表
     */
    ArrayList<LabComment> selectAllComment();

    /**
     * 获取所有项目
     *
     * @return 项目列表
     */
    ArrayList<Project> selectAllProj();

    /**
     * 获取所有奖项
     *
     * @return 奖项列表
     */
    ArrayList<Award> selectAllAward();

    /**
     * 添加评论
     *
     * @param comment
     * @return 添加成功返回1
     */
    int addComment(LabComment comment);

}