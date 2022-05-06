package com.jason.dubbo.service.impl;

import com.jason.dubbo.service.EmpDubboService;
import com.jason.mapper.EmpMapper;
import com.jason.pojo.Emp;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: com.jason.dubbo.service.impl
 */

@Service
public class EmpDubboServiceImpl implements EmpDubboService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public int insertEmp(Emp emp) {
        return empMapper.insertEmp(emp);
    }

    @Override
    public List<Emp> findEmpByDeptId(Integer did) {
        return empMapper.findEmpByDeptId(did);
    }
}
