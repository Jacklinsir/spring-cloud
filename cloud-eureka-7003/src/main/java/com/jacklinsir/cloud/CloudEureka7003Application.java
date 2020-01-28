package com.jacklinsir.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/28 12:28
 */
@SpringBootApplication
@EnableEurekaServer //启动eureka服务
public class CloudEureka7003Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudEureka7003Application.class, args);
    }
}
