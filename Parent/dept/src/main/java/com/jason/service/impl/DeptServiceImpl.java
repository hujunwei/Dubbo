package com.jason.service.impl;

import com.jason.dubbo.service.DeptDubboService;
import com.jason.dubbo.service.EmpDubboService;
import com.jason.pojo.Dept;
import com.jason.pojo.Emp;
import com.jason.service.DeptService;
import com.jason.utils.FastDFSClient;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> kindEditorUploadMultipleFiles(MultipartFile file) {
        Map<String, Object> map = new HashMap<>();

        try {
            String[] result = FastDFSClient.uploadFile(file.getInputStream(), file.getOriginalFilename());
            map.put("error", 0);
            map.put("url", "http://192.168.1.131:8888/" + result[0] + "/" + result[1]);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("error", 1);
            map.put("message", "Upload failed");
        }

        return map;
    }
}
