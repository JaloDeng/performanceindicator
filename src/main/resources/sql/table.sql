/*
MySQL Backup
Database: performance_indicator
Backup Time: 2019-07-29 22:10:39
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `performance_indicator`.`t_employee`;
DROP TABLE IF EXISTS `performance_indicator`.`t_employee_integral`;
DROP TABLE IF EXISTS `performance_indicator`.`t_integral`;
CREATE TABLE `t_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `address` varchar(200) DEFAULT NULL COMMENT '联系地址',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `createUser` varchar(100) DEFAULT NULL COMMENT '创建用户',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateUser` varchar(100) DEFAULT NULL COMMENT '更新用户',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='员工表';
CREATE TABLE `t_employee_integral` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `employeeId` int(11) DEFAULT NULL COMMENT '员工ID，t_employee.id',
  `integralId` int(11) DEFAULT NULL COMMENT '积分ID，t_integral.id',
  `integralTime` datetime DEFAULT NULL COMMENT '获得积分的时间',
  `value` int(11) DEFAULT NULL COMMENT '积分值，冗余，以防积分表变化',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `index_t_employee_integral_employeeId` (`employeeId`) USING BTREE,
  KEY `index_t_employee_integral_integralId` (`integralId`) USING BTREE,
  KEY `index_t_employee_integral_integralTime` (`integralTime`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='员工积分记录表';
CREATE TABLE `t_integral` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `label` varchar(100) DEFAULT NULL COMMENT '标签',
  `value` int(11) DEFAULT NULL COMMENT '积分值',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `createUser` varchar(100) DEFAULT NULL COMMENT '创建用户',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateUser` varchar(100) DEFAULT NULL COMMENT '更新用户',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_t_integral_label` (`label`) USING BTREE COMMENT '唯一索引，积分标签索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='积分表';
BEGIN;
LOCK TABLES `performance_indicator`.`t_employee` WRITE;
DELETE FROM `performance_indicator`.`t_employee`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `performance_indicator`.`t_employee_integral` WRITE;
DELETE FROM `performance_indicator`.`t_employee_integral`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `performance_indicator`.`t_integral` WRITE;
DELETE FROM `performance_indicator`.`t_integral`;
UNLOCK TABLES;
COMMIT;
