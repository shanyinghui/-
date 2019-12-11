package com.buba.stuinfomanager.pojo;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer stu_id;
    private String stu_num;
    private Integer classid; //入学班级
    private String nowClassId; //现在班级
    private String name;
    private String sex;
    private String birthday;
    private String home; //籍贯
    private String phone;
    private String familyStatus; //家庭状态
    private String market; //市场部
    private String password; //登录密码
    private String familyCommunication; //家长沟通情况
    private String cycle_progress; //学期进度
    private Integer dept_id; //部门

    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getNowClassId() {
        return nowClassId;
    }

    public void setNowClassId(String nowClassId) {
        this.nowClassId = nowClassId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFamilyCommunication() {
        return familyCommunication;
    }

    public void setFamilyCommunication(String familyCommunication) {
        this.familyCommunication = familyCommunication;
    }

    public String getCycle_progress() {
        return cycle_progress;
    }

    public void setCycle_progress(String cycle_progress) {
        this.cycle_progress = cycle_progress;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_num='" + stu_num + '\'' +
                ", classid=" + classid +
                ", nowClassId='" + nowClassId + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", home='" + home + '\'' +
                ", phone='" + phone + '\'' +
                ", familyStatus='" + familyStatus + '\'' +
                ", market='" + market + '\'' +
                ", password='" + password + '\'' +
                ", familyCommunication='" + familyCommunication + '\'' +
                ", cycle_progress='" + cycle_progress + '\'' +
                ", dept_id=" + dept_id +
                '}';
    }
}