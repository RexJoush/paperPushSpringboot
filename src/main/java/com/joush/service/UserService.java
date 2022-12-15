package com.joush.service;

import com.joush.entities.User;
import com.joush.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * @author Rex Joush
 * @time 2022.12.03
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User checkLogin(String username, String password) {
        String hex = DigestUtils.md5DigestAsHex(password.getBytes());
        return userMapper.checkLogin(username, hex, User.ENABLE);
    }

    /**
     * 注册用户
     * @param name 姓名
     * @param username 用户名
     * @param password 密码
     * @return 注册结果
     */
    public int register(String name, String username, String password) {
        User user = userMapper.getUserByUsername(username);
        if (user != null) {
            return 0;
        }
        String hex = DigestUtils.md5DigestAsHex(password.getBytes());
        return userMapper.register(name, username, hex, User.ENABLE);
    }

}
