package com.cyberdust.automation.tests.tutorial;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cyberdust.automation.elements.LoginWith;
import com.cyberdust.automation.elements.AndroidCamera;
import com.cyberdust.automation.elements.AndroidElements;

import io.appium.java_client.TouchAction;

public class Android_TutorialTest extends AndroidElements {

	AndroidCamera androidCamera = new AndroidCamera();
	LoginWith loginAs = new LoginWith();
	
	
	public void test01_newAccount() throws Exception {
		String account_name = "tutorialtest";
		String account_pw = "password";


		TouchAction action = new TouchAction(driver);
			//Starts on boarding
			sign_up_button().click();
			pick_username().sendKeys(account_name );
			username_confirm().click();
			create_password().sendKeys(account_pw );
			password_confirm().click();
			birthday_confirm().click();

			// Skips email
			skip_button().click();

			// Skips remaining on boarding
			skip_button().click();
			int x = (int)(screenWidth/12);
			int y = (int)(screenHeight/1.098);

			action.tap(x, y).perform();
			Thread.sleep(2000);

			try
			{
				if(tutorial_main_page().isDisplayed())
				{

					log("Tutorial enabled");
				}
			}
			catch (Exception e)
			{
				log("Tutorial is not enabled");
			}

		more_button().click();

		action.press(followers()).moveTo(back_button()).release().perform();
		logout().click();
		confirm().click();


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
			int x = (int)(screenWidth/12);
			int y = (int)(screenHeight/1.098);
			
		action.tap(x, y).perform();
		Thread.sleep(2000);
		
		try
		{
			if(tutorial_main_page().isDisplayed())
			{
				
				log("Tutorial enabled");
			}
		}
		catch (Exception e)
		{
			log("Tutorial is not enabled");
		}
	
	}
	
	public void test03_main_page() throws Exception
	{
		tutorial_private_messaging().click();
		tutorial_getStarted_Button().click();
		Thread.sleep(2000);

		
	}
	
}