package com.buba.stuinfomanager.service;

import com.buba.stuinfomanager.pojo.Summary;

/**
 * @description:
 * @author: liYong
 * @createDate: 2019/12/11
 * @remark:
 */
public interface SummaryServer {

    void insertSummary(Summary summary, Integer[] educations);

}
