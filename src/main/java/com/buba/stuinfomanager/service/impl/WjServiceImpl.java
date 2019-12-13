package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.WjMapper;
import com.buba.stuinfomanager.pojo.Wj;
import com.buba.stuinfomanager.service.WjService;
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


}
