package com.cyberdust.automation.tests.managingFriends;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_FriendTest extends Drivers {
	
	@Test
	public void test01_blastFromAcct04() throws Exception {
		log("[Start] Starting test");
		try {
			log("- Test01 -");
			
			if (Android()) {
				new Android_FriendsTest().test01_blast_for_blasts_tab();
			} else if (IOS()) {
				new IOS_FriendsTest().test01_blast_for_blasts_tab();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}

	@Test
	public void test02_blastFromAcct05() throws Exception {
		try {
			log("- Test02 -");

			if (Android()) {
				new Android_FriendsTest().test02_blast_for_swipe_view();
			} else if (IOS()) {
				new IOS_FriendsTest().test02_blast_for_swipe_view();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test03_blockAllAccounts() throws Exception {
		try {
			log("- Test03 -");
			
			if (Android()) {
				new Android_FriendsTest().test03_block_all_accounts();
			} else if (IOS()) {
				new IOS_FriendsTest().test03_block_all_accounts();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
		
	@Test
	public void test04_messageToBlocked() throws Exception {
		try {
			log("- Test04 -");

			if (Android()) {
				new Android_FriendsTest().test04_message_to_blocked();
			} else if (IOS()) {
				new IOS_FriendsTest().test04_message_to_blocked();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
		
	@Test
	public void test05_muteAllAccounts() throws Exception {
		try {
			log("- Test05 -");

			if (Android()) {
				new Android_FriendsTest().test05_mute_all_accounts();
			} else if (IOS()) {
				new IOS_FriendsTest().test05_mute_all_accounts();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
		
	@Test
	public void test06_dustsAndBlasts02() throws Exception {
		try {
			log("- Test06 -");

			if (Android()) {
				new Android_FriendsTest().test06_dusts_and_blasts_02();
			} else if (IOS()) {
				new IOS_FriendsTest().test06_dusts_and_blasts_02();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
			
	@Test
	public void test07_unfollowAccounts() throws Exception {
		try {
			log("- Test07 -");

			if (Android()) {
				new Android_FriendsTest().test07_unfollow_accounts();
			} else if (IOS()) {
				new IOS_FriendsTest().test07_unfollow_accounts();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
		
	@Test
	public void test08_dustsAndBlasts03() throws Exception {
		try {
			log("- Test08 -");

			if (Android()) {
				new Android_FriendsTest().test08_dusts_and_blasts_03();
			} else if (IOS()) {
				new IOS_FriendsTest().test08_dusts_and_blasts_03();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test09_dustsAndBlasts04() throws Exception {
		try {
			log("- Test09 -");

			if (Android()) {
				new Android_FriendsTest().test09_dusts_and_blasts_04();
			} else if (IOS()) {
				new IOS_FriendsTest().test09_dusts_and_blasts_04();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test10_dustsAndBlasts05() throws Exception {
		try {
			log("- Test10 -");

			if (Android()) {
				new Android_FriendsTest().test10_dusts_and_blasts_05();
			} else if (IOS()) {
				new IOS_FriendsTest().test10_dusts_and_blasts_05();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test11_dustsAndBlasts06() throws Exception {
		try {
			log("- Test11 -");

			if (Android()) {
				new Android_FriendsTest().test11_dusts_and_blasts_06();
			} else if (IOS()) {
				new IOS_FriendsTest().test11_dusts_and_blasts_06();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test12_checkMsgFromBlocked() throws Exception {
		try {
			log("- Test12 -");

			if (Android()) {
				new Android_FriendsTest().test12_check_msg_from_blocked();
			} else if (IOS()) {
				new IOS_FriendsTest().test12_check_msg_from_blocked();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test13_unblockAccounts() throws Exception {
		try {
			log("- Test13 -");

			if (Android()) {
				new Android_FriendsTest().test13_unblock_accounts();
			} else if (IOS()) {
				new IOS_FriendsTest().test13_unblock_accounts();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test14_checkMsgFromMuted() throws Exception {
		try {
			log("- Test14 -");

			if (Android()) {
				new Android_FriendsTest().test14_check_msg_from_muted();
			} else if (IOS()) {
				new IOS_FriendsTest().test14_check_msg_from_muted();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test15_unmuteAccount01() throws Exception {
		try {
			log("- Test15 -");

			if (Android()) {
				new Android_FriendsTest().test15_unmute_account01();
			} else if (IOS()) {
				new IOS_FriendsTest().test15_unmute_account01();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test16_unmuteAccount03And04() throws Exception {
		try {
			log("- Test16 -");

			if (Android()) {
				new Android_FriendsTest().test16_unmute_account03_and_04();
			} else if (IOS()) {
				new IOS_FriendsTest().test16_unmute_account03_and_04();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test17_unmuteAccount05And06() throws Exception {
		try {
			log("- Test17 -");

			if (Android()) {
				new Android_FriendsTest().test17_unmute_account05_and_06();
			} else if (IOS()) {
				new IOS_FriendsTest().test17_unmute_account05_and_06();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test18_addAccounts() throws Exception {
		try {
			log("- Test18 -");

			if (Android()) {
				new Android_FriendsTest().test18_add_accounts();
			} else if (IOS()) {
				new IOS_FriendsTest().test18_add_accounts();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}

		log("[Finish] Test complete\n");
	}
}