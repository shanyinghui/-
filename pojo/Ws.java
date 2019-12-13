package com.buba.stuinfomanager.pojo;

public class Ws {
    private Integer wid;
    private String wdate;
    private Integer wsroce;
    private Integer bjid;
    private Classes classes;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWdate() {
        return wdate;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }

    public Integer getWsroce() {
        return wsroce;
    }

    public void setWsroce(Integer wsroce) {
        this.wsroce = wsroce;
    }

    public Integer getBjid() {
        return bjid;
    }

    public void setBjid(Integer bjid) {
        this.bjid = bjid;
    }

    public Ws(Integer wid, String wdate, Integer wsroce, Integer bjid) {
        this.wid = wid;
        this.wdate = wdate;
        this.wsroce = wsroce;
        this.bjid = bjid;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Ws{" +
                "wid=" + wid +
                ", wdate='" + wdate + '\'' +
                ", wsroce=" + wsroce +
                ", bjid=" + bjid +
                ", classes=" + classes +
                '}';
    }
}
