package com.cyberdust.automation.tests.accountManagement;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_AccountManagement extends Drivers {
	
	@Test
	public void test01_ChangePassword() throws Exception {
		try {
			log("- Test01 -");
			log("Change account password");
			
			if (Android()) {
				new Android_AccountManagementTest().test01_changing_password();
			} else if (IOS()) {
				new IOS_AccountManagementTest().test01_changing_password();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}

	@Test
	public void test02_ChangeEmail() throws Exception {
		try {
			log("- Test02 -");
            log("Change account email");
			
			if (Android()) {
				new Android_AccountManagementTest().test02_changing_email();
			} else if (IOS()) {
				new IOS_AccountManagementTest().test02_changing_email();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}	
	}
	
	@Test
	public void test03_AccountDeleting() throws Exception 
	{
		try {
			log("- Test03 -");
            log("Delete account");
			
			if (Android()) {
				new Android_AccountManagementTest().test03_account_deleting();
			} else if (IOS()) {
				new IOS_AccountManagementTest().test03_account_deleting();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			throw e;
		}
		log("[Finish] Test complete\n");
	}
}