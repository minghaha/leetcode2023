package com.mybatis.spring.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created on 2023/4/6.
 *
 * @author lichuanming
 */
public interface UserMapper {

    @Select("select * from user ")
    List<User> selectById();
}
