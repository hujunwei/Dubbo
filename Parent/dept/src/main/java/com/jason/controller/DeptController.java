package com.jason.controller;

import com.jason.pojo.Emp;
import com.jason.service.DeptService;
import com.jason.utils.FastDFSClient;
import org.apache.dubbo.common.json.JSON;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @Description: com.jason.controller
 */

@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/dept")
    public String showDept(Model model) {
        model.addAttribute("list", deptService.findAll());
        return "dept";
    }

    @GetMapping("/showEmp")
    public String findEmpByDeptId(Integer did, Model model, HttpServletRequest request) throws IOException {
        List<Emp> empList = deptService.findEmpByDeptId(did);

        String realPath = request.getServletContext().getRealPath("/upload");
        File dir = new File(realPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        for (Emp emp : empList) {
            String photo = emp.getPhoto();

            if (null != photo && "" != photo) {
                // TODO: should not hard code "group1", instead, add a new column in db to store such info
                InputStream inputStream = FastDFSClient.downloadFile("group1", photo);

                if (null == inputStream) {
                    System.out.println("File not found");
                    continue;
                }

                String downloadedFilename = photo.substring(photo.lastIndexOf("/"));
                OutputStream outputStream = new FileOutputStream(new File(dir, downloadedFilename));
                int index = 0;
                while ((index = inputStream.read()) != -1) {
                    outputStream.write(index);
                }

                System.out.println("file downloaded for " + emp.getName() + " with path: " + dir + downloadedFilename);
                emp.setPhoto("http://localhost:8080/upload/" + downloadedFilename);

                outputStream.flush();
                outputStream.close();
                inputStream.close();
            } else {
                System.out.println("file did not download for" + emp.getName());
            }


        }

        model.addAttribute("list", empList);

        return "showEmp";
    }
    
    @PostMapping("/upload")
    @ResponseBody
    public Map<String, Object> kindEditorUploadMultipleFiles(MultipartFile imgFile) {
        Map<String, Object> stringObjectMap = deptService.kindEditorUploadMultipleFiles(imgFile);
        return stringObjectMap;
    }
}
