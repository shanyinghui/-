package com.buba.stuinfomanager.service;

import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Summary;

import java.util.List;

/**
 * @description:
 * @author: liYong
 * @createDate: 2019/12/11
 * @remark:
 */
public interface SummaryServer {

    void insertSummary(Summary summary,String educations);

    Student selectStudentBuId(Student student);

    Summary selectSummaryBySum_time(Summary summary);

    Integer selectSummaryCount(Summary summary);

    List<Summary> selectSummaryAll(Summary summary);

    void replenishSummary(Summary summary,String educations);

    void teacherUpdateSummary(Summary summary);

    void selectVerify(Student student,String time);

    void selectVerifystu(Student student,String time);

    List<Summary> selectSummaryTeacherAll(Summary summary);

    void TeacherDeleteSummary(Summary summary);

    String pmgressbar(Student student);

}
