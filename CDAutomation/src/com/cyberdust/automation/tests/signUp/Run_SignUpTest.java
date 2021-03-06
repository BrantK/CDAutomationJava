package com.cyberdust.automation.tests.signUp;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.utils.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_SignUpTest extends Drivers {
	
	@Test
	public void test01_checkIfLoggedOut() throws Exception {
		log("[Start] Starting sign up test");
		try {
			log("- Test01 -");
			
			if (isAndroid()) {
				new Android_SignUpTest().test01_check_logged_out();
			} else if (isIOS()) {
				new IOS_SignUpTest().test01_check_logged_out();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			getDriver().resetApp();
			throw e;
		}
	}

	@Test
	public void test02_signUp() throws Exception {
		try {
			log("- Test02 -");

			if (isAndroid()) {
				new Android_SignUpTest().test02_sign_up();
			} else if (isIOS()) {
				new IOS_SignUpTest().test02_sign_up();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			getDriver().resetApp();
			throw e;
		}
	}

    @Test
    public void test03_signUp2() throws Exception {
        try {
            log("- Test03 -");

            if (isAndroid()) {
                new Android_SignUpTest().test03_sign_up2();
            } else if (isIOS()) {
                new IOS_SignUpTest().test03_sign_up2();
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            getDriver().resetApp();
            throw e;
        }
    }
	
	@Test
	public void test04_updateProfilePic() throws Exception {
		try {
			log("- Test04 -");

			if (isAndroid()) {
				new Android_SignUpTest().test04_update_profile_pic();
			} else if (isIOS()) {
				new IOS_SignUpTest().test04_update_profile_pic();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

            if (isAndroid()) {
                new Android_SignUpTest().settingsIcon().click();
            }
            if (isIOS()) {
                new IOS_SignUpTest().more_button().click();
            }

			throw e;
		}
	}

	@Test
	public void test05_updateBio() throws Exception {
		try {
			log("- Test05 -");

			if (isAndroid()) {
				new Android_SignUpTest().test05_update_bio_and_website();
			} else if (isIOS()) {
				new IOS_SignUpTest().test05_update_bio_and_website();
			}

		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

            if (isAndroid()) {
                new Android_SignUpTest().settingsIcon().click();
            }
            if (isIOS()) {
                new IOS_SignUpTest().more_button().click();
            }

			throw e;
		}
	}
	
	@Test
	public void test06_loginLogout() throws Exception {
		try {
			log("- Test06 -");

			if (isAndroid()) {
				new Android_SignUpTest().test06_login_logout();
			} else if (isIOS()) {
				new IOS_SignUpTest().test06_login_logout();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		log("[Finish] Test Complete\n");
	}
}
