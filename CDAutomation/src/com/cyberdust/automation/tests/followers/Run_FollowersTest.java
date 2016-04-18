package com.cyberdust.automation.tests.followers;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_FollowersTest extends Drivers {

	@Test
	public void test01_addFriends() throws Exception {
		log("[Start] Starting blast test");
		try {
			log("Test01: Adding a friend from followers menu");
			
			if (Android()) {
				new Android_followersTest().test01_add_friends();
			} else if (IOS()) {
				new IOS_followersTest().test01_add_friends();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_addFriends02() throws Exception {
		log("[Start] Starting blast test");
		try {
			log("Test01: Adding a friend from followers menu");
			
			if (Android()) {
				new Android_followersTest().test02_add_friends();
			} else if (IOS()) {
				new IOS_followersTest().test02_add_friends();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			throw e;
		}
		log("[Finish] Test complete\n");
	}
}