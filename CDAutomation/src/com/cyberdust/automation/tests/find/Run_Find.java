package com.cyberdust.automation.tests.find;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_Find extends Drivers {
	
	@Test
	public void test01_followChatter() throws Exception {
		try {
			log("Starting test - ");
			
			if (Android()) {
				new Android_Find().test01_followChatter();
			} else if (IOS()) {
				new IOS_Find().test01_followChatter();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_chatter_categories() throws Exception {
		try {
			log("Starting test - ");
			
			if (Android()) {
				new Android_Find().test02_chattercategories();
			} else if (IOS()) {
				//new IOS_Find().xxx();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test03_followfeedList() throws Exception {
		try {
			log("Starting test - ");
			
			if (Android()) {
				new Android_Find().test03_followfeedlist();
			} else if (IOS()) {
				//new IOS_Find().xxx();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test04_feedlist_categories() throws Exception {
		try {
			log("Starting test - ");
			
			if (Android()) {
				new Android_Find().test04_feedList_categories();
			} else if (IOS()) {
				//new IOS_Find().xxx();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test05_findtab_menus() throws Exception {
		try {
			log("Starting test - ");
			
			if (Android()) {
				new Android_Find().test05_findtab_menus();
			} else if (IOS()) {
				//new IOS_Find().xxx();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test06_searchbar() throws Exception {
		try {
			log("Starting test - ");
			
			if (Android()) {
				new Android_Find().test06_searchbar();
			} else if (IOS()) {
				//new IOS_Find().xxx();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}