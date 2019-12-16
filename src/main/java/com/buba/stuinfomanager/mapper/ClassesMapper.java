package com.buba.stuinfomanager.mapper;

import com.buba.stuinfomanager.pojo.CardStu;
import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesMapper {
    //查询所有班级
    List<Classes> selAllClasses(String class_name, String headmaster, String teacher);

    //查询单个班级
    Classes selOneClasses(Integer class_id);

    //查询单个班级的班干部
    List<Student> selClassCadre(Integer class_id);

    //查询单个班级的学生
    List<Student> selClassStudent(Integer class_id);

    //添加一个班级
    void insClasses(Classes classes);

    //删除一个班级
    void delClasses(Integer class_id);

    //删除多个班级
    void delMoreClasses(@Param("stuid")String[] ids);

    //修改一个班级
    void updClasses(Classes classes);

    //修改学生班干部职位
    void updStuCard(CardStu cardStu);

    //添加学生班干部职位
    void insStuCard(Integer stu_id, Integer class_id, Integer card_id);

    //删除学生班干部职位
    void delStuCard(CardStu cardStu);

    //查询当前学生
    CardStu selOneCardStudent(Integer stu_id);
}
