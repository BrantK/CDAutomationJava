package tests.blasts;

import org.junit.*;
import org.junit.runners.MethodSorters;

import elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_BlastTest extends Drivers {
	
	/*
	@Test
	public void test01_createBlastList() throws Exception {
		log("[Start] Starting blast test");
		try {
			log("Test01 creating blast list");
			
			if (Android()) {
				new Android_BlastTest().test01_create_blast_list();
			} else if (IOS()) {
				new IOS_BlastTest().test01_create_blast_list();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}*/
	
	@Test
	public void test02_sendTextBlasts() throws Exception {
		try {
			log("Test02 sending text blasts");

			if (Android()) {
				new Android_BlastTest().test02_send_text_blasts();
			} else if (IOS()) {
				new IOS_BlastTest().test02_send_text_blasts();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test03_sendPhotoBlast1() throws Exception {
		try {
			log("Test03 sending photo blast1");

			if (Android()) {
				new Android_BlastTest().test03_send_photo_blast_01();
			} else if (IOS()) {
				new IOS_BlastTest().test03_send_photo_blast_01();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test04_sendPhotoBlast2() throws Exception {
		try {
			log("Test04 sending photo blast2");

			if (Android()) {
				new Android_BlastTest().test04_send_photo_blast_02();
			} else if (IOS()) {
				new IOS_BlastTest().test04_send_photo_blast_02();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test05_sendGiphyBlast() throws Exception {
		try {
			log("Test05 sending giphy blast");

			if (Android()) {
				new Android_BlastTest().test05_send_giphy_blast();
			} else if (IOS()) {
				new IOS_BlastTest().test05_send_giphy_blast();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test06_sendVideoBlast1() throws Exception {
		try {
			log("Test06 sending video blast1");

			if (Android()) {
				new Android_BlastTest().test06_send_video_blast_01();
			} else if (IOS()) {
				new IOS_BlastTest().test06_send_video_blast_01();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test07_sendVideoBlast2() throws Exception {
		try {
			log("Test07 sending video blast2");

			if (Android()) {
				new Android_BlastTest().test07_send_video_blast_02();
			} else if (IOS()) {
				new IOS_BlastTest().test07_send_video_blast_02();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test08_sendTextForReplies() throws Exception {
		try {
			log("Test08 sending text blast for reply test");

			if (Android()) {
				new Android_BlastTest().test08_send_text_for_replies();
			} else if (IOS()) {
				new IOS_BlastTest().test08_send_text_for_replies();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test09_openTextBlast() throws Exception {
		try {
			log("Test09 opening text blasts");

			if (Android()) {
				new Android_BlastTest().test09_open_text_blast();
			} else if (IOS()) {
				new IOS_BlastTest().test09_open_text_blast();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

			if (Android()) {
				new Android_BlastTest().name(new Android_BlastTest().account01).click(); 
			}
			if (IOS()) {
				new IOS_BlastTest().name(new IOS_BlastTest().account01).click(); 
			}
			
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test10_openPhotoBlast() throws Exception {
		try {
			log("Test10 opening photo blasts");

			if (Android()) {
				new Android_BlastTest().test10_open_photo_blast();
			} else if (IOS()) {
				new IOS_BlastTest().test10_open_photo_blast();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			
			if (Android()) {
				new Android_BlastTest().name(new Android_BlastTest().account01).click(); 
			}
			if (IOS()) {
				new IOS_BlastTest().name(new IOS_BlastTest().account01).click(); 
			}
			
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test11_openNonPublicBlast() throws Exception {
		try {
			log("Test11 openinig non public blast");

			if (Android()) {
				new Android_BlastTest().test11_open_non_public_blast();
			} else if (IOS()) {
				new IOS_BlastTest().test11_open_non_public_blast();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

			if (Android()) {
				new Android_BlastTest().name(new Android_BlastTest().account01).click(); 
			}
			if (IOS()) {
				new IOS_BlastTest().name(new IOS_BlastTest().account01).click(); 
			}
			
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test12_openGiphyBlast() throws Exception {
		try {
			log("Test12 opening giphy blast");
			
			if (Android()) {
				new Android_BlastTest().test12_open_giphy_blast();
			} else if (IOS()) {
				new IOS_BlastTest().test12_open_giphy_blast();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

			if (Android()) {
				new Android_BlastTest().name(new Android_BlastTest().account01).click(); 
			}
			if (IOS()) {
				new IOS_BlastTest().name(new IOS_BlastTest().account01).click(); 
			}
			
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test13_openVideoBlast() throws Exception {
		try {
			log("Test13 opening video blasts");

			if (Android()) {
				new Android_BlastTest().test13_open_video_blast();
			} else if (IOS()) {
				new IOS_BlastTest().test13_open_video_blast();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

			if (Android()) {
				new Android_BlastTest().name(new Android_BlastTest().account01).click(); 
			}
			if (IOS()) {
				new IOS_BlastTest().name(new IOS_BlastTest().account01).click(); 
			}
			
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test14_replyToBlast() throws Exception {
		try {
			log("Test14 replying to blast");

			if (Android()) {
				new Android_BlastTest().test14_reply_to_blast();
			} else if (IOS()) {
				new IOS_BlastTest().test14_reply_to_blast();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test15_checkReplies() throws Exception {
		try {
			log("Test15 checking if replies were received");

			if (Android()) {
				new Android_BlastTest().test15_check_replies();
			} else if (IOS()) {
				new IOS_BlastTest().test15_check_replies();
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