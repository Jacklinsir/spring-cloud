package com.jacklinsir.cloud.controller;

import com.jacklinsir.cloud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
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
    private RestTemplate restTemplate;


    public static final String REST_URL_PREFIX = "http://CLOUD-PROVIDER-EMP";

    @ResponseBody
    @RequestMapping("/emp/add")
    public Object add(@RequestBody Employee employee) {
        return restTemplate.patchForObject(REST_URL_PREFIX + "/emp/add", employee, Integer.class);
    }


    @ResponseBody
    @RequestMapping("/emp/get/{empNo}")
    public Map<String, Object> get(@PathVariable("empNo") Long empNo) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/emp/get/" + empNo, Map.class);
    }

    @ResponseBody
    @RequestMapping("/emp/queryAll")
    public Map<String, Object> queryAll() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/emp/queryAll", Map.class);

    }


}
