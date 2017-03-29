package com.cyberdust.automation.application;

import java.awt.*;
import java.io.IOException;

/**
 * Created by brant on 1/24/17.
 */
public class AutomationApp {

    private static AutomationUI app;

    public static void main(String[] args) {
        try {
            new Settings().loadSettings();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
