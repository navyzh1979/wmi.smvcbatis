/*
SQLyog Enterprise - MySQL GUI v7.14 
MySQL - 5.1.30-community : Database - wmicrm_venus
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`wmicrm_venus` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wmicrm_venus`;

/*Table structure for table `sys_right` */

DROP TABLE IF EXISTS `sys_right`;

CREATE TABLE `sys_right` (
  `right_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `right_label` varchar(100) NOT NULL,
  `right_uri` varchar(255) NOT NULL,
  `is_valid` tinyint(1) NOT NULL DEFAULT '1',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(100) NOT NULL DEFAULT 'system',
  PRIMARY KEY (`right_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100002 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_right` */

insert  into `sys_right`(`right_id`,`right_label`,`right_uri`,`is_valid`,`create_date`,`create_user`) values (100000,'角色查询','/sys/roles.do',1,'2012-10-29 14:38:26','system'),(100001,'角色创建','/sys/role_create.do',1,'2012-10-29 14:38:26','system');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
