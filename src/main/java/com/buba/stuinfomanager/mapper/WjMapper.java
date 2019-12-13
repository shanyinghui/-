package com.buba.stuinfomanager.mapper;

import com.buba.stuinfomanager.pojo.Wj;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WjMapper {

    //查询所有违纪信息
    public List<Wj> selAllWj(String starttime,String endtime,String classes,String studentname);

    //根据id查询违纪信息
    public Wj selWjById(Integer id);

    //修改违纪信息
    public void updWj(Wj wj);

    //根据id删除
    public void delWj(Integer id);

    //新增一条违纪信息
    public void addWj(Wj wj);
}
