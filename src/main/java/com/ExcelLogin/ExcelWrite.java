package com.ExcelLogin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public  void Excel_write(String bookname) throws IOException
	{	  
		String filename="src\\test\\resources\\TestData\\testdata.xlsx";
		String Sheetname="Sheet1";
		File f=new File(filename);
		try {
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet(Sheetname);
		XSSFRow row=sh.createRow(1);
		XSSFCell cell=row.createCell(0);
		
		FileOutputStream fos=new FileOutputStream(f);
		cell.setCellValue(bookname);
		wb.write(fos);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		}
}
