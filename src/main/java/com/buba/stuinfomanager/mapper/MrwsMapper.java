package com.buba.stuinfomanager.mapper;

import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Ws;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MrwsMapper {
    //查询所有卫生情况
    List<Ws> selAllWs(String begintime,String endtime,String id);
    //添加卫生情况
    Integer addWs(String class_id,String wscore,String date);
    //修改卫生情况
    Integer updWs(String class_id,String wscore,String wid);
    //删除卫生情况
    Integer delWs(String wid);
    //通过id查询当前卫生情况
    Ws selWsById(String wid);
    //查询所有班级
    List<Classes> selAllClasses();
}
