package com.mybatis.spring.service.impl;

import com.mybatis.spring.mapper.OrderMapper;
import com.mybatis.spring.mapper.UserMapper;
import com.mybatis.spring.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created on 2023/4/6.
 *
 * @author lichuanming
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    UserMapper userMapper;

    //@Resource
    //OrderMapper orderMapper;

    @Override
    public void test() {
        System.out.println(userMapper.selectById());
        //System.out.println(orderMapper.selectById());
    }


}
