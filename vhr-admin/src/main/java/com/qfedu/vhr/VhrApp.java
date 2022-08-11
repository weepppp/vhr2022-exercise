package com.qfedu.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author weepppp 2022/7/22 15:30
 **/
@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = {"com.qfedu.vhr.framework.mapper"
        , "com.qfedu.vhr.admin.controller.system.mapper"
        , "com.qfedu.vhr.employee.mapper"
        , "com.qfedu.vhr.employee.config"})
//@MapperScan(basePackages = "com.qfedu.vhr")
public class VhrApp {
    public static void main(String[] args) {
        SpringApplication.run(VhrApp.class, args);
    }
}
