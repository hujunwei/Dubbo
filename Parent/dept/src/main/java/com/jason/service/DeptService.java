package com.jason.service;

import com.jason.pojo.Dept;
import com.jason.pojo.Emp;

import java.util.List;

/**
 * @Description: com.jason.service
 */
public interface DeptService {
    public List<Dept> findAll();

    public List<Emp> findEmpByDeptId(Integer deptId);
}
