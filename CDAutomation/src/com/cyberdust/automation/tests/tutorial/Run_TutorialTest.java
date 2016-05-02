package com.cyberdust.automation.tests.tutorial;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_TutorialTest extends Drivers {

	@Test
	public void test01_new_account() throws Exception {
		log("[Start] Starting Tutorial test");
		try {
			log("Enabling tutoial");

			if (Android()) {
				new Android_TutorialTest().test01_enable_tutorial();
			} else if (IOS()) {
				new IOS_TutorialTest().test01_tutorialUI();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_profile_photo() throws Exception {
		try {
			log("Test02 Profile photo");

			if (Android()) {
				new Android_TutorialTest().test02_profile_photo();
			} else if (IOS()) {
				new IOS_TutorialTest().test02_tutorialFunctionality();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test03_Find_friends() throws Exception {
		try {
			log("Test03 Find friends");

			if (Android()) {
				new Android_TutorialTest().test03_Find_friends();
			} else if (IOS()) {
				new IOS_TutorialTest().test02_tutorialFunctionality();
			}

		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	public void test04_Learn_to_dust() throws Exception {
		try {
			log("Test04 Learn to dust");

			if (Android()) {
				new Android_TutorialTest().test04_Learn_to_dust();
			} else if (IOS()) {
				new IOS_TutorialTest().test02_tutorialFunctionality();
			}

		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		log("[Finish] Test complete\n");
	}
	
}


