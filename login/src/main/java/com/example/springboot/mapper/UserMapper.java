package com.example.springboot.mapper;


        import com.example.springboot.bean.User;
        import org.apache.ibatis.annotations.*;
        import org.springframework.stereotype.Repository;


@Mapper//标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface UserMapper {


    @Select(value = "select u.username,u.password from user as u where u.username=#{username}")
    @Results
            ({@Result(property = "username",column = "username"),
                    @Result(property = "password",column = "password")})
    User findUserByName(@Param("username") String username);


    @Insert("insert into user values(#{id},#{username},#{password})")
    //加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true,keyProperty = "id" ,keyColumn = "id")
    void regist(User user);


    @Select("select u.id from user u where u.username = #{username} and password = #{password}")
    Long login(User user);
}
