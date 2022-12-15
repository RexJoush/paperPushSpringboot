package com.joush.service;

import com.joush.entities.Record;
import com.joush.entities.display.Series;
import com.joush.mapper.RecordMapper;
import com.joush.util.TimeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author Rex Joush
 * @time 2022.12.04
 */
@Service
public class DisplayService {

    @Resource
    private RecordMapper recordMapper;

    public Map<String, Object> init() {
        // 获取近一周的时间值
        String recentWeek = TimeUtils.getRecentWeek();

        // 获取近一周的数据情况
        List<Record> records = recordMapper.listRecordNoPage();

        // x 轴的列表，名字
        Set<String> names = new HashSet<>();
        for (Record record : records) {
            names.add(record.getName());
        }
        List<List<Object>> series = new ArrayList<>();
        series.add(List.of("Year", "Words", "Name"));
        for (Record record : records) {
            List<Object> list = new ArrayList<>();
            list.add(record.getDate());
            list.add(record.getWords());
            list.add(record.getName());
            series.add(list);
        }
        Map<String, Object> res = new HashMap<>();
        res.put("names", names);
        res.put("series", series);
        return res;
    }

    // 获取所有的统计图数据
    public Map<String, Object> init2() {
        // 获取近一周的时间值
        String recentWeek = TimeUtils.getRecentWeek();

        // 获取近一周的数据情况
        List<Record> records = recordMapper.listRecordNoPage();

        // x 轴的列表，名字
        Set<String> names = new HashSet<>();
        for (Record record : records) {
            names.add(record.getName());
        }
        String[] recent7Date = TimeUtils.getRecent7Date();
        List<Series> initSeries = getInitSeries(recent7Date, names, records);
        Map<String, Object> res = new HashMap<>();
        res.put("legend", names);
        res.put("series", initSeries);
        res.put("xAxis", recent7Date);
        return res;
    }

    /**
     * 格式化 series 中的数据值
     * @param recent7Date 近七天的日期列表
     * @param names 姓名列表
     * @param records 纪录列表
     * @return series 列表
     */
    public List<Series> getInitSeries(String[] recent7Date, Set<String> names, List<Record> records) {
        List<Series> series = new ArrayList<>();

        for (String name : names) {
            int[] data = new int[7];
            // 筛选当前用户的记录
            List<Record> filter = filter(name, records);
            // 赋值近七天的数据
            for (Record record : filter) {
                if (record.getDate().equals(recent7Date[0])) {
                    data[0] = record.getWords();
                } else if (record.getDate().equals(recent7Date[1])) {
                    data[1] = record.getWords();
                } else if (record.getDate().equals(recent7Date[2])) {
                    data[2] = record.getWords();
                } else if (record.getDate().equals(recent7Date[3])) {
                    data[3] = record.getWords();
                } else if (record.getDate().equals(recent7Date[4])) {
                    data[4] = record.getWords();
                } else if (record.getDate().equals(recent7Date[5])) {
                    data[5] = record.getWords();
                } else if (record.getDate().equals(recent7Date[6])) {
                    data[6] = record.getWords();
                }
            }
            Series s = new Series();
            s.setName(name);
            s.setStack("Total");
            s.setType("line");
            s.setData(data);
            series.add(s);
        }
        return series;
    }

    /**
     * 筛选出某个人的记录信息
     * @param name 姓名
     * @param records 记录列表
     * @return 当前用户的记录
     */
    public List<Record> filter(String name, List<Record> records) {
        List<Record> records1 = new ArrayList<>();
        for (Record record : records) {

            if (record.getName().equals(name)) {
                records1.add(record);
            }
        }
        return records1;
    }
}
