package com.buba.stuinfomanager.controller;

import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Ws;
import com.buba.stuinfomanager.service.MrwsService;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MrwsController {
    //注入service对象
    @Autowired
    MrwsService mrwsService;
    //跳转到每日卫生管理下的各个页面
    @RequestMapping(value = "/wsManager")
    public String wsManager(String nowPage){
        return "/wsManager/"+nowPage+".html";
    }
    //查询所有卫生管理情况
    @RequestMapping(value = "/wsManager/list")
    @ResponseBody
    public ResultUtil selAllWs(Integer page,Integer limit,String begintime,String endtime,String class_id){
        List list = new ArrayList();
        PageInfo<Ws> ws = mrwsService.selAllWs(page,limit,begintime,endtime,class_id);
        ResultUtil resultUtil = new ResultUtil(0,"s",ws.getTotal(),ws.getList());
        return resultUtil;
    }
    //添加卫生管理情况
    @RequestMapping(value = "/wsManager/add")
    @ResponseBody
    public boolean addWs(String class_id,String wsroce){
        Integer i = mrwsService.addWs(class_id, wsroce);
        if(i > 0){
            return true;
        }
        return false;
    }
    //修改卫生管理情况
    @RequestMapping(value = "/wsManager/edit")
    @ResponseBody
    public boolean editWs(String class_id,String wsroce,String wid){
        Integer i = mrwsService.updWs(class_id, wsroce,wid);
        if(i > 0){
            return true;
        }
        return false;
    }
    //删除卫生管理情况
    @RequestMapping(value = "/wsManager/del")
    @ResponseBody
    public boolean delWs(String wid){
        Integer i = mrwsService.delWs(wid);
        if(i > 0){
            return true;
        }
        return false;
    }
    //导出
    @RequestMapping(value = "/wsManager/exportData")
    @ResponseBody
    public ResultUtil exportData(@RequestBody List<Ws> ws){
        return mrwsService.exportData(ws);
    }
    //进入到修改页面
    @RequestMapping(value = "/wsManager/toEdit")
    public String toEdit(String wid, HttpSession session){
        if(session.getAttribute("ws")!=null){
            session.removeAttribute("ws");
            Ws ws = mrwsService.selWsById(wid);
            session.setAttribute("ws",ws);
            return "/wsManager/edit.html";
        }
        Ws ws = mrwsService.selWsById(wid);
        session.setAttribute("ws",ws);
        return "/wsManager/edit.html";
    }
    @RequestMapping(value = "selAllClasses")
    @ResponseBody
    //ajax查询所有班级
    public List<Classes> selAllClasses(){
        return mrwsService.selAllClasses();
    }
}
