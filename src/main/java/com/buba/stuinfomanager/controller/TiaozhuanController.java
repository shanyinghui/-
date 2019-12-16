package com.buba.stuinfomanager.controller;

import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TiaozhuanController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/wjlist")
    public String wjList(Model model){
        List<Classes> classes = studentService.selectClass();
        model.addAttribute("classes",classes);
        return "/wj/wj.html";
    }
    @RequestMapping("/addWj")
    public String add(Model model){
        List<Classes> classes = studentService.selectClass();
        model.addAttribute("classes",classes);
        return "/wj/add.html";
    }
    @RequestMapping("/scorelist")
    public String scorelist(){
        return "/scoreManager/score.html";
    }
    @RequestMapping("/addScore")
    public String addScore(){
        return "/scoreManager/add.html";
    }
}
