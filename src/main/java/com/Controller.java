package com;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created on 2023/4/4.
 *
 * @author lichuanming
 */
@RestController
public class Controller {

    @Autowired
    @Qualifier("oneDataSource")
    DataSource oneDataSource;

    @Autowired
    @Qualifier("twoDataSource")
    DataSource twoDataSource;

    @Autowired
    UserService userService;


    @GetMapping("/")
    public void test(){
        userService.test();


        System.out.println(oneDataSource);
        System.out.println(twoDataSource);
    }
}
