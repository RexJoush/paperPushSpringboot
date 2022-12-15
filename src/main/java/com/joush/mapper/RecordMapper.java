package com.joush.mapper;

import com.joush.entities.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Rex Joush
 * @time 2022.12.04
 */
@Mapper
public interface RecordMapper {

    List<Record> listRecordsByUserName(@Param("username") String username);

    Record getRecordByDate(String username, String date);

    List<Record> list(@Param("username") String username,
                      @Param("pageStart") int pageStart,
                      @Param("pageSize") int pageSize);

    int add(@Param("username") String username,
            @Param("words") int words,
            @Param("date") String date);

    int edit(@Param("id") int id,
             @Param("words") int words);

    int del(@Param("id") int id);


    int count(@Param("username")String username);

    List<Record> listRecordNoPage();
}
