package com.cyberdust.automation.tests.find;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_Find extends Drivers {

        @Test
        public void test01_followChatter() throws Exception {
            try {
                log("- Starting test01 -");

                if (Android()) {
                    new Android_Find().test01_followChatter();
                } else if (IOS()) {
                    new IOS_Find().test01_followChatter();               }

            } catch (Exception e) {
                log("[Fail] Got exception " + e);
                relaunch();
                throw e;
            }
        }

        @Test
        public void test02_chatter_categories() throws Exception {
            try {
                log("- Starting test02 -");

                if (Android()) {
                    new Android_Find().test02_follow_publisher();
                } else if (IOS()) {
                    new IOS_Find().test02_follow_publisher();
                }

            } catch (Exception e) {
                log("[Fail] Got exception " + e);
                relaunch();
                throw e;
            }
        }

	@Test
	public void test03_category_titles () throws Exception {
		try {
			log("- Starting test03 -");
			
			if (Android()) {
				new Android_Find().test03_category_titles();
			} else if (IOS()) {
				new IOS_Find().test03_category_titles();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}

	@Test
	public void test04_build_a_following() throws Exception {
		try {
			log("- Starting test04 -");
			
			if (Android()) {
				new Android_Find().test04_build_a_following();
			} else if (IOS()) {
				new IOS_Find().test04_build_a_following();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}

	@Test
	public void test05_searchbar() throws Exception {
		try {
			log("- Starting test05 -");
			
			if (Android()) {
				new Android_Find().test05_searchbar();
			} else if (IOS()) {
				new IOS_Find().test05_searchbar();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			if (Android()) {
				new Android_Find().deleteAccount();
			} else if (IOS()) {
				new IOS_Find().deleteAccount();
			}
			throw e;
		}
		log("[Finish] Test complete\n");
	}

}