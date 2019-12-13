package com.buba.stuinfomanager.controller;

import com.buba.stuinfomanager.pojo.Score;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.service.ScoreService;
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
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @ResponseBody
    @RequestMapping("/selAllScore")
    public ResultUtil selAllScore(String studentid,String studentname,String period,Integer page,Integer limit){
        PageInfo<Score> pageInfo = scoreService.selAllScore(studentid,studentname,period,page,limit);
        ResultUtil resultUtil = new ResultUtil(0,"",pageInfo.getTotal(),pageInfo.getList());
        return resultUtil;
    }


    @RequestMapping("/selScoreById")
    public String selScoreById(@RequestParam("id") Integer id, Model model){
        Score score = scoreService.selScoreById(id);
        model.addAttribute("score",score);
        return "/scoreManager/edit.html";
    }

    @ResponseBody
    @RequestMapping("/updScore")
    public void updScore(@RequestBody Score score){
        scoreService.updScore(score);
    }

    @ResponseBody
    @RequestMapping("/addScore")
    public void addScore(@RequestBody Score score){
         scoreService.addScore(score);
    }

    @ResponseBody
    @RequestMapping("/selStudent")
    public Student selStudent(String studentid){
        Student student = scoreService.selStudent(studentid);
        return student;
    }

    @ResponseBody
    @RequestMapping("/selScoreByStuidPeriod")
    public Boolean selScoreByStuidPeriod(String studentid,String period){
        Boolean bool = scoreService.selScoreByStuidPeriod(studentid, period);
        return bool;
    }
}
