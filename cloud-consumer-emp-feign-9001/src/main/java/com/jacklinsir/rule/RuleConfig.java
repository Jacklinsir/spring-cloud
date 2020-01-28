package com.jacklinsir.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/28 20:17
 */
@Configuration
public class RuleConfig {

    @Bean
    public IRule rule() {
        return new TransferFiveServiceRuleCloud();
    }

}
