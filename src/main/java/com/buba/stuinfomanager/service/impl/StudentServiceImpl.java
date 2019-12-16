package com.buba.stuinfomanager.service.impl;

import com.buba.stuinfomanager.mapper.StudentMapper;
import com.buba.stuinfomanager.pojo.Classes;
import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.service.StudentService;
import com.buba.stuinfomanager.util.ExcelUtil;
import com.buba.stuinfomanager.util.MyUtil;
import com.buba.stuinfomanager.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageInfo<Student> findAllStudent(Integer page, Integer limit, String num, String name) {
        PageHelper.startPage(page, limit);
        List<Student> students = studentMapper.findAllStudent(num, name);
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return pageInfo;
    }

    @Override
    public void deleteOneStudent(Integer t_id) {
        studentMapper.deleteOneStudent(t_id);
    }

    @Override
    public Student selectOneById(Integer stu_id) {
        return studentMapper.selectOneById(stu_id);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void add(Student student) {
        String str = studentMapper.selectMaxStu_num(student.getNowClassId());
        if (str == null || str.isEmpty()) {
            String classname = studentMapper.selectClassName(student.getNowClassId());
            student.setStu_num(classname.substring(0, 4) + "01");
        } else {
            String format = String.format("%02d", Integer.parseInt(str.substring(4)) + 1);
            String stu_num = str.substring(0, 4) + format;
            student.setStu_num(stu_num);
        }
        System.out.println(student.getStu_num());
        studentMapper.add(student);
    }

    @Override
    public List<Classes> selectClass() {
        return studentMapper.selectClass();
    }

    @Override
    public void deleteMore(String[] ids) {
        studentMapper.deleteMore(ids);
    }

    @Override
    public ResultUtil importExcel(MultipartFile file) {
        try {
            InputStream in = file.getInputStream();
            XSSFWorkbook wb = new XSSFWorkbook(in);
            XSSFSheet sheet = wb.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 1; i <= lastRowNum; i++) {
                XSSFRow row = sheet.getRow(i);
                Student student = new Student();
                student.setStu_num(MyUtil.numOfImport(row.getCell(0)));
                student.setName(row.getCell(1).getStringCellValue());
                student.setClassid(studentMapper.selectClassId(row.getCell(2).getStringCellValue()));
                student.setNowClassId(studentMapper.selectClassId(row.getCell(3).getStringCellValue()));
                System.out.println(student);
                studentMapper.add(student);
            }
            return ResultUtil.ok();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }


    }

    @Override
    public ResultUtil exportData(List<Student> list) {
        String[] title = {
                "学号",
                "学生姓名",
                "入学班级",
                "现在班级",
                "手机号 ",
                "籍贯",
                "性别",
                "市场部",
        };
        String[][] content = new String[list.size()][];
        for(int i = 0; i < list.size(); i ++){
            content[i] = new String[title.length];
            Student stu = list.get(i);
            content[i][0] = stu.getStu_num();
            content[i][1] = stu.getName();
            content[i][2] = stu.getClasses().getClass_name();
            content[i][3] = stu.getNowClasses().getClass_name();
            content[i][4] = stu.getPhone();
            content[i][5] = stu.getHome();
            if(stu.getSex()!=null&&!stu.getSex().equals("")){
                content[i][6] = Integer.parseInt(stu.getSex())==0?"男":"女";
            }
            content[i][7] = stu.getMarket();
        }
        String sheetName = "学生信息表";

        try {
            ExcelUtil.exportExcel(title, sheetName, content);
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("导出失败！");
        }
    }

}
