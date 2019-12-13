package com.buba.stuinfomanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.buba.stuinfomanager.mapper")
public class StuinfomanagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(StuinfomanagerApplication.class, args);
    }
}
