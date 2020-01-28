package com.jacklinsir.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/27 23:54
 */
@EnableEurekaClient //注册到Eureka服务中
@SpringBootApplication
@MapperScan("com.jacklinsir.cloud.dao")
public class CloudProviderEmp8002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderEmp8002Application.class, args);
    }

}
