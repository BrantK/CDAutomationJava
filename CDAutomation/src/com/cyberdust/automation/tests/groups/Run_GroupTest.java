package com.cyberdust.automation.tests.groups;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_GroupTest extends Drivers {
	
	@Test
	public void test01_createGroup() throws Exception {
		log("[Start] Starting group test");
		
		try {
			log("- Test01 -");
			log("Creating a group");
			
			if (Android()) {
				new Android_GroupTest().test01_create_group();
			} else if (IOS()) {
				new IOS_GroupTest().test01_create_group();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			
			if (Android()) {
				new Android_GroupTest().dusts_tab().click();
				new Android_GroupTest().group1().click();
			}
			if (IOS()) {
				new IOS_GroupTest().dusts_tab().click();
				new IOS_GroupTest().group1().click();
			}
			
			throw e;
		}
	}
	
	@Test
	public void test02_addBlockedUser() throws Exception {
		try {
			log("- Test02 -");
            log("Trying to add blocked user");
			
			if (Android()) {
				new Android_GroupTest().test02_add_blocked_user();
			} else if (IOS()) {
				new IOS_GroupTest().test02_add_blocked_user();
			}
				
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			
			if (Android()) {
				new Android_GroupTest().dusts_tab().click();
				new Android_GroupTest().group1().click();
			}
			if (IOS()) {
				new IOS_GroupTest().dusts_tab().click();
				new IOS_GroupTest().group1().click();
			}
			
			throw e;
		}
	}
		
	@Test
	public void test03_groupMembers() throws Exception {
		try {
			log("- Test03 -");
            log("Checking group members");
			
			if (Android()) {
				new Android_GroupTest().test03_group_members();
			} else if (IOS()) {
				new IOS_GroupTest().test03_group_members();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			
			if (Android()) {
				new Android_GroupTest().dusts_tab().click();
				new Android_GroupTest().group1().click();
			}
			if (IOS()) {
				new IOS_GroupTest().dusts_tab().click();
				new IOS_GroupTest().group1().click();
			}
			
			throw e;
		}
	}
	
	@Test
	public void test04_sendUsername() throws Exception {
		try {
			log("- Test04 -");
            log("Sending a +username");
			
			if (Android()) {
				new Android_GroupTest().test04_send_username();
			} else if (IOS()) {
				new IOS_GroupTest().test04_send_username();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			
			if (Android()) {
				new Android_GroupTest().dusts_tab().click();
				new Android_GroupTest().group1().click();
			}
			if (IOS()) {
				new IOS_GroupTest().dusts_tab().click();
				new IOS_GroupTest().group1().click();
			}
			
			throw e;
		}
	}
	
	@Test
	public void test05_sendPhoto() throws Exception {
		try {
			log("- Test05 -");
            log("Sending a photo");
			
			if (Android()) {
				new Android_GroupTest().test05_send_photo();
			} else if (IOS()) {
				new IOS_GroupTest().test05_send_photo();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			
			if (Android()) {
				new Android_GroupTest().dusts_tab().click();
				new Android_GroupTest().group1().click();
			}
			if (IOS()) {
				new IOS_GroupTest().dusts_tab().click();
				new IOS_GroupTest().group1().click();
			}
			
			throw e;
		}
	}
		
	@Test
	public void test06_sendVideo() throws Exception {
		try {
			log("- Test06 -");
            log("Sending a video");
			
			if (Android()) {
				new Android_GroupTest().test06_send_video();
			} else if (IOS()) {
				new IOS_GroupTest().test06_send_video();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			
			if (Android()) {
				new Android_GroupTest().dusts_tab().click();
				new Android_GroupTest().group1().click();
			}
			if (IOS()) {
				new IOS_GroupTest().dusts_tab().click();
				new IOS_GroupTest().group1().click();
			}
			
			throw e;
		}
	}
	
	@Test
	public void test07_sendGiphy() throws Exception {
		try {
			log("- Test07 -");
            log("Sending a giphy");
			
			if (Android()) {
				new Android_GroupTest().test07_send_giphy();
			} else if (IOS()) {
				new IOS_GroupTest().test07_send_giphy();
			}
				
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			
			if (Android()) {
				new Android_GroupTest().dusts_tab().click();
				new Android_GroupTest().group1().click();
			}
			if (IOS()) {
				new IOS_GroupTest().dusts_tab().click();
				new IOS_GroupTest().group1().click();
			}
			
			throw e;
		}
	}
	
	@Test
	public void test08_sendGalleryPhoto() throws Exception {
		try {
			log("- Test08 -");
            log("Sending a picture from gallery");
			
			if (Android()) {
				new Android_GroupTest().test08_send_gallery_photo();
			} else if (IOS()) {
				new IOS_GroupTest().test08_send_gallery_photo();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			
			if (Android()) {
				new Android_GroupTest().dusts_tab().click();
				new Android_GroupTest().group1().click();
			}
			if (IOS()) {
				new IOS_GroupTest().dusts_tab().click();
				new IOS_GroupTest().group1().click();
			}
			
			throw e;
		}
	}
	
	@Test
	public void test09_openGroupMessages() throws Exception {
		try {
			log("- Test09 -");
            log("Checking group messages");
			
			if (Android()) {
				new Android_GroupTest().test09_open_group_messages();
			} else if (IOS()) {
				new IOS_GroupTest().test09_open_group_messages();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		log("[Finish] Test complete\n");
	}
}