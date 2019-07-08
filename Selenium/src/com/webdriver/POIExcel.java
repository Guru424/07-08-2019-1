package com.webdriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class POIExcel {
public static void main(String[] args) throws IOException {
	
	FileInputStream file=new FileInputStream("D:\\Guru\\input.xlsx");
	XSSFWorkbook    wb=new XSSFWorkbook(file);
	XSSFSheet       sh=wb.getSheet("Sheet1");
	
	Row r=sh.getRow(1);
	Cell c=r.getCell(1);
	System.out.println(c);
	
	int rows=sh.getLastRowNum()- sh.getFirstRowNum()+1;
	System.out.println("Total number of rows="+rows);
	
	for(int i=0;i<rows;i++)
	{
		Row row=sh.getRow(i);
		
		for(int j=0;j<row.getLastCellNum();j++)
		{
			System.out.println(row.getCell(j).getStringCellValue());
		}
	}
}
}
