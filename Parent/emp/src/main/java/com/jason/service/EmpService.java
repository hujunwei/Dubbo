package com.jason.service;

import com.jason.pojo.Dept;
import com.jason.pojo.Emp;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description: com.jason.service
 */
public interface EmpService {
    int insertEmp(Emp emp, MultipartFile file);

    List<Dept> showAllDept();
}
