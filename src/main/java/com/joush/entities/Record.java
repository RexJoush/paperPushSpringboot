package com.joush.entities;

import lombok.Data;

/**
 * @author Rex Joush
 * @time 2022.12.03
 */
@Data
public class Record {

    private int id;             // 记录 id

    private String username;    // 用户名

    private String name;        // 姓名

    private int words;          // 字数

    private String createTime;  // 创建时间

    private String updateTime;  // 更新时间

    private String date;        // 创建的日期

}
