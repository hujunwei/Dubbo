package com.jason.controller;

import com.jason.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
