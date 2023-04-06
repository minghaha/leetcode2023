package com.mybatis.spring.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * Created on 2023/4/6.
 *
 * @author lichuanming
 */
public interface OrderMapper {
    @Select("select 'order'")
    String selectById();
}
