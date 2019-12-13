package com.buba.stuinfomanager.service;

import com.buba.stuinfomanager.pojo.CardStu;
import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ClassesService {
    //查询所有班级
    PageInfo<Classes> selAllClasses(String class_name, String headmaster, String teacher,
                                    Integer page, Integer limit);

    //查询单个班级
    Classes selOneClasses(Integer class_id);

    //查询单个班级的班干部
    PageInfo<Student> selClassCadre(Integer class_id,Integer page,Integer limit);

    //查询单个班级的学生
    List<Student> selClassStudent(Integer class_id);

    //添加一个班级
    void insClasses(Classes classes);

    //删除一个班级
    void delClasses(Integer class_id);

    //修改一个班级
    void updClasses(Classes classes);

    //修改学生班干部职位
    void updStuCard(CardStu cardStu);

    //添加学生班干部职位
    void insStuCard(Integer stu_id,Integer class_id,Integer card_id);

    //删除学生班干部职位
    void delStuCard(CardStu delStuCard);

}
