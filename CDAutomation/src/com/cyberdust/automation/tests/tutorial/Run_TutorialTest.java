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
	public void test02_private_messaging() throws Exception {
		try {
			log("Test02 private messaging");

			if (Android()) {
				new Android_TutorialTest().test02_private_messaging();
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
	public void test03_profile_photo() throws Exception {
		try {
			log("Test03 profile photo");

			if (Android()) {
				new Android_TutorialTest().test03_profile_photo();
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
	public void test04_find_friends() throws Exception {
		try {
			log("Test04 find friends");
			if (Android()) {
				new Android_TutorialTest().test04_find_friends();
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
	public void test05_learn_to_dust() throws Exception {
		try {
			log("Test05 learn to dust");
			if (Android()) {
				new Android_TutorialTest().test05_learn_to_dust();
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
	public void test06_tutorial_complete01() throws Exception {
		try {
			log("Test06 Build A Following");
			if (Android()) {
				new Android_TutorialTest().test06_tutorial_complete();
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
	public void test07_restart() throws Exception {
		try {
			log("Test07 restart");
			if (Android()) {
				new Android_TutorialTest().test07_restart();
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
	public void test08_build_a_following() throws Exception {
		try {
			log("Test05 Build A Following");
			if (Android()) {
				new Android_TutorialTest().test08_build_a_following();
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
	public void test09_test09_find_friends_from_facebbok() throws Exception {
		try {
			log("Test09 find friends from facebbok");
			if (Android()) {
				new Android_TutorialTest().test09_find_friends_from_facebbok();
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
	public void test10_share_your_profile() throws Exception {
		try {
			log("Test10 share your profile");
			if (Android()) {
				new Android_TutorialTest().test10_share_your_profile();
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
	public void test11_learn_about_blasts() throws Exception {
		try {
			log("Test11 Build A Following");
			if (Android()) {
				new Android_TutorialTest().test11_learn_about_blasts();
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
	public void test12_tutorial_complete() throws Exception {
		try {
			log("Test12 tutorial complete");
			if (Android()) {
				new Android_TutorialTest().test06_tutorial_complete();
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


