package com.bo.hyserixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启仪表盘功能
public class HyserixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HyserixDashboardApplication.class, args);
    }

}
