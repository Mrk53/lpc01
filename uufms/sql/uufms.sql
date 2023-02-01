/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : uufms

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 01/02/2023 16:18:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `activity_id` int NOT NULL AUTO_INCREMENT,
  `activity_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `activity_body` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `activity_money` int NULL DEFAULT NULL,
  PRIMARY KEY (`activity_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `customer_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `customer_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `customer_level` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '1是管理员，0是普通用户',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `last_load_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `customer_gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '1是男，2是女，0为空',
  `customer_mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '连鹏程', '123456', '0', '2023-01-29 11:16:16', '2023-01-29 11:26:11', NULL, NULL);
INSERT INTO `customer` VALUES (3, '赵至', '12', '0', '2023-01-29 11:17:56', '2023-01-29 11:26:11', NULL, NULL);
INSERT INTO `customer` VALUES (4, '王宁', '213', '0', '2023-02-01 15:22:13', '2023-02-01 15:22:13', NULL, NULL);
INSERT INTO `customer` VALUES (5, '曹海军', '1212', '0', '2023-02-01 15:22:33', '2023-02-01 15:22:33', NULL, NULL);
INSERT INTO `customer` VALUES (6, '麻文博', '1231', '0', '2023-02-01 15:22:54', '2023-02-01 15:22:54', NULL, NULL);
INSERT INTO `customer` VALUES (7, '姚迪', '111', '0', '2023-02-01 15:23:08', '2023-02-01 15:23:08', NULL, NULL);
INSERT INTO `customer` VALUES (8, '薛弘辰', '121112', '0', '2023-02-01 15:24:06', '2023-02-01 15:24:06', NULL, NULL);
INSERT INTO `customer` VALUES (9, '曾宇航', 'wqqf', '0', '2023-02-01 15:24:37', '2023-02-01 15:24:37', NULL, NULL);
INSERT INTO `customer` VALUES (10, '彭喻', 'ybfy', '0', '2023-02-01 15:25:07', '2023-02-01 15:25:07', NULL, NULL);
INSERT INTO `customer` VALUES (11, '魏聪', 'nfur', '0', '2023-02-01 15:25:46', '2023-02-01 15:25:46', NULL, NULL);
INSERT INTO `customer` VALUES (12, '罗丹', 'efwfo', '0', '2023-02-01 15:26:02', '2023-02-01 15:26:02', NULL, NULL);
INSERT INTO `customer` VALUES (13, '赵亚琴', 'furh', '0', '2023-02-01 15:26:17', '2023-02-01 15:26:17', NULL, NULL);
INSERT INTO `customer` VALUES (14, '刘春丹', 'lcd', '0', '2023-02-01 15:27:04', '2023-02-01 15:27:04', NULL, NULL);

-- ----------------------------
-- Table structure for discuss
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss`  (
  `discuss_id` int NOT NULL AUTO_INCREMENT,
  `theme_id` int NULL DEFAULT NULL,
  `customer_id` int NULL DEFAULT NULL,
  `discussion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `discussion_create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`discuss_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discuss
-- ----------------------------

-- ----------------------------
-- Table structure for islike
-- ----------------------------
DROP TABLE IF EXISTS `islike`;
CREATE TABLE `islike`  (
  `islike_id` int NOT NULL AUTO_INCREMENT,
  `discuss_id` int NULL DEFAULT NULL,
  `customer_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`islike_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of islike
-- ----------------------------

-- ----------------------------
-- Table structure for theme
-- ----------------------------
DROP TABLE IF EXISTS `theme`;
CREATE TABLE `theme`  (
  `theme_id` int NOT NULL AUTO_INCREMENT,
  `theme_Title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `theme_issuer` int NULL DEFAULT NULL,
  `theme_create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `theme_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`theme_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of theme
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
