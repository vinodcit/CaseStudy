package com.citrixproject;

import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Util {

	public static WebDriver driver=null;

	/********************************************************
	 * Method/Function Name :launchApp
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public boolean launchApp(String url){
		try{
			driver.get(url);
		}catch(Exception e){
			System.out.println("Fail - not able to launch the application");
			return false;
		}
		return true;
	}
	
	/********************************************************
	 * Method/Function Name :OpenBrowser
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
		
		public boolean openBrowser(String browserType) {
			if((browserType).equalsIgnoreCase("Chrome")){
				String userDir=System.getProperty("user.dir");
				System.setProperty("webdriver.chrome.driver", userDir+"\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if((browserType).equalsIgnoreCase("IE")){
				System.out.println("IE Browser code will come here...");
			}else{
				System.out.println("Not a Valid Browser");
				return false;
			}
			waitForGivenSec(20);
			return true;
			
		}

	/********************************************************
	 * Method/Function Name :checkElementByName
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public boolean checkElementByName(String name) {
		try {
			   driver.findElement(By.name(name));
			   return true;
			} catch (NoSuchElementException e) {
				System.out.println("Exception Message:::"+e.getMessage());
			   return false;
			}
    }

	/********************************************************
	 * Method/Function Name :checkElementByXpath
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public boolean checkElementByXpath(String xpath) {
		try {
			   driver.findElement(By.xpath(xpath));
			   return true;
			} catch (NoSuchElementException e) {
				System.out.println("Exception Message:::"+e.getMessage());
			   return false;
			}
    }
	
	/********************************************************
	 * Method/Function Name :waitForGivenSec
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public void waitForGivenSec(long TimeInSecs){
		driver.manage().timeouts().implicitlyWait(TimeInSecs, TimeUnit.SECONDS);
	}
	
	/********************************************************
	 * Method/Function Name :waitForDefaultTime
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public void waitForDefaultTime(){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	/********************************************************
	 * Method/Function Name :clickElementByXpath
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	
	public String clickElementByXpath(String xpath){
		try{
			driver.findElement(By.xpath((xpath))).click();
		}catch(NoSuchElementException e){
			return e+" Exception : Not able to click the element with xpath - "+xpath;
		}
		return "Pass";	
	}
	
	
	/********************************************************
	 * Method/Function Name :clickElementByXpath
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	
	public String clickElementByLinkText(String partiallinkName){
		try{
			driver.findElement(By.linkText((partiallinkName))).click();
		}catch(NoSuchElementException e){
			return e+" Exception : Not able to click the element with partiallinkName - "+partiallinkName;
		}
		return "Pass";	
	}
	
	/********************************************************
	 * Method/Function Name :enterDate
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	
	public String enterDate(int days){
		
		try{
			
			/*List<WebElement> dates = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[0-9]/td[0-9]"));			 
	        for (int i=0; i<dates.size(); i++) {
	            System.out.println(i+1 + ".............. " + dates.get(i).getText());
	        }*/
	        
	        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
		    int futureDate = localCalendar.get(Calendar.DATE)+days;
	        for (int j=1; j<=5; j++) {
	        	String dateFound="";
	        	for (int k=1; k<=7; k++) {
	        		String d=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr["+j+"]/td["+k+"]")).getText();
	        		int v=Integer.parseInt(d);
	        		if(v==futureDate){
	        			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr["+j+"]/td["+k+"]")).click();
	        			dateFound="DateFound";	        			
	        			break;
	    			}
		        }
	        	if((dateFound.equals("DateFound"))){
        			break;
        		}
	        }
		}catch(NoSuchElementException e){
			System.out.println("Exception in Select Webinar >> EnterDate function: "+e);
			return "False";
		}
		return "Pass";
	}
	
	
	/********************************************************
	 * Method/Function Name :validateMyWebinarDate
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public boolean validateMyWebinarDate(String expMyWebinarDate){
		List<WebElement> getDate = driver.findElements(By.className("myWebinarDate"));
        for (int i=0; i<getDate.size(); i++) {
            if((getDate.get(i).getText()).equalsIgnoreCase(expMyWebinarDate)){
            	System.out.println("Date Mactched");
            	break;
            }else{
            	return false;
            }
        }
		return true;
	}
	/********************************************************
	 * Method/Function Name :clickElementByName
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	
	public String clickElementByName(String name){
		
		if(checkElementByName(name)){
			try{
				driver.findElement(By.name(name)).click();
			}catch(NoSuchElementException e){
				return e+" Exception : Element Found, but unable to click with ByName - "+name;
			}
		}else{
			
			return " Exception : Unable to find the Element with ByName - "+name;
		}
		
		return "Pass";	
	}

	
	/********************************************************
	 * Method/Function Name :isElementPresent
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public boolean isElementPresent(String xpath) {
		try {
			  driver.findElement(By.xpath(xpath));
			   return true;
			} catch (NoSuchElementException e) {
			   return false;
			}
    }
	
	/********************************************************
	 * Method/Function Name :inputByXpath
	 * Author:
	 * Purpose:
	 * Notes:
	 ********************************************************/  
	public String inputByXpath(String xpath,String data){
		try{
			driver.findElement(By.xpath((xpath))).sendKeys(data);
		}catch(NoSuchElementException e){
			System.out.println("Catch Excecption::::"+e);
			return "Fail - not able to enter data in input box -"+xpath;
		}
		return "Pass";			
	}
	
	/********************************************************
	 * Method/Function Name :getElementValueByXpath
	 * Author:
	 * Purpose:
	 * Notes:
	 *****************************************************/
	public String getElementValueByXpath(String xpath){
		
		if(checkElementByXpath(xpath)){
			try{
				String val=driver.findElement(By.xpath(xpath)).getText();
				return val;
			
			}catch(NoSuchElementException e){
				return e+" Exception : Element Found, but unable to click with ByName - "+xpath;
			}
		}else{
			
			return " Exception : Unable to find the Element with ByName - "+xpath;
		}
	}
	
	/********************************************************
	 * Method/Function Name :getElementValueByXpath
	 * Author:
	 * Purpose:
	 * Notes:
	 *****************************************************/
	public void closeBrowser(){
		driver.close();
		driver.quit();
		driver=null;
	}

	
			
}
