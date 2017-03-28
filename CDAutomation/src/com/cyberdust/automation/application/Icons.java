package com.cyberdust.automation.application;

import javax.swing.*;

/**
 * Created by brant on 1/26/17.
 */
public class Icons {

    private static Icon appiumIcon;
    private static Icon settingsIcon;
    private static Icon appleIcon;
    private static Icon androidIcon;
    private static Icon trashIcon;

    public static void setup() {
        String filePath = ListHelper.getProjectDir();
        String iconLocation = null;

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            if (!filePath.replace("/cdautomation", "/cdautomation/").toLowerCase().contains("/cdautomation/")) {
                iconLocation = filePath + "/CDAutomation/icons/";
            } else {
                iconLocation = filePath + "/icons/";
            }
        }

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            if (!filePath.toLowerCase().contains("\\cdautomation")) {
                iconLocation = filePath + "\\CDAutomation\\icons\\";
            } else {
                iconLocation = filePath + "\\icons\\";
            }
        }

        appiumIcon = new ImageIcon(new ImageIcon(iconLocation+"appium.png")
                .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        settingsIcon = new ImageIcon(new ImageIcon(iconLocation+"settings.png")
                .getImage().getScaledInstance(30,  30, java.awt.Image.SCALE_SMOOTH));
        appleIcon = new ImageIcon(new ImageIcon(iconLocation+"apple.png")
                .getImage().getScaledInstance(30,  30, java.awt.Image.SCALE_SMOOTH));
        androidIcon = new ImageIcon(new ImageIcon(iconLocation+"android.png")
                .getImage().getScaledInstance(30,  30, java.awt.Image.SCALE_SMOOTH));
        trashIcon = new ImageIcon(new ImageIcon(iconLocation+"trash.png")
                .getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
    }

    public static Icon getAppiumIcon() {
        return appiumIcon;
    }

    public static Icon getSettingsIcon() {
        return settingsIcon;
    }

    public static Icon getAppleIcon() {
        return appleIcon;
    }

    public static Icon getAndroidIcon() {
        return androidIcon;
    }

    public static Icon getTrashIcon() {
        return trashIcon;
    }
}
