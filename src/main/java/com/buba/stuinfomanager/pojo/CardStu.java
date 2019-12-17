package com.buba.stuinfomanager.pojo;

public class CardStu {
    private int card_id;
    private String card_name;
    private int class_id;
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

    public CardStu() {
    }

    public CardStu(int card_id, String card_name, int class_id, Integer stu_id, String stu_num,
                   Integer classid, String nowClassId, String name, String sex, String birthday,
                   String home, String phone, String familyStatus, String market, String password
            , String familyCommunication, String cycle_progress, Integer dept_id) {
        this.card_id = card_id;
        this.card_name = card_name;
        this.class_id = class_id;
        this.stu_id = stu_id;
        this.stu_num = stu_num;
        this.classid = classid;
        this.nowClassId = nowClassId;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.home = home;
        this.phone = phone;
        this.familyStatus = familyStatus;
        this.market = market;
        this.password = password;
        this.familyCommunication = familyCommunication;
        this.cycle_progress = cycle_progress;
        this.dept_id = dept_id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

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
        return "CardStu{" +
                "card_id=" + card_id +
                ", card_name='" + card_name + '\'' +
                ", class_id=" + class_id +
                ", stu_id=" + stu_id +
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
