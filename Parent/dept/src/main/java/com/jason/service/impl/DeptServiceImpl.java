package com.jason.service.impl;

import com.jason.dubbo.service.DeptDubboService;
import com.jason.pojo.Dept;
import com.jason.service.DeptService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: com.jason.service
 */

@Service
public class DeptServiceImpl implements DeptService {
    @Reference
    private DeptDubboService deptDubboService;

    @Override
    public List<Dept> findAll() {
        return deptDubboService.findAllDept();
    }
}
