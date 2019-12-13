package com.buba.stuinfomanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TiaozhuanController {
    @RequestMapping("/wjlist")
    public String wjList(){
        return "/wj/wj.html";
    }
    @RequestMapping("/addWj")
    public String add(){
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
