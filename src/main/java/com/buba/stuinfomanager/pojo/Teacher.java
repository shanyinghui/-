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
