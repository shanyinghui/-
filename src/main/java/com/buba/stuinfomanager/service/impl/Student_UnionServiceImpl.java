package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.Student_UnionMapper;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Student_Union;
import com.buba.stuinfomanager.service.Student_UnionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student_UnionServiceImpl implements Student_UnionService {

    @Autowired
    private Student_UnionMapper student_unionMapper;


    @Override
    public PageInfo<Student> selStu_UnionStu(Integer department_id, String name, Integer sex,
                                    Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Student> students = student_unionMapper.selStu_UnionStu(department_id, name, sex);
        PageInfo<Student> info = new PageInfo<>(students);
        return info;
    }

    @Override
    public void updStu_Union(Student student) {
        student_unionMapper.updStu_Union(student);
    }

    @Override
    public Student selOneStu_UnionStu(Integer stu_id) {
        return student_unionMapper.selOneStu_UnionStu(stu_id);
    }

    @Override
    public List<Student> selAllNoStu_UnionStu() {
        return student_unionMapper.selAllNoStu_UnionStu();
    }
}
