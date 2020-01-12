package com.iotat.infoscreen.mapper;

import com.iotat.infoscreen.entity.User;

/**
 * @Description 普通用户接口
 * @ClassName UserMapper
 * @Author Jean
 * @date 2020.01.07 16:20
 */
public interface UserMapper {

    /**
     * 根据用户名查找用户
     *
     * @param userName
     * @return 用户信息
     */
    User selectUserByUserName(String userName);

    /**
     * 添加用户
     *
     * @param user
     * @return 添加成功返回1
     */
    int addUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return 修改成功返回1
     */
    int updateUser(User user);

}
