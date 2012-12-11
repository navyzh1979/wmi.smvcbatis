/*
SQLyog Enterprise - MySQL GUI v7.14 
MySQL - 5.1.30-community : Database - wmicrm_venus
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `sys_right` */

DROP TABLE IF EXISTS `sys_right`;

CREATE TABLE `sys_right` (
  `right_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `right_code` char(6) NOT NULL,
  `right_name` varchar(100) NOT NULL,
  `right_abbr` varchar(10) DEFAULT NULL,
  `right_url` varchar(255) DEFAULT NULL,
  `right_level` tinyint(1) unsigned NOT NULL,
  `parent_right` char(6) NOT NULL,
  `is_valid` tinyint(1) NOT NULL DEFAULT '1',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(100) NOT NULL DEFAULT 'system',
  `update_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(100) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`right_id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_right` */

insert  into `sys_right`(`right_id`,`right_code`,`right_name`,`right_abbr`,`right_url`,`right_level`,`parent_right`,`is_valid`,`create_date`,`create_user`,`update_date`,`update_user`,`remark`) values (1,'100000','系统管理',NULL,'',1,'',1,'2012-11-01 00:38:07','system',NULL,NULL,NULL),(2,'101000','角色管理',NULL,'/sys/role_list.html',2,'100000',1,'2012-11-01 00:38:07','system',NULL,NULL,NULL),(3,'101010','角色查询',NULL,'/sys/role_query.html',3,'101000',1,'2012-11-01 00:38:07','system',NULL,NULL,NULL),(4,'101011','角色创建',NULL,'/sys/role_create.html',3,'101000',1,'2012-11-01 00:38:07','system',NULL,NULL,NULL),(5,'101012','角色修改',NULL,'/sys/role_edit.html',3,'101000',1,'2012-11-01 00:38:07','system',NULL,NULL,NULL),(6,'101013','角色审核',NULL,'/sys/role_audit.html',3,'101000',1,'2012-11-01 00:38:07','system',NULL,NULL,NULL),(7,'102000','用户管理',NULL,'/sys/user_list.html',2,'100000',1,'2012-11-01 00:38:07','system',NULL,NULL,NULL),(8,'102010','用户创建',NULL,'/sys/user_create.html',3,'102000',1,'2012-11-01 00:38:07','system',NULL,NULL,NULL),(9,'102011','用户删除',NULL,'/sys/user_delete.html',3,'102000',1,'2012-11-01 00:38:07','system',NULL,NULL,NULL),(10,'102012','用户修改',NULL,'/sys/user_edit.html',3,'102000',1,'2012-11-01 00:38:07','system',NULL,NULL,NULL),(11,'102013','用户查询',NULL,'/sys/user_query.html',3,'102000',1,'2012-11-01 00:38:07','system',NULL,NULL,NULL),(12,'103000','课程管理',NULL,'/sys/course_list.html',2,'100000',1,'2012-11-01 00:38:07','system',NULL,NULL,NULL),(13,'103010','课程创建',NULL,'/sys/course_create.html',3,'103000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(14,'103011','课程删除',NULL,'/sys/course_delete.html',3,'103000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(15,'103012','课程修改',NULL,'/sys/course_edit.html',3,'103000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(16,'103013','课程查询',NULL,'/sys/course_query.html',3,'103000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(17,'104000','工作管理',NULL,'/sys/job_list.html',2,'100000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(18,'104010','工作创建',NULL,'/sys/job_create.html',3,'104000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(19,'104011','工作删除',NULL,'/sys/job_delete.html',3,'104000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(20,'104012','工作修改',NULL,'/sys/job_edit.html',3,'104000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(21,'104013','工作查询',NULL,'/sys/job_query.html',3,'104000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(22,'105000','标签管理',NULL,'/sys/tag_list.html',2,'100000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(23,'105010','标签创建',NULL,'/sys/tag_create.html',3,'105000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(24,'105011','标签删除',NULL,'/sys/tag_delete.html',3,'105000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(25,'105012','标签修改',NULL,'/sys/tag_edit.html',3,'105000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(26,'105013','标签查询',NULL,'/sys/tag_query.html',3,'105000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(27,'106000','公告管理',NULL,'/sys/notice_list.html',2,'100000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(28,'106010','公告创建',NULL,'/sys/notice_create.html',3,'106000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(29,'106011','公告删除',NULL,'/sys/notice_delete.html',3,'106000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(30,'106012','公告修改',NULL,'/sys/notice_edit.html',3,'106000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(31,'106013','公告查询',NULL,'/sys/notice_query.html',3,'106000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(32,'107000','来源渠道管理',NULL,'/sys/source_list.html',2,'100000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(33,'107010','来源渠道创建',NULL,'/sys/source_create.html',3,'107000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(34,'107011','来源渠道删除',NULL,'/sys/source_delete.html',3,'107000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(35,'107012','来源渠道修改',NULL,'/sys/source_edit.html',3,'107000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(36,'107013','来源渠道查询',NULL,'/sys/source_query.html',3,'107000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(37,'108000','活动主题管理',NULL,'/sys/activity_list.html',2,'100000',1,'2012-11-01 00:38:08','system',NULL,NULL,NULL),(38,'108010','活动主题创建',NULL,'/sys/activity_create.html',3,'108000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(39,'108011','活动主题删除',NULL,'/sys/activity_delete.html',3,'108000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(40,'108012','活动主题修改',NULL,'/sys/activity_edit.html',3,'108000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(41,'108013','活动主题查询',NULL,'/sys/activity_query.html',3,'108000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(42,'109000','属性选项管理',NULL,'/sys/option_list.html',2,'100000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(43,'109010','属性选项创建',NULL,'/sys/option_create.html',3,'109000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(44,'109011','属性选项删除',NULL,'/sys/option_delete.html',3,'109000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(45,'109012','属性选项修改',NULL,'/sys/option_edit.html',3,'109000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(46,'109013','属性选项查询',NULL,'/sys/option_query.html',3,'109000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(47,'200000','市场部',NULL,'',1,'000000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(48,'200010','新增学员信息',NULL,'',3,'200000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(49,'200011','删除学员信息',NULL,'',3,'200000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(50,'200012','修改学员信息',NULL,'',3,'200000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(51,'200013','学员信息查询',NULL,'',3,'200000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(52,'200014','导出学员名单',NULL,'',3,'200000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(53,'201000','市场工作分配',NULL,'',2,'200000',1,'2012-11-01 00:38:09','system',NULL,NULL,NULL),(54,'201010','导入学员名单',NULL,'',3,'201000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(55,'201011','任务分配',NULL,'',3,'201000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(56,'202000','任务分配查询',NULL,'',2,'200000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(57,'203000','学员联系与清理',NULL,'',2,'200000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(58,'203010','记录联系名单',NULL,'',3,'203000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(59,'203011','更新联系结果',NULL,'',3,'203000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(60,'203012','清理学员名单',NULL,'',3,'203000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(61,'300000','销售部',NULL,'',1,'000000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(62,'300010','新增学员信息',NULL,'',3,'300000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(63,'300011','修改学员信息',NULL,'',3,'300000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(64,'300012','学员信息查询',NULL,'',3,'300000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(65,'300013','导出学员名单',NULL,'',3,'300000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(66,'301000','销售工作分配',NULL,'',2,'300000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(67,'301010','导入学员名单',NULL,'',3,'301000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(68,'301011','任务分配',NULL,'',3,'301000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(69,'302000','任务分配查询',NULL,'',2,'300000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(70,'303000','我的销售名单',NULL,'',2,'300000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(71,'303010','增加销售记录',NULL,'',3,'303000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(72,'303011','课程销售',NULL,'',3,'303000',1,'2012-11-01 00:38:10','system',NULL,NULL,NULL),(73,'303012','课程支付',NULL,'',3,'303000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(74,'400000','教学客服',NULL,'',1,'000000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(75,'400010','新增学员信息',NULL,'',3,'400000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(76,'400011','修改学员信息',NULL,'',3,'400000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(77,'400012','学员信息查询',NULL,'',3,'400000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(78,'400013','导出学员名单',NULL,'',3,'400000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(79,'401000','客服工作分配',NULL,'',2,'400000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(80,'401010','任务分配',NULL,'',3,'401000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(81,'402000','任务分配查询',NULL,'',2,'400000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(82,'403000','我的服务名单',NULL,'',2,'400000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(83,'403010','增加服务案例',NULL,'',3,'403000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(84,'403011','课程资料维护',NULL,'',3,'403000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(85,'403012','课程销售',NULL,'',3,'403000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(86,'403013','课程支付',NULL,'',3,'403000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(87,'500000','统计报表',NULL,'',1,'000000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(88,'501000','学员信息查询',NULL,'',2,'500000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL),(89,'502000','按天统计工作量',NULL,'',2,'500000',1,'2012-11-01 00:38:11','system',NULL,NULL,NULL);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) NOT NULL,
  `audit_status` tinyint(1) NOT NULL DEFAULT '0',
  `is_valid` tinyint(1) NOT NULL DEFAULT '1',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(100) DEFAULT 'system',
  `update_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200000 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_role` */

/*Table structure for table `sys_role_rights` */

DROP TABLE IF EXISTS `sys_role_rights`;

CREATE TABLE `sys_role_rights` (
  `role_right_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `right_id` int(11) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(100) NOT NULL DEFAULT 'system',
  PRIMARY KEY (`role_right_id`),
  UNIQUE KEY `role_id` (`role_id`,`right_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_rights` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;