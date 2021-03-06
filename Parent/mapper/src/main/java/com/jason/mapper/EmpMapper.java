package com.jason.mapper;

import com.jason.pojo.Emp;

import java.util.List;

/**
 * @Description: PACKAGE_NAME
 */
public interface EmpMapper {
    int insertEmp(Emp emp);

    List<Emp> findEmpByDeptId(Integer did);

    List<Emp> showAll();
}
