package com.citrixproject;
import com.citrixproject.Util;

public class MyWebinar {
	Util util=new Util();
	 /********************************************************
		 * Method/Function Name :validateMyWebinarTitle
		 * Author:
		 * Purpose:
		 * Notes:
		 ********************************************************/ 
		public boolean validateMyWebinarTitle(String title){
			if(util.checkElementByXpath("//span[text()=\'"+title+"']")){
				System.out.println("Tranining scheduled successfully....................");
			}else{
				return false;
			}
			return true;
		}
		
		 /********************************************************
		 * Method/Function Name :clickScheduleAWebinarLink
		 * Author:
		 * Purpose:
		 * Notes:
		 ********************************************************/ 
		public boolean validateMyWebinarDate11(String date){
			util.validateMyWebinarDate(date);
			return true;
		}
}
