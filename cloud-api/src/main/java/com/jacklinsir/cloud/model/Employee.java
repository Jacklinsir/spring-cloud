package com.jacklinsir.cloud.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/27 23:09
 */
@Setter
@Getter
@Accessors(chain = true) //开启链式编程
public class Employee implements Serializable {

    /**
     * 用户标识列
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long empNo;
    /**
     * 用户名
     */
    private String empName;
    /**
     * 所在数据库位置
     * 一个微服务对应一个数据库
     */
    private String dbSource;

}
