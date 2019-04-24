/*
 Navicat Premium Data Transfer

 Source Server         : db_mysql
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : health_

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 18/02/2019 11:33:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blood_pressure
-- ----------------------------
DROP TABLE IF EXISTS `blood_pressure`;
CREATE TABLE `blood_pressure`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号码 用户关联用户',
  `high_pressure` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '高压值',
  `low_pressure` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '低压值',
  `meal_condition` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '1代表饭前 2代表饭后',
  `medicine_condition` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '1代表服药前 2代表服药后',
  `save_health_record` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1代表录入健康档案  2 代表不录入健康档案',
  `measure_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '测量时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `openid_index`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blood_pressure
-- ----------------------------
INSERT INTO `blood_pressure` VALUES (4, 'root', '128', '28', '1', '1', '1', '2019-02-18 11:04:31');
INSERT INTO `blood_pressure` VALUES (14, 'root', '100', '10', '1', '1', '1', '2019-02-18 11:32:04');

-- ----------------------------
-- Table structure for blood_sugar
-- ----------------------------
DROP TABLE IF EXISTS `blood_sugar`;
CREATE TABLE `blood_sugar`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号码 用户关联用户',
  `blood_sugar_value` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '血糖值',
  `meal_condition` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '1代表饭前 2 代表饭后',
  `medicine_condition` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '1代表服药前  2代表服药后',
  `save_health_record` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1代表录入健康档案  2 代表不录入健康档案',
  `measure_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '测量时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `openid_index`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blood_sugar
-- ----------------------------
INSERT INTO `blood_sugar` VALUES (4, 'root', '100', '1', '1', '1', '2019-02-18 11:05:58');
INSERT INTO `blood_sugar` VALUES (8, 'root', '5.8', '1', '1', '2', '2019-02-18 11:18:24');

-- ----------------------------
-- Table structure for body_data
-- ----------------------------
DROP TABLE IF EXISTS `body_data`;
CREATE TABLE `body_data`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号码 用于关联用户',
  `weight` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户体重',
  `today_step_count` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户当天运动步数',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `openid_index`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '身体数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of body_data
-- ----------------------------
INSERT INTO `body_data` VALUES (4, 'root', '59', '22345', '2019-02-18 11:06:53');
INSERT INTO `body_data` VALUES (5, 'root', '55', '1234', '2019-02-18 11:21:51');

-- ----------------------------
-- Table structure for custody_user
-- ----------------------------
DROP TABLE IF EXISTS `custody_user`;
CREATE TABLE `custody_user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '监护人手机号码',
  `idcard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '监护人身份证号码',
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '监护人姓名',
  `password` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '监护人密码',
  `headimgurl` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '监护人头像',
  `sex` int(2) NULL DEFAULT NULL COMMENT '用户性别 1位男性 2位女性 0为未知',
  `age` int(3) NULL DEFAULT NULL COMMENT '监护人年龄',
  `custody_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '被监护人phone',
  `custody_relationship` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '与被监护人的关系',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `phone_index`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '监护人表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号码 用于关联用户',
  `morning_medicine` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '早晨药物名字',
  `morning_number` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '早晨药物数量',
  `noon_medicine` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '中午药物名字',
  `noon_number` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '中午药物数量',
  `night_medicine` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '晚上药物名字',
  `night_number` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '晚上药物数量',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `openid_index`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES (4, '', 'aaa', '1', 'bbb', '2', 'ccc', '1', '2019-02-18 11:21:22');

-- ----------------------------
-- Table structure for mood
-- ----------------------------
DROP TABLE IF EXISTS `mood`;
CREATE TABLE `mood`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号码 用于关联用户',
  `morning_mood` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '早上心情 1为良好 2为一般 3为差',
  `noon_mood` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '中午心情 1为良好 2为一般 3为差',
  `night_mood` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '晚上心情  1为良好 2为一般 3为差',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `openid_index`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mood
-- ----------------------------
INSERT INTO `mood` VALUES (4, 'root', '1', '2', '1', '2019-02-18 11:21:41');

-- ----------------------------
-- Table structure for sleeping
-- ----------------------------
DROP TABLE IF EXISTS `sleeping`;
CREATE TABLE `sleeping`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号码 用于关联用户',
  `noon_time` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '午睡时间 单位为小时',
  `night_time` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '夜晚睡眠时间 单位为小时',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `openid_index`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sleeping
-- ----------------------------
INSERT INTO `sleeping` VALUES (4, 'root', '1', '8', '2019-02-18 11:21:32');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户手机号码',
  `idcard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户身份证号码',
  `headimgurl` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户头像',
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户姓名',
  `password` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户密码',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户性别 1位男性 2位女性 0为未知',
  `age` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户年龄',
  `custody_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '监护人手机号码',
  `custody_relationship` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '与监护人关系',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone_unique`(`phone`) USING BTREE,
  INDEX `phone_index`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (4, 'root', 'root', NULL, 'root', 'cm9vdA==', '1', '20', 'root', 'root');

SET FOREIGN_KEY_CHECKS = 1;
