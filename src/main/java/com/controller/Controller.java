package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.entity.Users;
import com.mapper.UsersMapper;
import com.service.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created on 2023/4/4.
 *
 * @author lichuanming
 */
@RestController
@Slf4j
public class Controller {

    @Autowired
    @Qualifier("oneDataSource")
    DataSource oneDataSource;

    @Autowired
    @Qualifier("twoDataSource")
    DataSource twoDataSource;



    @Resource
    private IUsersService iUsersService;



    @GetMapping("/")
    public void test(){
        //userService.test();
        //
        //
        //System.out.println(oneDataSource);
        //System.out.println(twoDataSource);
        List<Users> list = iUsersService.list();
        System.out.println(list);

    }
}
