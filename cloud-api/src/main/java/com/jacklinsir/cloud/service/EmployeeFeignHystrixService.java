package com.jacklinsir.cloud.service;

import com.jacklinsir.cloud.model.Employee;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务降级
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/29 20:40
 */
@Component
public class EmployeeFeignHystrixService implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new EmployeeFeignService() {
            @Override
            public Map<String, Object> addEmp(Employee employee) {
                return null;
            }

            @Override
            public Map<String, Object> getByEmployeeId(Long empNo) {
                Map<String, Object> map = new HashMap<>();
                map.put("empNo", empNo);
                map.put("result", "服务停止，正在维护");
                return map;
            }

            @Override
            public Map<String, Object> queryEmployeeAll() {
                return null;
            }
        };
    }
}
