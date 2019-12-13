/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : stuinfomanager

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 11/12/2019 19:00:53
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_classes
-- ----------------------------
DROP TABLE IF EXISTS `tb_classes`;
CREATE TABLE `tb_classes`  (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级名',
  `headmaster` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班主任',
  `teacher` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '老师',
  `cycle_progress` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '周期进度',
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_score
-- ----------------------------
DROP TABLE IF EXISTS `tb_score`;
CREATE TABLE `tb_score`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` int(11) DEFAULT NULL COMMENT '学生学号(关联学生表)',
  `studentname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生姓名',
  `classes` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级名',
  `period` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '周期',
  `interviewresult` double(3, 1) DEFAULT NULL COMMENT '面试成绩',
  `skillscores` double(3, 1) DEFAULT NULL COMMENT '技能成绩',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `studentid`(`studentid`) USING BTREE,
  CONSTRAINT `tb_score_ibfk_1` FOREIGN KEY (`studentid`) REFERENCES `tb_student` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `stu_id` int(10) NOT NULL COMMENT '主键',
  `stu_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `classid` int(10) NOT NULL COMMENT '入学班级',
  `nowClassId` int(255) NOT NULL COMMENT '现在班级',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0:男，1:女',
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出生日期',
  `home` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '籍贯',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
  `familyStatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '家庭状态',
  `market` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '市场部',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登录密码',
  `familyCommunication` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '家长沟通情况',
  `cycle_progress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学期进度',
  `dept_id` int(5) DEFAULT NULL COMMENT '学生会部门id',
  PRIMARY KEY (`stu_id`) USING BTREE,
  INDEX `classid`(`classid`) USING BTREE,
  INDEX `nowClassId`(`nowClassId`) USING BTREE,
  INDEX `dept_id`(`dept_id`) USING BTREE,
  CONSTRAINT `tb_student_ibfk_1` FOREIGN KEY (`classid`) REFERENCES `tb_classes` (`class_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_student_ibfk_2` FOREIGN KEY (`nowClassId`) REFERENCES `tb_classes` (`class_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_student_ibfk_3` FOREIGN KEY (`dept_id`) REFERENCES `tb_student_union` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_student_union
-- ----------------------------
DROP TABLE IF EXISTS `tb_student_union`;
CREATE TABLE `tb_student_union`  (
  `department_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `department_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`department_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_summary
-- ----------------------------
DROP TABLE IF EXISTS `tb_summary`;
CREATE TABLE `tb_summary`  (
  `sum_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '每日总结主键',
  `sum_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '总结的日期',
  `sum_plan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目进度  ',
  `sum_techGrasp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '技术掌握进度',
  `sum_techExpand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '技术拓展',
  `sum_growth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '我的成长',
  `sum_break` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '违纪情况',
  `sum_shortcoming` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '我的不足',
  `sum_eduRec_army` int(1) NOT NULL COMMENT '军队文化教育情况： 0 没上； 1上了',
  `sum_eduRec_tradition` int(1) DEFAULT NULL COMMENT '传统文化教育情况： 0 没上； 1上了',
  `sum_eduRec_school` int(1) DEFAULT NULL COMMENT '学校文化教育情况： 0 没上； 1上了',
  `sum_eduRec_workplace` int(1) DEFAULT NULL COMMENT '职场文化教育情况： 0 没上； 1上了',
  `sum_eduRec_politics` int(1) DEFAULT NULL COMMENT '政治思想文化教育情况： 0 没上； 1上了',
  `stu_id` int(11) DEFAULT NULL COMMENT '外键-学生表主键',
  `tea_id` int(11) DEFAULT NULL COMMENT '外键-教师表主键',
  PRIMARY KEY (`sum_id`) USING BTREE,
  INDEX `stu_id`(`stu_id`) USING BTREE,
  INDEX `tea_id`(`tea_id`) USING BTREE,
  CONSTRAINT `tb_summary_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `tb_student` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_summary_ibfk_2` FOREIGN KEY (`tea_id`) REFERENCES `tb_teacher` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher`  (
  `t_id` int(10) NOT NULL,
  `t_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师名字',
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '出生日期',
  `home` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '籍贯',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系电话',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登录密码',
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_wj
-- ----------------------------
DROP TABLE IF EXISTS `tb_wj`;
CREATE TABLE `tb_wj`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` date DEFAULT NULL COMMENT '违纪日期',
  `classes` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级',
  `name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `typeid` int(2) DEFAULT NULL COMMENT '违纪类型',
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `typeid`(`typeid`) USING BTREE,
  CONSTRAINT `tb_wj_ibfk_1` FOREIGN KEY (`typeid`) REFERENCES `tb_wjtype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_wjtype
-- ----------------------------
DROP TABLE IF EXISTS `tb_wjtype`;
CREATE TABLE `tb_wjtype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '违纪类型名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_ws
-- ----------------------------
DROP TABLE IF EXISTS `tb_ws`;
CREATE TABLE `tb_ws`  (
  `hid` int(11) NOT NULL AUTO_INCREMENT COMMENT '卫生表主键',
  `hdate` date DEFAULT NULL COMMENT '评分日期',
  `hscore` int(11) DEFAULT NULL COMMENT '卫生评分',
  `bjid` int(11) DEFAULT NULL COMMENT '班级外键',
  PRIMARY KEY (`hid`) USING BTREE,
  INDEX `bjid`(`bjid`) USING BTREE,
  CONSTRAINT `tb_ws_ibfk_1` FOREIGN KEY (`bjid`) REFERENCES `tb_classes` (`class_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
