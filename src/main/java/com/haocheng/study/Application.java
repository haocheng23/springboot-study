package com.haocheng.study;

import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.spring.boot.autoconfigure.ShiroAnnotationProcessorAutoConfiguration;
import org.apache.shiro.spring.boot.autoconfigure.ShiroAutoConfiguration;
import org.apache.shiro.spring.boot.autoconfigure.ShiroBeanAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: haocheng
 * @Date: 2019-08-27 14:01
 */
//@EnableScheduling
@EnableSwagger2
@MapperScan("com.haocheng.study.dao")
@SpringBootApplication//
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
