package com.joush.controller;

import com.joush.entities.Record;
import com.joush.service.RecordService;
import com.joush.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Rex Joush
 * @time 2022.12.04
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Resource
    private RecordService recordService;

    @GetMapping("/list")
    public String listRecord(@RequestParam("pageNo") int pageNo,
                             @RequestParam("pageSize") int pageSize,
                             HttpServletRequest request) {

        String username = request.getHeader("token");
        List<Record> records = recordService.list(username, pageNo, pageSize);
        int total = recordService.count(username);
        return Result.ok("获取成功!", Map.of("records", records, "total", total));
    }

    @GetMapping("/add")
    public String addRecord(@RequestParam("words") int words,
                            HttpServletRequest request) {

        String username = request.getHeader("token");
        int res = recordService.add(username, words);
        if (res > 0) {
            return Result.ok("添加成功!");
        } else if (res == 0) {
            return Result.info("今天已经添加过，请明天再添加！");
        } else {
            return Result.error("添加失败!");
        }
    }

    @GetMapping("/edit")
    public String editRecord(@RequestParam("id") int id,
                            @RequestParam("words") int words) {

        boolean res = recordService.edit(id, words);
        if (res) {
            return Result.ok("编辑成功!");
        } else {
            return Result.error("编辑失败!");
        }
    }

    @GetMapping("/del")
    public String delRecord(@RequestParam("id") int id) {

        boolean res = recordService.del(id);
        if (res) {
            return Result.ok("删除成功!");
        } else {
            return Result.error("删除失败!");
        }
    }
}
