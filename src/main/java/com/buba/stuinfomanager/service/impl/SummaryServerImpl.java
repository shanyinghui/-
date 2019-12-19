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
        summaryMapper.updateStudentcycle_progress(summary);

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
    public Integer selectSummaryCount(Summary summary) {
        if (Summary.sum_state_undone.equals(summary.getSum_state())){
            return summaryMapper.selectSummaryCount(summary);
        }else {
            System.out.println("是老师");
            return summaryMapper.selectSummaryCountTeacher(summary);
        }
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

        summaryMapper.teacherUpdateSummary(summary);
        summary.setStudent(summaryMapper.selectStudentByStu_num(summary));
        summaryMapper.updateStudentcycle_progress(summary);

    }

    /**
     * 查询昨天又没有总结
     * @param time
     * @return
     */
    @Override
    public void selectVerify(Student student) {

        Summary sum = new Summary();
        Date date4 = new Date(new Date().getTime()-24*60*60*1000);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String time = sdf.format(date4);
        sum.setSum_time(time);

        sum.setStudent(student);
        sum.getStudent().setStu_id(student.getStu_id());
        Summary summary = summaryMapper.selectVerify(sum);
        if (null != summary){ //总结了

        }else {
            sum.setSum_state(Summary.sum_state_undone);
            summaryMapper.saveSummaryforVerify(sum);
        }

    }

    @Override
    public void selectVerifystu(Student student, String time) {
        Summary sum = new Summary();
        sum.setSum_time(time);
        sum.getStudent().setStu_id(student.getStu_id());
        Summary summary = summaryMapper.selectVerifystu(sum);
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

    @Override
    public void TeacherDeleteSummary(Summary summary) {
        summaryMapper.TeacherDeleteSummary(summary);
    }

    @Override
    public String pmgressbar(Student student) {

        student = summaryMapper.pmgressbar(student);
        Integer cycle_progress = student.getCycle_progress();
        if (cycle_progress < 20 ){

            return "0/20";
        }else {
            Integer num = cycle_progress%20;
            System.out.println(num);
            if (num == 0){
               return cycle_progress/20 + "/20";
            }else {
                return (cycle_progress-num)/20 + "/20";
            }
        }

    }
}
