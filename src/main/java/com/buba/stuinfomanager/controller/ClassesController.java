package com.buba.stuinfomanager.controller;

import com.buba.stuinfomanager.pojo.CardStu;
import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.service.ClassesService;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    //进入班级的页面
    @RequestMapping("/jrClasses")
    public String jrClasses() {
        return "classesManager/classes";
    }

    //查询所有班级
    @ResponseBody
    @RequestMapping("/selAllClassess")
    public ResultUtil selAllClasses(String class_name, String headmaster, String teacher,
                                    Integer page, Integer limit) {
        PageInfo<Classes> info = classesService.selAllClasses(class_name, headmaster, teacher,
                page, limit);
        ResultUtil resultUtil = new ResultUtil(0, "", info.getTotal(), info.getList());
        return resultUtil;
    }

    //进入添加班级的页面
    @RequestMapping("/jrInsClasses")
    public String jrInsClasses() {
        return "classesManager/add";
    }

    @RequestMapping("/insClasses")
    public String insClasses(@RequestBody Classes classes) {
        classesService.insClasses(classes);
        return "redirect:selAllClasses?page=1&limit=10";
    }

    @RequestMapping("/delClasses")
    public String delClasses(Integer class_id) {
        classesService.delClasses(class_id);
        return "redirect:selAllClasses?page=1&limit=10";
    }

    @RequestMapping("/selOneClasses")
    public ModelAndView selOneClasses(Integer class_id) {
        Classes class1 = classesService.selOneClasses(class_id);
        ModelAndView mav = new ModelAndView();
        mav.getModel().put("class1", class1);
        mav.setViewName("classesManager/edit");
        return mav;
    }

    @RequestMapping("/updClasses")
    public String updClasses(@RequestBody Classes classes) {
        classesService.updClasses(classes);
        return "redirect:selAllClasses?page=1&limit=10";
    }

    //进入班干部页面
    @RequestMapping("/jrClassCadre")
    public String jrClassCadre(){
        return "studentCadreManager/classCadre";
    }

    //查询班干部有哪些
    @RequestMapping("/selClassCadre")
    @ResponseBody
    public ResultUtil selClassCadre(Integer class_id, Integer page, Integer limit) {
        PageInfo<Student> info = classesService.selClassCadre(class_id, page, limit);
        ResultUtil resultUtil = new ResultUtil(0, "", info.getTotal(), info.getList());
        return resultUtil;
    }

    @RequestMapping("/selClassStudent")
    @ResponseBody
    public List<Student> selClassStudent(Integer class_id) {
        return classesService.selClassStudent(class_id);
    }

    @RequestMapping("/updStuCard")
    @ResponseBody
    public String updStuCard(CardStu cardStu) {
        classesService.updStuCard(cardStu);
        return "haode";
    }

    //进入添加部门
    @RequestMapping("jrInsStuCard")
    public String jrInsStuCard(){
        return "studentCadreManager/add";
    }
    @RequestMapping("/insStuCard")
    public void insStuCard(Integer stu_id,Integer class_id,Integer card_id) {
        System.out.println(stu_id);
        System.out.println(class_id);
        System.out.println(card_id);
        classesService.insStuCard(stu_id,class_id,card_id);
    }

    @RequestMapping("/delStuCard")
    @ResponseBody
    public String delStuCard(CardStu cardStu) {
        classesService.delStuCard(cardStu);
        return "haode";
    }
}
