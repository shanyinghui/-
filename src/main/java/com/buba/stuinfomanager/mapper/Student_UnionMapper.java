package com.buba.stuinfomanager.mapper;

import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Student_Union;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Student_UnionMapper {

    //修改、添加、删除学生在哪个部门
    void updStu_Union(Student student);

    //查询某个部有哪些学生
    List<Student> selStu_UnionStu(Integer department_id, String name, Integer sex);

    //查询某个学生
    Student selOneStu_UnionStu(Integer stu_id);

    //查询所有没有在学生部门的学生
    List<Student> selAllNoStu_UnionStu();
}
