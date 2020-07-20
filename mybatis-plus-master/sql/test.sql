/*
SQLyog Ultimate v8.32 
MySQL - 5.5.19 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID自增',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `user_password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `user_gender` int(11) DEFAULT NULL COMMENT '用户性别',
  `version` int(11) DEFAULT NULL COMMENT '更新版本',
  `create_date_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(11) DEFAULT '0' COMMENT '逻辑删除(1代表删除)',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`user_name`,`user_password`,`user_gender`,`version`,`create_date_time`,`update_date_time`,`is_delete`) values (1,'采先生i','123456',1,1,'2020-02-02 00:00:00',NULL,0),(2,'大哥','123456',0,2,'2019-10-16 00:00:00','2020-03-29 13:10:52',1),(3,'乙','123456',0,1,'2019-12-26 00:00:00',NULL,1),(4,'丙','123456',0,1,'2018-08-28 00:00:00',NULL,0),(5,'丁','123456',1,1,'2020-01-01 00:00:00',NULL,1),(6,NULL,NULL,0,1,NULL,NULL,0),(7,'埃索达','123456',1,1,'2020-03-29 12:24:08','2020-03-29 12:24:08',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
