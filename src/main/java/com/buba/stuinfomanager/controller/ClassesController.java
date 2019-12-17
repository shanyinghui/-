package com.buba.stuinfomanager.controller;

import com.buba.stuinfomanager.annotation.Log;
import com.buba.stuinfomanager.pojo.CardStu;
import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.service.ClassesService;
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
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    //删除多个班级
    @RequestMapping("delMoreClasses")
    @ResponseBody
    public ResultUtil delMoreClasses(@RequestParam(value = "class_id") String[] ids) {
        try {
            classesService.delMoreClasses(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.ok();
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
    @ResponseBody
    public Map<String, String> delClasses(Integer class_id) {
        Map<String, String> map = new HashMap<>();
        try {
            classesService.delClasses(class_id);
            map.put("code", "200");
            return map;
        } catch (Exception e) {
            map.put("code", "500");
            return map;
        }
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
    public String jrClassCadre(Integer class_id, Model model) {
        model.addAttribute("class_id", class_id);
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

    //查询当前学生
    @RequestMapping("/selOneCardStudent")
    public ModelAndView selOneCardStudent(Integer stu_id) {
        CardStu student = classesService.selOneCardStudent(stu_id);
        ModelAndView mav = new ModelAndView();
        mav.getModel().put("student1", student);
        mav.setViewName("studentCadreManager/edit");
        return mav;
    }

    //查询当前班级学生
    @RequestMapping("/selClassStudent")
    @ResponseBody
    public List<Student> selClassStudent(Integer class_id) {
        return classesService.selClassStudent(class_id);
    }

    @RequestMapping("/updStuCard")
    @ResponseBody
    public Map<String, String> updStuCard(CardStu cardStu) {
        Map<String, String> map = new HashMap<>();
        try {
            classesService.updStuCard(cardStu);
            map.put("code", "200");
            return map;
        } catch (Exception e) {
            map.put("code", "500");
            return map;
        }
    }


    //进入添加学生职位
    @RequestMapping("jrInsStuCard")
    public String jrInsStuCard(Integer class_id, Model model) {
        model.addAttribute("class_id", class_id);
        return "studentCadreManager/add";
    }

    @RequestMapping("/insStuCard")
    @ResponseBody
    public Map<String, String> insStuCard(CardStu cardStu) {
        Map<String, String> map = new HashMap<>();
        try {
            classesService.insStuCard(cardStu.getStu_id(), cardStu.getClass_id(),
                    cardStu.getCard_id());
            map.put("code", "200");
            return map;
        } catch (Exception e) {
            map.put("code", "500");
            return map;
        }
    }

    @RequestMapping("/delStuCard")
    @ResponseBody
    public Map<String, String> delStuCard(CardStu cardStu) {
        Map<String, String> map = new HashMap<>();
        try {
            classesService.delStuCard(cardStu);
            map.put("code", "200");
            return map;
        } catch (Exception e) {
            map.put("code", "500");
            return map;
        }
    }
    @RequestMapping("/importClassExcel")
    @ResponseBody
    public ResultUtil importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        return classesService.importExcel(file);
    }

    @RequestMapping("/exportClassData")
    @ResponseBody
    @Log
    public ResultUtil exportData(@RequestBody List<Classes> classes){
        return classesService.exportData(classes);
    }
}
