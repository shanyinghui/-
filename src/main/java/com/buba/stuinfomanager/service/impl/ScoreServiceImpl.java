package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.ScoreMapper;
import com.buba.stuinfomanager.pojo.Score;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.service.ScoreService;
import com.buba.stuinfomanager.util.ExcelUtil;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {


    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public PageInfo<Score> selAllScore(String studentid,String studentname,String period,Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        List<Score> list = scoreMapper.selAllScore(studentid,studentname,period);
        PageInfo<Score> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Score selScoreById(Integer id) {
        return scoreMapper.selScoreById(id);
    }

    @Override
    public void updScore(Score score) {
        scoreMapper.updScore(score);
    }

    @Override
    public void addScore(Score score) {
        scoreMapper.addScore(score);
    }

    @Override
    public Student selStudent(String studentid) {

        return  scoreMapper.selStudent(studentid);
    }

    @Override
    public Boolean selScoreByStuidPeriod(String studentid, String period) {
        Score score = scoreMapper.selScoreByStuidPeriod(studentid, period);
        if(score != null){
            return true;
        }
        return false;
    }

    @Override
    public void updClasses(Integer classid, String studentid) {
        scoreMapper.updClasses(classid,studentid);
    }

    @Override
    public int selDownClassesId(String class_name) {
        return scoreMapper.selDownClassesId(class_name);
    }



    @Override
    public ResultUtil exportData(List<Score> list) {
        String[] title = {
                "学号",
                "学生姓名姓名",
                "班级",
                "周期进度",
                "面试成绩 ",
                "机试成绩"
        };
        String[][] content = new String[list.size()][];
        for(int i = 0; i < list.size(); i ++){
            content[i] = new String[title.length];
            Score score = list.get(i);
            content[i][0] = score.getStudentid();
            content[i][1] = score.getStudentname();
            content[i][2] = score.getClasses();
            content[i][3] = score.getPeriod();
            content[i][4] = String.valueOf(score.getInterviewresult());
            content[i][5] = String.valueOf(score.getSkillscores());
        }
        String sheetName = "成绩信息表";

        try {
            ExcelUtil.exportExcel(title, sheetName, content);
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("导出失败！");
        }
    }

    @Override
    public void updPer_progress(Integer period, String studentid) {
        scoreMapper.updPer_progress(period,studentid);
    }
}
