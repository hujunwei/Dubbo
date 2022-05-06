package com.jason.controller;

import com.jason.pojo.Dept;
import com.jason.pojo.Emp;
import com.jason.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description: com.jason.controller
 */
@Controller
public class EmpController {
    @Autowired
    private EmpService empService;

    @PostMapping("/add")
    public String insertEmp(Emp emp, MultipartFile file) {
        empService.insertEmp(emp, file);
        return "emp";
    }


    @GetMapping("/empadd")
    public String empAdd(Model model) {
        List<Dept> deptList = empService.showAllDept();
        model.addAttribute("list", deptList);

        return "emp";
    }
}
