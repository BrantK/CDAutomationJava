package com.cyberdust.automation.tools;

import com.cyberdust.automation.elements.IOSElements;
import org.junit.*;

public class IOSAutoBlast extends IOSElements {
	String blast_recipient = "bktest02";
	String blast_type = "text, photo";  // Use photo, video, text, or a combination of the 3
	String blast_text = "Test";  // Only works for text blasts
	int number_of_blasts = 50;  // Number of blasts per type
	
    public void photo_blast() throws Exception {
        Thread.sleep(500);
        action_menu().click();
        Thread.sleep(500);
        action_menu_media().click();
        photo_gallery().click();
        camera_roll().click();
        camera_roll_photo1().click();
        next_button().click();
        blast_friends().click();
        username(blast_recipient).click();
        blast_Ok_button().perform();
    }
    public void video_blast() throws Exception {
        action_menu().click();
        action_menu_media().click();
        video_button().click();
        action().longPress(photo_button(), 5000).release().perform();
        next_button().click();
        blast_friends().click();
        username(blast_recipient).click();
        blast_Ok_button().perform();
    }
    public void text_blast() throws Exception {
        action_menu().click();
        action_menu_text().click();
        driver.getKeyboard().sendKeys(blast_text);
        next_button().click();
        blast_friends().click();
        username(blast_recipient).click();
        blast_Ok_button().perform();
    }

    @Test
    public void autoblast() throws Exception {
    	for (int i = 0; i < number_of_blasts;) {
    		
    		if (blast_type.toLowerCase().contains("text".toLowerCase())) {
    			text_blast();
    			System.out.println("Sending blast: #" + (i+1));
                i+=1;
    		}
    		if (blast_type.toLowerCase().contains("photo".toLowerCase())) {
    			photo_blast();
    			System.out.println("Sending blast: #" + (i+1));
                i+=1;
    	    }
    		if (blast_type.toLowerCase().contains("video".toLowerCase())) {
    			video_blast();
    			System.out.println("Sending blast: #" + (i+1));
                i+=1;
    	    }
        }
    }
}
