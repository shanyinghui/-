package com.buba.stuinfomanager.service;

import com.buba.stuinfomanager.pojo.Score;
import com.buba.stuinfomanager.pojo.Wj;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WjService {

    //查询所有违纪信息
    public PageInfo<Wj> selAllWj(String starttime, String endtime, String classes, String studentname, Integer page, Integer limit);

    //根据id查询违纪信息
    public Wj selWjById(Integer id);

    //新增一条违纪信息
    public void addWj(Wj wj);

    //根据id删除
    public void delWj(Integer id);

    //修改违纪信息
    public void updWj(Wj wj);

    ResultUtil exportData(List<Wj> wj);
}
