package com.joush.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author Rex Joush
 * @time 2022.12.04
 */
@Mapper
public interface DisplayMapper {

    String getEndTime();

}
