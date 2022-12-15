package com.joush.controller;

import com.joush.service.UserService;
import com.joush.entities.User;
import com.joush.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Rex Joush
 * @time 2022.12.03
 */

@CrossOrigin
@RestController
public class UserController {

    @Resource
    private UserService userService;

    // 获取token信息
    @PostMapping("/user/login")
    public String login(@RequestBody Map<String, String> map) {
        // 获取到登录名
        String username = map.get("username");
        User user = userService.checkLogin(username, map.get("password"));
        if (user == null) {
            return Result.error("用户名或密码错误，或账号停用！");
        } else {
            return Result.ok("登录成功", Map.of("token", username));
        }
    }

    // 获取个人信息
    @GetMapping("/user/info")
    public String info(@RequestParam("token") String token, HttpServletRequest request) {
        return Result.ok("token", token);
    }

    @PostMapping("/user/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return Result.ok();
    }

    @PostMapping("/user/register")
    public String register(@RequestBody Map<String, String> map) {
        System.out.println(map);
        int register = userService.register(map.get("name"), map.get("username"), map.get("password1"));
        if (register > 0) {
            return Result.ok("注册成功");
        } else if (register == 0) {
            return Result.info("账户已经存在");
        } else {
            return Result.error("注册失败");
        }
    }

}
