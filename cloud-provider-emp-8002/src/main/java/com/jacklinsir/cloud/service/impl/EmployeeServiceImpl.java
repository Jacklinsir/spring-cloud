package com.jacklinsir.cloud.service.impl;

import com.jacklinsir.cloud.dao.EmployeeDao;
import com.jacklinsir.cloud.model.Employee;
import com.jacklinsir.cloud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/27 23:42
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public int addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public Employee getByEmployeeNo(Long empNo) {
        return employeeDao.getByEmployeeNo(empNo);
    }

    @Override
    public List<Employee> queryAllEmployee() {
        return employeeDao.queryAllEmployee();
    }
}
