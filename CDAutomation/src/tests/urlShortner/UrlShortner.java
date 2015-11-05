package tests.urlShortner;

import elements.Drivers;
import elements.LoginWith;
import io.appium.java_client.TouchAction;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UrlShortner extends Drivers {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	///////////////////////////////////////////////
	String account_name = "existingTest01";
	String account_pw = "password";
	String account_email = "new_existing@cyberdust.com";
	String account_website = "www.cyberdust.com";
	String shortned_website = "cyberdust.com";
	
	//////////////////////////////////////////////

	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();

	int sw = driver.manage().window().getSize().getWidth();
	int sh = driver.manage().window().getSize().getHeight();

	@Test
	public void test01_shortned_bio() throws Exception {
		loginAs.user(account_name, account_pw);
		more_button().click();
		enter_website().click();
		edit_textbox().sendKeys(account_website);
		save_button().click();
		
		WebElement shortned_url = wait.until(ExpectedConditions.elementToBeClickable(By.name(shortned_website)));
		
		try {
			if (shortned_url.isDisplayed())
				System.out.println("Website name is shortned");
		} catch (Exception e) {
			System.out.println("Unable to shorten the website name");
		}

	}
	@Test
	public void test02_shortned_bio() throws Exception {
		
		enter_website().click();
		edit_textbox().sendKeys(shortned_website);
		save_button().click();
		
		WebElement shortned_url = wait.until(ExpectedConditions.elementToBeClickable(By.name(shortned_website)));
		
		try {
			if (shortned_url.isDisplayed())
				System.out.println("Website name is not shortned");
		} catch (Exception e) {
			System.out.println("Website is shortned");
		}

	}
}