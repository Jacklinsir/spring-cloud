package com.jacklinsir.cloud;

import com.jacklinsir.rule.RuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/28 0:13
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PROVIDER-EMP", configuration = RuleConfig.class) //在启动该微服务的时候就能去加载我们的自定义Ribbon配置类.
public class CloudConsumerEmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerEmpApplication.class, args);
    }

}
