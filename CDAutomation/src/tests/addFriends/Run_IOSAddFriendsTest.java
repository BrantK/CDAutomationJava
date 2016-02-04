package tests.addFriends;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_IOSAddFriendsTest extends IOS_AddFriendsTest {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	IOS_AddFriendsTest iPhone = new IOS_AddFriendsTest();
	/*
	@Test
	public void test01_AddFriendFromChat() throws Exception {
		log("[Start] Starting add friend test");
		try {
			log("Test01: add a user that messaged you from chat");
			iPhone.test01_addFriend_fromChat();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}*/
	@Test
	public void test02_AddFriendFromDusts() throws Exception {
		try {
			log("Test02: add a user that messaged you from home +");
			iPhone.test02_AddFriend_from_DustsTab();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test03_AddFriendFromFollowers() throws Exception {
		try {
			log("Test03: add a user that added you");
			iPhone.test03_chat_from_search_bar();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test04_AddFriendFromFollowers() throws Exception {
		try {
			log("Test04: add a user by searching username in AddFriends");
			iPhone.test04_Follow_from_AddFriends();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test05_AddFriendFromFollowers() throws Exception {
		try {
			log("Test05: add a user by searching username in HomeScreen");
			iPhone.test05_AddFriend_from_home();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test06_AddFriendFromPopular() throws Exception {
		try {
			log("Test06: Popular page - can access ");
			iPhone.test06_popular_page();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test07_AddFriendFromChatters() throws Exception {
		try {
			log("Test07: Chatters page  - can access ");
			iPhone.test07_chatters_page();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test08_AddFriendFromPopular2() throws Exception {
		try {
			log("Test08: Popular page - a user can be added ");
			iPhone.test08_Popular_page();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}