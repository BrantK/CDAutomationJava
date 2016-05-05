package com.cyberdust.automation.tests.messagePinning;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_MessagePinningTest extends Drivers {
	
	@Test
	public void test01() throws Exception {
		log("[Start] Starting test");
		try {
			log("- Test01 -");
			
			if (Android()) {
				new Android_MessagePinningTest().test01_pinning_messages();
			} else if (IOS()) {
				new IOS_MessagePinningTest().test01_pinning_messages();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02() throws Exception {
		try {
			log("- Test02 -");
			
			if (Android()) {
				new Android_MessagePinningTest().test02_messagePinning();
			} else if (IOS()) {
				new IOS_MessagePinningTest().test02_messagePinning();
			}
			
			log("Test Complete");
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		log("[Finish] Test complete\n");
	}	
}