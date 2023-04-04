package com.service.serviceImpl;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * Created on 2023/4/4.
 *
 *
 * @author lichuanming
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("oneDataSource")
    DataSource oneDataSource;

    @Autowired
    @Qualifier("twoDataSource")
    DataSource twoDataSource;

    @Override
    public void test() {
        System.out.println("test");
    }
}
