package org.wmichina.crm.helper;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 操作Excel表格的功能类
 */
public class XSLReader {
	private int columnCount;
	private int rowCount;
	private List<String> titleFields;
	private  Map<Integer, List<String>> dataContents;
	//
	public XSLReader(InputStream is) {
		try {
			POIFSFileSystem fs = new POIFSFileSystem(is);
			Workbook wb = new HSSFWorkbook(fs);
			Sheet sheet = wb.getSheetAt(0);
			//read title
			Row row = sheet.getRow(0);
			columnCount = row.getPhysicalNumberOfCells();
			titleFields = new ArrayList<String>(columnCount);
			for (int i = 0; i < columnCount; i++) {
				titleFields.add(getCellFormatValue(row.getCell((short) i)));
			}
			//read data contents
			dataContents= new HashMap<Integer, List<String>>();
			rowCount = sheet.getLastRowNum();
			for (int i = 1; i <= rowCount; i++) {
				row = sheet.getRow(i);
				int j = 0;
				List<String> rowContent = new ArrayList<String>(columnCount);
				while (j < columnCount) {
					String cellValue = getCellFormatValue(row.getCell((short) j)).trim();
					rowContent.add(cellValue);
					j++;
				}
				dataContents.put(i, rowContent);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//
	public int getColumnCount() {
		return columnCount;
	}


	public int getRowCount() {
		return rowCount;
	}


	public List<String> getTitleFields() {
		return titleFields;
	}


	public Map<Integer, List<String>> getDataContents() {
		return dataContents;
	}


	/**
	 * 根据HSSFCell类型设置数据
	 * 
	 * @param cell
	 * @return
	 */
	private String getCellFormatValue(Cell cell) {
		String cellvalue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC:
				cellvalue = String.valueOf(cell.getNumericCellValue());
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				cellvalue = String.valueOf(cell.getBooleanCellValue());
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				cellvalue = "";
				break;
			case HSSFCell.CELL_TYPE_FORMULA: {
				// 判断当前的cell是否为Date
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，转化为Date格式
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellvalue = sdf.format(date);

				}
				// 如果是纯数字
				else {
					// 取得当前Cell的数值
					cellvalue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			case HSSFCell.CELL_TYPE_STRING:
				// 取得当前的Cell字符串
				cellvalue = cell.getRichStringCellValue().getString().trim();
				break;
			// 默认的Cell值
			default:
				cellvalue = " ";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;

	}
}