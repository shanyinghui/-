
package com.buba.stuinfomanager.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class ExcelUtil {
	//title是表格的列名，sheetName是表名，body是表的主体信息
	public static void exportExcel(String[] title,String sheetName,String[][] body) throws Exception{
		HSSFWorkbook wb = null;
		File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
		String desktopPath = desktopDir.getAbsolutePath();
		String path = desktopPath + "\\" +sheetName+".xls";
		File file = new File(path);
		FileOutputStream os = null;
		//判断该excel表是否已经存在，如果存在就直接在该表最后一行追加数据
		if(file.exists()){
			FileInputStream fs=new FileInputStream(path);

			//使用POI提供的方法得到excel的信息
			POIFSFileSystem ps=new POIFSFileSystem(fs);
			wb = new HSSFWorkbook(ps);

			//获取到工作表，因为一个excel可能有多个工作表
			HSSFSheet sheet=wb.getSheetAt(0);

			//获取第一行,excel中的行默认从0开始
			HSSFRow row=sheet.getRow(0);

			//得到最后一行的行号
			int rowNum = sheet.getLastRowNum();

			//追加数据
			for (int i = 0; i < body.length; i++) {
				row = sheet.createRow(i+rowNum+1);
				for(int j = 0; j < body[i].length; j++){
					row.createCell(j).setCellValue(body[i][j]);
				}

			}
			//写数据
			FileOutputStream out=new FileOutputStream(path);
			os = new FileOutputStream(path);


		}else{//如果不存在，就先创建excel文件


			// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
			wb = new HSSFWorkbook();

			//头标题样式
			//创建合并单元格对象
			CellRangeAddress callRangeAddress = new CellRangeAddress(0,0,0,8);//起始行,结束行,起始列,结束列

			HSSFCellStyle headStyle = createCellStyle(wb,(short)16);


			// 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet sheet = wb.createSheet(sheetName);

			//加载合并单元格对象
			sheet.addMergedRegion(callRangeAddress);

			//设置默认列宽
			sheet.setDefaultColumnWidth(20);

			// 第三步，在sheet中添加表头第0行
			HSSFRow row = sheet.createRow(0);
			row.setHeightInPoints(30);

			//声明列对象
			HSSFCell cell = null;

			//3.1创建头标题行;并且设置头标题

			cell = row.createCell(0);

			cell.setCellStyle(headStyle);
			cell.setCellValue(sheetName);


			//创建标题
			row = sheet.createRow(1);
			for(int i=0;i<title.length;i++){
				cell = row.createCell(i);
				cell.setCellValue(title[i]);
			}

			//主要数据
			for(int i = 0;i < body.length; i++){
				row = sheet.createRow(i + 2);

				for(int j = 0; j < body[i].length; j++){

					row.createCell(j).setCellValue(body[i][j]);
				}
			}
			os = new FileOutputStream(path);
		}
		wb.write(os);
		os.flush();


	}


	private static HSSFCellStyle createCellStyle(HSSFWorkbook wb, short fontsize) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
		//创建字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(fontsize);
		//加载字体
		style.setFont(font);
		return style;

	}
}
