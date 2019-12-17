package com.buba.stuinfomanager.service;

import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Teacher;

public interface LoginService {
    Student stuLogin(String usernum);
    Teacher teaLogin(String usernum);
    Integer editTeaPwd(String id,String pwd);
    Integer editStuPwd(String id,String pwd);
}