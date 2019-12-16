package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.MrwsMapper;
import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Ws;
import com.buba.stuinfomanager.service.MrwsService;
import com.buba.stuinfomanager.util.ExcelUtil;
import com.buba.stuinfomanager.util.ResultUtil;
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
    public ResultUtil exportData(List<Ws> list) {
        String[] title = {
                "日期",
                "班级",
                "分数",
        };
        String[][] content = new String[list.size()][];
        for(int i = 0; i < list.size(); i ++){
            content[i] = new String[title.length];
            Ws ws = list.get(i);
            content[i][0] = ws.getWdate();
            content[i][1] = ws.getClasses().getClass_name();
            content[i][2] = ws.getWsroce()+"";
        }
        String sheetName = "卫生信息表";

        try {
            ExcelUtil.exportExcel(title, sheetName, content);
            return ResultUtil.ok("导出成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("导出失败！");
        }
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
