package com.jason;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: com.jason
 */

@SpringBootApplication
@EnableDubbo
public class DeptApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptApplication.class, args);
    }
}
