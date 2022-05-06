package com.zhy.takeoutcabinet.controller.uniapp;


import com.zhy.takeoutcabinet.entity.User;
import com.zhy.takeoutcabinet.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/uni")
public class UniUserController {
    @Resource
    UserService userService;
    @GetMapping("/user")
    public User getUserInfo() {
        return userService.findById(1);
    }
}
