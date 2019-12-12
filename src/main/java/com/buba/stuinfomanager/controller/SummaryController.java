package com.buba.stuinfomanager.controller;

import com.buba.stuinfomanager.pojo.Summary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: liYong
 * @createDate: 2019/12/11
 * @remark: 学生每日总结  业务控制层
 */
@RestController
@RequestMapping("/summary")
public class SummaryController {

    @RequestMapping("/insertSummary")
    public String insertSummary(Summary summary, Integer[] educations){



        return "";
    }

}
