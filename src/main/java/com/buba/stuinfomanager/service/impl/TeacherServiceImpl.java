package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.TeacherMapper;
import com.buba.stuinfomanager.pojo.Teacher;
import com.buba.stuinfomanager.service.TeacherService;
import com.buba.stuinfomanager.util.ExcelUtil;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public PageInfo<Teacher> findAllTeacher(Integer page,Integer limit,String t_num,String name) {
        PageHelper.startPage(page,limit);
        List<Teacher> teachers = teacherMapper.findAllTeacher(t_num,name);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
        return pageInfo;
    }

    @Override
    public void deleteOneTeacher(Integer t_id) {
        teacherMapper.deleteOneTeacher(t_id);
    }

    @Override
    public Teacher selectOneById(Integer t_id) {
        return teacherMapper.selectOneById(t_id);
    }

    @Override
    public void update(Teacher teacher) {
        teacherMapper.update(teacher);
    }


    @Override
    public void add(Teacher teacher) {
        String str = teacherMapper.selectMaxT_num();
        String str1 = str.substring(1);
        int num = Integer.parseInt(str1)+1;
        String t_num = "t"+num;
        teacher.setT_num(t_num);
        teacherMapper.add(teacher);
    }

    @Override
    public void deleteMore(String[] ids) {
        teacherMapper.deleteMore(ids);
    }

    @Override
    public ResultUtil exportData(List<Teacher> list) {
        String[] title = {
                "教号",
                "教师姓名",
                "出生日期",
                "籍贯",
                "联系电话 "
        };
        String[][] content = new String[list.size()][];
        for(int i = 0; i < list.size(); i ++){
            content[i] = new String[title.length];
            Teacher teacher = list.get(i);
            content[i][0] = teacher.getT_num();
            content[i][1] = teacher.getName();
            content[i][2] = teacher.getBirthday();
            content[i][3] = teacher.getHome();
            content[i][4] = teacher.getPhone();
        }
        String sheetName = "教师信息表";

        try {
            ExcelUtil.exportExcel(title, sheetName, content);
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("导出失败！");
        }
    }
}
