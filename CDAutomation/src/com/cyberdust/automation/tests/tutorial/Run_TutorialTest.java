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
			log("Test01 New accounts have tutorial enabled");

			if (Android()) {
				new Android_TutorialTest().test01_newAccount();
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
	public void test02_enable_tutorial() throws Exception {
		try {
			log("Test02 Tutorial Functionality");

			if (Android()) {
				new Android_TutorialTest().test02_enable_tutorial();
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
	public void test03_main_page() throws Exception {
		try {
			log("Test03 Tutorial main page");

			if (Android()) {
				new Android_TutorialTest().test03_main_page();
			} else if (IOS()) {
				new IOS_TutorialTest().test02_tutorialFunctionality();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
}


