package com.cyberdust.automation.tests.dusts;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_DustTest extends Drivers {
	
	@Test
	public void test01_sendTextDusts() throws Exception {
		log("[Start] Starting blast test");
		try {
			log("- Test01 -");
			log("Starting a new dust from action menu");
			
			if (Android()) {
				new Android_DustTest().test01_chat_from_action_menu();
			} else if (IOS()) {
				new IOS_dustTest().test01_chat_from_action_menu();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_dustRoomTest() throws Exception {
		try {
			log("- Test02 -");
            log("Starting a dust with someone you already dusted");

			if (Android()) {
				new Android_DustTest().test02_chat_from_dust_room();
			} else if (IOS()) {
				new IOS_dustTest().test02_chat_from_dust_room();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test03_sendDustFromSearchBar() throws Exception {
		try {
			log("- Test03 -");
            log("Starting a dust from search");

			if (Android()) {
				new Android_DustTest().test03_chat_from_search_bar();
			} else if (IOS()) {
				new IOS_dustTest().test03_chat_from_search_bar();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test04_sendDustFromSearchBar02() throws Exception {
		try {
			log("- Test04 -");
            log("Start a new dust from search");

			if (Android()) {
				new Android_DustTest().test04_chat_from_search_bar();
			} else if (IOS()) {
				new IOS_dustTest().test04_chat_from_search_bar();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test05_sendDustsfromFriendsPage() throws Exception {
		try {
			log("- Test05 -");
            log("Starting a dust from friends - search");

			if (Android()) {
				new Android_DustTest().test05_chat_from_friend_list();
			} else if (IOS()) {
				new IOS_dustTest().test05_chat_from_friend_list();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test06_sendDustsfromFriendsPage02() throws Exception {
		try {
			log("- Test06 -");
            log("Starting a new dust from friends - search");

			if (Android()) {
				new Android_DustTest().test06_chat_from_friend_list();
			} else if (IOS()) {
				new IOS_dustTest().test06_chat_from_friend_list();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test07_sendDustsfromFriendsPage03() throws Exception {
		try {
			log("- Test07 -");
            log("Start a dust from friends list");

			if (Android()) {
				new Android_DustTest().test07_chat_from_friend_list();
			} else if (IOS()) {
				new IOS_dustTest().test07_chat_from_friend_list();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
		
	@Test
	public void test08_sendDustsfromFriendsPage04() throws Exception {
		try {
			log("- Test08 -");
            log("Start new dust from friends list");

			if (Android()) {
				new Android_DustTest().test08_chat_from_friend_list();
			} else if (IOS()) {
				new IOS_dustTest().test08_chat_from_friend_list();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			throw e;
		}
		log("Test complete\n");
	}
}
	