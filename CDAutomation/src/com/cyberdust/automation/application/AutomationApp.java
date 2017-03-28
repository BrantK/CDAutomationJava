package com.cyberdust.automation.application;

import java.awt.*;

/**
 * Created by brant on 1/24/17.
 */
public class AutomationApp {

    private static AutomationUI app;

    public static void main(String[] args) {
        new Settings().loadSettings();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                app = new AutomationUI();
                app.initialize();
            }
        });
    }

    public static AutomationUI getApp() {
         return app;
    }
}
