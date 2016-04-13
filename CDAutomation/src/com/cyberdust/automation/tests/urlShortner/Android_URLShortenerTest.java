package com.cyberdust.automation.tests.urlShortner;

import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.LoginWith;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class Android_URLShortenerTest extends AndroidElements {

	String account_website = "www.cyberdust.com ";
	String shortened_website = "cyberdust.com";

	LoginWith loginAs = new LoginWith();
	
	public void test01_shortned_bio() throws Exception {	
		loginAs.user(url_account, url_password);
		
		more_button().click();
		enter_website().click();
		edit_textbox().clear();
		edit_textbox().sendKeys(account_website);
		Thread.sleep(2000);
		
		save_button().click();
		
		//WebElement shortened_url = wait.until(ExpectedConditions.elementToBeClickable(By.name(shortened_website)));
		
		try {
			WebElement shortened_url = wait.until(ExpectedConditions.elementToBeClickable(By.name(shortened_website)));
			if (shortened_url.isDisplayed())
				System.out.println("Website name is shortned");
		} catch (Exception e) {
			System.err.println("Unable to shorten the website name");
		}

	}
	
	public void test02_shortned_bio() throws Exception {
		enter_website().click();
		edit_textbox().sendKeys(shortened_website);
		save_button().click();
		

		
		try {
			WebElement shortened_url = wait.until(ExpectedConditions.elementToBeClickable(By.name(shortened_website)));
			if (shortened_url.isDisplayed())
				System.out.println("Website name is not shortned");
		} catch (Exception e) {
			System.err.println("Website is shortned");
		}
		enter_website().click();
		edit_textbox().clear();
		save_button().click();

	}
}