package com.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * Created on 2023/4/4.
 *
 * @author lichuanming
 */
@Configuration
@MapperScan("com.mapper")
public class MybatisPlusConfig {


    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MyMetaObjectHandler();
    }

    public class MyMetaObjectHandler implements MetaObjectHandler {

        /**
         * 新增时填充createTime和updateTime字段的值
         */
        @Override
        public void insertFill(MetaObject metaObject) {
            // 自动对 createTime 和 updateTime 进行填充，不会覆盖手动赋值的值
            this.setFieldValByName("createDate", new Date(), metaObject);
            this.setFieldValByName("modifyDate", new Date(), metaObject);
        }

        /**
         * 修改时填充updateTime字段的值
         */
        @Override
        public void updateFill(MetaObject metaObject) {
            // 自动对 updateTime 进行填充，不会覆盖手动赋值的值
            this.setFieldValByName("modifyDate", new Date(), metaObject);
        }
    }
}
