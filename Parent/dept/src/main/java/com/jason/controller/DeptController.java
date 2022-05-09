package com.jason.controller;

import com.jason.pojo.Emp;
import com.jason.service.DeptService;
import com.jason.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

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
}
