package com.haocheng.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: haocheng
 * @Date: 2019-08-27 14:01
 */
//@EnableScheduling
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.haocheng.study.mapper")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
