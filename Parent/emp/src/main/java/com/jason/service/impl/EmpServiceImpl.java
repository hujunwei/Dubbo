package com.jason.service.impl;

import com.jason.dubbo.service.DeptDubboService;
import com.jason.dubbo.service.EmpDubboService;
import com.jason.pojo.Dept;
import com.jason.pojo.Emp;
import com.jason.service.EmpService;
import com.jason.utils.FastDFSClient;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @Description: com.jason.service.impl
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Reference
    private EmpDubboService empDubboService;

    @Reference
    private DeptDubboService deptDubboService;

    @Override
    public int insertEmp(Emp emp, MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();

            String oldName = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));

            System.out.println("filename: " + fileName);

            String[] results = FastDFSClient.uploadFile(inputStream, fileName);
            System.out.println(Arrays.toString(results));

            // {UUID}.XXX
            emp.setPhoto(results[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return empDubboService.insertEmp(emp);
    }

    @Override
    public List<Dept> showAllDept() {
        return deptDubboService.findAllDept();
    }
}
