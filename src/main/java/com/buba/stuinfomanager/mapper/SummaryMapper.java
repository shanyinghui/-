package com.buba.stuinfomanager.mapper;

import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Summary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface SummaryMapper {

    void insertSummary(Summary summary);

    Student selectStudentBuId(Student student);

    Integer selectSummaryCount(Summary summary);

    Integer selectSummaryCountTeacher(Summary summary);

    List<Summary> selectSummaryAll(Summary summary);

    void replenishSummary(Summary summary);

    void teacherUpdateSummary(Summary summary);

    Summary selectVerify(Summary summary);

    Summary selectVerifystu(Summary summary);

    void saveSummaryforVerify(Summary summary);

    List<Summary> selectSummaryTeacherAll(Summary summary);

    void TeacherDeleteSummary(Summary summary);

    Student pmgressbar(Student student);

    void updateStudentcycle_progress(Summary summary);

    Student selectStudentByStu_num(Summary summary);

}
