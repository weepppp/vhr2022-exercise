package com.qfedu.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author weepppp 2022/7/22 15:30
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.qfedu.vhr.framework.mapper")
public class VhrApp {
    public static void main(String[] args) {
        SpringApplication.run(VhrApp.class,args);
    }
}
