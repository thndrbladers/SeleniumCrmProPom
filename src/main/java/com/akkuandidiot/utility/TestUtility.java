package com.akkuandidiot.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.akkuandidiot.base.CrmProBase;

public class TestUtility extends CrmProBase{
	
	
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	public static String testDataPath="F:\\Java-Selenium\\SeleniumCrmProPom\\src\\main\\java\\com\\akkuandidiot\\testdata\\CrmproData.xlsx";
	
	//Switch to mainpanel frame
	public static void switchToframe() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file;
		try {
			file=new FileInputStream(testDataPath);
			book=new XSSFWorkbook(file);
			sheet=book.getSheet(sheetName);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		int numOfRows=sheet.getLastRowNum();
		int numOfCol=sheet.getRow(0).getLastCellNum();
		Object [][] obj = new Object[numOfRows][numOfCol];
		for(int i=0;i<numOfRows;i++) {
			for(int j=0;j<numOfCol;j++) {
				obj[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return obj;
		
	}
	
	public static void takeScreenshotAtEndOfTest() {
		try {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFileToDirectory(file, new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		}
	
	
	

}
