package com.jacklinsir.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/30 11:20
 */
@SpringBootApplication
@EnableZuulProxy // 开启Zuul网关
public class CloudZuulGateway9527Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudZuulGateway9527Application.class, args);
    }
}
