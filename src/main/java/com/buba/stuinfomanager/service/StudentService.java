package com.buba.stuinfomanager.service;

import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    PageInfo<Student> findAllStudent(Integer page, Integer limit, String num, String name);

    void deleteOneStudent(Integer t_id);

    Student selectOneById(Integer t_id);

    void update(Student student);

    void add(Student student);

    List<Classes> selectClass();

    void deleteMore(String[] ids);

    ResultUtil importExcel(MultipartFile file) throws IOException;

    ResultUtil exportData(List<Student> students);
 }
