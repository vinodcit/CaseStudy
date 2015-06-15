package com.citrixproject;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.citrixproject.Util;

public class Common {
	
	Util util=new Util();
	
	/********************************************************
	 * Method/Function Name :getData
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public String[][] getData() {
		String currentDir = System.getProperty("user.dir");
		currentDir=currentDir+"\\Data.xls";
		String[][]strExcelArray = null;
		try{
			FileInputStream fileInputStream = new FileInputStream(currentDir);
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheet = workbook.getSheet("Sheet1");
			int intTotalRows=worksheet.getLastRowNum();
			intTotalRows=intTotalRows+1;
			HSSFRow rowZero = worksheet.getRow(0);
			int intTotalCols = rowZero.getLastCellNum();
			System.out.println("Total Cols:"+intTotalCols);
			strExcelArray = new String[intTotalRows][intTotalCols];
			for(int i=0;i<intTotalRows;i++){
				HSSFRow row = worksheet.getRow(i);
				for(int j=0; j<intTotalCols;j++){
					String strExcelData="";
					if(row.getCell(j)!=null){						
							strExcelData=row.getCell(j).getStringCellValue();
					}
					strExcelArray[i][j]=strExcelData;
				}	
			}
			workbook.close();
		}catch(Throwable e){
			System.out.println("Error:"+e);
		}
		
		return strExcelArray;	
	}


	/********************************************************
	 * Method/Function Name :login
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public boolean login(String app, String userName, String password) {
		
		//util.waitForDefaultTime();
		String userNameXpath="";
		String passwordXpath="";
		String signInXpath="";
		if(app.equalsIgnoreCase("GoToWebinar")){
			userNameXpath="//*[@id=\"emailAddress\"]";
			passwordXpath="//*[@id=\"password\"]";
			signInXpath="//*[@id=\"submit\"]";
		}else if(app.equalsIgnoreCase("GoToMeeting")){
			userNameXpath="";
			passwordXpath="";
			userName= "";
			password= "";
		}else{
			System.out.println("Invalid application passed in login()");	
		}
		
		if(util.inputByXpath(userNameXpath,userName)=="Pass"){
			if(util.inputByXpath(passwordXpath,password)=="Pass"){
				if(util.clickElementByXpath(signInXpath)=="Pass"){
					System.out.println("Common lib >> Login function completed");
				}else{
					return false;
				}
				return false;
			}
			return false;
		}
		
		return true;
	}
	
	
	/********************************************************
	 * Method/Function Name :validateLogin
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public boolean validateLogin(String app){
		String checkLogOutLink="";
		if(app.equalsIgnoreCase("GoToWebinar")){
			checkLogOutLink="topNavLnk_logout";
		}else if(app.equalsIgnoreCase("GoToMeeting")){
			checkLogOutLink="";
		}else{
			System.out.println("Not a Valid application passed in ValidateLogin()");	
		}
		
		if(util.checkElementByName(checkLogOutLink)){
			System.out.println("SignIn Successful");
			
		}else{
			System.out.println("SignIn Failed");
			return false;
		}
		return true;
	}
	
	/********************************************************
	 * Method/Function Name :clickLogOut
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public boolean clickLogOut(String app){
		String logOutlinkName="";
		if(app.equalsIgnoreCase("GoToWebinar")){
			logOutlinkName="topNavLnk_logout";
		}else if(app.equalsIgnoreCase("GoToMeeting")){
			logOutlinkName="";
		}else{
			System.out.println("Not a Valid application passed in clickLogOut()");	
		}
		
		if(util.clickElementByName(logOutlinkName)=="Pass"){
			System.out.println("SignIn clicked successfully");
			return true;
		}else{
			return false;
		}
	}

	/********************************************************
	 * Method/Function Name :validateSignOut
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public boolean validateSignOut(String app){
		String checkLogOutXpath="";
		if(app.equalsIgnoreCase("GoToWebinar")){
			checkLogOutXpath="//*[@id=\"emailAddress\"]";
		}else if(app.equalsIgnoreCase("GoToMeeting")){
			checkLogOutXpath="";
		}else{
			System.out.println("Not a Valid application passed in ValidateLogin()");	
		}
		
		if(util.isElementPresent(checkLogOutXpath)){
			System.out.println("SignOut Successful");
			
		}else{
			System.out.println("SignOut Failed");
			return false;
		}
		return true;
	}
	
}
