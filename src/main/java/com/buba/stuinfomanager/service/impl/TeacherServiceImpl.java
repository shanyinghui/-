package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.TeacherMapper;
import com.buba.stuinfomanager.pojo.Teacher;
import com.buba.stuinfomanager.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public PageInfo<Teacher> findAllTeacher(Integer page,Integer limit,String t_num,String name) {
        PageHelper.startPage(page,limit);
        List<Teacher> teachers = teacherMapper.findAllTeacher(t_num,name);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
        return pageInfo;
    }

    @Override
    public void deleteOneTeacher(Integer t_id) {
        teacherMapper.deleteOneTeacher(t_id);
    }

    @Override
    public Teacher selectOneById(Integer t_id) {
        return teacherMapper.selectOneById(t_id);
    }

    @Override
    public void update(Teacher teacher) {
        teacherMapper.update(teacher);
    }


    @Override
    public void add(Teacher teacher) {
        String str = teacherMapper.selectMaxT_num();
        String str1 = str.substring(1);
        int num = Integer.parseInt(str1)+1;
        String t_num = "t"+num;
        teacher.setT_num(t_num);
        teacherMapper.add(teacher);
    }

    @Override
    public void deleteMore(String[] ids) {
        teacherMapper.deleteMore(ids);
    }
}
