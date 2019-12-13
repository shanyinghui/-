package com.buba.stuinfomanager.pojo;

import java.io.Serializable;

public class Wj implements Serializable {
    private int id;
    private String date;
    private String classes;
    private String studentname;
    private int typeid;
    private String notes;
    private String wjdate;
    private WjType wjType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getWjdate() {
        return wjdate;
    }

    public void setWjdate(String wjdate) {
        this.wjdate = wjdate;
    }

    public WjType getWjType() {
        return wjType;
    }

    public void setWjType(WjType wjType) {
        this.wjType = wjType;
    }

    @Override
    public String toString() {
        return "Wj{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", classes='" + classes + '\'' +
                ", studentname='" + studentname + '\'' +
                ", typeid=" + typeid +
                ", notes='" + notes + '\'' +
                ", wjdate='" + wjdate + '\'' +
                ", wjType=" + wjType +
                '}';
    }
}
