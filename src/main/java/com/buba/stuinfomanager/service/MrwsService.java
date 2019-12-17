package com.buba.stuinfomanager.service;

import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Ws;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 每日卫生管理service层
 */
public interface MrwsService {
    //查询所有卫生情况
    PageInfo<Ws> selAllWs(Integer page, Integer limit, String begintime, String endtime, String class_id);
    //添加卫生情况
    Integer addWs(String class_id,String wscore);
    //修改卫生情况
    Integer updWs(String class_id,String wscore,String wid);
    //删除卫生情况
    Integer delWs(String wid);
    //通过id查询当前卫生情况
    Ws selWsById(String wid);
    //查询所有班级
    List<Classes> selAllClasses();
    //导出卫生
    ResultUtil exportData(List<Ws> students);
}
