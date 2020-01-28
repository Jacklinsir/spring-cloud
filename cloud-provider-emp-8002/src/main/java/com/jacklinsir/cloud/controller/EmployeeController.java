package com.jacklinsir.cloud.controller;

import com.jacklinsir.cloud.model.Employee;
import com.jacklinsir.cloud.service.IEmployeeService;
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

}
