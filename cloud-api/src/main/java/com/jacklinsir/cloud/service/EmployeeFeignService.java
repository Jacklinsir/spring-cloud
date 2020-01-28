package com.jacklinsir.cloud.service;

import com.jacklinsir.cloud.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/28 21:11
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-EMP")
public interface EmployeeFeignService {

    @PostMapping("/emp/add")
    Map<String,Object> addEmp(Employee employee);

    @GetMapping("/emp/get/{empNo}")
    Map<String,Object> getByEmployeeId(@PathVariable("empNo") Long empNo);

    @GetMapping("/emp/queryAll")
    Map<String,Object> queryEmployeeAll();

}
