package com.Estore.utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Estore.dataprovider.DataProviders;

public class NewExcelLibrary extends DataProviders{
	private static XSSFWorkbook workbook = null;
	public static String excelread(int i , int j, String sheetName) throws EncryptedDocumentException, IOException
	{
		String Path = "./resources/Book1.xlsx";
		FileInputStream f = new FileInputStream(Path);
		
	Workbook wb = WorkbookFactory.create(f);
	workbook.getSheetIndex(sheetName);
	Sheet sh = wb.getSheet(sheetName);
	Row r= sh.getRow(0);
	sh.getLastRowNum();
	r.getLastCellNum();
	Cell cell = sh.getRow(i).getCell(j);
	CellType type = cell.getCellType();
	String type1 = type.toString();
	if(type1=="STRING")
	{
		String value =cell.getStringCellValue();
		return value ;
	}else
		{if(type1=="NUMERIC")
		 {
			double val = cell.getNumericCellValue();
			long valu = (long)val;
			String value = String.valueOf(valu);
			return value;
		 }else 
			{
			boolean val = cell.getBooleanCellValue();
			String value = String.valueOf(val);
			return value;
			}
		}
	
	}		
}
