package com.buba.stuinfomanager.mapper;

import com.buba.stuinfomanager.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {
    List<Teacher> findAllTeacher(@Param("t_num") String tnum, @Param("name") String name);

    void deleteOneTeacher(Integer t_id);

    Teacher selectOneById(Integer t_id);

    void update(Teacher teacher);

    void add(Teacher teacher);

    String selectMaxT_num();

    //删除多个
    void deleteMore(@Param("tids")String[] ids);
}
