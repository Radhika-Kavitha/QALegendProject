package org.qalegend.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.qalegend.constants.Constants;

public class ExcelUtility
{
	static FileInputStream f;//input sheet
	static XSSFWorkbook wb;// workbook read
	static XSSFSheet sh; //sheet read
	
	//to read string data from excel
	public static String stringDataRead(int row, int col, String sheetName) 
	{	
		try {
		//Create an Instance of the Workbook Class and Open the Excel File
		f=new FileInputStream(Constants.TEST_DATA_EXCELPATH);
		wb = new XSSFWorkbook(f);
					//Get the Desired Sheet from the Workbook
		sh =wb.getSheet(sheetName);
					//Create Rows and Cells
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
		}catch(Exception e)
		{
			throw new RuntimeException("TestData excel sheet not found");
			
		}
	}
	//to read integer data from excel
	public static String integerDataRead(int row, int col, String sheetName)
	{
		try {
		f=new FileInputStream(Constants.TEST_DATA_EXCELPATH);
		wb = new XSSFWorkbook(f);
		sh =wb.getSheet(sheetName);
		XSSFRow r= sh.getRow(row);
		XSSFCell c= r.getCell(col);
		int a= (int) c.getNumericCellValue();
		return String.valueOf(a);
		}catch(Exception e)
		{
			throw new RuntimeException("TestData excel sheet not found");
			
		}
	}
}
