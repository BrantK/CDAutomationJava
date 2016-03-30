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
	
	
	public void test01_newAccount() throws Exception
	{
		log("needs to be implemented");
	}
		
	public void test02_enable_tutorial() throws Exception
	{
		loginAs.user(tutorial_account, tutorial_password);
		Thread.sleep(4000);
		more_button().click();
		action.press(followers()).moveTo(back_button()).release().perform();
		tutorial().click();
		if(tutorial_switch().getText().contains("OFF"))
		{
			tutorial_switch().click();
		}
			tutorial_back_button().click();
			back_button().click();
			Thread.sleep(1000);
		action.tap(90, 1750).perform();
		Thread.sleep(1000);
		
		try
		{
			if(tutorial_getStarted_Button().isDisplayed())
				System.out.println(tutorial_getStarted_Button().getText());
			log("Tutorial enabled");
		}
		catch (Exception e)
		{
			log("Tutorial is not enabled");
		}
	
	}
	
	public void test02_tutorialFunctionality() throws Exception
	{
		
	}
	
}