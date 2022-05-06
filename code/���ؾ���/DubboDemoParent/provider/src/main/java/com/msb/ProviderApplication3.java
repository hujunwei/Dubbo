package com.msb;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by IBM on 2020/9/26.
 */
@SpringBootApplication
@EnableDubbo
public class ProviderApplication3 {

    public static void main(String[] args) {

        SpringApplication.run(ProviderApplication3.class , args);


    }
}
