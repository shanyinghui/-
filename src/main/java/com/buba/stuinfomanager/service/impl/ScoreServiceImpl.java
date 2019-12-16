package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.ScoreMapper;
import com.buba.stuinfomanager.pojo.Score;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Wj;
import com.buba.stuinfomanager.service.ScoreService;
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
}
