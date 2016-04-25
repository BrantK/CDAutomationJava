package com.cyberdust.automation.tests.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cyberdust.automation.elements.LoginWith;
import com.cyberdust.automation.elements.IOSElements;

public class IOS_TutorialTest extends IOSElements {

	LoginWith loginAs = new LoginWith();
	
	public void test01_tutorialUI() throws Exception
	{
		loginAs.user(tutorial_account, tutorial_password);
		Thread.sleep(5000);
		
		more_button().click();
		 action().press(followers()).moveTo(back_button()).release().perform();
		 tutorial_button().click();
		 Thread.sleep(1000);
		 WebElement replay = wait.until(ExpectedConditions.elementToBeClickable(By.name("replay")));
		 WebElement exit = wait.until(ExpectedConditions.elementToBeClickable(By.name("exit")));
		 try{
			 if((replay.isDisplayed())&&((exit.isDisplayed())))
			 {
				 log("Tutorial UI is displayed");
			 }
		 }
		 catch(Exception e)
		 {
			 log("Tutorial UI is not displayed properly");
		 }
		
	}
	
	public void test02_tutorialFunctionality() throws Exception
	{
		WebElement replay = wait.until(ExpectedConditions.elementToBeClickable(By.name("replay")));
		 WebElement exit = wait.until(ExpectedConditions.elementToBeClickable(By.name("exit")));
		
		 replay.click();
		 exit.click();
		 
		 try{
			 if((!replay.isDisplayed())&&((!exit.isDisplayed())))
			 {
				 log("Tutorial UI is displayed");
			 }
		 }
		 catch(Exception e)
		 {
			 log("Tutorial UI is not displayed properly");
		 }
	
	
	}
	
}