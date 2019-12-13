package com.buba.stuinfomanager.pojo;

import java.io.Serializable;

public class Teacher implements Serializable {
    private Integer t_id;
    private String t_num;
    private String name;
    private String birthday;
    private String home;
    private String phone;
    private String password;

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_num() {
        return t_num;
    }

    public void setT_num(String t_num) {
        this.t_num = t_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "t_id=" + t_id +
                ", t_num='" + t_num + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", home='" + home + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
