package com.jacklinsir.cloud.controller;

import com.jacklinsir.cloud.model.Employee;
import com.jacklinsir.cloud.service.IEmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;


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

    /**
     * getByEmployeeNo 添加服务熔断，当前服务方法不能用，会调用备用的服务方法，实现服务熔断机制
     * 服务熔断在服务端实现 服务降级在客户端实现
     * @param empNo
     * @return
     */
    @GetMapping("/emp/get/{empNo}")
    @HystrixCommand(fallbackMethod = "hystrixEmp")
    public Map<String, Object> getByEmployeeNo(@PathVariable("empNo") Long empNo) {
        Map<String, Object> map = new HashMap<>();
        Employee employee = employeeService.getByEmployeeNo(empNo);
        if (employee != null) {
            map.put("result", employee);
        } else {
            throw new RuntimeException("当前ID存在！");
        }
        return map;
    }


    public Map<String, Object> hystrixEmp(@PathVariable("empNo") Long empNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("empNo", empNo);
        map.put("result", "当前empNo不存在数据");
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

}
