package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.StudentMapper;
import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageInfo<Student> findAllStudent(Integer page, Integer limit, String num, String name) {
        PageHelper.startPage(page,limit);
        List<Student> students = studentMapper.findAllStudent(num, name);
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return pageInfo;
    }

    @Override
    public void deleteOneStudent(Integer t_id) {
        studentMapper.deleteOneStudent(t_id);
    }

    @Override
    public Student selectOneById(Integer stu_id) {
        return studentMapper.selectOneById(stu_id);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void add(Student student) {
        String str = studentMapper.selectMaxStu_num(student.getNowClassId());
        if(str==null || str.isEmpty()){
            String classname = studentMapper.selectClassName(student.getNowClassId());
            student.setStu_num(classname.substring(0,4)+"01");
        }else{
            String format = String.format("%02d", Integer.parseInt(str.substring(4)) + 1);
            String stu_num = str.substring(0,4) + format;
            student.setStu_num(stu_num);
        }
        System.out.println(student.getStu_num());
        studentMapper.add(student);
    }

    @Override
    public List<Classes> selectClass() {
        return studentMapper.selectClass();
    }

    @Override
    public void deleteMore(String[] ids) {
        studentMapper.deleteMore(ids);
    }
}
