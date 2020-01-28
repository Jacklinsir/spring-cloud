package com.jacklinsir.cloud.dao;

import com.jacklinsir.cloud.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/27 23:35
 */
public interface EmployeeDao {


    /**
     * 添加员工
     *
     * @param employee
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into employee(emp_no,emp_name,db_source)values (#{empNo},#{empName},DATABASE())")
    int addEmployee(Employee employee);

    /**
     * 根据ID查询员工
     *
     * @param empNo
     * @return
     */

    @Results(id = "BaseResultMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "emp_no", property = "empNo"),
            @Result(column = "emp_name", property = "empName"),
            @Result(column = "db_source", property = "dbSource")
    })
    @Select("select *from employee where emp_no=#{empNo} ")
    Employee getByEmployeeNo(Long empNo);

    /**
     * 查询所有员工
     *
     * @return
     */
    @ResultMap("BaseResultMap")
    @Select("select *from employee")
    List<Employee> queryAllEmployee();

}
