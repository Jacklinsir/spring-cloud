package com.jacklinsir.cloud.controller;

import com.jacklinsir.cloud.model.Employee;
import com.jacklinsir.cloud.service.EmployeeFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/28 0:15
 */
@Controller
public class EmployeeController {


    @Autowired
    private EmployeeFeignService employeeFeignService = null;

    @ResponseBody
    @RequestMapping("/emp/add")
    public Map<String,Object> add(@RequestBody Employee employee) {
        return employeeFeignService.addEmp(employee);
    }


    @ResponseBody
    @RequestMapping("/emp/get/{empNo}")
    public Map<String,Object> get(@PathVariable("empNo") Long empNo) {
        return employeeFeignService.getByEmployeeId(empNo);
    }

    @ResponseBody
    @RequestMapping("/emp/queryAll")
    public Map<String,Object> queryAll() {
        return employeeFeignService.queryEmployeeAll();
    }


}
