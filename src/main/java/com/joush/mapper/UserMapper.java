package com.joush.mapper;

import com.joush.entities.User;
import com.joush.entities.display.Progress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Rex Joush
 * @time 2022.12.03
 */
@Mapper
public interface UserMapper {

    User checkLogin(@Param("username") String username,
                    @Param("password") String password,
                    @Param("status") int status);

    int register(@Param("name") String name,
                 @Param("username") String username,
                 @Param("password") String password,
                 @Param("status") int status);

    User getUserByUsername(@Param("username") String username);

    Progress getDeadlineAndTarget(@Param("username") String username);

    int updateTarget(@Param("username") String username, @Param("target") int target);

    int updateDeadline(@Param("username") String username, @Param("deadline") String deadline);
}
