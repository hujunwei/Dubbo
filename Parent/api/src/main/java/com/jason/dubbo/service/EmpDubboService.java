package com.jason.dubbo.service;

import com.jason.pojo.Emp;

import java.util.List;

/**
 * @Description: com.jason.dubbo.service
 */
public interface EmpDubboService {
    int insertEmp(Emp emp);

    List<Emp> findEmpByDeptId(Integer did);
}
