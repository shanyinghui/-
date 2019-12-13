package com.buba.stuinfomanager.pojo;

import java.io.Serializable;

public class Classes implements Serializable {
    private Integer class_id;
    private String class_name;
    private String headmaster;
    private String teacher;
    private String cycle_progress;

    public Classes() {
    }

    public Classes(Integer class_id, String class_name, String headmaster, String teacher,
                   String cycle_progress) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.headmaster = headmaster;
        this.teacher = teacher;
        this.cycle_progress = cycle_progress;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(String headmaster) {
        this.headmaster = headmaster;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCycle_progress() {
        return cycle_progress;
    }

    public void setCycle_progress(String cycle_progress) {
        this.cycle_progress = cycle_progress;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "class_id=" + class_id +
                ", class_name='" + class_name + '\'' +
                ", headmaster='" + headmaster + '\'' +
                ", teacher='" + teacher + '\'' +
                ", cycle_progress='" + cycle_progress + '\'' +
                '}';
    }
}
