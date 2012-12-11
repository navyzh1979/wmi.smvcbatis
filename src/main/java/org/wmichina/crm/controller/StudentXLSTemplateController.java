package org.wmichina.crm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wmichina.crm.helper.XLSTemplateBuilder;

@Controller
@RequestMapping(value = "student")
public class StudentXLSTemplateController {

	@RequestMapping(value="template/maketing_stlist_import")
	public ModelAndView downloadTemplate_MarketingImport(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		//
		System.out.println(" Try to downlad MarketingImport template .");
		String templateFileName = "市场部-学员信息导入模板.xls";		
		String templateFilePath = XLSTemplateBuilder.TEMPLATE_ROOTDIR;
		String downLoadFile = templateFilePath + templateFileName;
		System.out.println(" Template File : "+downLoadFile);
		File file = new File(downLoadFile);
		if(!file.isFile()){
			System.out.println(" Template File is not exists, create it ...... ");
			file = XLSTemplateBuilder.writeXLS(downLoadFile, XLSTemplateBuilder.createMarketingImportWB());
		}
		//
		response.setContentType("application/msexcel");
		response.setHeader("Content-disposition", "attachment; filename=" + new String(templateFileName.getBytes("utf-8"), "ISO8859-1"));
		response.setHeader("Content-Length", String.valueOf(file.length()));
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
			bis.close();
			bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
