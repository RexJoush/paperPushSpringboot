package com.joush.service;

import com.joush.entities.Record;
import com.joush.entities.display.Progress;
import com.joush.mapper.DisplayMapper;
import com.joush.mapper.RecordMapper;
import com.joush.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rex Joush
 * @time 2022.12.04
 */
@Service
public class StatisticsService {

    @Resource
    private RecordMapper recordMapper;

    @Resource
    private DisplayMapper displayMapper;

    @Resource
    private UserMapper userMapper;

    public Map<String, Object> init(String username) {
        List<Record> records = recordMapper.listRecordsByUserName(username);
        List<String> xAxis = new ArrayList<>();
        List<Integer> series = new ArrayList<>();
        for (Record record : records) {
            xAxis.add(record.getDate());
            series.add(record.getWords());
        }
        Map<String, Object> res = new HashMap<>();
        res.put("series", series);
        res.put("xAxis", xAxis);
        return res;
    }

    public Progress getDeadlineAndTarget(String username) {
        return userMapper.getDeadlineAndTarget(username);
    }

    public boolean updateTarget(String username, int target) {
        int res = userMapper.updateTarget(username, target);
        return res > 0;
    }

    public boolean updateDeadline(String username, String deadline) {
        int res = userMapper.updateDeadline(username, deadline);
        return res > 0;
    }
}
