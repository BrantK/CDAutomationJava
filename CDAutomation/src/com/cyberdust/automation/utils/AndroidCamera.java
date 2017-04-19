package com.cyberdust.automation.utils;

import com.cyberdust.automation.elements.AndroidElements;

public class AndroidCamera extends AndroidElements {
	
	public boolean takePhoto() throws Exception {
		// Tries to take a photo with several different kinds of android phones
		boolean photo_taken = false;
//
//        try {
//            setWaitTime(2);
//            if (profile_picture().isDisplayed()) {
//                log("[Warning] Camera failed to open");
//            }
//        } catch (Exception ignored) {}
//
//        Thread.sleep(1000);
//        getAndroidDriver().pressKeyCode(27);
//
//        Thread.sleep(1000);
//        getAndroidDriver().pressKeyCode(25);
//
//        try {
//            driver.findElementById("com.android.camera2:id/photo_video_button").click(); // Takes photo on Nexus phone
//        } catch (Exception ignored) {}
//
//        Thread.sleep(5000);
//
//        try {
//        	driver.findElementById("com.motorola.camera:id/review_approve").click();  // For Moto phones
//        } catch (Exception ignored) {}
//
//        try {
//        	driver.findElementById("com.android.camera:id/select_this").click();  // For older HTC one phones
//        } catch (Exception ignored) {}
//
//        try {
//        	action().press(1660, 530).release().perform();  // For new HTC One phones
//        } catch (Exception ignored) {}
//
//        try {
//        	Thread.sleep(500);
//        	name("OK").click();  // For Galaxy Note 4
//        } catch (Exception ignored) {}
//
//        try {
//        	Thread.sleep(500);
//        	name("Save").click();  // For Galaxy Note 3
//        } catch (Exception ignored) {}
//
//        try {
//        	Thread.sleep(500);
//        	driver.findElementById("com.android.camera2:id/done_button").click();  // For Nexus phones
//        } catch (Exception ignored) {}
//
//        try {
//            setWaitTime(2);
//            profile_picture();
//            photo_taken = true;
//            Thread.sleep(2000);
//        } catch (Exception e){
//            try {
//                setWaitTime(2);
//                OK_button().click();
//                photo_taken = true;
//                Thread.sleep(2000);
//            } catch (Exception f) {
//
//                // If none of the above works, go back to More page
//                log("Could not take a photo");
//                Thread.sleep(1000);
//                getAndroidDriver().pressKeyCode(4);
//
//                try {
//                    profile_picture();
//                } catch (Exception g) {
//                    getAndroidDriver().pressKeyCode(4);
//                }
//
//                try {
//                    profile_picture();
//                } catch (Exception h) {
//                    setWaitTime(15);
//                    relaunch();
//                    more_button().click();
//                }
//            }
//        }
//
        return photo_taken;

	}
}