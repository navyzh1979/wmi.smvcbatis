/**
 * 
 */
package org.wmichina.crm.helper;


public final class EntityConstants {
	/* 分页时每页的记录条数 */
	public static final int PAGE_SIZE=3;
	/** 通用属性设置值 **/
    public static final int IS_VALILD_1=1;
    public static final int IS_VALILD_0=0;
    public static final int IS_PREDEFINED_1=1;
    public static final int IS_PREDEFINED_0=0;
    public static final int AUDITSTATUS_1=1;
    public static final int AUDITSTATUS_0=0;

    /*权限级别 - 功能模块*/
    public static final int RIGHT_LEVEL_BRANCH=1;
	/*权限级别 - 功能菜单*/
    public static final int RIGHT_LEVEL_NODE=2;
	/*权限级别 - 功能点*/
    public static final int RIGHT_LEVEL_LEAF=3;

	/*系统常量级别 - 实体/属性/选项*/
    public static final int CONSTANT_LEVEL_ENTITY=1;
    public static final int CONSTANT_LEVEL_ATTRIBUTE=2;
    public static final int CONSTANT_LEVEL_OPTION=3;
	/*系统常量级别 - 实体预定义*/
    public static final String ENTITY_BASE="900000";    //基础信息
    public static final String ENTITY_BASE_DEPART="901000";    //工作部门
    public static final String ENTITY_BASE_LNCITY="902000";    //授课地点
    public static final String ENTITY_COUSR="100000";    //课程信息
    public static final String ENTITY_COURSE_CATEGORY="101000";    //课程主类
    public static final String ENTITY_COURSE_CLASS="102000";    //课程分类
    public static final String ENTITY_COURSE_TYPE="103000";    //课程级别
    public static final String ENTITY_COURSE_MODE="104000";    //授课方式
    public static final String ENTITY_COURSE_TIME="105000";    //授课时间
    public static final String ENTITY_MATERIAL="200000";    //资料信息
    public static final String ENTITY_MATERIAL_CATEGORY="201000";    //资料主类
    public static final String ENTITY_MATERIAL_CLASS="202000";    //资料分类
    public static final String ENTITY_MATERIAL_TYPE="203000";    //资料级别
    public static final String ENTITY_CHANNEL="300000";    //来源渠道
    public static final String ENTITY_CHANNEL_C1="301000";    //一级渠道
    public static final String ENTITY_CHANNEL_C2="302000";    //二级渠道
    public static final String ENTITY_CHANNEL_C3="303000";    //三级渠道
    public static final String ENTITY_CHANNEL_C4="304000";    //四级渠道
    public static final String ENTITY_CHANNEL_C5="305000";    //五级渠道
    public static final String ENTITY_ACTIVITY="400000";    //活动主题
    public static final String ENTITY_ACTIVITY_C1="401000";    //一级类别
    public static final String ENTITY_ACTIVITY_C2="402000";    //二级类别
    public static final String ENTITY_ACTIVITY_C3="403000";    //三级类别
    public static final String ENTITY_STUDENT="500000";    //学员信息
    public static final String ENTITY_STUDENT_OTCONTACTS="501000";    //其他联系方式
    public static final String ENTITY_STUDENT_JOBINDUSTY="502000";    //从业行业
    public static final String ENTITY_STUDENT_JOBTILE="503000";    //职业
    public static final String ENTITY_STUDENT_EDUDEGREE="504000";    //学历
    
    /** SysRegion - regionLevel **/
    public static final int REGION_LEVEL_NATION=0;
    public static final int REGION_LEVEL_PROVINCE=1;
    public static final int REGION_LEVEL_CITY=2;
    public static final int REGION_LEVEL_COUNTY=3;
    
}
