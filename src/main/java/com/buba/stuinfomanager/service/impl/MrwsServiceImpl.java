package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.MrwsMapper;
import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Ws;
import com.buba.stuinfomanager.service.MrwsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MrwsServiceImpl implements MrwsService {
    //注入mapper对象
    @Autowired
    MrwsMapper mrwsMapper;
    @Override
    public PageInfo<Ws> selAllWs(Integer page,Integer limit,String begintime,String endtime,String class_id) {
        PageHelper.startPage(page,limit);
        List<Ws> ws = mrwsMapper.selAllWs(begintime, endtime, class_id);
        PageInfo<Ws> pageinfo =  new PageInfo<>(ws);
        return pageinfo;
    }

    @Override
    public Integer addWs(String class_id, String wscore) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        return mrwsMapper.addWs(class_id,wscore,df.format(new Date()));
    }

    @Override
    public Integer updWs(String class_id, String wscore, String wid) {
        return mrwsMapper.updWs(class_id,wscore,wid);
    }

    @Override
    public Integer delWs(String wid) {
        return mrwsMapper.delWs(wid);
    }

    @Override
    public Ws selWsById(String wid) {
        return mrwsMapper.selWsById(wid);
    }

    @Override
    public List<Classes> selAllClasses() {
        return mrwsMapper.selAllClasses();
    }
}
