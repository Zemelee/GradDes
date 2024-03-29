package com.example.mall.service;

import com.example.mall.entity.User;
import com.example.mall.entity.UserFeedback;
import com.example.mall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //用户登录
    public User userLogin(String name, String pwd) {
        return userMapper.userLogin(name, pwd);
    }

    public void registerUser(User user) {
        userMapper.registerUser(user);
    }

    public boolean validateUser(String name, String pwd) {
        User user = userMapper.getUserByName(name);
        // 如果找不到用户或者密码不匹配，返回 false
        return user != null && user.getPassword().equals(pwd);
    }

    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public float recharge(int id, float amount) {
        return userMapper.recharge(id, amount);
    }

    public void addFeedback(UserFeedback userFeedback) {
        userMapper.addFeedback(userFeedback);
    }

    public List<UserFeedback> getFeedback() {

        return userMapper.getFeedback();
    }


}
