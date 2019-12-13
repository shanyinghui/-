package com.buba.stuinfomanager.controller;

import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Student_Union;
import com.buba.stuinfomanager.service.Student_UnionService;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Studen_UnionController {

    @Autowired
    private Student_UnionService student_unionService;

    //进入学生会页面
    @RequestMapping("/jrStu_Union")
    public String jrStu_Union(Integer department_id, Model model) {
        model.addAttribute("department_id", department_id);
        return "studentUnionManager/studentUnionManager";
    }

    @RequestMapping("/selStu_UnionStu")
    @ResponseBody
    public ResultUtil selStu_UnionStu(Integer department_id, String name, String strsex,
                                      Integer page, Integer limit) {
        Integer sex = 0;
        if (strsex != null && strsex != "") {
            if (strsex == "男") {
                sex = 0;
            } else {
                sex = 1;
            }
        } else {
            sex = 3;
        }
        PageInfo<Student> info = student_unionService.selStu_UnionStu(department_id,
                name, sex, page
                , limit);
        ResultUtil resultUtil = new ResultUtil(0, "", info.getTotal(), info.getList());
        return resultUtil;
    }

    @RequestMapping("/selOneStu_UnionStu")
    @ResponseBody
    public ModelAndView selOneStu_UnionStu(Integer stu_id) {
        System.out.println(stu_id);
        Student student = student_unionService.selOneStu_UnionStu(stu_id);
        ModelAndView mav = new ModelAndView();
        mav.getModel().put("stu", student);
        mav.setViewName("studentUnionManager/edit");
        return mav;
    }

    @RequestMapping("/updStu_Union")
    public void updStu_Union(Student student) {
        student_unionService.updStu_Union(student);
    }
}
