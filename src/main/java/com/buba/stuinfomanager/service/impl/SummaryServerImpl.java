package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.SummaryMapper;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Summary;
import com.buba.stuinfomanager.service.SummaryServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: liYong
 * @createDate: 2019/12/11
 * @remark:
 */
@Service
public class SummaryServerImpl implements SummaryServer {

    @Autowired
    private SummaryMapper summaryMapper;

    /**
     * 学生每日总结
     * @param summary
     * @param educations
     */
    @Override
    public void insertSummary(Summary summary, String educations) {

        if ("none".equals(educations)){
            summary.setSum_eduRec_army(Summary.sum_eduRec_army_no);
            summary.setSum_eduRec_tradition(Summary.sum_eduRec_tradition_no);
            summary.setSum_eduRec_school(Summary.sum_eduRec_school_no);
            summary.setSum_eduRec_workplace(Summary.sum_eduRec_workplace_no);
            summary.setSum_eduRec_politics(Summary.sum_eduRec_politics_no);
        }else {
            String[] eduRec = educations.split(",");
            for (int i = 0;i<eduRec.length;i++){

                if ("army".equals(eduRec[i])){
                    summary.setSum_eduRec_army(Summary.sum_eduRec_army_yes);
                    summary.setSum_eduRec_tradition(Summary.sum_eduRec_army_no);
                    summary.setSum_eduRec_school(Summary.sum_eduRec_school_no);
                    summary.setSum_eduRec_workplace(Summary.sum_eduRec_workplace_no);
                    summary.setSum_eduRec_politics(Summary.sum_eduRec_politics_no);
                    continue;
                }else {
                    summary.setSum_eduRec_army(Summary.sum_eduRec_army_no);
                    if ("tradition".equals(eduRec[i])){
                        summary.setSum_eduRec_army(Summary.sum_eduRec_army_no);
                        summary.setSum_eduRec_tradition(Summary.sum_eduRec_tradition_yes);
                        summary.setSum_eduRec_school(Summary.sum_eduRec_school_no);
                        summary.setSum_eduRec_workplace(Summary.sum_eduRec_workplace_no);
                        summary.setSum_eduRec_politics(Summary.sum_eduRec_politics_no);
                        continue;
                    }else {
                        summary.setSum_eduRec_tradition(Summary.sum_eduRec_army_no);
                        if ("school".equals(eduRec[i])){
                            summary.setSum_eduRec_army(Summary.sum_eduRec_army_no);
                            summary.setSum_eduRec_tradition(Summary.sum_eduRec_tradition_no);
                            summary.setSum_eduRec_school(Summary.sum_eduRec_school_yes);
                            summary.setSum_eduRec_workplace(Summary.sum_eduRec_workplace_no);
                            summary.setSum_eduRec_politics(Summary.sum_eduRec_politics_no);
                            continue;
                        }else{
                            summary.setSum_eduRec_school(Summary.sum_eduRec_school_no);
                            if ("workplace".equals(eduRec[i])){
                                summary.setSum_eduRec_army(Summary.sum_eduRec_army_no);
                                summary.setSum_eduRec_tradition(Summary.sum_eduRec_tradition_no);
                                summary.setSum_eduRec_school(Summary.sum_eduRec_school_no);
                                summary.setSum_eduRec_workplace(Summary.sum_eduRec_workplace_yes);
                                summary.setSum_eduRec_politics(Summary.sum_eduRec_politics_no);
                                continue;
                            }else {
                                summary.setSum_eduRec_workplace(Summary.sum_eduRec_workplace_no);
                                if ("politics".equals(eduRec[i])){
                                    summary.setSum_eduRec_army(Summary.sum_eduRec_army_no);
                                    summary.setSum_eduRec_tradition(Summary.sum_eduRec_tradition_no);
                                    summary.setSum_eduRec_school(Summary.sum_eduRec_school_no);
                                    summary.setSum_eduRec_workplace(Summary.sum_eduRec_workplace_no);
                                    summary.setSum_eduRec_politics(Summary.sum_eduRec_politics_yes);
                                    continue;
                                }else {
                                    summary.setSum_eduRec_politics(Summary.sum_eduRec_politics_no);
                                }
                            }
                        }
                    }
                }
            }
        }

        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        summary.setSum_time(dateString);
        summary.setSum_state(Summary.sum_state_done);
        summaryMapper.insertSummary(summary);

    }

    @Override
    public Student selectStudentBuId(Student student) {

        return summaryMapper.selectStudentBuId(student);
    }

    @Override
    public Summary selectSummaryBySum_time(Summary summary) {

        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        summary.setSum_time(dateString);
        return summaryMapper.selectVerify(summary);
    }

    /**
     * 查询总条数
     * @return
     */
    @Override
    public Integer selectSummaryCount(Integer state) {
        Summary summary = new Summary();
        summary.setSum_state(state);
        //先获取session 然后复制
        Student student = new Student();
        student.setStu_id(1);
        summary.setStudent(student);
        return summaryMapper.selectSummaryCount(summary);
    }

    @Override
    public List<Summary> selectSummaryAll(Summary summary) {
        return  summaryMapper.selectSummaryAll(summary);
    }

    /**
     * 补充 - 修改
     * @param summary
     */
    @Override
    public void replenishSummary(Summary summary,String educations) {

        if ("none".equals(educations)){
            summary.setSum_eduRec_army(Summary.sum_eduRec_army_no);
            summary.setSum_eduRec_tradition(Summary.sum_eduRec_tradition_no);
            summary.setSum_eduRec_school(Summary.sum_eduRec_school_no);
            summary.setSum_eduRec_workplace(Summary.sum_eduRec_workplace_no);
            summary.setSum_eduRec_politics(Summary.sum_eduRec_politics_no);
        }else {
            String[] eduRec = educations.split(",");
            for (int i = 0;i<eduRec.length;i++){

                if ("army".equals(eduRec[i])){
                    summary.setSum_eduRec_army(Summary.sum_eduRec_army_yes);
                    summary.setSum_eduRec_tradition(Summary.sum_eduRec_army_no);
                    summary.setSum_eduRec_school(Summary.sum_eduRec_school_no);
                    summary.setSum_eduRec_workplace(Summary.sum_eduRec_workplace_no);
                    summary.setSum_eduRec_politics(Summary.sum_eduRec_politics_no);
                    continue;
                }else {
                    summary.setSum_eduRec_army(Summary.sum_eduRec_army_no);
                    if ("tradition".equals(eduRec[i])){
                        summary.setSum_eduRec_army(Summary.sum_eduRec_army_no);
                        summary.setSum_eduRec_tradition(Summary.sum_eduRec_tradition_yes);
                        summary.setSum_eduRec_school(Summary.sum_eduRec_school_no);
                        summary.setSum_eduRec_workplace(Summary.sum_eduRec_workplace_no);
                        summary.setSum_eduRec_politics(Summary.sum_eduRec_politics_no);
                        continue;
                    }else {
                        summary.setSum_eduRec_tradition(Summary.sum_eduRec_army_no);
                        if ("school".equals(eduRec[i])){
                            summary.setSum_eduRec_army(Summary.sum_eduRec_army_no);
                            summary.setSum_eduRec_tradition(Summary.sum_eduRec_tradition_no);
                            summary.setSum_eduRec_school(Summary.sum_eduRec_school_yes);
                            summary.setSum_eduRec_workplace(Summary.sum_eduRec_workplace_no);
                            summary.setSum_eduRec_politics(Summary.sum_eduRec_politics_no);
                            continue;
                        }else{
                            summary.setSum_eduRec_school(Summary.sum_eduRec_school_no);
                            if ("workplace".equals(eduRec[i])){
                                summary.setSum_eduRec_army(Summary.sum_eduRec_army_no);
                                summary.setSum_eduRec_tradition(Summary.sum_eduRec_tradition_no);
                                summary.setSum_eduRec_school(Summary.sum_eduRec_school_no);
                                summary.setSum_eduRec_workplace(Summary.sum_eduRec_workplace_yes);
                                summary.setSum_eduRec_politics(Summary.sum_eduRec_politics_no);
                                continue;
                            }else {
                                summary.setSum_eduRec_workplace(Summary.sum_eduRec_workplace_no);
                                if ("politics".equals(eduRec[i])){
                                    summary.setSum_eduRec_army(Summary.sum_eduRec_army_no);
                                    summary.setSum_eduRec_tradition(Summary.sum_eduRec_tradition_no);
                                    summary.setSum_eduRec_school(Summary.sum_eduRec_school_no);
                                    summary.setSum_eduRec_workplace(Summary.sum_eduRec_workplace_no);
                                    summary.setSum_eduRec_politics(Summary.sum_eduRec_politics_yes);
                                    continue;
                                }else {
                                    summary.setSum_eduRec_politics(Summary.sum_eduRec_politics_no);
                                }
                            }
                        }
                    }
                }
            }
        }

        summary.setSum_state(Summary.sum_state_authstr);
        summaryMapper.replenishSummary(summary);
    }

    /**
     * 老师审核-修改
     * @param summary
     */
    @Override
    public void teacherUpdateSummary(Summary summary) {

        summary.setSum_state(Summary.sum_state_done);
        summaryMapper.teacherUpdateSummary(summary);
    }

    /**
     * 查询昨天又没有总结
     * @param time
     * @return
     */
    @Override
    public void selectVerify(Student student,String time) {

        Summary sum = new Summary();
        sum.setSum_time(time);
        sum.getStudent().setStu_id(student.getStu_id());
        Summary summary = summaryMapper.selectVerify(sum);
        if (null != summary){ //总结了

        }else {
            sum.setSum_state(Summary.sum_state_undone);
            summaryMapper.saveSummaryforVerify(sum);
        }

    }

    @Override
    public List<Summary> selectSummaryTeacherAll(Summary summary) {
        return summaryMapper.selectSummaryTeacherAll(summary);
    }
}
