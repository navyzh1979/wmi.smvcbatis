package org.wmichina.crm.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class XLSTemplateBuilder {
	public static final String TEMPLATE_ROOTDIR = "/data/cache/template/";
	public static final String TEMPLATE_UPLOADDIR = "/data/cache/upload/";

	/**
	 * 生成市场部学员信息导入导出模板
	 * 
	 * @return
	 */
	public static Workbook createMarketingImportWB() {
		// 创建Workbook对象, HSSFWorkbook表示以xls为后缀名的文件
		Workbook workbook = new HSSFWorkbook();

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
			cell = createTitleCell(workbook, row, i + 1);
			// 给单元格设值
			cell.setCellValue(field.getFieldName());
			mainSheet.setColumnWidth(i + 1, field.getFieldLength() * 256);
		}
		return workbook;
	}

	/**
	 * 根据标题和内容生成sheet页面
	 * 
	 * @return
	 */
	public static Workbook createMarketingImportErrorWB(String sheetName, List<String> titleFields,
			Map<Integer, List<String>> dataContents, Map<Integer, String> invalidRowRemarks) {
		// 创建Workbook对象, HSSFWorkbook表示以xls为后缀名的文件
		Workbook workbook = new HSSFWorkbook();
		// 创建Sheet并给名字(表示Excel的一个Sheet)
		Sheet mainSheet = workbook.createSheet(sheetName);

		// Row表示一行Cell表示一列
		Row row = null;
		Cell cell = null;

		// #1. 创建标题行
		row = mainSheet.createRow(0);
		row.setHeightInPoints(12);
		// 生成标题列
		for (int i = 0; i < titleFields.size(); i++) {
			XLSField field = XLSTemplateValidator.STUDENT_FIELDS_USING_XLSKEY.get(titleFields.get(i));
			if (field != null) {
				cell = createTitleCell(workbook, row, i + 1);
				// 给单元格设值
				cell.setCellValue(field.getFieldName());
				mainSheet.setColumnWidth(i + 1, field.getFieldLength() * 256);
			} else {
				System.out.println(titleFields.get(i) + " is an invalid filed in method[createMarketingImportErrorWB].");
			}
		}
		// 添加备注列，说明出错原因
		cell = createTitleCell(workbook, row, titleFields.size() + 1);
		// 给单元格设值
		cell.setCellValue("错误说明");
		mainSheet.setColumnWidth(titleFields.size() + 1, 20 * 256);

		// #2. 生成内容行
		int rowNo = 1;
		for (Map.Entry<Integer, List<String>> entry : dataContents.entrySet()) {
			//
			row = mainSheet.createRow(rowNo);
			row.setHeightInPoints(12);
			//
			List<String> rowCells = entry.getValue();
			for (int i = 0; i < rowCells.size(); i++) {
				cell = createNormalContentCell(workbook, row, i + 1);
				// 给单元格设值
				cell.setCellValue(rowCells.get(i));
			}
			// 追加备注列内容
			cell = createErrorContentCell(workbook, row, rowCells.size() + 1);
			cell.setCellValue(invalidRowRemarks.get(entry.getKey()));
			//
			rowNo++;
		}

		return workbook;
	}

	/**
	 * 创建标准标题行单元格
	 * 
	 * @return
	 */
	public static Cell createTitleCell(Workbook workbook, Row row, int seq) {
		// 创建一个基本的样式
		CellStyle cellStyle = workbook.createCellStyle();

		// #1. 设置一个单元格边框颜色
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);

		// #2. 设置一个单元格边框颜色
		cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());

		// #3. 设置文字在单元格里面的位置
		// 设置左右
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		// 设置上下
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

		// #4. 先创建字体样式,并把这个样式加到单元格的字体里面
		org.apache.poi.ss.usermodel.Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 10); // 字体高度
		font.setColor(HSSFColor.BLACK.index); // 字体颜色
		font.setFontName("黑体 "); // 字体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度
		font.setItalic(false); // 是否使用斜体
		font.setStrikeout(false); // 是否使用划线
		cellStyle.setFont(font);

		// #5. 设置字体颜色及填充色
		cellStyle.setFillBackgroundColor(IndexedColors.WHITE.index);
		cellStyle.setFillForegroundColor(IndexedColors.BLACK.index);

		// 创建单元格并设定样式
		Cell cell = row.createCell(seq);
		cell.setCellStyle(cellStyle);

		return cell;
	}

	/**
	 * 创建标准内容行单元格
	 * 
	 * @return
	 */
	public static Cell createNormalContentCell(Workbook workbook, Row row, int seq) {
		// 创建一个基本的样式
		CellStyle cellStyle = workbook.createCellStyle();

		// #1. 设置一个单元格边框颜色
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);

		// #2. 设置一个单元格边框颜色
		cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());

		// #3. 设置文字在单元格里面的位置
		// 设置左右
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		// 设置上下
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

		// #4. 先创建字体样式,并把这个样式加到单元格的字体里面
		org.apache.poi.ss.usermodel.Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 10); // 字体高度
		font.setColor(HSSFColor.BLACK.index); // 字体颜色
		font.setFontName("黑体 "); // 字体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL); // 宽度
		font.setItalic(false); // 是否使用斜体
		font.setStrikeout(false); // 是否使用划线
		cellStyle.setFont(font);

		// #5. 设置字体颜色及填充色
		cellStyle.setFillBackgroundColor(IndexedColors.WHITE.index);
		cellStyle.setFillForegroundColor(IndexedColors.BLACK.index);

		// 创建单元格并设定样式
		Cell cell = row.createCell(seq);
		cell.setCellStyle(cellStyle);

		return cell;
	}

	/**
	 * 创建错误提示单元格
	 * 
	 * @return
	 */
	public static Cell createErrorContentCell(Workbook workbook, Row row, int seq) {
		// 创建一个基本的样式
		CellStyle cellStyle = workbook.createCellStyle();

		// #1. 设置一个单元格边框颜色
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);

		// #2. 设置一个单元格边框颜色
		cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());

		// #3. 设置文字在单元格里面的位置
		// 设置左右
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		// 设置上下
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

		// #4. 先创建字体样式,并把这个样式加到单元格的字体里面
		org.apache.poi.ss.usermodel.Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 10); // 字体高度
		font.setColor(HSSFColor.BLACK.index); // 字体颜色
		font.setFontName("黑体 "); // 字体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL); // 宽度
		font.setItalic(false); // 是否使用斜体
		font.setStrikeout(false); // 是否使用划线
		cellStyle.setFont(font);

		// #5. 设置字体颜色及填充色
		cellStyle.setFillBackgroundColor(IndexedColors.YELLOW.index);
		cellStyle.setFillForegroundColor(IndexedColors.BLACK.index);

		// 创建单元格并设定样式
		Cell cell = row.createCell(seq);
		cell.setCellStyle(cellStyle);

		return cell;
	}

	/**
	 * 格式化单元格 如#,##0.00,m/d/yy去HSSFDataFormat或XSSFDataFormat里面找
	 * 
	 * @param cellStyle
	 * @param fmt
	 * @return
	 */
	public static CellStyle setCellFormat(CreationHelper helper, CellStyle cellStyle, String fmt) {
		// 还可以用其它方法创建format
		cellStyle.setDataFormat(helper.createDataFormat().getFormat(fmt));
		return cellStyle;
	}

	/**
	 * XLS文件，并返回File句柄
	 * 
	 * @param path
	 * @param workbook
	 * @return
	 */
	public static File writeXLS(String fileName, Workbook workbook) {
		File file = null;
		OutputStream outputStream;
		try {
			file = new File(fileName);
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
	 * 
	 * @param name
	 * @return
	 */
	public static String reNameFile(String name) {
		Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		Long random = (long) (Math.random() * now);
		String fileName = now + "" + random;

		if (name.indexOf(".") != -1) {
			fileName += name.substring(name.lastIndexOf("."));
		}

		return fileName;
	}

	public static void main(String args[]) {
		String fileName = "C:/abc.xls";
		XLSTemplateBuilder.writeXLS(fileName, XLSTemplateBuilder.createMarketingImportWB());
	}
}
