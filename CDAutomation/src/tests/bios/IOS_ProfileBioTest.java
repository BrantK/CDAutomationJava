package tests.bios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.IOSElements;
import elements.LoginWith;

public class IOS_ProfileBioTest extends IOSElements {
	
	///////////////////////////////////////////////
	String account_name = "testProfilebio";
	String account_pw = "password";
	String text_bio = "Cyberdust1 ";
	//////////////////////////////////////////////
	
	LoginWith loginAs = new LoginWith();
	
	public void test01_text_bio() throws Exception
	{
		loginAs.user(account_name, account_pw);
		System.out.println("Entering text bio");
		more_button().click();
		enter_bio().click();
		
		//int unicode = 0x1F60A;
	    //String text = String.valueOf(Character.toChars(unicode));
	    //inputConnection.commitText(text, mComposing.length());
		driver.getKeyboard().sendKeys(text_bio + "\n");
		close_button().click();
		more_button().click();
		WebElement bio = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextView[1]"));
		try{
			if ((bio.getAttribute("value")).equals("Cyberdust1 ")) {
				System.out.println("Text bio successful");
			}
			else{
				System.out.println("Text bio failed");
			}
			
			action.longPress(345, 300).release().perform();
			action.longPress(delete_button(), 3000).release().perform();
			action.longPress(delete_button(), 3000).release().perform();
			close_button().click();
		}
		finally {}
		
	}
	
	public void test02_emoji_bio() throws Exception
	{
		
		
	}
}