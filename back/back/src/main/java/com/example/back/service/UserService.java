package com.example.back.service;

import com.alibaba.fastjson.JSON;
import com.example.back.entity.User;
import com.example.back.mapper.UserMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONFilter;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public User checkToken(String token){
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        if (token != null){
            String userJSONString = ops.get(token);
            return JSON.parseObject(userJSONString,User.class);
        }
        return null;
    }


}
