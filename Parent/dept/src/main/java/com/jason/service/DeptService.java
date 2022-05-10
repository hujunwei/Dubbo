package com.jason.service;

import com.jason.pojo.Dept;
import com.jason.pojo.Emp;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Description: com.jason.service
 */
public interface DeptService {
    public List<Dept> findAll();

    public List<Emp> findEmpByDeptId(Integer deptId);

    public Map<String, Object> kindEditorUploadMultipleFiles(MultipartFile file);
}
