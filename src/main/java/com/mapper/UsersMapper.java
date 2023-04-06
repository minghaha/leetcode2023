package com.mapper;

import com.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lichuanming
 * @since 2023-04-04
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    //List<Users> selectList();
}
