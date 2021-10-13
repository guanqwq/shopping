package org.guanqwq.springbootshopping.mapper;

import org.apache.ibatis.annotations.*;
import org.guanqwq.springbootshopping.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Results(id = "user_field_mapper",
            value = {
                @Result(column = "id", property = "userID", id = true),
                @Result(column = "name", property = "userName"),
                @Result(column = "role", property = "userRole"),
                @Result(column = "password", property = "userPassword"),
                @Result(column = "balance", property = "userBalance")
    })
    @Select("<script>" +
            "Select * FROM user WHERE name=#{name}" +
            "<if test=\"pwd!=null\"> AND password=#{pwd} </if>" +
            "</script>")
    User getUser(@Param("name") String username, @Param("pwd") String password);

    @ResultMap("user_field_mapper")
    @Select("SELECT * FROM user WHERE id=#{id}")
    User getUserByID(Integer id);

    @ResultMap("user_field_mapper")
    @Select("SELECT * FROM user")
    List<User> getAllUsers();
}
