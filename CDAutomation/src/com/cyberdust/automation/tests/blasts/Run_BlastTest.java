package com.cyberdust.automation.tests.blasts;

import com.cyberdust.automation.elements.IOSElements;
import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_BlastTest extends Drivers {

	@Test
	public void test01_createBlastList() throws Exception {
		log("[Start] Starting blast test");

		try {
			log("- Test01 -");
			
			if (Android()) {

				new Android_BlastTest().test01_create_blast_list();
			} else if (IOS()) {
				new IOS_BlastTest().test01_create_blast_list();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

			if (Android()) {
                new Android_BlastTest().blasts_tab().click();
            }
            if (IOS()) {
                new IOSElements().blasts_tab().click();
            }

			throw e;
		}
	}
	
	@Test
	public void test02_sendTextBlasts() throws Exception {
		try {
			log("- Test02 -");

			if (Android()) {
				new Android_BlastTest().test02_send_text_blasts();
			} else if (IOS()) {
				new IOS_BlastTest().test02_send_text_blasts();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

            if (Android()) {
                new Android_BlastTest().blasts_tab().click();
            }
            if (IOS()) {
                new IOS_BlastTest().blasts_tab().click();
            }

			throw e;
		}
	}
	
	@Test
	public void test03_sendPhotoBlast1() throws Exception {
		try {
			log("- Test03 -");

			if (Android()) {
				new Android_BlastTest().test03_send_photo_blast_01();
			} else if (IOS()) {
				new IOS_BlastTest().test03_send_photo_blast_01();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

            if (Android()) {
                new Android_BlastTest().blasts_tab().click();
            }
            if (IOS()) {
                new IOS_BlastTest().blasts_tab().click();
            }

			throw e;
		}
	}
	
	@Test
	public void test04_sendPhotoBlast2() throws Exception {
		try {
			log("- Test04 -");

			if (Android()) {
				new Android_BlastTest().test04_send_photo_blast_02();
			} else if (IOS()) {
				new IOS_BlastTest().test04_send_photo_blast_02();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

            if (Android()) {
                new Android_BlastTest().blasts_tab().click();
            }
            if (IOS()) {
                new IOS_BlastTest().blasts_tab().click();
            }

			throw e;
		}
	}
	
	@Test
	public void test05_sendGiphyBlast() throws Exception {
		try {
			log("- Test05 -");

			if (Android()) {
				new Android_BlastTest().test05_send_giphy_blast();
			} else if (IOS()) {
				new IOS_BlastTest().test05_send_giphy_blast();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

            if (Android()) {
                new Android_BlastTest().blasts_tab().click();
            }
            if (IOS()) {
                new IOS_BlastTest().blasts_tab().click();
            }

			throw e;
		}
	}
	
	@Test
	public void test06_sendVideoBlast1() throws Exception {
		try {
			log("- Test06 -");

			if (Android()) {
				new Android_BlastTest().test06_send_video_blast_01();
			} else if (IOS()) {
				new IOS_BlastTest().test06_send_video_blast_01();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

            if (Android()) {
                new Android_BlastTest().blasts_tab().click();
            }
            if (IOS()) {
                new IOS_BlastTest().blasts_tab().click();
            }

			throw e;
		}
	}
	
	@Test
	public void test07_sendVideoBlast2() throws Exception {
		try {
			log("- Test07 -");

			if (Android()) {
				new Android_BlastTest().test07_send_video_blast_02();
			} else if (IOS()) {
				new IOS_BlastTest().test07_send_video_blast_02();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

            if (Android()) {
                new Android_BlastTest().blasts_tab().click();
            }
            if (IOS()) {
                new IOS_BlastTest().blasts_tab().click();
            }

			throw e;
		}
	}
	
	@Test
	public void test08_sendTextForReplies() throws Exception {
		try {
			log("- Test08 -");

			if (Android()) {
				new Android_BlastTest().test08_send_text_for_replies();
			} else if (IOS()) {
				new IOS_BlastTest().test08_send_text_for_replies();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

            if (Android()) {
                new Android_BlastTest().blasts_tab().click();
            }
            if (IOS()) {
                new IOS_BlastTest().blasts_tab().click();
            }

			throw e;
		}
	}
	
	@Test
    public void test09_replyToBlast() throws Exception {
        try {
            log("- Test09 -");

            if (Android()) {
                new Android_BlastTest().test09_reply_to_blast();
            } else if (IOS()) {
                new IOS_BlastTest().test09_reply_to_blast();
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();

            if (Android()) {
                new Android_BlastTest().blasts_tab().click();
                new Android_BlastTest().blast01().click();
            }
            if (IOS()) {
                new IOS_BlastTest().blasts_tab().click();
                new IOS_BlastTest().blast01().click();
            }

            throw e;
        }
    }


    @Test
    public void test10_openVideoBlast() throws Exception {
        try {
            log("- Test10 -");

            if (Android()) {
                new Android_BlastTest().test10_open_video_blast();
            } else if (IOS()) {
                new IOS_BlastTest().test10_open_video_blast();
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();

            if (Android()) {
                new Android_BlastTest().blasts_tab().click();
                new Android_BlastTest().blast01().click();
            }
            if (IOS()) {
                new IOS_BlastTest().blasts_tab().click();
                new IOS_BlastTest().blast01().click();
            }

            Thread.sleep(1000);
            throw e;
        }
    }
	
	@Test
    public void test11_openGiphyBlast() throws Exception {
        try {
            log("- Test11 -");

            if (Android()) {
                new Android_BlastTest().test11_open_giphy_blast();
            } else if (IOS()) {
                new IOS_BlastTest().test11_open_giphy_blast();
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();

            if (Android()) {
                new Android_BlastTest().blasts_tab().click();
                new Android_BlastTest().blast01().click();
            }
            if (IOS()) {
                new IOS_BlastTest().blasts_tab().click();
                new IOS_BlastTest().blast01().click();
            }

            Thread.sleep(1000);
            throw e;
        }
    }
	
	@Test
    public void test12_openNonPublicBlast() throws Exception {
        try {
            log("- Test12 -");

            if (Android()) {
                new Android_BlastTest().test12_open_non_public_blast();
            } else if (IOS()) {
                new IOS_BlastTest().test12_open_non_public_blast();
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();

            if (Android()) {
                new Android_BlastTest().blasts_tab().click();
                new Android_BlastTest().blast01().click();
            }
            if (IOS()) {
                new IOS_BlastTest().blasts_tab().click();
                new IOS_BlastTest().blast01().click();
            }

            Thread.sleep(1000);
            throw e;
        }
    }
	
	@Test
    public void test13_openPhotoBlast() throws Exception {
        try {
            log("- Test13 -");

            if (Android()) {
                new Android_BlastTest().test13_open_photo_blast();
            } else if (IOS()) {
                new IOS_BlastTest().test13_open_photo_blast();
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();

            if (Android()) {
                new Android_BlastTest().blasts_tab().click();
                new Android_BlastTest().blast01().click();
            }
            if (IOS()) {
                new IOS_BlastTest().blasts_tab().click();
                new IOS_BlastTest().blast01().click();
            }

            Thread.sleep(1000);
            throw e;
        }
    }
	
	@Test
    public void test14_openTextBlast() throws Exception {
        try {
            log("- Test14 -");

            if (Android()) {
                new Android_BlastTest().test14_open_text_blast();
            } else if (IOS()) {
                new IOS_BlastTest().test14_open_text_blast();
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
			log("- Test15 -");

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