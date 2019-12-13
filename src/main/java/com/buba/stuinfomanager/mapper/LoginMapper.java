package com.buba.stuinfomanager.mapper;

import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    //学生登录
    Student stuLogin(String usernum);
    //教师登录
    Teacher teaLogin(String usernum);
    //修改教师密码
    Integer editTeaPwd(String id,String pwd);
    //修改学生密码
    Integer editStuPwd(String id,String pwd);
}
