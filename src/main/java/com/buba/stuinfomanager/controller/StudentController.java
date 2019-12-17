package com.buba.stuinfomanager.controller;

import com.buba.stuinfomanager.annotation.Log;
import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.service.StudentService;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/studentInfo")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //去往展示学生信息的页面
    @RequestMapping("/student")
    public String toTeacher(){
        return "/studentInfo/student";
    }

    //展示所有
    @RequestMapping("/list")
    @ResponseBody
    @Log
    public ResultUtil StudentList(Integer page,Integer limit,String num,String name){
        PageInfo<Student> pageinfo = studentService.findAllStudent(page, limit,num,name);
        ResultUtil resultUtil = new ResultUtil(0,"",pageinfo.getTotal(),pageinfo.getList());
        return resultUtil;
    }

    //删除
    @RequestMapping("/delete")
    @ResponseBody
    @Log
    public ResultUtil deleteOneStudent(Integer id){
        try {
            studentService.deleteOneStudent(id);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }

        return ResultUtil.ok();
    }

    //去往修改页面
    @RequestMapping("/toEdit")
    public String toEdit(Integer id, Model model){
        Student student = studentService.selectOneById(id);
        List<Classes> lists = studentService.selectClass();
        model.addAttribute("student",student);
        model.addAttribute("classes",lists);
        return "/studentInfo/edit";
    }

   //修改
    @RequestMapping("/update")
    @ResponseBody
    public ResultUtil updateStudent(@RequestBody Student student){
        System.out.println(student);
        try {
            studentService.update(student);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.ok();
    }


    //去往添加页面
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        List<Classes> lists = studentService.selectClass();
        model.addAttribute("classes",lists);
        return "/studentInfo/add";
    }

    //添加用户信息
    @RequestMapping("/add")
    @ResponseBody
    @Log
    public ResultUtil add(@RequestBody Student student){
        try {
            studentService.add(student);
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
    public ResultUtil deleteMore(@RequestParam(value="stuids")String[] ids) {
        System.out.println(ids);
        try {
            studentService.deleteMore(ids);
        }catch (Exception e){
            return ResultUtil.error();
        }
        return ResultUtil.ok();
    }

    @RequestMapping("/importExcel")
    @ResponseBody
    @Log
    public ResultUtil importExcel(@RequestParam("file")MultipartFile file) throws IOException {
        return studentService.importExcel(file);
    }

    @RequestMapping("/exportData")
    @ResponseBody
    @Log
    public ResultUtil exportData(@RequestBody List<Student> students){
        return studentService.exportData(students);
    }
}
