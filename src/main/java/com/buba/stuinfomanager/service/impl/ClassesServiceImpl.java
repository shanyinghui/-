package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.ClassesMapper;
import com.buba.stuinfomanager.pojo.CardStu;
import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.service.ClassesService;
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
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public PageInfo<Classes> selAllClasses(String class_name, String headmaster, String teacher,
                                           Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Classes> classes = classesMapper.selAllClasses(class_name, headmaster, teacher);
        PageInfo<Classes> info = new PageInfo<>(classes);
        return info;
    }

    @Override
    public Classes selOneClasses(Integer class_id) {
        return classesMapper.selOneClasses(class_id);
    }

    @Override
    public PageInfo<Student> selClassCadre(Integer class_id,Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<Student> students = classesMapper.selClassCadre(class_id);
        PageInfo<Student> info = new PageInfo<>(students);
        return info;
    }

    @Override
    public List<Student> selClassStudent(Integer class_id) {
        return classesMapper.selClassStudent(class_id);
    }

    @Override
    public void insClasses(Classes classes) {
        classesMapper.insClasses(classes);
    }

    @Override
    public void delClasses(Integer class_id) {
        classesMapper.delClasses(class_id);
    }

    @Override
    public void delMoreClasses(String[] ids) {
        classesMapper.delMoreClasses(ids);
    }

    @Override
    public void updClasses(Classes classes) {
        classesMapper.updClasses(classes);
    }

    @Override
    public void updStuCard(CardStu cardStu) {
        classesMapper.updStuCard(cardStu);
    }

    @Override
    public void insStuCard(Integer stu_id,Integer class_id,Integer card_id) {
        classesMapper.insStuCard(stu_id,class_id,card_id);
    }

    @Override
    public void delStuCard(CardStu delStuCard) {
        classesMapper.delStuCard(delStuCard);
    }

    @Override
    public CardStu selOneCardStudent(Integer stu_id) {
        return classesMapper.selOneCardStudent(stu_id);
    }

    @Override
    public ResultUtil importExcel(MultipartFile file) {
        try {
            InputStream in = file.getInputStream();
            Workbook wb = WorkbookFactory.create(in);
            Sheet sheet = wb.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 2; i <= lastRowNum; i++) {
                Row row = sheet.getRow(i);
                Classes classes = new Classes();
                classes.setClass_name(row.getCell(0).getStringCellValue());
                classes.setHeadmaster(row.getCell(1).getStringCellValue());
                classes.setTeacher(row.getCell(2).getStringCellValue());
                classes.setCycle_progress(row.getCell(3).getStringCellValue());
                System.out.println(classes);
                classesMapper.insClasses(classes);
            }
            return ResultUtil.ok("导入成功！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }


    }

    @Override
    public ResultUtil exportData(List<Classes> list) {
        String[] title = {
                "班名",
                "班主任",
                "老师",
                "周期进度",
        };
        String[][] content = new String[list.size()][];
        for(int i = 0; i < list.size(); i ++){
            content[i] = new String[title.length];
            Classes classes = list.get(i);
            content[i][0] = classes.getClass_name();
            content[i][1] = classes.getHeadmaster();
            content[i][2] = classes.getTeacher();
            content[i][3] = classes.getCycle_progress();
        }
        String sheetName = "班级信息表";

        try {
            ExcelUtil.exportExcel(title, sheetName, content);
            return ResultUtil.ok("导出成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("导出失败！");
        }
    }

}
