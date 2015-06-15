package com.citrixproject;

public class WebinarLeftFrame {
	Util util=new Util();
  /********************************************************
	 * Method/Function Name :clickScheduleAWebinarLink
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/ 
	public boolean clickScheduleAWebinarLink(){
		if(util.clickElementByLinkText("Schedule a Webinar")=="Pass"){
			System.out.println("Left Frame >> Schedule A Webinar link clicked successfully..................");
		}else{
			return false;
		}
		return true;
	}
  
  /********************************************************
 	 * Method/Function Name :clickMyWebinarLink
 	 * Author:
 	 * Purpose:
 	 * Notes:
 	 ********************************************************/ 
 	public boolean clickMyWebinarsLink(){
		if(util.clickElementByLinkText("My Webinars")=="Pass"){
			System.out.println("Left Frame >> My Webinar link clicked successfully...............");
		}else{
			return false;
		}
		return true;
 		
 	}
}
