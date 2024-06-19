package com.example.back.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.example.back.entity.Book;
import com.example.back.entity.User;
import com.example.back.mapper.UserMapper;
import com.example.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ValueConstants;

import java.util.concurrent.TimeUnit;

@RestController
public class redisController {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;

    @GetMapping("/text")
    public void test(){
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        ops.set("name","nihao");
        String name = ops.get("name");

        System.out.println(name);

        ValueOperations ops1 = redisTemplate.opsForValue();
        Book b1 = new Book();
        b1.setName("zhang");
        b1.setBookId(1);
        b1.setPrice(12.4);
        b1.setPress("zhang");
        b1.setAuthor("zhang");
        Book book = (Book) ops1.get("b1");

        System.out.println(book);
    }

    @GetMapping("/login")
    public String login(String username,String password){
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        User user = userMapper.getUserByName(username);
        if(user != null && user.getPassword().equals(password)){
            String token = user.getUsername();
            String userJSONStrin = JSON.toJSONString(user);
            System.out.println(user);
            ops.set(token,userJSONStrin,5, TimeUnit.MINUTES);
            System.out.println(token);
            return token;
        }
        return "no login";
    }

    @GetMapping("/checkToken")
    public String check(String token){
        return JSON.toJSONString(userService.checkToken(token));
    }
}
