package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.Student_UnionMapper;
import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Student_Union;
import com.buba.stuinfomanager.service.Student_UnionService;
import com.buba.stuinfomanager.util.ExcelUtil;
import com.buba.stuinfomanager.util.MyUtil;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Service
public class Student_UnionServiceImpl implements Student_UnionService {

    @Autowired
    private Student_UnionMapper student_unionMapper;


    @Override
    public PageInfo<Student> selStu_UnionStu(Integer department_id, String name, Integer sex,
                                             Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Student> students = student_unionMapper.selStu_UnionStu(department_id, name, sex);
        PageInfo<Student> info = new PageInfo<>(students);
        return info;
    }

    @Override
    public void updStu_Union(Student student) {
        student_unionMapper.updStu_Union(student);
    }

    @Override
    public Student selOneStu_UnionStu(Integer stu_id) {
        return student_unionMapper.selOneStu_UnionStu(stu_id);
    }

    @Override
    public List<Student> selAllNoStu_UnionStu() {
        return student_unionMapper.selAllNoStu_UnionStu();
    }


    @Override
    public ResultUtil exportData(List<Student> list) {
        String[] title = {
                "学号",
                "学生姓名",
                "性别",
                "部门"
        };
        String[][] content = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            Student stu = list.get(i);
            content[i][0] = stu.getStu_num();
            content[i][1] = stu.getName();
            if (stu.getSex() != null && !stu.getSex().equals("")) {
                content[i][2] = Integer.parseInt(stu.getSex()) == 0 ? "男" : "女";
            }
            if (stu.getDept_id() != null && !stu.getSex().equals("") && stu.getDept_id() != 0) {
                content[i][3] = stu.getDept_id() == 1 ? "生活部" : (stu.getDept_id() == 2 ? "纪检部" :
                        (stu.getDept_id() == 3 ? "文体部" : stu.getDept_id() == 4 ? "学习部" : "宣传部"));
            }
        }
        String sheetName = "学生信息表";

        try {
            ExcelUtil.exportExcel(title, sheetName, content);
            return ResultUtil.ok("导出成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("导出失败！");
        }
    }
}
