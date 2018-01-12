-- MySQL DATABASE
-- version 5.7.17
-- Host:localhost port:3306
-- database:bicycle_sharing
-- username:root
-- password:123456

-- 1.创建数据库bicycle_sharing
CREATE DATABASE bicycle_sharing;
use bicycle_sharing;
-- 2.创建用户表user
CREATE TABLE user (
  user_id      INT(11)     NOT NULL
  COMMENT '用户id',
  user_name    VARCHAR(64) NOT NULL
  COMMENT '用户手机号',
  user_account DECIMAL(9, 2) DEFAULT 0
  COMMENT '余额',
  user_credit  INT           DEFAULT 80
  COMMENT '信用度',
  user_cash    INT           DEFAULT 0
  COMMENT '押金',
  PRIMARY KEY (user_id),
  CHECK (user_credit >= 0 AND user_credit <= 100),
  CHECK (user_cash = 0 OR 199)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '用户表';

-- 3.创建管理员表admin
CREATE TABLE admin (
  admin_id       INT(11)      NOT NULL
  COMMENT '管理员id',
  admin_name     VARCHAR(64)  NOT NULL
  COMMENT '管理员账户',
  admin_password VARCHAR(32)  NOT NULL
  COMMENT '管理员密码',
  admin_email    VARCHAR(100) NOT NULL
  COMMENT '管理员邮箱',
  PRIMARY KEY (admin_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '管理员表';

-- 4.插入管理员信息,自增从1开始,在程序里不进行删除,只进行无效的删除,或者删除非自增的插入数据(密码是123456,这里是加密好的)
INSERT INTO
  admin VALUES (0, 'root', 'e10adc3949ba59abbe56e057f20f883e', '1150555483@qq.com');

-- 5.创建管理员通知表admin_message
CREATE TABLE admin_message (
  admin_message_id      INT(11)      NOT NULL
  COMMENT '管理员通知id',
  admin_message_title   VARCHAR(500) NOT NULL
  COMMENT '管理员通知标题',
  admin_message_content TEXT         NOT NULL
  COMMENT '管理员通知内容',
  admin_message_time    TIMESTAMP    NOT NULL
  COMMENT '发布时间',
  admin_id              INT(11)      NOT NULL
  COMMENT '发布管理员id',
  PRIMARY KEY (admin_message_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '管理员通知表';
-- 如果这里设置主键自增的话:  AUTO_INCREMENT = startNum;这样以后Service插入不需要主键,自动设置
-- 后面mybatis全局配置文件里面也可以启动useGeneratedKeys选项,强制自增

-- 6.插入通知信息
INSERT INTO
  admin_message VALUES (0, '开会啦', '一起来做广播体操吧', now(), 1);

-- 7.创建自行车表
CREATE TABLE bicycle (
  bicycle_id        INT(11)  NOT NULL
  COMMENT '单车id',
  bicycle_current_x DOUBLE   NOT NULL
  COMMENT '单车经度',
  bicycle_current_y DOUBLE   NOT NULL
  COMMENT '单车纬度',
  bicycle_last_time DATETIME NOT NULL
  COMMENT '最后一次归还时间',
  bicycle_statement VARCHAR(32) DEFAULT '可用'
  COMMENT '单车状况',
  PRIMARY KEY (bicycle_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '单车表';
-- 修改状态列为数字
ALTER TABLE bicycle_sharing.bicycle
  MODIFY bicycle_statement INT(11) NOT NULL DEFAULT '1'
  COMMENT '单车状况';
-- 添加车辆

INSERT INTO
bicycle VALUES (0, 118.642371, 32.036997, now(), 1);
-- 8.创建充值记录表
CREATE TABLE recharge (
  recharge_id     INT(11)       NOT NULL
  COMMENT '充值记录id',
  user_id         INT(11)       NOT NULL
  COMMENT '充值人id',
  recharge_amount DECIMAL(9, 2) NOT NULL
  COMMENT '充值金额',
  remaining       DECIMAL(9, 2) NOT NULL
  COMMENT '余额',
  recharge_time   TIMESTAMP     NOT NULL
  COMMENT '充值时间',
  PRIMARY KEY (recharge_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '充值记录表';

-- 9.创建借车记录表
CREATE TABLE borrow (
  borrow_id         INT(11)       NOT NULL
  COMMENT '借车记录id',
  bicycle_id        INT(11)       NOT NULL
  COMMENT '单车id',
  user_id           INT(11)       NOT NULL
  COMMENT '借车人id',
  borrow_start_time TIMESTAMP     NOT NULL
  COMMENT '借车开始时间',
  borrow_end_time   TIMESTAMP     NOT NULL
  COMMENT '借车结束时间',
  borrow_start_x    DOUBLE        NOT NULL
  COMMENT '开始经度',
  borrow_start_y    DOUBLE        NOT NULL
  COMMENT '开始纬度',
  borrow_end_x      DOUBLE        NOT NULL
  COMMENT '开始经度',
  borrow_end_y      DOUBLE        NOT NULL
  COMMENT '开始纬度',
  cost              DECIMAL(9, 2) NOT NULL
  COMMENT '消费金额',
  remaining         DECIMAL(9, 2) NOT NULL
  COMMENT '消费余额',
  PRIMARY KEY (borrow_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '借车记录表';

-- 10.使用表AUTO_INCREMENT
--  admin
ALTER TABLE admin
  MODIFY admin_id INT(11) NOT NULL AUTO_INCREMENT
  COMMENT '管理员id',
  AUTO_INCREMENT = 1;
-- admin_message
ALTER TABLE admin_message
  MODIFY admin_message_id INT(11) NOT NULL AUTO_INCREMENT
  COMMENT '管理员通知id',
  AUTO_INCREMENT = 1;
-- user
ALTER TABLE user
  MODIFY user_id INT(11) NOT NULL AUTO_INCREMENT
  COMMENT '用户id',
  AUTO_INCREMENT = 1;
-- bicycle
ALTER TABLE bicycle
  MODIFY bicycle_id INT(11) NOT NULL AUTO_INCREMENT
  COMMENT '单车id',
  AUTO_INCREMENT = 1;
-- borrow
ALTER TABLE borrow
  MODIFY borrow_id INT(11) NOT NULL AUTO_INCREMENT
  COMMENT '管理员通知id',
  AUTO_INCREMENT = 1;
-- recharge
ALTER TABLE recharge
  MODIFY recharge_id INT(11) NOT NULL AUTO_INCREMENT
  COMMENT '管理员通知id',
  AUTO_INCREMENT = 1;
-- 11.创建用户反馈表
CREATE TABLE user_feedback (
  feedback_id        INT(11)     NOT NULL AUTO_INCREMENT
  COMMENT '反馈id',
  feedback_title     VARCHAR(64) NOT NULL
  COMMENT '反馈标题',
  feedback_content   VARCHAR(64) NOT NULL
  COMMENT '反馈内容',
  user_id            INT(11)     NOT NULL
  COMMENT '用户id',
  bicycle_id         INT(11)     NOT NULL
  COMMENT '车辆id',
  feedback_time      DATETIME    NOT NULL
  COMMENT '反馈时间',
  feedback_statement INT(11)     NOT NULL
  COMMENT '状态',
  PRIMARY KEY (feedback_id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT '用户反馈表'
