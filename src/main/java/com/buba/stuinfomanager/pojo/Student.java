package com.buba.stuinfomanager.pojo;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer stu_id;
    private String stu_num;
    private Integer classid;
    private Integer nowClassId;

    private String name;
    private String sex;
    private String birthday;
    private String home; //籍贯
    private String phone;
    private String familyStatus; //家庭状态
    private String market; //市场部
    private String password; //登录密码
    private String familyCommunication; //家长沟通情况
    private Integer cycle_progress; //学期总进度
    private Integer dept_id; //部门
    private Student_Union student_union;
    private Classes classes; //入学班级
    private Classes nowClasses; //现在班级
    private Integer per_progress;
    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getNowClassId() {
        return nowClassId;
    }

    public void setNowClassId(Integer nowClassId) {
        this.nowClassId = nowClassId;
    }

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Classes getNowClasses() {
        return nowClasses;
    }

    public void setNowClasses(Classes nowClasses) {
        this.nowClasses = nowClasses;
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

    public Integer getCycle_progress() {
        return cycle_progress;
    }

    public void setCycle_progress(Integer cycle_progress) {
        this.cycle_progress = cycle_progress;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Student_Union getStudent_union() {
        return student_union;
    }

    public void setStudent_union(Student_Union student_union) {
        this.student_union = student_union;
    }


    public Integer getPer_progress() {
        return per_progress;
    }

    public void setPer_progress(Integer per_progress) {
        this.per_progress = per_progress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_num='" + stu_num + '\'' +
                ", classid=" + classid +
                ", nowClassId=" + nowClassId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", home='" + home + '\'' +
                ", phone='" + phone + '\'' +
                ", familyStatus='" + familyStatus + '\'' +
                ", market='" + market + '\'' +
                ", password='" + password + '\'' +
                ", familyCommunication='" + familyCommunication + '\'' +
                ", cycle_progress=" + cycle_progress +
                ", dept_id=" + dept_id +
                ", student_union=" + student_union +
                ", classes=" + classes +
                ", nowClasses=" + nowClasses +
                ", per_progress=" + per_progress +
                '}';
    }
}
