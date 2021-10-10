package org.guanqwq.springbootshopping.mapper;

import org.apache.ibatis.annotations.*;
import org.guanqwq.springbootshopping.entity.User;

@Mapper
public interface UserMapper {

    @Results(id = "user",
            value = {
                @Result(column = "id", property = "userID", id = true),
                @Result(column = "name", property = "userName"),
                @Result(column = "role", property = "userRole"),
                @Result(column = "password", property = "userPassword"),
                @Result(column = "balance", property = "userBalance")
    })
    // @Select("Select * FROM user WHERE name=#{name} and password=#{pwd}")
    @Select("<script>" +
            "Select * FROM user WHERE name=#{name}" +
            "<if test=\"pwd!=null\"> AND password=#{pwd} </if>" +
            "</script>")
    User getUser(@Param("name") String username, @Param("pwd") String password);
}
