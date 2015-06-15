package com.citrixproject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.citrixproject.Common;
import com.citrixproject.MyWebinar;
import com.citrixproject.Util;
import com.citrixproject.ScheduleAWebinar;
import com.citrixproject.WebinarLeftFrame;

public class DriverScript {
	 
	Util util=new Util();
	Common comm= new Common();
	WebinarLeftFrame leftFrame=new WebinarLeftFrame();
	MyWebinar myWebinarPg=new MyWebinar();
	 
	 String [][] TestData=null;
	 String app="GoToWebinar";
	 
	 @Test(priority=1)
	 public void gettingTestData(){
		 TestData=comm.getData();
	 }

	 @Test(priority=2,dependsOnMethods={"gettingTestData"})
	 public void LaunchWebinarBrowser(){
		
		String browserType=TestData[1][0];
		String url=TestData[1][1];
		util.openBrowser(browserType);
		util.launchApp(url);
		
	}
	
	@Test(priority=3,dependsOnMethods={"gettingTestData","LaunchWebinarBrowser"})
	public void validateWebinarLoginPage(){

		String userName=TestData[1][2];
		String password=TestData[1][3];
		comm.login(app, userName, password);
		comm.validateLogin(app);
		
	}
	
	@Test(priority=4,dependsOnMethods={"validateWebinarLoginPage"})
	public void scheduleAWebinarPage(){
		
		long temp=System.currentTimeMillis();
		String title="Auto_Title_"+Long.toString(temp);
		String desc="Auto_Description - "+title;
		String startDate="3";
		ScheduleAWebinar schdWebinar= new ScheduleAWebinar();
		
		//Click on schedule A Webinar Link from left frame
		if(leftFrame.clickScheduleAWebinarLink()){
						
			//Entering webinar details
			schdWebinar.EnterScheduleAWebinarDetails(title, desc, startDate);
			
			//Click on Submit
			schdWebinar.clickScheduleAWebinarSubmitBt();
		}
	}
	
	@Test(priority=5,dependsOnMethods={"validateWebinarLoginPage","scheduleAWebinarPage"})
	public void validateSavedWebinar(){
		
		String webinarTitle=ScheduleAWebinar.Gbltitle;
		String webinarStartDate=ScheduleAWebinar.GblnewStDate;
		
		//Click My Webinar link
		if(leftFrame.clickMyWebinarsLink()){
			util.waitForGivenSec(9);
			util.waitForDefaultTime();
			//Validating the title
			if(myWebinarPg.validateMyWebinarTitle(webinarTitle)){
				System.out.println("Title matched..................");
			}
			
			//Validating the date
			if(myWebinarPg.validateMyWebinarDate11(webinarStartDate)){
				System.out.println("Date matched..................");
			}
			
		}
		
	}
	/*
	@Test(priority=6,dependsOnMethods={"validateWebinarLoginPage"})
	public void signingOut(){
		//Click on Logout
		comm.clickLogOut(app);
		
		//check logout is successful
		comm.validateLogin(app);
	}
	*/
	@AfterTest
	public void ClosingAllBrowsers(){
		myWebinarPg=null;
		leftFrame=null;
		comm=null;
		util.closeBrowser();
		
	}
}
