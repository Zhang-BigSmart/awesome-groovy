package com.zhang.awesome.groovy.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : edison
 */
@SpringBootApplication(scanBasePackages = "com.zhang.awesome.groovy")
@MapperScan("com.zhang.awesome.groovy.demo.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
