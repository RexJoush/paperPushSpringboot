package com.joush.service;

import com.joush.entities.Record;
import com.joush.mapper.RecordMapper;
import com.joush.util.TimeUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Rex Joush
 * @time 2022.12.04
 */
@Service
public class RecordService {

    @Resource
    private RecordMapper recordMapper;

    public List<Record> getRecordsByUserName(String username) {
        return recordMapper.listRecordsByUserName(username);
    }

    public List<Record> list(String username, int pageNo, int pageSize) {
        int limit = (pageNo - 1) * pageSize;
        return recordMapper.list(username, limit, pageSize);
    }

    public int add(String username, int words) {
        String date = TimeUtils.sdfCreate.format(new Date());
        Record record = recordMapper.getRecordByDate(username, date);
        if (record != null) {
            return 0;
        }
        return recordMapper.add(username, words, date);
    }

    public boolean edit(int id, int words) {
        int res = recordMapper.edit(id, words);
        return res > 0;
    }

    public boolean del(int id) {
        int res = recordMapper.del(id);
        return res > 0;
    }

    public int count(String username) {
        return recordMapper.count(username);
    }
}
