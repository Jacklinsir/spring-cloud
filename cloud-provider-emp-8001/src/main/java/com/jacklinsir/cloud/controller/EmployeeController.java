package com.jacklinsir.cloud.controller;

import com.jacklinsir.cloud.model.Employee;
import com.jacklinsir.cloud.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * rest员工API
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/27 23:44
 */
@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/emp/add")
    public Map<String, Object> add(@RequestBody Employee employee) {
        Map<String, Object> map = new HashMap<>();
        int addEmployee = employeeService.addEmployee(employee);
        if (addEmployee == 1) {
            map.put("message", "添加成功");
        } else {
            map.put("message", "添加失败");
        }
        return map;
    }

    @GetMapping("/emp/get/{empNo}")
    public Map<String, Object> getByEmployeeNo(@PathVariable Long empNo) {
        Map<String, Object> map = new HashMap<>();
        Employee employee = employeeService.getByEmployeeNo(empNo);
        if (employee != null) {
            map.put("result", employee);
        } else {
            map.put("result", null);
        }
        return map;
    }

    @GetMapping("/emp/queryAll")
    public Map<String, Object> queryAllyEmployee() {
        Map<String, Object> map = new HashMap<>();
        List<Employee> employees = employeeService.queryAllEmployee();
        if (employees.size() > 0) {
            map.put("result", employees);
        } else {
            map.put("result", Collections.EMPTY_LIST);
        }
        return map;
    }


    /**
     * 获取一些注册进来的微服务，获取一些信息
     *
     * @return
     */
    @RequestMapping("/discovery")
    public Object discovery() {
        //获取服务清单
        List<String> services = discoveryClient.getServices();
        //输出服务清单
        services.forEach(s -> {
            log.info("服务清单：{}", s);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-EMP-8001");
        instances.forEach(serviceInstance -> {
            log.info("主机名: {}", serviceInstance.getHost());
            log.info("端口: {}", serviceInstance.getPort());
            log.info("url: {}", serviceInstance.getUri());
            log.info("实例ID: {}", serviceInstance.getServiceId());
        });
        return this.discoveryClient;
    }

}
