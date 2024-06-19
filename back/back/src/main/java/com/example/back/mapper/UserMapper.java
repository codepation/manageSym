package com.example.back.mapper;

import com.example.back.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User getUserByName(String username);

    @Select("select * from user where password=#{password}")
    User getUserByPass(String password);

}
