package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.LoginMapper;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Teacher;
import com.buba.stuinfomanager.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    //注入mapper对象
    @Autowired
    LoginMapper loginMapper;
    //学生登录
    @Override
    public Student stuLogin(String usernum) {
        return loginMapper.stuLogin(usernum);
    }
    //教室登录
    @Override
    public Teacher teaLogin(String usernum) {
        return loginMapper.teaLogin(usernum);
    }

    @Override
    public Integer editTeaPwd(String id, String pwd) {
        return loginMapper.editTeaPwd(id,pwd);
    }
    @Override
    public Integer editStuPwd(String id, String pwd) {
        return loginMapper.editStuPwd(id,pwd);
    }
}
