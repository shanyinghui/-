package com.buba.stuinfomanager.controller;

import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Summary;
import com.buba.stuinfomanager.pojo.Teacher;
import com.buba.stuinfomanager.service.SummaryServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description:
 * @author: liYong
 * @createDate: 2019/12/11
 * @remark: 学生每日总结  业务控制层
 */
@Controller
@RequestMapping("/summary")
public class SummaryController {

    @Autowired
    private SummaryServer summaryServer;

    /**
     * 进入主页面
     */
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("summaryManager/summaryManager.html");
        return modelAndView;
    }

    /**
     * 每日总结添加信息
     * @param summary
     * @param educations
     * @return
     */
    @RequestMapping("/insertSummary")
    @ResponseBody
    public Map<String,String> insertSummary(Summary summary, String educations){

        Map<String,String> map = new HashMap<>();
        String str = "";
        //先获取session 然后复制
        Student student = new Student();
        student.setStu_id(1);
        summary.setStudent(student);

        Summary summ = summaryServer.selectSummaryBySum_time(summary);

        if (null == summ){
            try {
                summaryServer.insertSummary(summary,educations);
                str = "SUCCESS";
                map.put("msg",str);
                return map;
            }catch (Exception e){
                str = "Error";
                map.put("msg",str);
                return map;
            }
        }
        str = "今天已总结过，让我们一起迎接美好的明天吧！";
        map.put("msg",str);
        return map;

    }

    @RequestMapping("/selectSummaryAll")
    @ResponseBody
    public Map<String,Object> selectSummaryAll(){

        //先获取session 然后复制
        Integer pageCount = summaryServer.selectSummaryCount(Summary.sum_state_undone);

        Map<String, Object> map = new HashMap<String, Object>();

        if (pageCount > 0) {

            //先获取session 然后复制
            Student student = new Student();
            student.setStu_id(1);
            Summary summary = new Summary();
            summary.setStudent(student);
            summary.setSum_state(Summary.sum_state_undone);
            List<Summary> list = summaryServer.selectSummaryAll(summary);

            map.put("data", list);
            map.put("code", 0);

            map.put("msg", "");
            map.put("count", pageCount);
        } else {
            map.put("data", new ArrayList<>());
            map.put("code", 0);

            map.put("msg", "");
            map.put("count", 0);
        }

        return map;
    }

    /**
     * 打开父页面
     */
    @RequestMapping("/layeropen")
    @ResponseBody
    public ModelAndView layeropen(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("summaryManager/add.html");
        return modelAndView;
    }

    /**
     * 补充学生每日一节
     * 修改功能
     */
    @RequestMapping("/replenishSummary")
    @ResponseBody
    public String replenishSummary(Summary summary,String educations){

        try {
            summaryServer.replenishSummary(summary,educations);
            return "SUCCESS";
        }catch (Exception e){
            return "Error";
        }
    }

    /**
     * 学生审核页面显示
     */
    @RequestMapping("/selectSummaryTeacherAll")
    @ResponseBody
    public Map<String,Object> selectSummaryTeacherAll(){

        //先获取session 然后复制
        Integer pageCount = summaryServer.selectSummaryCount(Summary.sum_state_authstr);

        Map<String, Object> map = new HashMap<String, Object>();

        if (pageCount > 0) {

            //先获取session 然后复制
            Teacher teacher = new Teacher();
            teacher.setT_id(1);
            Summary summary = new Summary();
            summary.setTeacher(teacher);
            summary.setSum_state(Summary.sum_state_authstr);
            List<Summary> list = summaryServer.selectSummaryTeacherAll(summary);

            map.put("data", list);
            map.put("code", 0);

            map.put("msg", "");
            map.put("count", pageCount);
        } else {
            map.put("data", new ArrayList<>());
            map.put("code", 0);

            map.put("msg", "");
            map.put("count", 0);
        }

        return map;
    }

    /**
     * 老师审核
     * 修改
     */
    @RequestMapping("/TeacherUpdateSummary")
    @ResponseBody
    public String TeacherUpdateSummary(@RequestBody Summary summary){
        System.out.println(summary);
        try {
            summaryServer.teacherUpdateSummary(summary);
            return "SUCCESS";
        }catch (Exception e){
            return "Error";
        }

    }

    /**
     * 每次进来之后都要验证
     */
    public void selectVerify(Student student){

        Date date4 = new Date(new Date().getTime()-24*60*60*1000);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String time = sdf.format(date4);

        summaryServer.selectVerify(student,time);

    }


}
