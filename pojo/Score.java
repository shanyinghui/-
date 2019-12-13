package com.buba.stuinfomanager.pojo;

import java.io.Serializable;

public class Score implements Serializable {
    private int id;
    private String studentid;
    private String classes;
    private String studentname;
    private String period;//周期
    private String interviewresult;//面试成绩
    private String skillscores;//机试成绩

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getInterviewresult() {
        return interviewresult;
    }

    public void setInterviewresult(String interviewresult) {
        this.interviewresult = interviewresult;
    }

    public String getSkillscores() {
        return skillscores;
    }

    public void setSkillscores(String skillscores) {
        this.skillscores = skillscores;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", studentid='" + studentid + '\'' +
                ", classes='" + classes + '\'' +
                ", studentname='" + studentname + '\'' +
                ", period='" + period + '\'' +
                ", interviewresult='" + interviewresult + '\'' +
                ", skillscores='" + skillscores + '\'' +
                '}';
    }
}
