package org.wmichina.crm.helper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XLSTemplateValidator {
	public static final String EMAIL_PATTERN = "^[a-zA-Z0-9_]+[@][a-zA-Z0-9]+[\\.][a-zA-Z0-9]{2,4}$";
	public static final String MOBILE_PATTERN = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|999)\\d{8}$";
	
	public static final SimpleDateFormat DATE_PARRTERN_YM = new SimpleDateFormat("yyyy-MM");
	public static final SimpleDateFormat DATE_PARRTERN_YMD = new SimpleDateFormat("yyyy-MM-dd");
	
	public static final String XLS_FILE_TYPE="application/vnd.ms-excel";
	public static final String XLSX_FILE_TYPE="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
	/**
	 * 校验市场部学员信息导入标题栏
	 * @return
	 */
	public static boolean validateMarketingImportWBTiltle(List<String> title, StringBuilder result) {
		boolean isValid = true;
		//
		if(title !=null ){
			for(String titleEntry : title){
				if(!STUDENT_FIELDS_USING_XLSKEY.containsKey(titleEntry)){
					result.append(titleEntry).append(",");
					isValid = false;
				}
			}
		}
		return isValid;
	}

	//
	public static final Map<String, XLSField> STUDENT_FIELDS_USING_DBKEY=new HashMap<String, XLSField>();
	public static final Map<String, XLSField> STUDENT_FIELDS_USING_XLSKEY=new HashMap<String, XLSField>();
	public static final List<XLSField> STUDENT_FIELDS_LIST=new ArrayList<XLSField>();
	static{
		STUDENT_FIELDS_USING_DBKEY.put("student_no",new XLSField("学号","student_no","String",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("name",new XLSField("姓名","name","String",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("email",new XLSField("邮件地址","email","String",16,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("mobile",new XLSField("手机号码","mobile","String",13,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("sex",new XLSField("性别","sex","String",6,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("birthday",new XLSField("生日","birthday","Date",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("nation",new XLSField("国家","nation","String",6,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("province",new XLSField("省份","province","String",8,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("city",new XLSField("城市","city","String",8,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("area",new XLSField("区县","area","String",8,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("address",new XLSField("地址","address","String",20,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("postcode",new XLSField("邮编","postcode","String",8,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("telphone",new XLSField("电话","telphone","String",13,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("email_standby",new XLSField("备用邮件","email_standby","String",16,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("mobile_standby",new XLSField("备用手机","mobile_standby","String",13,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("contact_qq",new XLSField("QQ","contact_qq","String",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("contact_msn",new XLSField("MSN","contact_msn","String",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("contact_weibo",new XLSField("微博","contact_weibo","String",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("contact_others",new XLSField("其他联系方式","contact_others","String",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("job_industry",new XLSField("从业行业","job_industry","String",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("job_title",new XLSField("职务","job_title","String",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("job_company",new XLSField("工作单位","job_company","String",20,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("job_telphone",new XLSField("单位电话","job_telphone","String",13,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("job_address",new XLSField("单位地址","job_address","String",20,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("job_postcode",new XLSField("单位邮编","job_postcode","String",8,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("edu_degree",new XLSField("学历","edu_degree","String",6,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("edu_graduation_date",new XLSField("毕业时间","edu_graduation_date","String",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("edu_school",new XLSField("学校","edu_school","String",20,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("edu_speciality",new XLSField("专业","edu_speciality","String",12,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("edu_address",new XLSField("学校地址","edu_address","String",20,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("edu_postcode",new XLSField("邮编","edu_postcode","String",8,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("remark",new XLSField("备注","remark","String",20,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("intend_type",new XLSField("意向类型","intend_type","String",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("intend_course",new XLSField("意向课程资料","intend_course","String",20,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("exam_time",new XLSField("考试时间","exam_time","String",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("assigned_depart",new XLSField("被分配部门","assigned_depart","String",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("assigned_user",new XLSField("被分配员工","assigned_user","String",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("assigned_job",new XLSField("被分配工作","assigned_job","String",10,"",false));
		STUDENT_FIELDS_USING_DBKEY.put("assigned_days",new XLSField("工作天数","assigned_days","String",10,"",false));

		STUDENT_FIELDS_USING_XLSKEY.put("学号",new XLSField("学号","student_no","String",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("姓名",new XLSField("姓名","name","String",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("邮件地址",new XLSField("邮件地址","email","String",16,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("手机号码",new XLSField("手机号码","mobile","String",13,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("性别",new XLSField("性别","sex","String",6,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("生日",new XLSField("生日","birthday","Date",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("国家",new XLSField("国家","nation","String",6,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("省份",new XLSField("省份","province","String",8,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("城市",new XLSField("城市","city","String",8,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("区县",new XLSField("区县","area","String",8,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("地址",new XLSField("地址","address","String",20,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("邮编",new XLSField("邮编","postcode","String",8,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("电话",new XLSField("电话","telphone","String",13,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("备用邮件",new XLSField("备用邮件","email_standby","String",16,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("备用手机",new XLSField("备用手机","mobile_standby","String",13,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("QQ",new XLSField("QQ","contact_qq","String",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("MSN",new XLSField("MSN","contact_msn","String",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("微博",new XLSField("微博","contact_weibo","String",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("其他联系方式",new XLSField("其他联系方式","contact_others","String",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("从业行业",new XLSField("从业行业","job_industry","String",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("职务",new XLSField("职务","job_title","String",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("工作单位",new XLSField("工作单位","job_company","String",20,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("单位电话",new XLSField("单位电话","job_telphone","String",13,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("单位地址",new XLSField("单位地址","job_address","String",20,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("单位邮编",new XLSField("单位邮编","job_postcode","String",8,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("学历",new XLSField("学历","edu_degree","String",6,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("毕业时间",new XLSField("毕业时间","edu_graduation_date","String",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("学校",new XLSField("学校","edu_school","String",20,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("专业",new XLSField("专业","edu_speciality","String",12,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("学校地址",new XLSField("学校地址","edu_address","String",20,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("邮编",new XLSField("邮编","edu_postcode","String",8,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("备注",new XLSField("备注","remark","String",20,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("意向类型",new XLSField("意向类型","intend_type","String",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("意向课程资料",new XLSField("意向课程资料","intend_course","String",20,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("考试时间",new XLSField("考试时间","exam_time","String",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("被分配部门",new XLSField("被分配部门","assigned_depart","String",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("被分配员工",new XLSField("被分配员工","assigned_user","String",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("被分配工作",new XLSField("被分配工作","assigned_job","String",10,"",false));
		STUDENT_FIELDS_USING_XLSKEY.put("工作天数",new XLSField("工作天数","assigned_days","String",10,"",false));

		STUDENT_FIELDS_LIST.add(new XLSField("学号","student_no","String",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("姓名","name","String",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("邮件地址","email","String",16,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("手机号码","mobile","String",13,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("性别","sex","String",6,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("生日","birthday","Date",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("国家","nation","String",6,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("省份","province","String",8,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("城市","city","String",8,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("区县","area","String",8,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("地址","address","String",20,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("邮编","postcode","String",8,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("电话","telphone","String",13,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("备用邮件","email_standby","String",16,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("备用手机","mobile_standby","String",13,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("QQ","contact_qq","String",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("MSN","contact_msn","String",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("微博","contact_weibo","String",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("其他联系方式","contact_others","String",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("从业行业","job_industry","String",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("职务","job_title","String",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("工作单位","job_company","String",20,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("单位电话","job_telphone","String",13,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("单位地址","job_address","String",20,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("单位邮编","job_postcode","String",8,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("学历","edu_degree","String",6,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("毕业时间","edu_graduation_date","String",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("学校","edu_school","String",20,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("专业","edu_speciality","String",12,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("学校地址","edu_address","String",20,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("邮编","edu_postcode","String",8,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("备注","remark","String",20,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("意向类型","intend_type","String",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("意向课程资料","intend_course","String",20,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("考试时间","exam_time","String",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("被分配部门","assigned_depart","String",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("被分配员工","assigned_user","String",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("被分配工作","assigned_job","String",10,"",false));
		STUDENT_FIELDS_LIST.add(new XLSField("工作天数","assigned_days","String",10,"",false));
		
	}

}
