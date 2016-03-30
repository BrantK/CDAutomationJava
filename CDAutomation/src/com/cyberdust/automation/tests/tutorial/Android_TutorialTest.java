package com.cyberdust.automation.tests.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cyberdust.automation.elements.LoginWith;
import com.cyberdust.automation.elements.AndroidCamera;
import com.cyberdust.automation.elements.AndroidElements;

public class Android_TutorialTest extends AndroidElements {

	AndroidCamera androidCamera = new AndroidCamera();
	LoginWith loginAs = new LoginWith();
	
	
	public void test01_tutorialUI() throws Exception
	{
		
		loginAs.user(tutorial_account, tutorial_password);
		Thread.sleep(5000);
		if(!tutorial_icon().isDisplayed())
		{
			more_button().click();
			action.press(followers()).moveTo(back_button()).release().perform();
		}
		
		
		
	}
	
	public void test02_tutorialFunctionality() throws Exception
	{
		
	}
	
}