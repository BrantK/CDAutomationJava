package tests.followers;
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
public class Followers extends Drivers {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	///////////////////////////////////////////////
	String account_name = "existingTest01";
	String account_pw = "password";
	String account_email = "new_existing@cyberdust.com";
	String friend_username = "aaaaa2";

	//////////////////////////////////////////////

	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();
	
	
	@Test
	public void test01_add_friends() throws Exception {
		
		loginAs.user(account_name, account_pw);
		more_button().click();
		followers().click();
		add_friend().click();
		
		try {
			if (!add_friend().isDisplayed())
				System.out.println("Friend added from followers menu");
		} catch (Exception e) {
			System.out.println("Unable to add friend from followers menu");
		}
		back_button().click();
		back_button().click();
		more_button().click();
		friends().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		action.longPress(first_friend,4000).release().perform();
		unfollow_button().click();
		okay_button().click();
		back_button().click();

	}
	

	@Test
	public void test02_add_friends() throws Exception {
		
		followers().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		action.longPress(first_friend, 4000).release().perform();
		
		blast_more_block().click();
		okay_button().click();
		back_button().click();
		action.press(followers()).moveTo(back_button()).release().perform();
		muted_blocked_users().click();
		
		try {
			if (first_friend.isDisplayed())
				System.out.println("Friend added from followers menu");
		} catch (Exception e) {
			System.out.println("Unable to add friend from followers menu");
		}
		first_friend.click();
	}
	
	
	
}