package com.jacklinsir.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
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
public class CloudProviderEmp8003Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderEmp8003Application.class, args);
    }

    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }

}
