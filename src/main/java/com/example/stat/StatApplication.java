package com.example.stat;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.stat.mapper")
public class StatApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatApplication.class, args);
    }

}
