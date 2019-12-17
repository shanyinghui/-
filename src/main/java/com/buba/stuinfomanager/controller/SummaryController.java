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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @RequestMapping("/summaryManager")
    public ModelAndView summaryManager(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("summaryManager/summaryManager.html");
        return modelAndView;
    }

    @RequestMapping("/termplana")
    public ModelAndView termplana(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("summaryManager/termplana.html");
        return modelAndView;
    }

    @RequestMapping("/add")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("summaryManager/add.html");
        return modelAndView;
    }

    @RequestMapping("/teacheraudit")
    public ModelAndView teacheraudit(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("summaryManager/teacheraudit.html");
        return modelAndView;
    }

    /**
     * 显示进度AJAX
     */
    @RequestMapping("/pmgressbar")
    @ResponseBody
    public Map<String,String> pmgressbar(HttpServletRequest request){
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("type"));
        //session 获取学生登录信息
        Student student = new Student();
        if((Integer) session.getAttribute("type")==0){
            int id = Integer.parseInt(session.getAttribute("id")+"");
            student.setStu_id(id);
        }

        Map<String,String> map = new HashMap<>();
        String pmgressbar = summaryServer.pmgressbar(student);
        map.put("pmgressbar",pmgressbar);

        return map;
    }

    /**
     * 每日总结添加信息
     * @param summary
     * @param educations
     * @return
     */
    @RequestMapping("/insertSummary")
    @ResponseBody
    public Map<String,String> insertSummary(Summary summary, String educations,HttpSession session){

        Map<String,String> map = new HashMap<>();
        String str = "";
        //先获取session 然后赋值
        Student student = new Student();
        if((Integer)session.getAttribute("type")==0){
            int id = Integer.parseInt(session.getAttribute("id")+"");
            student.setStu_id(id);
        }
        summary.setStudent(student);
        Summary summ = summaryServer.selectSummaryBySum_time(summary);
        System.out.println(summary);
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
    public Map<String,Object> selectSummaryAll(HttpSession session){

        //先获取session 然后复制
        Student student = new Student();
        Summary summary = new Summary();
        if(session.getAttribute("type").equals("0")){
            int id = Integer.parseInt(session.getAttribute("id")+"");
            student.setStu_id(id);
        }
        summary.setStudent(student);
        summary.setSum_state(Summary.sum_state_undone);

        Integer pageCount = summaryServer.selectSummaryCount(summary);

        Map<String, Object> map = new HashMap<String, Object>();

        if (pageCount > 0) {

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
    public Map<String,String> replenishSummary(Summary summary,String educations){

        Map<String,String> map = new HashMap<>();
        try {
            summaryServer.replenishSummary(summary,educations);
            map.put("msg","SUCCESS");
            return map;
        }catch (Exception e){
            map.put("msg","Error");
            return map;
        }
    }

    /**
     * 学生审核页面显示
     */
    @RequestMapping("/selectSummaryTeacherAll")
    @ResponseBody
    public Map<String,Object> selectSummaryTeacherAll(HttpSession session){

        //如果是登录的老师  则获取session 然后赋值
        Teacher teacher = new Teacher();

        Summary summary = new Summary();
        if(session.getAttribute("type").equals("1")){
            int id = Integer.parseInt(session.getAttribute("id")+"");
            teacher.setT_id(id);
        }
        summary.setTeacher(teacher);
        summary.setSum_state(Summary.sum_state_authstr);

        Integer pageCount = summaryServer.selectSummaryCount(summary);

        Map<String, Object> map = new HashMap<String, Object>();

        if (pageCount > 0) {

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
    public Map<String,String> TeacherUpdateSummary(@RequestBody Summary summary,HttpSession session){
        //获取登录老师的id
        Teacher teacher = new Teacher();
        if(session.getAttribute("type").equals("1")){
            int id = Integer.parseInt(session.getAttribute("id")+"");
            teacher.setT_id(id);
        }
        summary.setTeacher(teacher);
        summary.setSum_state(Summary.sum_state_done);

        Map<String,String> map = new HashMap<>();

        try {
            summaryServer.teacherUpdateSummary(summary);
            map.put("msg","SUCCESS");
            return map;
        }catch (Exception e){
            map.put("msg","Error");
            return map;
        }

    }

    /**
     * 如果老师审核不予以通过
     */
    @RequestMapping("/TeacherDeleteSummary")
    @ResponseBody
    public Map<String,String> TeacherDeleteSummary(@RequestBody Summary summary,HttpSession session){
        //获取登录老师的id
        Teacher teacher = new Teacher();
        if(session.getAttribute("type").equals("1")){
            int id = Integer.parseInt(session.getAttribute("id")+"");
            teacher.setT_id(id);
        }
        summary.setTeacher(teacher);
        summary.setSum_state(Summary.sum_state_done);

        Map<String,String> map = new HashMap<>();

        try {
            summaryServer.TeacherDeleteSummary(summary);
            map.put("msg","SUCCESS");
            return map;
        }catch (Exception e){
            map.put("msg","Error");
            return map;
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
