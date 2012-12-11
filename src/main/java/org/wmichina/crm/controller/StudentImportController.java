package org.wmichina.crm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import org.wmichina.crm.entity.Student;
import org.wmichina.crm.helper.XLSField;
import org.wmichina.crm.helper.XLSTemplateBuilder;
import org.wmichina.crm.helper.XLSTemplateValidator;
import org.wmichina.crm.helper.XSLReader;
import org.wmichina.crm.service.StudentService;

@Controller
@RequestMapping(value = "student")
public class StudentImportController {
  
	@Resource(name="studentService")
	private StudentService studentService;

	@RequestMapping(value = "to_stlist_import")
	public ModelAndView toImport() {
		return new ModelAndView("marketing/stlist_import");
	}

	@RequestMapping(value = "do_stlist_import")
	public ModelAndView upload( HttpServletRequest request){
		System.out.println(" Do importing file ...... ");
		Map<String, Object> map = new HashMap<String, Object>();
		//判断上传文件类型.
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		MultipartFile uploadFile = mRequest.getFile("uploadFile");
		String originalFileName = uploadFile.getOriginalFilename();
		String fileContentType = uploadFile.getContentType();
		System.out.println(" Upload file " + originalFileName+ "'s fileType is " + fileContentType);
		//
		if(!XLSTemplateBuilder.XLS_FILE_TYPE.equals(fileContentType)){
			System.out.println(" Upload fileType must be xls or xlsx. ");
			map.put("errorMsg", "上传文件类型不是excel文件，请重新选择文件。");
		}else {
			//创建上传文件目录
			String uploadDir = XLSTemplateBuilder.TEMPLATE_UPLOADDIR + "t-" + System.currentTimeMillis();
			File filePath = new File(uploadDir);
			if (!filePath.exists()) {
				filePath.mkdir();
			}
			String renameFile = XLSTemplateBuilder.reNameFile(originalFileName);
			//保存上传文件
			File destFile = new File(uploadDir+"/"+renameFile);
			try {
				FileCopyUtils.copy(uploadFile.getBytes(), destFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//分析上传文件
			try {
				InputStream inputStream = new FileInputStream(destFile);
				XSLReader xlsReader = new XSLReader(inputStream);
				List<String> titleFields = xlsReader.getTitleFields();
				Map<Integer, List<String>> dataContents = xlsReader.getDataContents();
				//校验标题
				boolean isTitleValid = true;
				StringBuilder titleValidateResult = new StringBuilder();
				if(titleFields !=null ){
					for(String titleField : titleFields){
						if(!XLSTemplateValidator.STUDENT_FIELDS_USING_XLSKEY.containsKey(titleField)){
							titleValidateResult.append(titleField).append(",");
							isTitleValid = false;
						}
					}
				}
				if(!isTitleValid){
					map.put("isTitleValid", isTitleValid);
					map.put("fileName", originalFileName);
					map.put("titleValidateResult", titleValidateResult);
					return new ModelAndView("marketing/stlist_import", map);
				}
				//校验内容
				boolean isContentValid=true, isEmptyMobile=false, isEmptyEmail=false;
				if(dataContents!=null){
					for(Map.Entry<Integer, List<String>> entry : dataContents.entrySet()){
						int rowNo = entry.getKey();
						List<String> rowContent = entry.getValue();
						Student studentInfo = new Student();
						StringBuilder wrongInfoDesc = new StringBuilder();
						for(int i=0; i<xlsReader.getColumnCount(); i++){
							String titleField = titleFields.get(i);
							String cellContent = StringUtils.trim(rowContent.get(i));
							XLSField xlsField = XLSTemplateValidator.STUDENT_FIELDS_USING_XLSKEY.get(titleField);
							switch(xlsField.getFieldMapping()){
								case "student_no":{
									if(StringUtils.isNotBlank(cellContent)){
											boolean isStudentNoExists = this.studentService.isStudentNoExists(cellContent);
											if(isStudentNoExists){
												wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
															.append("学员编号已存在.|");
												isContentValid = false;
											}else {
												studentInfo.setStudentNo(cellContent);	
											}
									}else {
										//TODO: studentNo生成算法待定
										studentInfo.setStudentNo(cellContent);
									}
									break;
								}
								case "name":{
									studentInfo.setName(cellContent);
									break;
								}
								case "email":{
									if(StringUtils.isNotBlank(cellContent)){
										if(cellContent.matches(XLSTemplateValidator.EMAIL_PATTERN)){
											boolean isEmailExists = this.studentService.isEmailExists(cellContent);
											if(isEmailExists){
												wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
															.append("邮件地址已存在.|");
												isContentValid = false;
											}else {
												studentInfo.setEmail(cellContent);	
											}
										}else {
											wrongInfoDesc.append(xlsField.getFieldName())
											.append("[").append(cellContent).append("]")
											.append("邮件地址格式不正确.|");
											isContentValid = false;
										}
									}else {
										isEmptyEmail = true;
									}
									break;
								}
								case "mobile":{
									if(StringUtils.isNotBlank(cellContent)){
										if(cellContent.matches(XLSTemplateValidator.MOBILE_PATTERN)){
											boolean isMobileExists = this.studentService.isMobileExists(cellContent);
											if(isMobileExists){
												wrongInfoDesc.append(xlsField.getFieldName()).append("[").append(cellContent).append("]")
												.append("手机号码已存在.|");
									isContentValid = false;
											}else{
												studentInfo.setMobile(cellContent);
											}	
										}else {
											wrongInfoDesc.append(xlsField.getFieldName())
											.append("[").append(cellContent).append("]")
											.append("手机号码格式不正确.|");
											isContentValid = false;
										}
									}else {
										isEmptyMobile = true;
									}
									break;
								}
								case "sex":{
									if(StringUtils.isNotBlank(cellContent)){
										if(cellContent.equals("男")){
											studentInfo.setSex(1);
										}else if(cellContent.equals("女")){
											studentInfo.setSex(0);
										}else {
											wrongInfoDesc.append(xlsField.getFieldName())
													.append("[").append(cellContent).append("]")
													.append("性别错误，应为男或女.|");
											isContentValid = false;
										}
									}else {
										isEmptyMobile = true;
									}
									break;
								}
								case "birthday":
								case "nation":
								case "province":
								case "city":
								case "area":
								case "address":
								case "postcode":
								case "telphone":
								case "email_standby":
								case "mobile_standby":
								case "contact_qq":
								case "contact_msn":
								case "contact_weibo":
								case "contact_others":
								case "job_industry":
								case "job_title":
								case "job_company":
								case "job_telphone":
								case "job_address":
								case "job_postcode":
								case "edu_degree":
								case "edu_graduation_date":
								case "edu_school":
								case "edu_speciality":
								case "edu_address":
								case "edu_postcode":
								case "remark":
								case "assigned_depart":
								case "assigned_user":
								case "assigned_job":
								case "assigned_days":
								default:
								
							}
						}
 
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//
		return new ModelAndView("marketing/stlist_import", map);
	}
	
	@RequestMapping(params = "method=uploadAjax")  
    public void uploadAjax(@RequestParam(value = "file") MultipartFile file,  
                    HttpServletRequest request, HttpServletResponse response) {  
            String uploadDirPath = request.getSession().getServletContext()  
                            .getRealPath("/upload");  
            MultipartFile image = file;  
            File destFile = new File(uploadDirPath + "/"  
                            + image.getOriginalFilename());  
            try {  
                    FileCopyUtils.copy(image.getBytes(), destFile);  
            } catch (IOException e) {  
                    e.printStackTrace();  
            }  
            String destPath = request.getContextPath() + "/upload/"  
                            + destFile.getName();  
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
}
