package com.joush.controller;

import com.joush.entities.display.Progress;
import com.joush.service.StatisticsService;
import com.joush.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Rex Joush
 * @time 2022.12.04
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Resource
    private StatisticsService statisticsService;

    @GetMapping("/initMyGraph")
    public String initMyGraph(HttpServletRequest request) {
        String username = request.getHeader("token");
        Map<String, Object> init = statisticsService.init(username);
        Progress progress = statisticsService.getDeadlineAndTarget(username);
        init.put("deadline", progress.getDeadline());
        init.put("target", progress.getTarget());
        return Result.ok("获取成功!", init);
    }

    @GetMapping("/updateTarget")
    public String updateTarget(@RequestParam("target") int target,
                               HttpServletRequest request) {
        String username = request.getHeader("token");

        boolean res = statisticsService.updateTarget(username, target);
        if (res) {
            return Result.ok("更新成功!");
        } else {
            return Result.error("更新失败!");
        }
    }

    @GetMapping("/updateDeadline")
    public String updateDeadline(@RequestParam("deadline") String deadline,
                                 HttpServletRequest request) {
        String username = request.getHeader("token");
        boolean res = statisticsService.updateDeadline(username, deadline);
        if (res) {
            return Result.ok("更新成功!");
        } else {
            return Result.error("更新失败!");
        }
    }
}
