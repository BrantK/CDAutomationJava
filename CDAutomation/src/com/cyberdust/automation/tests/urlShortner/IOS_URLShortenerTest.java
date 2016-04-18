package com.cyberdust.automation.tests.urlShortner;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class IOS_URLShortenerTest extends IOSElements {

	String account_website = "www.cyberdust.com ";
	String shortened_website = "cyberdust.com";
	
	LoginWith loginAs = new LoginWith();
	
	public void test01_shortened_bio() throws Exception {
		loginAs.user(url_account, url_password);
		
		more_button().click();
		enter_website().click();
		edit_textbox().clear();
		edit_textbox().sendKeys(account_website);
		wait(2);
		
		save_button().click();
		
		WebElement shortened_url = wait.until(ExpectedConditions.elementToBeClickable(By.name(shortened_website)));
		
		try {
			if (shortened_url.isDisplayed())
				log("Website name is shortened");
		} catch (Exception e) {
			log("Unable to shorten the website name");
		}

	}
	
	public void test02_shortened_bio() throws Exception {
		enter_website().click();
		edit_textbox().sendKeys(shortened_website);
		save_button().click();
		
		WebElement shortened_url = wait.until(ExpectedConditions.elementToBeClickable(By.name(shortened_website)));
		
		try {
			if (shortened_url.isDisplayed())
				log("Website name is not shortened");
		} catch (Exception e) {
			log("Website is shortened");
		}
		enter_website().click();
		edit_textbox().clear();
		save_button().click();
		logoutAccount();
	}
}