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

 Date: 15/12/2019 18:41:41
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for stu_card
-- ----------------------------
DROP TABLE IF EXISTS `stu_card`;
CREATE TABLE `stu_card`  (
  `stu_id` int(10) NOT NULL,
  `card_id` int(10) NOT NULL,
  `class_id` int(10) DEFAULT NULL,
  INDEX `stu_id`(`stu_id`) USING BTREE,
  INDEX `card_id`(`card_id`) USING BTREE,
  CONSTRAINT `stu_card_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `tb_student` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `stu_card_ibfk_2` FOREIGN KEY (`card_id`) REFERENCES `tb_class_card` (`card_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_class_card
-- ----------------------------
DROP TABLE IF EXISTS `tb_class_card`;
CREATE TABLE `tb_class_card`  (
  `card_id` int(11) NOT NULL,
  `card_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  INDEX `card_id`(`card_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_class_card
-- ----------------------------
INSERT INTO `tb_class_card` VALUES (1, '班长');
INSERT INTO `tb_class_card` VALUES (2, '学习委员');
INSERT INTO `tb_class_card` VALUES (3, '生活委员');
INSERT INTO `tb_class_card` VALUES (4, '体育文员');
INSERT INTO `tb_class_card` VALUES (5, '文艺委员');
INSERT INTO `tb_class_card` VALUES (6, '纪律委员');

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_classes
-- ----------------------------
INSERT INTO `tb_classes` VALUES (1, '1806a', '邢壮', '李四', NULL);
INSERT INTO `tb_classes` VALUES (2, '1805a', '赵仁伟', '王五', NULL);
INSERT INTO `tb_classes` VALUES (3, '1808a', '李伟', '张三', NULL);
INSERT INTO `tb_classes` VALUES (4, '1809a', '李维波', '赵六', NULL);
INSERT INTO `tb_classes` VALUES (5, '1901a', '赵六', '张三', '2');
INSERT INTO `tb_classes` VALUES (6, '34214321', '4321', '4312', '4312');

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
  `interviewresult` double DEFAULT NULL COMMENT '面试成绩',
  `skillscores` double DEFAULT NULL COMMENT '技能成绩',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `studentid`(`studentid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_score
-- ----------------------------
INSERT INTO `tb_score` VALUES (1, 180601, '白伟', '1806a', NULL, 50, 50);
INSERT INTO `tb_score` VALUES (2, 180602, '齐硕', '1806a', NULL, 60, 60);
INSERT INTO `tb_score` VALUES (3, 180603, '张三', '1806a', NULL, 40, 40);

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `stu_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES (1, '180601', 1, 1, '白伟', '0', '1995-10-04', '安徽省/黄山市/歙县', '13248962571', '良好', '河北市场部', '123456', '', '2', NULL);
INSERT INTO `tb_student` VALUES (2, '180602', 1, 1, '齐硕', '1', '1990-08-11', '北京市/北京市/门头沟区', '13248962571', '良好', '河北市场部', '123456', NULL, NULL, NULL);
INSERT INTO `tb_student` VALUES (3, '180603', 1, 1, '张三', '0', '2019-12-03', '安徽省/芜湖市/弋江区', '13248965214', '良好', '豫东市场部', '123456', '', NULL, NULL);

-- ----------------------------
-- Table structure for tb_student_union
-- ----------------------------
DROP TABLE IF EXISTS `tb_student_union`;
CREATE TABLE `tb_student_union`  (
  `department_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `department_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`department_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher`  (
  `t_id` int(10) NOT NULL AUTO_INCREMENT,
  `t_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师名字',
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '出生日期',
  `home` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '籍贯',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系电话',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登录密码',
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES (1, 't1000', '张三', '1989-01-27', '北京市/北京市/宣武区', '12312341422', '123456');

-- ----------------------------
-- Table structure for tb_wj
-- ----------------------------
DROP TABLE IF EXISTS `tb_wj`;
CREATE TABLE `tb_wj`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `wjdate` date DEFAULT NULL COMMENT '违纪日期',
  `classes` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级',
  `name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `typeid` int(2) DEFAULT NULL COMMENT '违纪类型',
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `typeid`(`typeid`) USING BTREE,
  CONSTRAINT `tb_wj_ibfk_1` FOREIGN KEY (`typeid`) REFERENCES `tb_wjtype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_wj
-- ----------------------------
INSERT INTO `tb_wj` VALUES (1, '2019-12-12', '1806a', '白伟', 1, NULL);
INSERT INTO `tb_wj` VALUES (2, '2019-12-02', '1806a', '齐硕', 2, NULL);
INSERT INTO `tb_wj` VALUES (3, '2019-12-25', '1806a', '张三', 3, NULL);

-- ----------------------------
-- Table structure for tb_wjtype
-- ----------------------------
DROP TABLE IF EXISTS `tb_wjtype`;
CREATE TABLE `tb_wjtype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '违纪类型名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_wjtype
-- ----------------------------
INSERT INTO `tb_wjtype` VALUES (1, '内务');
INSERT INTO `tb_wjtype` VALUES (2, '着装');
INSERT INTO `tb_wjtype` VALUES (3, '迟到早退');
INSERT INTO `tb_wjtype` VALUES (4, '吸烟');
INSERT INTO `tb_wjtype` VALUES (5, '其他(看小说、睡觉、打游戏、玩手机)');

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_ws
-- ----------------------------
INSERT INTO `tb_ws` VALUES (1, '2019-12-13', 8, 1);
INSERT INTO `tb_ws` VALUES (2, '2019-12-13', 8, 1);
INSERT INTO `tb_ws` VALUES (3, '2019-12-13', 1, 3);

SET FOREIGN_KEY_CHECKS = 1;
