package com.buba.stuinfomanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/index.html")
    public String toIndex(){
        return "index";
    }


    @RequestMapping("/teacherInfo/teacher")
    public String teacher_list(){
        return "/teacherInfo/teacher";
    }
}
