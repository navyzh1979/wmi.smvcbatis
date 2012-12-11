package org.wmichina.crm.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class XLSTemplateBuilder {
	public static final String XLS_FILE_TYPE="application/vnd.ms-excel";
	public static final String XLSX_FILE_TYPE="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
	public static final String TEMPLATE_ROOTDIR="/data/cache/template/";
	public static final String TEMPLATE_UPLOADDIR="/data/cache/upload/";
	/**
	 * 生成市场部学员信息导入导出模板
	 * @return
	 */
	public static Workbook createMarketingImportWB() {
		// 创建Workbook对象, HSSFWorkbook表示以xls为后缀名的文件
		Workbook workbook = new HSSFWorkbook();

		// 获得CreationHelper对象
		// CreationHelper helper = wb.getCreationHelper();

		// 创建Sheet并给名字(表示Excel的一个Sheet)
		Sheet mainSheet = workbook.createSheet("学员信息");

		// Row表示一行Cell表示一列
		Row row = null;
		Cell cell = null;

		// 创建标题行
		row = mainSheet.createRow(0);
		row.setHeightInPoints(12);
		// 生成标题列
		List<XLSField> allFields = XLSTemplateValidator.STUDENT_FIELDS_LIST;
		for (int i = 0; i < allFields.size(); i++) {
			XLSField field = allFields.get(i);
			// 创建一个基本的样式
			CellStyle cellStyle = XLSTemplateValidator.createStyleCell(workbook);
			// 获得这一行的每j列
			cell = row.createCell(i+1);
			// 设置文字在单元格里面的位置
			cellStyle = XLSTemplateValidator.setCellStyleAlignment(cellStyle, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
			// 先创建字体样式,并把这个样式加到单元格的字体里面
			cellStyle.setFont(XLSTemplateValidator.createTitleFonts(workbook));

			// 把这个样式加到单元格里面
			cell.setCellStyle(cellStyle);
			// 给单元格设值
			cell.setCellValue(field.getFieldName());
			mainSheet.setColumnWidth(i+1, field.getFieldLength()*256);
		}
		return workbook;
	}
	/**
	 * 保持XLS文件，并返回File句柄
	 * @param path
	 * @param workbook
	 * @return
	 */
	public static File writeXLS(String fileName, Workbook workbook){
		File file = null;
		OutputStream outputStream;
		try {
			file =  new File(fileName); 
			outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
			
			return file;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}
	/**
	 * 重命名文件名
	 * @param name
	 * @return
	 */
	public static String reNameFile(String name) {
		Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date()));
		Long random = (long) (Math.random() * now);
		String fileName = now + "" + random;

		if (name.indexOf(".") != -1) {
			fileName += name.substring(name.lastIndexOf("."));
		}

		return fileName;
	}

	/**
	 * 压缩后的文件名
	 * 
	 * @param name
	 * @return
	 */
	public static String zipName(String name) {
		String prefix = "";
		if (name.indexOf(".") != -1) {
			prefix = name.substring(0, name.lastIndexOf("."));
		} else {
			prefix = name;
		}
		return prefix + ".zip";
	}

	public static void main(String args[]) {
		String fileName = "C:/abc.xls";
		XLSTemplateBuilder.writeXLS(fileName,XLSTemplateBuilder.createMarketingImportWB());
	}
}
