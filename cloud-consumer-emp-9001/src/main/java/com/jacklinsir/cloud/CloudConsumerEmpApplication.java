package com.jacklinsir.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/28 0:13
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConsumerEmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerEmpApplication.class, args);
    }

}
