package com.cyberdust.automation.tests.deleteGroupChatRoom;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_DeleteGroupChatTests extends Drivers {
	
	@Test
	public void test01_delete_all_group_chat_rooms() throws Exception {
		log("[Start] Starting delete group chat room test");
		try {
			log("- Test01 -");
			log("Deleting all group chat rooms");
			
			if (Android()) {
				new Android_DeleteGroupChatTests().test01_delete_all_group_chat_rooms();
			} else if (IOS()) {
				new IOS_DeleteGroupChatTests().test01_delete_all_group_chat_rooms();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_delete_group_chat_rooms() throws Exception {
		
		try {
			log("- Test02 -");
            log("Deleting 1-4 group chat rooms");

			if (Android()) {
				new Android_DeleteGroupChatTests().test02_delete_group_chat_rooms();
			} else if (IOS()) {
				new IOS_DeleteGroupChatTests().test02_delete_group_chat_rooms();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		log("[Finish] Test complete\n");
	}
}