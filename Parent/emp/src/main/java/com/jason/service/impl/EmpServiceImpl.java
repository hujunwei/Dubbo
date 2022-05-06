package com.jason.service.impl;

import com.jason.dubbo.service.DeptDubboService;
import com.jason.dubbo.service.EmpDubboService;
import com.jason.pojo.Dept;
import com.jason.pojo.Emp;
import com.jason.service.EmpService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

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
            // 通过Spring容器获取HttpServletRequest对象
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            // 通过HttpServletRequest对象 获取图片将要上传路径
            String path = request.getServletContext().getRealPath("/img");

            // 生成随机文件名以保证文件名高并发下不重复 并获取后缀名
            long currentTimeMills = System.currentTimeMillis();
            Random random = new Random();
            String fileName = currentTimeMills + "" + random.nextInt(1000);
            String oldName = file.getOriginalFilename();
            fileName += oldName.substring(oldName.lastIndexOf("."));

            // 如果上传的dir不存在mkdir
            File pathFile = new File(path);
            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }

            // 把文件写入dir
            file.transferTo(new File(path, fileName));

            // 把整个路径存入emp 对象插入数据库
            emp.setPhoto("http://localhost:8081/img/" + fileName);
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
