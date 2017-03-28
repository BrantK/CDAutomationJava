package com.cyberdust.automation.application;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;

/**
 * Created by brant on 3/27/17.
 */
public class CellRenderer extends DefaultListCellRenderer {

    private AutomationUI app = AutomationApp.getApp();

    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        String filePath = Paths.get("").toAbsolutePath().normalize().toString();
        String iconLocation = "";

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

        Icon runningIcon = new ImageIcon(iconLocation+"running.gif");
        Icon tSuiteIcon = new ImageIcon(iconLocation+"tsuite.gif");
        Icon testIcon = new ImageIcon(iconLocation+"test.gif");
        Icon passIcon = new ImageIcon(iconLocation+"pass.gif");
        Icon failIcon = new ImageIcon(iconLocation+"fail.gif");

        if (ListHelper.getSimpleTestList().contains(value)) {
            setIcon(tSuiteIcon);
            setFont(new Font("Arial", Font.BOLD, 11));

            if (!(app.getTestMethodsList().indexOf(value) == 0)) {
                setBorder(BorderFactory.createEmptyBorder(12, 0, 0, 0));
            }
        }

        if (value.toString().contains("test")) {
            setBorder(BorderFactory.createEmptyBorder(2,12,0,0));
            setIcon(testIcon);
        }

        if (value.toString().equals(TestListener.getCurrentTest())) {
            setIcon(runningIcon);
        }

        if (app.getFailedTests().contains(value)) {
            setIcon(failIcon);
        }

        if (app.getPassedTests().contains(value)) {
            setIcon(passIcon);
        }

        return label;
    }
}
