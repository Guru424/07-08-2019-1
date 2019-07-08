package com.webdriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JXLExcel {
public static void main(String[] args) throws BiffException, IOException {
	
	
	FileInputStream file=new FileInputStream("D:\\Guru\\input.xls");
	Workbook        wb=Workbook.getWorkbook(file);
	Sheet           sh=wb.getSheet(0);
	
	System.out.println(sh.getName());
	
	int rows=sh.getRows();
	System.out.println("Total number of rows="+rows);
	int col=sh.getColumns();
	System.out.println("Total number of columns="+col);
	
	String data=sh.getCell(0, 0).getContents();
	System.out.println(data);
	
	for(int i=0;i<rows;i++)
	{
		String data1=sh.getCell(0, i).getContents();
		System.out.println(data1);
	}
}
}
