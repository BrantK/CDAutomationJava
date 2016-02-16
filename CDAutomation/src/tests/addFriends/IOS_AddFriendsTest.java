package tests.addFriends;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.IOSElements;
import elements.LoginWith;
import io.appium.java_client.TouchAction;





public class IOS_AddFriendsTest extends IOSElements {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	///////////////////////////////////////////////
	String account_name = "existingtest02";
	String account_short = "existingtest02";
	String account_pw = "password";
	String account_email = "existing02@cyberdust.com";
	String text_message = "cyber dust";
	String friend_username = "aaaaa2";
	String friend_username0 = "aaaaa";
	//////////////////////////////////////////////


	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();

	public WebElement first_friend() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
	}
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	public void test01_addFriend_fromChat() throws Exception {
		loginAs.user(friend_username, account_pw);
		action_menu().click();
		action_menu_dust().click();
		
		driver.getKeyboard().sendKeys(account_short);
		WebElement user = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_name)));
		user.click();
		chat_room_text_box();
		dust_text_box();
		driver.getKeyboard().sendKeys(text_message);
		send_dust().click();
		back_button().click();
		System.out.println("Sent a dust");
		
		loginAs.user(account_name + "\n", account_pw + "\n");
		dusts_tab().click();
		first_friend().click();
		group_three_dotted_menu().click();
		follow_from_chat_room().click();
		OK_button().click();
		group_three_dotted_menu().click();
		try{
			if(unfollow_from_chat_room().getAttribute("name").equals("unfollow")){
				System.out.println("Followed from chat room");
			}
			unfollow_from_chat_room().click();
			yes_button().click();
		}
		finally {}
	}


	public void test02_AddFriend_from_DustsTab() throws Exception
	{
		Thread.sleep(800);
		action.press(45, 105).release().perform();//try to click unlabeled prof pic button
				
		WebElement follow_firstFriend = wait.until(ExpectedConditions.elementToBeClickable(By.name("Follow" )));
		follow_firstFriend.click();
		close_profile_view();
		first_friend().click();
		
		Thread.sleep(800);
		action.press(45, 105).release().perform();//try to click unlabeled prof pic button
		follow_firstFriend = wait.until(ExpectedConditions.elementToBeClickable(By.name("Following")));
		
		
		try{
			if((driver.findElement(By.name("Following"))).getAttribute("name").equals("Following"))
				System.out.println("Followed from dusts tab");
			follow_firstFriend.click();
			yes_button().click();
			close_profile_view();
		}
		finally{}
	}
			
			


	public void test03_chat_from_search_bar() throws Exception

	{
		
		more_button().click();
		browse_followers().click();
		add_friend().click();
		OK_button().click();
		back_button().click();
		browse_friends().click();

		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		action.longPress(first_friend()).release().perform();
		group_three_dotted_menu().click();
		
		try{
			
			if(unfollow_button().isDisplayed())
				System.out.println("Added a friend from search bar");
			unfollow_button().click();
			yes_button().click();
			close_profile_view();
			back_button().click();
		}

		catch (Exception e) {

			System.out.println("Unable to add a friend from search bar");

		}

	}
	public void test04_Follow_from_AddFriends() throws Exception{
		
		more_button().click();
		browse_friends().click();
		Thread.sleep(1500);
		action.longPress(75, 85).release().perform();//clicks in search bar
		driver.getKeyboard().sendKeys(friend_username);	
		add_friends_button_inBrowseFriends().click();
		clear_friends_searchbar().click();
		back_button().click();
		browse_friends().click();

		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		action.longPress(first_friend()).release().perform();
		group_three_dotted_menu().click();

		try{
			
			if(unfollow_button().isDisplayed())
				System.out.println("Added a friend from search bar");
			unfollow_button().click();
			yes_button().click();
			close_profile_view();
			
			
		}
		catch (Exception e) {

			System.out.println("Unable to add a friend from search bar");

		}
		
	}

	public void test05_AddFriend_from_home() throws Exception

	{

		action_menu().click();
		Thread.sleep(2000);
		action_menu_search().click();
		//friends_search().click();
		driver.getKeyboard().sendKeys(friend_username);
		add_friends_button_inBrowseFriends().click();
		clear_friends_searchbar().click();
		more_button().click();
		browse_friends().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		action.longPress(first_friend(), 4000).release().perform();
		group_three_dotted_menu().click();
		

		try{
			
			if(unfollow_button().isDisplayed())
				System.out.println("Added a friend from search bar");
			unfollow_button().click();
			yes_button().click();
			close_profile_view();
			
		}

		catch (Exception e) {

			System.out.println("Unable to add a friend from search bar");

		}
		
	}
	public void test06_popular_page() throws Exception

	{

		
		action_menu().click();
		//Thread.sleep(2000);
		action_menu_discover().click();
		Thread.sleep(4000);
	
		try{
			
			if(discover_tab().isDisplayed())
				System.out.println("Popular tab is accessible");
			}

		catch (Exception e) {

			System.out.println("Popular tab is not accessible");

		}
		
	}
	
	public void test07_chatters_page() throws Exception
	{
		try{
			if(chatters_tab().isDisplayed())
				System.out.println("Chatters tab is accessible");
		}

		catch (Exception e) {
			System.out.println("Chatters tab is not accessible");

		}
		
	}
	
	public void test08_Popular_page() throws Exception

	{

	
		try{
			
			if(chatters_tab().isDisplayed())
			{
				
				WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RelativeLayout[@index='3']")));
				first_friend.click();
				yes_button().click();
				Thread.sleep(2000);
				first_friend.click();
				yes_button().click();
				
				if(Friend_already_added().isDisplayed())
				{
					System.out.println("Popular page - a user can be added");
				}
			}
		}
		catch (Exception e) {

			System.out.println("Discover tab is not accessible");
		
		}
	}	
	
	public void logout_account() throws Exception {
		back_button().click();
		back_button().click();
		more_button().click();
		logoutAccount();
	}
	
}