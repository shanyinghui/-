package com.buba.stuinfomanager.controller;

import com.buba.stuinfomanager.annotation.Log;
import com.buba.stuinfomanager.pojo.Teacher;
import com.buba.stuinfomanager.service.TeacherService;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/teacherInfo")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    //去往展示老师信息的页面
    @RequestMapping("/teacher")
    public String toTeacher(){
        return "/teacherInfo/teacher";
    }

    //展示所有
    @RequestMapping("/list")
    @ResponseBody
    @Log
    public ResultUtil teacherList(Integer page,Integer limit,String num,String name){
        PageInfo<Teacher> pageinfo = teacherService.findAllTeacher(page, limit,num,name);
        ResultUtil resultUtil = new ResultUtil(0,"",pageinfo.getTotal(),pageinfo.getList());
        return resultUtil;
    }

    //删除
    @RequestMapping("/delete")
    @ResponseBody
    @Log
    public ResultUtil deleteOneTeacher(Integer t_id){
        try {
            teacherService.deleteOneTeacher(t_id);
        }catch (Exception e){
            return ResultUtil.error();
        }

        return ResultUtil.ok();
    }

    //去往修改页面
    @RequestMapping("/toEdit")
    public String toEdit(Integer id, Model model){
        Teacher teacher = teacherService.selectOneById(id);
        model.addAttribute("teacher",teacher);
        return "/teacherInfo/edit";
    }

    //修改
    @RequestMapping("/update")
    @ResponseBody
    @Log
    public ResultUtil updateTeacher(@RequestBody Teacher teacher){
        try {
            teacherService.update(teacher);
        }catch (Exception e){
            return ResultUtil.error();
        }
        return ResultUtil.ok();
    }

    //去往添加页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "/teacherInfo/add";
    }

    //添加用户信息
    @RequestMapping("/add")
    @ResponseBody
    @Log
    public ResultUtil add(@RequestBody Teacher teacher){
        try {
            teacherService.add(teacher);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.ok();
    }

    /**
     *  	批量删除
     * @param ids
     * @return
     */
    @RequestMapping("deleteMore")
    @ResponseBody
    @Log
    public ResultUtil deleteMore(@RequestParam(value="tids")String[] ids) {
        System.out.println(ids);
        try {
            teacherService.deleteMore(ids);
        }catch (Exception e){
            return ResultUtil.error();
        }
        return ResultUtil.ok();
    }

}
