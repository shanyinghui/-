package com.buba.stuinfomanager.pojo;

import java.io.Serializable;

public class Student_Union implements Serializable {
    private Integer department_id;
    private String department_name;

    public Student_Union() {
    }

    public Student_Union(Integer department_id, String department_name) {
        this.department_id = department_id;
        this.department_name = department_name;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    @Override
    public String toString() {
        return "Student_Union{" +
                "department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}
