package com.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created on 2023/4/4.
 *
 * @author lichuanming
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "oneDataSource")
    @Qualifier("oneDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid.one")
    public DataSource oneDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "twoDataSource")
    @Qualifier("twoDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid.two")
    public DataSource twoDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
