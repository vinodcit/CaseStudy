package com.citrixproject;

import org.openqa.selenium.WebDriver;

import com.citrixproject.Util;

public class ScheduleAWebinar {
	
	Util util=new Util();
	WebinarLeftFrame leftFrame=new WebinarLeftFrame();
	Common comm= new Common();
	MyWebinar myWebinarPg=new MyWebinar();
	WebDriver driver;
	public static String Gbltitle="";
	public static String GblstartDate="";
	public static String GblnewStDate="";
	String newStDate;
	
	public void clickOnScheduleAWebinarLinkFromLeftFrame(){
		
	}
	

	/********************************************************
	 * Method/Function Name :EnterScheduleAWebinarDetails
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public void EnterScheduleAWebinarDetails(String title, String desc, String startDate) {
		
		util.waitForDefaultTime();
		
		
		
		//Entering Title
		
		if(!util.inputByXpath("//*[@id=\"name\"]",title).equalsIgnoreCase("Pass")){
			System.out.println("Unable to Enter Webinar Title in Schedule A Webinar Page");
		}
		
		//Entering Desc
		
		if(!util.inputByXpath("//*[@id=\"description\"]",desc).equalsIgnoreCase("Pass")){
			System.out.println("Unable to Enter Webinar Description in Schedule A Webinar Page");
			
		}
		
		//Entering start date (if start date is today, skip this field, else enter user defined date
		
		if(!startDate.equalsIgnoreCase("today")){
			int daysInNumber;
			daysInNumber=3;
			if(util.clickElementByXpath("//*[@id=\"webinarTimesForm.dateTimes_0.baseDate\"]")=="Pass"){
				util.enterDate(daysInNumber);			
			}
		}
		
		//Getting new future date
		newStDate=util.getElementValueByXpath("//*[@id=\"webinarTimesForm.dateTimes_0.baseDate\"]");
		
		//storing the title and date for future validation
		Gbltitle=title;
		GblnewStDate=newStDate;
	}
	
	/********************************************************
	 * Method/Function Name :clickScheduleAWebinarSubmitBt
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public boolean clickScheduleAWebinarSubmitBt(){
		//Click on Submit button
		if(!(util.clickElementByXpath("//*[@id=\"schedule.submit.button\"]")=="Pass")){
			return false;
		}
		return true;
			
	}
	
	/********************************************************
	 * Method/Function Name :checkScheduleWebinarSave1
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************//*  
	public boolean checkScheduleWebinarSave1(String title,String newStDate){
		
		System.out.println(util.getElementValueByXpath("//*[@id=\"trainingName\"]")+"=="+title);
		System.out.println(util.getElementValueByXpath("//*[@id=\"dateTime\"]/p")+"=="+newStDate);
		
		
		if(util.getElementValueByXpath("//*[@id=\"trainingName\"]")==title){
			System.out.println("Tranining scheduled successfully");
		}else{
			return false;
		}
		
		
		
		return true;
	}
	
	*//********************************************************
	 * Method/Function Name :checkScheduleWebinarSave
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************//*  
	public boolean getScheduledWebinarDate(String title){
		System.out.println(util.getElementValueByXpath("//*[@id=\"trainingName\"]")+"=="+title);
		if(util.getElementValueByXpath("//*[@id=\"trainingName\"]")==title){
			System.out.println("Tranining scheduled successfully");
		}else{
			return false;
		}
		return true;
	}
	
	*/
}
