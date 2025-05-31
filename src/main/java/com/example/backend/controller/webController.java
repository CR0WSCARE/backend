package com.example.backend.controller;

import cn.hutool.core.util.StrUtil;
import com.example.backend.common.Result;
import com.example.backend.pojo.user;
import com.example.backend.service.userService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class webController {
    @Resource
    userService userService;

    @GetMapping("/")
    public Result hello() {
        // 返回欢迎信息
        return Result.success("Hello World");
    }

    @PostMapping("/adminLogin/adminLogin") // 管理员登录接口
    public Result login(@RequestBody user user) {
        if (StrUtil.isBlank(user.getUsername()) || StrUtil.isBlank(user.getPassword())) {
            return Result.error("-1", "用户名或密码不能为空");
        }
        user = userService.login(user);
        return Result.success(user);
    }
}
