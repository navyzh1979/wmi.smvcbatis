package org.wmichina.crm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.wmichina.crm.entity.BizCourse;
import org.wmichina.crm.entity.BizMaterial;
import org.wmichina.crm.entity.Student;
import org.wmichina.crm.entity.StudentInfoMarketing;
import org.wmichina.crm.entity.StudentLogAssign;
import org.wmichina.crm.entity.SysConstant;
import org.wmichina.crm.entity.SysDailyJob;
import org.wmichina.crm.entity.SysRegion;
import org.wmichina.crm.entity.SysUser;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.SysCache;
import org.wmichina.crm.helper.XLSField;
import org.wmichina.crm.helper.XLSTemplateBuilder;
import org.wmichina.crm.helper.XLSTemplateValidator;
import org.wmichina.crm.helper.XSLReader;
import org.wmichina.crm.service.BizCourseMaterialService;
import org.wmichina.crm.service.StudentService;

@Controller
@RequestMapping(value = "student")
public class StudentImportController {

	@Resource(name = "studentService")
	private StudentService studentService;
	@Resource(name = "bizCourseMaterialService")
	private BizCourseMaterialService bizCourseMaterialService;

	@RequestMapping(value = "to_stlist_import")
	public ModelAndView toImport() {
		return new ModelAndView("marketing/stlist_import");
	}

	@RequestMapping(value = "do_stlist_import")
	public ModelAndView upload(HttpServletRequest request) {
		System.out.println(" Do importing file ...... ");
		Map<String, Object> map = new HashMap<String, Object>();
		// 判断上传文件类型.
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		MultipartFile uploadFile = mRequest.getFile("uploadFile");
		String originalFileName = uploadFile.getOriginalFilename();
		String fileContentType = uploadFile.getContentType();
		System.out.println(" Upload file " + originalFileName + "'s fileType is " + fileContentType);
		//
		if (!XLSTemplateValidator.XLS_FILE_TYPE.equals(fileContentType)) {
			System.out.println(" Upload fileType must be xls or xlsx. ");
			map.put("errorMsg", "上传文件类型不是excel文件，请重新选择文件。");
		} else {
			// 创建上传文件目录
			String uploadDir = XLSTemplateBuilder.TEMPLATE_UPLOADDIR + "t-" + System.currentTimeMillis();
			File filePath = new File(uploadDir);
			if (!filePath.exists()) {
				filePath.mkdir();
			}
			String renameFile = XLSTemplateBuilder.reNameFile(originalFileName);
			// 保存上传文件
			File destFile = new File(uploadDir + "/" + renameFile);
			try {
				FileCopyUtils.copy(uploadFile.getBytes(), destFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 分析处理上传文件
			try {
				InputStream inputStream = new FileInputStream(destFile);
				XSLReader xlsReader = new XSLReader(inputStream);
				List<String> titleFields = xlsReader.getTitleFields();
				Map<Integer, List<String>> dataContents = xlsReader.getDataContents();
				// #1. 校验标题
				boolean isTitleInvalid = false;
				StringBuilder titleValidateResult = new StringBuilder();
				if (titleFields != null) {
					for (String titleField : titleFields) {
						if (!XLSTemplateValidator.STUDENT_FIELDS_USING_XLSKEY.containsKey(titleField)) {
							titleValidateResult.append(titleField).append(",");
							isTitleInvalid = true;
						}
					}
				}
				if (isTitleInvalid) {
					map.put("isTitleInvalid", isTitleInvalid);
					map.put("fileName", originalFileName);
					map.put("titleValidateResult", titleValidateResult);
					return new ModelAndView("marketing/stlist_import", map);
				}

				// #2. 按行校验内容，拆分为俩个Map：内容有效的数据行和含错误内容的数据行
				Map<Integer, List<String>> validRows = new HashMap<Integer, List<String>>();
				Map<Student, StudentLogAssign> insertingData = new HashMap<Student, StudentLogAssign>();
				Map<Integer, List<String>> inValidRows = new HashMap<Integer, List<String>>();
				Map<Integer, String> invalidRowRemarks = new HashMap<Integer, String>();
				if (dataContents != null) {
					for (Map.Entry<Integer, List<String>> row : dataContents.entrySet()) {
						Integer rowNo = row.getKey();
						List<String> rowContent = row.getValue();
						Student studentInfo = new Student();
						StudentLogAssign assignInfo = new StudentLogAssign();
						StudentInfoMarketing infoMarketing = new StudentInfoMarketing();
						StringBuilder wrongInfoDesc = new StringBuilder();
						if (this.analysisRow(titleFields, rowContent, xlsReader.getColumnCount(), wrongInfoDesc, studentInfo,
								assignInfo, infoMarketing)) {
							System.out.println(" Valid Row[" + rowNo + "] - " + Arrays.toString(rowContent.toArray()) + ".");
							validRows.put(rowNo, rowContent);
							insertingData.put(studentInfo, assignInfo);
						} else {
							System.out.println(" Invalid Row[" + rowNo + "] - " + Arrays.toString(rowContent.toArray()) + ".");
							inValidRows.put(rowNo, rowContent);
							invalidRowRemarks.put(rowNo, wrongInfoDesc.toString());
						}
					}
				}
				// #3. 将有效的数据行数据保存到数据库中

				// #4. 将含错误的数据行写入到XLS文件中，并可下载

				// #5. 将导入结果返回到页面

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//
		return new ModelAndView("marketing/stlist_import", map);
	}

	@RequestMapping(params = "method=uploadAjax")
	public void uploadAjax(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		String uploadDirPath = request.getSession().getServletContext().getRealPath("/upload");
		MultipartFile image = file;
		File destFile = new File(uploadDirPath + "/" + image.getOriginalFilename());
		try {
			FileCopyUtils.copy(image.getBytes(), destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String destPath = request.getContextPath() + "/upload/" + destFile.getName();
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("path", destPath);
			response.setContentType("text/html");
			response.getWriter().println(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 分析一行内的单元格内容是否有效。
	 * 
	 * @param titleFields
	 * @param rowContent
	 * @param columnCount
	 * @param studentInfo
	 * @param assignInfo
	 */
	private boolean analysisRow(List<String> titleFields, List<String> rowContent, int columnCount,
			StringBuilder wrongInfoDesc, Student studentInfo, StudentLogAssign assignInfo, StudentInfoMarketing infoMarketing) {
		boolean isContentValid = true;
		boolean isEmptyMobile = false;
		boolean isEmptyEmail = false;
		//
		SysRegion province = null;
		SysRegion city = null;
		SysRegion county = null;
		//
		SysConstant assignDepart = null;
		SysUser assignUser = null;
		SysDailyJob assignJob = null;
		Integer intendType = null;

		// Start to analysis every cell in row.
		for (int i = 0; i < columnCount; i++) {
			String titleField = titleFields.get(i);
			String cellContent = StringUtils.trim(rowContent.get(i));
			XLSField xlsField = XLSTemplateValidator.STUDENT_FIELDS_USING_XLSKEY.get(titleField);
			// Start switch
			switch (xlsField.getFieldMapping()) {
			case "student_no": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 20) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("学号长度不能大于20位.|");
						isContentValid = false;
						break;
					}
					boolean isStudentNoExists = this.studentService.isStudentNoExists(cellContent);
					if (isStudentNoExists) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("学员编号已存在.|");
						isContentValid = false;
					} else {
						studentInfo.setStudentNo(cellContent);
					}
				} else {
					// TODO: studentNo生成算法待定
					studentInfo.setStudentNo(cellContent);
				}
				break;
			}
			case "name": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 20) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("姓名长度不能大于20位.|");
						isContentValid = false;
						break;
					}
				} else {
					studentInfo.setName(cellContent);
				}
				break;
			}
			case "email": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 30) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("邮件地址长度不能大于30位.|");
						isContentValid = false;
						break;
					}
					if (cellContent.matches(XLSTemplateValidator.EMAIL_PATTERN)) {
						boolean isEmailExists = this.studentService.isEmailExists(cellContent);
						if (isEmailExists) {
							wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
									.append("邮件地址已存在.|");
							isContentValid = false;
						} else {
							studentInfo.setEmail(cellContent);
						}
					} else {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("邮件地址格式不正确.|");
						isContentValid = false;
					}
				} else {
					isEmptyEmail = true;
				}
				break;
			}
			case "mobile": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 11) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("手机号码长度不能大于11位.|");
						isContentValid = false;
						break;
					}
					if (cellContent.matches(XLSTemplateValidator.MOBILE_PATTERN)) {
						boolean isMobileExists = this.studentService.isMobileExists(cellContent);
						if (isMobileExists) {
							wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
									.append("手机号码已存在.|");
							isContentValid = false;
						} else {
							studentInfo.setMobile(cellContent);
						}
					} else {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("手机号码格式不正确.|");
						isContentValid = false;
					}
				} else {
					isEmptyMobile = true;
				}
				break;
			}
			case "sex": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.equals("男")) {
						studentInfo.setSex(1);
					} else if (cellContent.equals("女")) {
						studentInfo.setSex(0);
					} else {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("性别错误，应为男或女.|");
						isContentValid = false;
					}
				} else {
					isEmptyMobile = true;
				}
				break;
			}
			case "birthday": {
				if (StringUtils.isNotBlank(cellContent)) {
					Date birthDay = null;
					try {
						birthDay = XLSTemplateValidator.DATE_PARRTERN_YMD.parse(cellContent);
					} catch (java.text.ParseException e) {
						e.printStackTrace();
						birthDay = null;
					}
					if (birthDay == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("生日格式错误，应为1992-12-01.|");
						isContentValid = false;
					} else {
						studentInfo.setBirthday(birthDay);
					}
				}
				break;
			}
			case "nation": {
				if (StringUtils.isNotBlank(cellContent)) {
					SysRegion nation = SysCache.getInstance().REGION_NATION_BYNAME.get(cellContent);

					if (nation == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("请填写正确的国家.|");
						isContentValid = false;
					} else {
						studentInfo.setNation(nation.getRegionCode());
					}
				}
				break;
			}
			case "province": {
				if (StringUtils.isNotBlank(cellContent)) {
					province = SysCache.getInstance().REGION_PROVINCE_BYNAME.get(cellContent);

					if (province == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("请填写正确的省份.|");
						isContentValid = false;
					} else {
						studentInfo.setProvince(province.getRegionCode());
					}
				}
				break;
			}
			case "city": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (province == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("请先填写省份.|");
						isContentValid = false;
					} else {
						Map<String, SysRegion> cities = SysCache.getInstance().REGION_PROVINCE_CITY_BYNAME.get(province
								.getRegionCode());
						city = cities.get(cellContent);
						if (city == null) {
							wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
									.append("请填写正确的城市.|");
							isContentValid = false;
						} else {
							studentInfo.setCity(city.getRegionCode());
						}
					}
				}
				break;
			}
			case "area": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (province == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("请先填写省份.|");
						isContentValid = false;
					} else if (city == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]").append("请填写城市.|");
						isContentValid = false;
					} else {
						Map<String, SysRegion> counties = SysCache.getInstance().REGION_CITY_COUNTY_BYNAME.get(province
								.getRegionCode());
						county = counties.get(cellContent);
						if (county == null) {
							wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
									.append("请填写正确的区县.|");
							isContentValid = false;
						} else {
							studentInfo.setArea(county.getRegionCode());
						}
					}
				}
				break;
			}
			case "address": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 30) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("地址长度不能大于30位.|");
						isContentValid = false;
						break;
					}
					studentInfo.setAddress(cellContent);
				}
				break;
			}
			case "postcode": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 6) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("邮编长度不能大于6位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setPostcode(cellContent);
					}
				}
				break;
			}
			case "telphone": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 20) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("电话长度不能大于20位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setTelphone(cellContent);
					}
				}
				break;
			}
			case "email_standby":
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 30) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("备用邮件地址长度不能大于30位.|");
						isContentValid = false;
						break;
					}
					if (cellContent.matches(XLSTemplateValidator.EMAIL_PATTERN)) {
						boolean isEmailExists = this.studentService.isEmailStandbyExists(cellContent);
						if (isEmailExists) {
							wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
									.append("备用邮件地址已存在.|");
							isContentValid = false;
						} else {
							studentInfo.setEmailStandby(cellContent);
						}
					} else {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("备用邮件地址格式不正确.|");
						isContentValid = false;
					}
				}
				break;
			case "mobile_standby": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 11) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("备用手机号码长度不能大于11位.|");
						isContentValid = false;
						break;
					}
					if (cellContent.matches(XLSTemplateValidator.MOBILE_PATTERN)) {
						boolean isMobileExists = this.studentService.isMobileStandbyExists(cellContent);
						if (isMobileExists) {
							wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
									.append("备用手机号码已存在.|");
							isContentValid = false;
						} else {
							studentInfo.setMobileStandby(cellContent);
						}
					} else {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("备用手机号码格式不正确.|");
						isContentValid = false;
					}
				} else {
					isEmptyMobile = true;
				}
				break;
			}
			case "contact_qq": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 20) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("QQ号码长度不能大于20位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setContactQq(cellContent);
					}
				}
				break;
			}
			case "contact_msn": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 20) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("MSN长度不能大于20位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setContactMsn(cellContent);
					}
				}
				break;
			}
			case "contact_weibo": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 30) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("微博帐号长度不能大于30位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setContactWeibo(cellContent);
					}
				}
				break;
			}
			case "contact_others": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 30) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("其他联系方式长度不能大于30位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setContactOthers(cellContent);
					}
				}
				break;
			}
			case "job_industry": {
				if (StringUtils.isNotBlank(cellContent)) {
					List<SysConstant> options = SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP
							.get(EntityConstants.ENTITY_STUDENT_JOBINDUSTY);
					SysConstant option = null;
					for (SysConstant constant : options) {
						if (constant.getConstantName().equals(cellContent.trim())) {
							option = constant;
						}
					}
					if (option == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("请填写正确的从业行业.|");
						isContentValid = false;
					} else {
						studentInfo.setJobIndustry(option.getConstantCode());
					}
				}
				break;
			}
			case "job_title": {
				if (StringUtils.isNotBlank(cellContent)) {
					List<SysConstant> options = SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP
							.get(EntityConstants.ENTITY_STUDENT_JOBTILE);
					SysConstant option = null;
					for (SysConstant constant : options) {
						if (constant.getConstantName().equals(cellContent.trim())) {
							option = constant;
						}
					}
					if (option == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("请填写正确的职业.|");
						isContentValid = false;
					} else {
						studentInfo.setJobTitle(option.getConstantCode());
					}
				}
				break;
			}
			case "job_company": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 30) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("工作单位长度不能大于30位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setJobCompany(cellContent);
					}
				}
				break;
			}
			case "job_telphone": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 20) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("单位电话长度不能大于20位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setJobTelphone(cellContent);
					}
				}
				break;
			}
			case "job_address": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 30) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("单位邮编长度不能大于30位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setJobAddress(cellContent);
					}
				}
				break;
			}
			case "job_postcode": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 6) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("单位邮编长度不能大于6位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setJobPostcode(cellContent);
					}
				}
				break;
			}
			case "edu_degree": {
				if (StringUtils.isNotBlank(cellContent)) {
					List<SysConstant> options = SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP
							.get(EntityConstants.ENTITY_STUDENT_EDUDEGREE);
					SysConstant option = null;
					for (SysConstant constant : options) {
						if (constant.getConstantName().equals(cellContent.trim())) {
							option = constant;
						}
					}
					if (option == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("请填写正确的学历.|");
						isContentValid = false;
					} else {
						studentInfo.setEduDegree(option.getConstantCode());
					}
				}
				break;
			}
			case "edu_graduation_date": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 15) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("毕业时间长度不能大于15位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setEduGraduationDate(cellContent);
					}
				}
				break;
			}
			case "edu_school": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 20) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("学校长度不能大于20位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setEduSchool(cellContent);
					}
				}
				break;
			}
			case "edu_speciality": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 20) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("专业长度不能大于20位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setEduSpeciality(cellContent);
					}
				}
				break;
			}
			case "edu_address": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 20) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("学校地址长度不能大于20位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setEduAddress(cellContent);
					}
				}
				break;
			}
			case "edu_postcode": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 6) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("学校邮编长度不能大于6位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setEduPostcode(cellContent);
					}
				}
				break;
			}
			case "remark": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.length() > 50) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("备注信息长度不能大于50位.|");
						isContentValid = false;
						break;
					} else {
						studentInfo.setRemark(cellContent);
					}
				}
				break;
			}
			case "intend_type": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (cellContent.equals("资料")) {
						intendType = EntityConstants.LEARNING_COURSE;
						infoMarketing.setIntendType(intendType);
					} else if (cellContent.equals("课程")) {
						intendType = EntityConstants.LEARNING_MATERIAL;
						infoMarketing.setIntendType(intendType);
					} else {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("错误的意向类型,应为:资料或者课程.|");
						isContentValid = false;
					}
				}
				break;
			}
			case "intend_course": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (intendType == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("请填写正确的意向类型,应为:资料或者课程.|");
						isContentValid = false;
					} else if (intendType == EntityConstants.LEARNING_COURSE) {
						BizCourse course = this.bizCourseMaterialService.selectCourseByName(cellContent);
						if (course == null) {
							wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
									.append("此课程不存在,请确认.|");
							isContentValid = false;
						} else {
							infoMarketing.setIntendCourse(course.getCourseCode());
						}
					} else if (intendType == EntityConstants.LEARNING_MATERIAL) {
						BizMaterial material = this.bizCourseMaterialService.selectMaterialByName(cellContent);
						if (material == null) {
							wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
									.append("此资料不存在,请确认.|");
							isContentValid = false;
						} else {
							infoMarketing.setIntendCourse(material.getMaterialCode());
						}
					} else {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("错误的意向类型(" + intendType + "),应为:资料或者课程.|");
						isContentValid = false;
					}
				}
				break;
			}
			case "exam_time": {
				if (StringUtils.isNotBlank(cellContent)) {
					Date examDate = null;
					try {
						examDate = XLSTemplateValidator.DATE_PARRTERN_YM.parse(cellContent);
					} catch (java.text.ParseException e) {
						e.printStackTrace();
						examDate = null;
					}
					if (examDate == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("考试时间格式错误，应为2012-12.|");
						isContentValid = false;
					} else {
						infoMarketing.setExamDate(cellContent);
					}
				}
				break;
			}
			case "assigned_depart": {
				if (StringUtils.isNotBlank(cellContent)) {
					List<SysConstant> options = SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP
							.get(EntityConstants.ENTITY_BASE_DEPART);
					for (SysConstant constant : options) {
						if (constant.getConstantName().equals(cellContent.trim())) {
							assignDepart = constant;
						}
					}
					if (assignDepart == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("请填写正确的被分配部门.|");
						isContentValid = false;
					} else {
						assignInfo.setDepartCode(assignDepart.getConstantCode());
						assignInfo.setDepartName(assignDepart.getConstantName());
					}
				}
				break;
			}
			case "assigned_user": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (assignDepart == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("请先填写被分配部门.|");
						isContentValid = false;
					} else {
						assignUser = SysCache.getInstance().USER_MAP_BYNAME.get(cellContent);
						if (assignUser == null) {
							wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
									.append("请填写被分配员工.|");
							isContentValid = false;
						} else {
							if (assignUser.getDepartment().equals(assignDepart.getConstantCode())) {
								assignInfo.setAssignedTo(assignUser.getLoginName());
							} else {
								wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
										.append("不属于部门[").append(assignDepart.getConstantName()).append("]的员工.|");
								isContentValid = false;
							}
						}
					}
				}
				break;
			}
			case "assigned_job": {
				if (StringUtils.isNotBlank(cellContent)) {
					if (assignDepart == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("请先填写被分配部门.|");
						isContentValid = false;
					} else if (assignUser == null) {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
								.append("请填写被分配员工.|");
						isContentValid = false;
					} else {
						assignJob = SysCache.getInstance().JOB_MAP_BYNAME.get(cellContent);
						if (assignJob == null) {
							wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
									.append("请填写被分配工作.|");
							isContentValid = false;
						} else {
							if (assignJob.getJobDepartment().equals(assignDepart.getConstantCode())) {
								assignInfo.setJobCode(assignJob.getJobCode());
								assignInfo.setJobName(assignJob.getJobName());
							} else {
								wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
										.append("不属于部门[").append(assignDepart.getConstantName()).append("]的工作.|");
								isContentValid = false;
							}
						}
					}
				}
				break;
			}
			case "assigned_days": {
				if (assignJob != null) {
					if (StringUtils.isNotBlank(cellContent)) {
						if (StringUtils.isNumeric(cellContent)) {
							int days = Integer.parseInt(cellContent);
							if (days > 100) {
								wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
										.append("超过最大工作时限(100天).|");
								isContentValid = false;
							} else {
								assignInfo.setJobDays(days);
							}
						} else {
							wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
									.append("必须为数字.|");
							isContentValid = false;
						}
					} else {
						wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]").append("不能为空.|");
						isContentValid = false;
					}
				}
			}
			default:
				System.out.println(cellContent + " doesn't match any field.");
				break;
			}
			// End Switch
		}
		// End analysis every cell in row.
		if (isEmptyEmail && isEmptyMobile) {
			wrongInfoDesc.append("手机号码和邮箱不能同时为空.|");
			isContentValid = false;
		}

		return isContentValid;
	}

}
