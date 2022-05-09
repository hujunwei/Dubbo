package com.jason.service.impl;

import com.jason.dubbo.service.DeptDubboService;
import com.jason.dubbo.service.EmpDubboService;
import com.jason.pojo.Dept;
import com.jason.pojo.Emp;
import com.jason.service.DeptService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @Description: com.jason.service
 */

@Service
public class DeptServiceImpl implements DeptService {
    @Reference
    private DeptDubboService deptDubboService;

    @Reference
    private EmpDubboService empDubboService;

    @Override
    public List<Dept> findAll() {
        return deptDubboService.findAllDept();
    }

    @Override
    public List<Emp> findEmpByDeptId(Integer deptId) {
        return empDubboService.findEmpByDeptId(deptId);
    }
}
