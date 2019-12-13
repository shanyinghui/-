package com.buba.stuinfomanager.mapper;

import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> findAllStudent(@Param("stu_num") String num, @Param("name") String name);

    void deleteOneStudent(Integer t_id);

    Student selectOneById(Integer t_id);

    void update(Student student);

    void add(Student student);

    List<Classes> selectClass();

    String selectMaxStu_num(Integer nowClassId);

    String selectClassName(Integer classid);

    //删除多个
    void deleteMore(@Param("stuid")String[] ids);
}
