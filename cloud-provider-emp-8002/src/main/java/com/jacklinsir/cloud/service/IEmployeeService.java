package com.jacklinsir.cloud.service;

import com.jacklinsir.cloud.model.Employee;

import java.util.List;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/27 23:38
 */
public interface IEmployeeService {

    /**
     * 添加员工
     *
     * @param employee
     * @return
     */
    int addEmployee(Employee employee);

    /**
     * 根据员工ID查询员工
     *
     * @param empNo
     * @return
     */
    Employee getByEmployeeNo(Long empNo);

    /**
     * 查询所有员工
     *
     * @return
     */
    List<Employee> queryAllEmployee();

}
