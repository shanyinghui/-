package com.buba.stuinfomanager.mapper;

import com.buba.stuinfomanager.pojo.Score;
import com.buba.stuinfomanager.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreMapper {

    //查询所有成绩信息
    public List<Score> selAllScore(String studentid,String studentname,String period);

    //根据id查询成绩信息
    public Score selScoreById(Integer id);

    //添加一条成绩信息
    public void addScore(Score score);

    //修改成绩信息
    public void updScore(Score score);

    //删除一条成绩信息
    public void delScore(Integer id);

    //根据学号查询一个学生
    public Student selStudent(String studentid);

    //根据学号与周期查询成绩是否已经添加
    public Score selScoreByStuidPeriod(String studentid,String period);
}
