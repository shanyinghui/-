package com.buba.stuinfomanager.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 *  配置druid信息
 */

public class DruidConfig {
    @Autowired
    public Environment env;

    @Bean
    public DataSource getDataSouce(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(env.getProperty("spring.datasource.url"));
        druidDataSource.setUsername(env.getProperty("spring.datasource.username"));
        druidDataSource.setPassword(env.getProperty("spring.datasource.password"));
        druidDataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));

        return druidDataSource;
    }
}
