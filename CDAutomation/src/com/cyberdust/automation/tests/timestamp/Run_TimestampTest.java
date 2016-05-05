package com.cyberdust.automation.tests.timestamp;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_TimestampTest extends Drivers {
	
	@Test
	public void test01_Sent_Dust_TimestampTest() throws Exception {
		log("- Start -Starting timestamp test");
		try {
			log("Test01");
			
			if (Android()) {
				new Android_TimestampTest().test01_sent_dust_timestamp();
			} else if (IOS()) {
				new IOS_TimestampTest().test01_sent_dust_timestamp();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_Sent_GroupText_TimestampTest() throws Exception {
		try {
			log("- Test02 -");
			

			if (Android()) {
				new Android_TimestampTest().test02_sent_group_timestamp();
			} else if (IOS()) {
				new IOS_TimestampTest().test02_sent_group_timestamp();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test03_received_dust_TimestampTest() throws Exception {
		try {
			log("- Test03 -");

			if (Android()) {
				new Android_TimestampTest().test03_received_dust_timestamp();
			} else if (IOS()) {
				new IOS_TimestampTest().test03_received_dust_timestamp();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test03_received_group_TimestampTest() throws Exception {
		try {
			log("- Test04 -");

			if (Android()) {
				new Android_TimestampTest().test04_received_group_timestamp();
			} else if (IOS()) {
				new IOS_TimestampTest().test04_received_group_timestamp();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		log("[Finish] Test complete\n");
	}
}