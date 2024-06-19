package com.example.back.controller;

import com.example.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    //    @GetMapping 获取
//    @PostMapping 添加
//    @PutMapping 更新
//    @DeleteMapping 删除
    @Autowired
    UserService userService;

//    @GetMapping("/login")
//    public String login(String username, String password) {
//        String loginRe = userService.checkToken();
//        return "登陆" + loginRe;
//    }

}
