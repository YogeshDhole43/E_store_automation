
package com.Estore.dataprovider;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataProviders {


	@DataProvider(name="credentials")
	String [][] getCredentials() throws EncryptedDocumentException, IOException
	{
		String path = "./resources/Book1.xlsx";

		File f = new File(path);
		Sheet sh =WorkbookFactory.create(f).getSheet("Credentials");
		int rows = sh.getLastRowNum(); 
		int col = sh.getRow(0).getLastCellNum(); 
		String[][] data = new String[rows][col];
		for(int i = 1  ; i<=rows ; i++)
		{
			for(int j = 0; j<col;j++)
			{
				data [i-1][j] = sh.getRow(i).getCell(j).getStringCellValue(); 
			}
		}
		return data;
	}
	
	@DataProvider(name="email")
	
	String [][] getEmail() throws EncryptedDocumentException, IOException
	{
		String path = "G:\\Automation Project Guru99\\Estore\\resources\\TestData.xlsx";

		File f = new File(path);
		Sheet sh =WorkbookFactory.create(f).getSheet("Email");
		int rows = sh.getLastRowNum(); 
		int col = sh.getRow(0).getLastCellNum(); 
		String[][] data = new String[rows][col];
		for(int i = 1  ; i<=rows ; i++)
		{
			for(int j = 0; j<col;j++)
			{
				data [i-1][j] = sh.getRow(i).getCell(j).getStringCellValue(); 
			}
		}
		return data;
	}
	
	
	@DataProvider(name="getProduct")
	String [][] getProduct() throws EncryptedDocumentException, IOException
	{
		String path = "G:\\Automation Project Guru99\\Estore\\resources\\TestData.xlsx";

		File f = new File(path);
		Sheet sh =WorkbookFactory.create(f).getSheet("ProductDetails");
		int rows = sh.getLastRowNum(); 
		int col = sh.getRow(0).getLastCellNum(); 
		String[][] data = new String[rows][col];
		for(int i = 1  ; i<=rows ; i++)
		{
			for(int j = 0; j<col;j++)
			{
				data [i-1][j] = sh.getRow(i).getCell(j).getStringCellValue(); 
			}
		}
		return data;
	}
	
	@DataProvider(name="searchProduct")
	String [][] getProductPrice() throws EncryptedDocumentException, IOException
	{
		String path = "G:\\Automation Project Guru99\\Estore\\resources\\TestData.xlsx";

		File f = new File(path);
		Sheet sh =WorkbookFactory.create(f).getSheet("SearchProduct");
		int rows = sh.getLastRowNum(); 
		int col = sh.getRow(0).getLastCellNum(); 
		String[][] data = new String[rows][col];
		for(int i = 1  ; i<=rows ; i++)
		{
			for(int j = 0; j<col;j++)
			{
				data [i-1][j] = sh.getRow(i).getCell(j).getStringCellValue(); 
			}
		}
		return data;
	}
	
	@DataProvider(name="newAcountDetailsData")
	String [][] accountCreation() throws EncryptedDocumentException, IOException
	{
		String path = "G:\\Automation Project Guru99\\Estore\\resources\\TestData.xlsx";

		File f = new File(path);
		Sheet sh =WorkbookFactory.create(f).getSheet("AccountCreationData");
		int rows = sh.getLastRowNum(); 
		int col = sh.getRow(0).getLastCellNum(); 
		String[][] data = new String[rows][col];
		for(int i = 1  ; i<=rows ; i++)
		{
			for(int j = 0; j<col;j++)
			{
				data [i-1][j] = sh.getRow(i).getCell(j).getStringCellValue(); 
			}
		}
		return data;
	}

}
