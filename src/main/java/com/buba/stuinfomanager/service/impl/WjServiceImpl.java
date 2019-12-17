package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.WjMapper;
import com.buba.stuinfomanager.pojo.Wj;
import com.buba.stuinfomanager.service.WjService;
import com.buba.stuinfomanager.util.ExcelUtil;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WjServiceImpl implements WjService {
    @Autowired
    WjMapper wjMapper;

    @Override
    public PageInfo<Wj> selAllWj(String starttime, String endtime, String classes, String studentname, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Wj> list = wjMapper.selAllWj(starttime, endtime, classes, studentname);
        PageInfo<Wj> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Wj selWjById(Integer id) {
        Wj wj = wjMapper.selWjById(id);
        return wj;
    }

    @Override
    public void addWj(Wj wj) {
        wjMapper.addWj(wj);
    }

    @Override
    public void delWj(Integer id) {
        wjMapper.delWj(id);
    }

    @Override
    public void updWj(Wj wj) {
        wjMapper.updWj(wj);
    }

    @Override
    public ResultUtil exportData(List<Wj> list) {
        String[] title = {
                "姓名",
                "班级",
                "违纪日期",
                "违纪类型 ",
                "备注"
        };
        String[][] content = new String[list.size()][];
        for(int i = 0; i < list.size(); i ++){
            content[i] = new String[title.length];
            Wj wj = list.get(i);
            content[i][0] = wj.getStudentname();
            content[i][1] = wj.getClasses();
            content[i][2] = wj.getWjdate();
            content[i][3] = wj.getWjType().getTypename();
            content[i][4] = wj.getNotes();
        }
        String sheetName = "违纪信息表";

        try {
            ExcelUtil.exportExcel(title, sheetName, content);
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("导出失败！");
        }
    }


}
