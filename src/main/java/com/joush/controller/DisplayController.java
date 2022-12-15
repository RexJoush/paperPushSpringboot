package com.joush.controller;

import com.joush.service.DisplayService;
import com.joush.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Rex Joush
 * @time 2022.12.04
 */
@RestController
@RequestMapping("/display")
public class DisplayController {

    @Resource
    private DisplayService displayService;

    @GetMapping("/init")
    public String init() {
        Map<String, Object> init = displayService.init();
        return Result.ok("获取成功", init);
    }

}
