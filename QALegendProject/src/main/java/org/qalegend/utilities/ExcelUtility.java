package org.qalegend.utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.qalegend.constants.Constants;

public class ExcelUtility
{
	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet sh; 
	
	
	public static String stringDataRead(int row, int col, String sheetName) 
	{	
		try {
		String path = Constants.HOME_DIRECTORY+Constants.TEST_DATA_EXCELPATH;
		f=new FileInputStream(path);
		wb = new XSSFWorkbook(f);
		sh =wb.getSheet(sheetName);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
		}catch(Exception e)
		{
			throw new RuntimeException("TestData excel sheet not found");
		}
	}
	
	public static String integerDataRead(int row, int col, String sheetName)
	{
		try {
		String path = Constants.HOME_DIRECTORY+Constants.TEST_DATA_EXCELPATH;
		f=new FileInputStream(path);
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
