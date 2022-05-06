package com.jason.dubbo.service.impl;

import com.jason.dubbo.service.DeptDubboService;
import com.jason.mapper.DeptMapper;
import com.jason.pojo.Dept;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: com.jason.dubbo.service.impl
 */

@Service
public class DeptDubboServiceImpl implements DeptDubboService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAllDept() {
        return deptMapper.findAll();
    }
}
