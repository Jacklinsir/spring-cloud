package com.jacklinsir.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/29 21:03
 */
@SpringBootApplication
@EnableHystrixDashboard //开启监控
public class CloudConsumerHystrixDashboardEmpApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerHystrixDashboardEmpApplication.class, args);
    }
}
