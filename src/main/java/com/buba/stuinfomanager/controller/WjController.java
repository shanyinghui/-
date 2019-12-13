package com.buba.stuinfomanager.controller;

import com.buba.stuinfomanager.pojo.Wj;
import com.buba.stuinfomanager.service.WjService;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/wj")
public class WjController {
    @Autowired
    WjService wjService;

    @ResponseBody
    @RequestMapping("/selAllWj")
    public ResultUtil selAllWj(String starttime, String endtime, String classes, String studentname,Integer page,Integer limit){

        PageInfo<Wj> pageInfo = wjService.selAllWj(starttime, endtime, classes, studentname,page,limit);
        ResultUtil resultUtil = new ResultUtil(0,"",pageInfo.getTotal(),pageInfo.getList());
        return resultUtil;
    }

    @RequestMapping("/selWjById")
    public String selWjById(@RequestParam("id")Integer id, Model model){
        Wj wj = wjService.selWjById(id);
        model.addAttribute("wj",wj);
        return "/wj/edit.html";
    }

    @ResponseBody
    @RequestMapping("/addWj")
    public void addWj(@RequestBody Wj wj){
        wjService.addWj(wj);
    }

    @ResponseBody
    @RequestMapping("/delWj")
    public void delWj(@RequestParam("id")Integer id){
        wjService.delWj(id);
    }

    @ResponseBody
    @RequestMapping("/updWj")
    public void updWj(@RequestBody Wj wj){
        wjService.updWj(wj);
    }
}
