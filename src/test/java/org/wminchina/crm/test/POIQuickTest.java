/**
 * 
 */
package org.wminchina.crm.test;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

/**
 * Created on 2012-11-2 下午4:50:35.
 *
 * <p>Title:        
 * </p>
 * <p>Description:  
 * </p>
 *
 * @author andy_zhou
 * @version 
 *
 */
public class POIQuickTest {

	
	@Test
	public void createBlankSheet() throws Exception{
	    Workbook wb = new HSSFWorkbook();
	    //Workbook wb = new XSSFWorkbook();
	    CreationHelper createHelper = wb.getCreationHelper();
	    Sheet sheet = wb.createSheet("new sheet");

	    // Create a row and put some cells in it. Rows are 0 based.
	    Row row = sheet.createRow((short)0);
	    // Create a cell and put a value in it.
	    Cell cell = row.createCell(0);
	    cell.setCellValue(1);

	    // Or do it on one line.
	    row.createCell(1).setCellValue(1.2);
	    row.createCell(2).setCellValue(
	         createHelper.createRichTextString("This is a string"));
	    row.createCell(3).setCellValue(true);

	    row.createCell(4).setCellValue(new Date());

	    // we style the second cell as a date (and time).  It is important to
	    // create a new cell style from the workbook otherwise you can end up
	    // modifying the built in style and effecting not only this cell but other cells.
	    CellStyle cellStyle = wb.createCellStyle();
	    cellStyle.setDataFormat(
	        createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
	    cellStyle.setAlignment(CellStyle.ALIGN_JUSTIFY);
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	    cell = row.createCell(5);
	    cell.setCellValue(new Date());
	    cell.setCellStyle(cellStyle);

	    //you can also set date as java.util.Calendar
	    cell = row.createCell(6);
	    cell.setCellValue(Calendar.getInstance());
	    cell.setCellStyle(cellStyle);
	    
	    CellStyle style = wb.createCellStyle();
	    style.setBorderBottom(CellStyle.BORDER_THIN);
	    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderLeft(CellStyle.BORDER_THIN);
	    style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
	    style.setBorderRight(CellStyle.BORDER_THIN);
	    style.setRightBorderColor(IndexedColors.BLUE.getIndex());
	    style.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
	    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	    cell.setCellStyle(style);
	    
	    Sheet sheet1 = wb.getSheetAt(0);
	    for (Row row1 : sheet1) {
	        for (Cell cell1 : row1) {
	            CellReference cellRef = new CellReference(row1.getRowNum(), cell1.getColumnIndex());
	            System.out.print(cellRef.formatAsString());
	            System.out.print(" - ");

	            switch (cell1.getCellType()) {
	                case Cell.CELL_TYPE_STRING:
	                    System.out.println(cell1.getRichStringCellValue().getString());
	                    break;
	                case Cell.CELL_TYPE_NUMERIC:
	                    if (DateUtil.isCellDateFormatted(cell1)) {
	                        System.out.println(cell1.getDateCellValue());
	                    } else {
	                        System.out.println(cell1.getNumericCellValue());
	                    }
	                    break;
	                case Cell.CELL_TYPE_BOOLEAN:
	                    System.out.println(cell1.getBooleanCellValue());
	                    break;
	                case Cell.CELL_TYPE_FORMULA:
	                    System.out.println(cell1.getCellFormula());
	                    break;
	                default:
	                    System.out.println();
	            }
	        }
	    }
	    
	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("workbook.xls");
	    wb.write(fileOut);
	    fileOut.close();
		
	}
	
	@Test
	public void testFillAndFonts() throws Exception{
	    Workbook wb = new HSSFWorkbook();
	    Sheet sheet = wb.createSheet("new sheet");

	    // Create a row and put some cells in it. Rows are 0 based.
	    Row row = sheet.createRow((short) 1);

	    // Aqua background
	    CellStyle style = wb.createCellStyle();
	    style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
	    style.setFillPattern(CellStyle.BIG_SPOTS);
	    Cell cell = row.createCell((short) 1);
	    cell.setCellValue("X");
	    cell.setCellStyle(style);

	    // Orange "foreground", foreground being the fill foreground not the font color.
	    style = wb.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
	    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	    cell = row.createCell((short) 2);
	    cell.setCellValue("X");
	    cell.setCellStyle(style);
	    //
	    Font font = wb.createFont();
	    font.setFontHeightInPoints((short)12);
	    font.setFontName("Courier New");
	    font.setItalic(true);
	    font.setStrikeout(true);
	    style = wb.createCellStyle();
	    style.setFont(font)
	    ;

	    // Create a cell and put a value in it.
	    cell = row.createCell(3);
	    cell.setCellValue("This is a test of fonts");
	    cell.setCellStyle(style);

	       sheet.autoSizeColumn(( short ) 0 ); // 调整第一列宽度 
	       sheet.autoSizeColumn(( short ) 1 ); // 调整第二列宽度 
	       sheet.autoSizeColumn(( short ) 2 ); // 调整第三列宽度 
	       sheet.autoSizeColumn(( short ) 3 ); // 调整第四列宽度 
	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("workbook1.xls");
	    wb.write(fileOut);
	    fileOut.close();
	}
	
	@Test
	public void testNw(){
        /** */ /** 
        * @see <a href=" http://poi.apache.org/hssf/quick-guide.html #NewWorkbook">For more</a> 
        */         
       // 创建新的Excel 工作簿 
       HSSFWorkbook workbook = new HSSFWorkbook(); 
      
       // 在Excel工作簿中建一工作表，其名为缺省值, 也可以指定Sheet名称 
       HSSFSheet sheet = workbook.createSheet(); 
       // HSSFSheet sheet = workbook.createSheet("SheetName"); 
      
       // 用于格式化单元格的数据 
       HSSFDataFormat format = workbook.createDataFormat(); 
      
       // 创建新行(row),并将单元格(cell)放入其中. 行号从0开始计算. 
       HSSFRow row = sheet.createRow(( short ) 1 ); 

       // 设置字体 
       HSSFFont font = workbook.createFont(); 
       font.setFontHeightInPoints(( short ) 20 ); // 字体高度 
       font.setColor(HSSFFont.COLOR_RED); // 字体颜色 
       font.setFontName( " 黑体 " ); // 字体 
       font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度 
       font.setItalic( true ); // 是否使用斜体 
//       font.setStrikeout(true); // 是否使用划线 

       // 设置单元格类型 
       HSSFCellStyle cellStyle = workbook.createCellStyle(); 
       cellStyle.setFont(font); 
       cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平布局：居中 
       cellStyle.setWrapText( true ); 
      
       // 添加单元格注释 
       // 创建HSSFPatriarch对象,HSSFPatriarch是所有注释的容器. 
       HSSFPatriarch patr = sheet.createDrawingPatriarch(); 
       // 定义注释的大小和位置,详见文档 
       HSSFComment comment = patr.createComment( new HSSFClientAnchor( 0 , 0 , 0 , 0 , ( short ) 4 , 2 , ( short ) 6 , 5 )); 
       // 设置注释内容 
       comment.setString( new HSSFRichTextString( " 可以在POI中添加注释！ " )); 
       // 设置注释作者. 当鼠标移动到单元格上是可以在状态栏中看到该内容. 
       comment.setAuthor( " Xuys. " ); 
      
       // 创建单元格 
       HSSFCell cell = row.createCell(( short ) 1 ); 
       HSSFRichTextString hssfString = new HSSFRichTextString( " Hello World! " ); 
       cell.setCellValue(hssfString); // 设置单元格内容 
       cell.setCellStyle(cellStyle); // 设置单元格样式 
       cell.setCellType(HSSFCell.CELL_TYPE_STRING); // 指定单元格格式：数值、公式或字符串 
       cell.setCellComment(comment); // 添加注释 

       // 格式化数据 
       row = sheet.createRow(( short ) 2 ); 
       cell = row.createCell(( short ) 2 ); 
       cell.setCellValue( 11111.25 ); 
       cellStyle = workbook.createCellStyle(); 
       cellStyle.setDataFormat(format.getFormat( " 0.0 " )); 
       cell.setCellStyle(cellStyle); 

       row = sheet.createRow(( short ) 3 ); 
       cell = row.createCell(( short ) 3 ); 
       cell.setCellValue( 9736279.073 ); 
       cellStyle = workbook.createCellStyle(); 
       cellStyle.setDataFormat(format.getFormat( " #,##0.0000 " )); 
       cell.setCellStyle(cellStyle); 
      
      
       sheet.autoSizeColumn(( short ) 0 ); // 调整第一列宽度 
       sheet.autoSizeColumn(( short ) 1 ); // 调整第二列宽度 
       sheet.autoSizeColumn(( short ) 2 ); // 调整第三列宽度 
       sheet.autoSizeColumn(( short ) 3 ); // 调整第四列宽度 

        try { 
           FileOutputStream fileOut = new FileOutputStream( "3.xls " ); 
           workbook.write(fileOut); 
           fileOut.close(); 
        } catch (Exception e){ 
           System.out.println(e.toString()); 
       } 
   } 
}
