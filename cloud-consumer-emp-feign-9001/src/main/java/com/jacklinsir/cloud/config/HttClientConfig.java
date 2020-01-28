package com.jacklinsir.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Http请求配置类
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/28 0:14
 */
@Configuration
public class HttClientConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
