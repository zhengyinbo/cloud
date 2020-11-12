package com.bo.zuul1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启api网关服务功能
@EnableEurekaClient
public class Zuul1Application {

    public static void main(String[] args) {
        SpringApplication.run(Zuul1Application.class, args);
    }

}
