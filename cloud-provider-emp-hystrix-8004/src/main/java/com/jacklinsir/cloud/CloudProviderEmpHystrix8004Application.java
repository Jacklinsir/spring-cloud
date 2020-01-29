package com.jacklinsir.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/27 23:54
 */
@EnableEurekaClient //注册到Eureka服务中
@SpringBootApplication
@MapperScan("com.jacklinsir.cloud.dao")
@EnableCircuitBreaker //启动熔断注解
public class CloudProviderEmpHystrix8004Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderEmpHystrix8004Application.class, args);
    }

    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }

}