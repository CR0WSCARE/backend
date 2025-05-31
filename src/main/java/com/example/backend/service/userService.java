package com.example.backend.service;

import com.example.backend.exception.serviceException;
import com.example.backend.mapper.userMapper;
import com.example.backend.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    userMapper userMapper;

    // 用户登录验证方法
    public boolean authenticate(String username, String password) {
        // 这里可以添加实际的用户验证逻辑，比如查询数据库等
        // 目前仅为示例，假设用户名为"admin"，密码为"password"
        return "user".equals(username) && "password".equals(password);
    }

    // 登录方法，返回用户信息
    public user login(user user) {
        user dbuser = userMapper.selectByName(user.getUsername());
        if (dbuser == null) {
            //抛出自定义异常
            throw new serviceException("用户名或密码错误");
        }
        if (!dbuser.getPassword().equals(user.getPassword())) {
            //抛出自定义异常
            throw new serviceException("用户名或密码错误");
        }
        return dbuser;
    }
}
