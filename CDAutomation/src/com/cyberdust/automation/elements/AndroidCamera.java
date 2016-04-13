package com.cyberdust.automation.elements;

public class AndroidCamera extends AndroidElements {
	
	public boolean takePhoto() throws Exception {
		// Tries to take a photo with several different kinds of android phones

        boolean photo_taken = false;

            Thread.sleep(1000);
            aDriver().pressKeyCode(25);
            Thread.sleep(1000);
            aDriver().pressKeyCode(27);
            Thread.sleep(5000);

            try {
                driver.findElementById("com.motorola.camera:id/review_approve").click();  // For Moto phones
            } catch (Exception ignored) {

            }
            try {
                driver.findElementById("com.android.camera:id/select_this").click();  // For older HTC one phones
            } catch (Exception ignored) {

            }
            try {
                action.press(1660, 530).release().perform();  // For new HTC One phones
            } catch (Exception ignored) {

            }
            try {
                Thread.sleep(1000);
                driver.findElementByName("OK").click();  // For Galaxy Note 4
            } catch (Exception ignored) {

            }
            try {
                Thread.sleep(1000);
                driver.findElementByName("Save").click();  // For Galaxy Note 3

            } catch (Exception ignored) {

            }
            try {
                Thread.sleep(1000);
                driver.findElementById("com.android.camera2:id/done_butto").click();  // For Nexus phones
            } catch (Exception ignored) {

            }
            try {
                profile_picture_done().click(); Thread.sleep(3000);
                photo_taken = true;
            } catch (Exception e) {
                log("Could not take a photo, going back.");
                for (int i = 0; i < 2; i++) {
                    aDriver().pressKeyCode(4); Thread.sleep(3000);  // If none of the above works, go back
                    try {
                        skip_button().click();
                    } catch (Exception ignored) {

                    }
                }
            }

        return photo_taken;
    }



}
