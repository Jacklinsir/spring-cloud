package com.jacklinsir.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/27 23:54
 */
@EnableEurekaClient //注册到Eureka服务中
@SpringBootApplication
@MapperScan("com.jacklinsir.cloud.dao")
@EnableDiscoveryClient //服务发现
public class CloudProviderEmp8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderEmp8001Application.class, args);
    }

}
