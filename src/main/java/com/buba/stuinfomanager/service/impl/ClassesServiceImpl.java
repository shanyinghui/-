package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.ClassesMapper;
import com.buba.stuinfomanager.pojo.CardStu;
import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.service.ClassesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public PageInfo<Classes> selAllClasses(String class_name, String headmaster, String teacher,
                                           Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Classes> classes = classesMapper.selAllClasses(class_name, headmaster, teacher);
        PageInfo<Classes> info = new PageInfo<>(classes);
        return info;
    }

    @Override
    public Classes selOneClasses(Integer class_id) {
        return classesMapper.selOneClasses(class_id);
    }

    @Override
    public PageInfo<Student> selClassCadre(Integer class_id,Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<Student> students = classesMapper.selClassCadre(class_id);
        PageInfo<Student> info = new PageInfo<>(students);
        return info;
    }

    @Override
    public List<Student> selClassStudent(Integer class_id) {
        return classesMapper.selClassStudent(class_id);
    }

    @Override
    public void insClasses(Classes classes) {
        classesMapper.insClasses(classes);
    }

    @Override
    public void delClasses(Integer class_id) {
        classesMapper.delClasses(class_id);
    }

    @Override
    public void delMoreClasses(String[] ids) {
        classesMapper.delMoreClasses(ids);
    }

    @Override
    public void updClasses(Classes classes) {
        classesMapper.updClasses(classes);
    }

    @Override
    public void updStuCard(CardStu cardStu) {
        classesMapper.updStuCard(cardStu);
    }

    @Override
    public void insStuCard(Integer stu_id,Integer class_id,Integer card_id) {
        classesMapper.insStuCard(stu_id,class_id,card_id);
    }

    @Override
    public void delStuCard(CardStu delStuCard) {
        classesMapper.delStuCard(delStuCard);
    }

    @Override
    public CardStu selOneCardStudent(Integer stu_id) {
        return classesMapper.selOneCardStudent(stu_id);
    }

}
