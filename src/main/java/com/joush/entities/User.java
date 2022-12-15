package com.joush.entities;

import lombok.Data;

/**
 * @author Rex Joush
 * @time 2022.12.03
 */
@Data
public class User {

    private int id;             // id

    private String username;    // 登录用户名

    private String password;    // 密码

    private String name;        // 用户名

    private String createTime;  // 创建时间

    private String updateTime;  // 更新时间

    private int status;         // 可用状态

    // 状态有效
    public static final int ENABLE = 1;

    // 状态无效
    public static final int DISABLE = 0;

}
