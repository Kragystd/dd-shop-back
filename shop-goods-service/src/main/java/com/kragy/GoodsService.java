package com.kragy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kragy.mapper")
public class GoodsService {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(GoodsService.class, args);
    }
}