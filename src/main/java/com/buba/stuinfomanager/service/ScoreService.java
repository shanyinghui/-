package com.buba.stuinfomanager.service;

import com.buba.stuinfomanager.pojo.Score;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface ScoreService {
    //查询所有成绩信息
    public PageInfo<Score> selAllScore(String studentid, String studentname, String period, Integer page, Integer limit);

    //根据id查询成绩信息
    public Score selScoreById(Integer id);

    //修改一条成绩信息
    public void updScore(Score score);

    //添加一条成绩信息
    public void addScore(Score score);

    //根据学号查询一个学生
    public Student selStudent(String studentid);

    //根据学号与周期查询成绩是否已经添加
    public Boolean selScoreByStuidPeriod(String studentid,String period);

    //根据学号修改学生所在班级
    public void updClasses(Integer classid,String studentid);

    //查询降班id
    public int selDownClassesId(String class_name);

    //导出
    ResultUtil exportData(List<Score> score);

    public void updPer_progress(Integer period , String studentid);

    //批量导入
    public ResultUtil importExcel(@RequestParam("file")MultipartFile file) throws IOException;
}
