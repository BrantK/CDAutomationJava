package com.cyberdust.automation.tests.addFriends;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_AddFriendsTest extends Drivers {
	
	@Test
	public void test01_AddFriendFromChat() throws Exception {
		log("[Start] Starting add friend test");
		try {
			log("- Test01 -");
			log("Add a user that messaged you from chat");
			
			if (Android()) {
				new Android_AddFriendsTest().test01_addFriend_fromChat();
			} else if (IOS()) {
				new IOS_AddFriendsTest().test01_addFriend_fromChat();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_AddFriendFromDusts() throws Exception {
		try {
			log("- Test02 -");
            log("Add a user that messaged you from home +");

			if (Android()) {
				new Android_AddFriendsTest().test02_AddFriend_from_DustsTab();
			} else if (IOS()) {
				new IOS_AddFriendsTest().test02_AddFriend_from_DustsTab();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test03_AddFriendFromFollowers() throws Exception {
		try {
			log("- Test03 -");
            log("Add a user that added you");

			if (Android()) {
				new Android_AddFriendsTest().test03_chat_from_search_bar();
			} else if (IOS()) {
				new IOS_AddFriendsTest().test03_chat_from_search_bar();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test04_Follow_From_AddFriends() throws Exception {
		try {
			log("- Test04 -");
            log("Add a user by searching username in AddFriends");

			if (Android()) {
				new Android_AddFriendsTest().test04_Follow_from_AddFriends();
			} else if (IOS()) {
				new IOS_AddFriendsTest().test04_Follow_from_AddFriends();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test05_AddFriendFromHome() throws Exception {
		try {
			log("- Test05 -");
            log("Add a user by searching username in HomeScreen");

			if (Android()) {
				new Android_AddFriendsTest().test05_AddFriend_from_home();
			} else if (IOS()) {
				new IOS_AddFriendsTest().test05_AddFriend_from_home();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		log("[Finish] Test complete\n");
	}
}