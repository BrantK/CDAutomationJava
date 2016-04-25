package com.cyberdust.automation.tests.reblast;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_ReblastTest extends Drivers {

    @Test
    public void test01_sendVideoNoLoc() throws Exception {
        log("[Start] Starting reblast test");
        try {
            log("Test01 sending video blasts without location");

            if (Android()) {
                new Android_ReblastTest().test01_send_video_no_loc();
            } else if (IOS()) {
                new IOS_ReblastTest().test01_send_video_no_loc();
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();
            throw e;
        }
    }

    @Test
    public void test02_sendVideoWithLoc() throws Exception {
        try {
            log("Test02 sending video blasts with location");

            if (Android()) {
                new Android_ReblastTest().test02_send_video_with_loc();
            } else if (IOS()) {
                new IOS_ReblastTest().test02_send_video_with_loc();
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();
            throw e;
        }
    }

    @Test
    public void test03_sendGiphyNoLoc() throws Exception {
        try {
            log("Test03 sending giphy blasts without location");

            if (Android()) {
                new Android_ReblastTest().test03_send_giphy_no_loc();
            } else if (IOS()) {
                new IOS_ReblastTest().test03_send_giphy_no_loc();
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();
            throw e;
        }
    }

    @Test
    public void test04_sendGiphyWithLoc() throws Exception {
        try {
            log("Test04 sending giphy blasts with location");

            if (Android()) {
                new Android_ReblastTest().test04_send_giphy_with_loc();
            } else if (IOS()) {
               new IOS_ReblastTest().test04_send_giphy_with_loc();
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();
            throw e;
        }
    }

	@Test
	public void test05_sendPhotoNoLoc() throws Exception {
		try {
			log("Test05 sending photo blasts without location");
			
			if (Android()) {
				new Android_ReblastTest().test05_send_photo_no_loc();
			} else if (IOS()) {
				new IOS_ReblastTest().test05_send_photo_no_loc();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}

    @Test
    public void test06_sendPhotoWithLoc() throws Exception {
        try {
            log("Test06 sending photo blasts with location");

            if (Android()) {
                new Android_ReblastTest().test06_send_photo_with_loc();
            } else if (IOS()) {
               new IOS_ReblastTest().test06_send_photo_with_loc();
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();
            throw e;
        }
    }

    @Test
    public void test07_sendTextNoLoc() throws Exception {
        try {
            log("Test07 sending text blasts without location");

            if (Android()) {
                new Android_ReblastTest().test07_send_text_no_loc();
            } else if (IOS()) {
                new IOS_ReblastTest().test07_send_text_no_loc();
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();
            throw e;
        }
    }

    @Test
    public void test08_sendTextWithLoc() throws Exception {
        try {
            log("Test08 sending text blasts with location");
            if (Android()) {
                new Android_ReblastTest().test08_send_text_with_loc();
            } else if (IOS()) {
                new IOS_ReblastTest().test08_send_text_with_loc();
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();
            throw e;
        }
    }
	
	@Test
	public void test09_reblastSetup() throws Exception {
		try {
			log("Test09 setting up for reblast test");
			
			if (Android()) {
				new Android_ReblastTest().test09_reblast_setup();
			} else if (IOS()) {
				new IOS_ReblastTest().test09_reblast_setup();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

			if (Android()) {
				new Android_ReblastTest().blasts_tab().click();
			}
			if (IOS()) {
				new IOS_ReblastTest().blasts_tab().click();
			}

			throw e;
		}
	}
	
	@Test
	public void test10_reblastTextWithLoc() throws Exception {
		try {
			log("Test10 reblasting text blasts with location");
			
			if (Android()) {
				new Android_ReblastTest().test10_reblast_text_with_loc();
			} else if (IOS()) {
				new IOS_ReblastTest().test10_reblast_text_with_loc();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

			if (Android()) {
				new Android_ReblastTest().blasts_tab().click();
			}
			if (IOS()) {
				new IOS_ReblastTest().blasts_tab().click();
			}

			throw e;
		}
	}
	
	@Test
	public void test11_reblastTextNoLoc() throws Exception {
		try {
			log("Test11 reblasting text blasts without location");
			
			if (Android()) {
				new Android_ReblastTest().test11_reblast_text_no_loc();
			} else if (IOS()) {
				new IOS_ReblastTest().test11_reblast_text_no_loc();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

			if (Android()) {
				new Android_ReblastTest().blasts_tab().click();
			}
			if (IOS()) {
				new IOS_ReblastTest().blasts_tab().click();
			}

			throw e;
		}
	}
	
	@Test
	public void test12_reblastPhotoWithLoc() throws Exception {
		try {
			log("Test12 reblasting photo blasts with location");
			
			if (Android()) {
				new Android_ReblastTest().test12_reblast_photo_with_loc();
			} else if (IOS()) {
				new IOS_ReblastTest().test12_reblast_photo_with_loc();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

			if (Android()) {
				new Android_ReblastTest().blasts_tab().click();
			}
			if (IOS()) {
				new IOS_ReblastTest().blasts_tab().click();
			}

			throw e;
		}
	}
	
	@Test
	public void test13_reblastPhotoNoLoc() throws Exception {
		try {
			log("Test13 reblasting photo blasts without location");
			
			if (Android()) {
				new Android_ReblastTest().test13_reblast_photo_no_loc();
			} else if (IOS()) {
				new IOS_ReblastTest().test13_reblast_photo_no_loc();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

			if (Android()) {
				new Android_ReblastTest().blasts_tab().click();
			}
			if (IOS()) {
				new IOS_ReblastTest().blasts_tab().click();
			}

			throw e;
		}
	}
	
	@Test
	public void test14_reblastGiphyWithLoc() throws Exception {
		try {
			log("Test14 reblasting giphy blasts with location");
			
			if (Android()) {
				new Android_ReblastTest().test14_reblast_giphy_with_loc();
			} else if (IOS()) {
				new IOS_ReblastTest().test14_reblast_giphy_with_loc();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

			if (Android()) {
				new Android_ReblastTest().blasts_tab().click();
			}
			if (IOS()) {
				new IOS_ReblastTest().blasts_tab().click();
			}

			throw e;
		}
	}
	
	@Test
	public void test15_reblastGiphyNoLoc() throws Exception {
		try {
			log("Test15 reblasting giphy blasts without location");
			
			if (Android()) {
				new Android_ReblastTest().test15_reblast_giphy_no_loc();
			} else if (IOS()) {
				new IOS_ReblastTest().test15_reblast_giphy_no_loc();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

			if (Android()) {
				new Android_ReblastTest().blasts_tab().click();
			}
			if (IOS()) {
				new IOS_ReblastTest().blasts_tab().click();
			}

			throw e;
		}
	}
	
	@Test
	public void test16_reblastVideoWithLoc() throws Exception {
		try {
			log("Test16 reblasting video blasts with location");
			
			if (Android()) {
				new Android_ReblastTest().test16_reblast_video_with_loc();
			} else if (IOS()) {
				new IOS_ReblastTest().test16_reblast_video_with_loc();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

			if (Android()) {
				new Android_ReblastTest().blasts_tab().click();
			}
			if (IOS()) {
				new IOS_ReblastTest().blasts_tab().click();
			}

			throw e;
		}
	}
	
	@Test
	public void test17_reblastVideoNoLoc() throws Exception {
		try {
			log("Test17 reblasting video blasts without location");
			
			if (Android()) {
				new Android_ReblastTest().test17_reblast_video_no_loc();
			} else if (IOS()) {
				new IOS_ReblastTest().test17_reblast_video_no_loc();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();

			if (Android()) {
				new Android_ReblastTest().blasts_tab().click();
			}
			if (IOS()) {
				new IOS_ReblastTest().blasts_tab().click();
			}

			throw e;
		}
	}
	
	@Test
	public void test18_checkReblastCount() throws Exception {
        try {
			log("Test18 checking if all reblasts were received");
			
			if (Android()) {
				new Android_ReblastTest().test18_check_reblast_count();
			} else if (IOS()) {
				new IOS_ReblastTest().test18_check_reblast_count();
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