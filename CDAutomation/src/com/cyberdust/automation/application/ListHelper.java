package com.cyberdust.automation.application;

import javax.swing.*;
import java.nio.file.Paths;

/**
 * Created by brant on 1/24/17.
 */
public class ListHelper {

    private static String projectDir = Paths.get("").toAbsolutePath().normalize().toString();
    private static DefaultListModel<String> absoluteTestPath = FileFinder.getFilePath();

    // Returns full file path
    public static DefaultListModel<String> getAbsoluteTestList() {
        return absoluteTestPath;
    }

    // Returns just the test name
    public static DefaultListModel<String> getSimpleTestList() {
        DefaultListModel<String> s = new DefaultListModel<>();

        for (int i = 0; i < absoluteTestPath.size(); i++) {
            s.addElement(absoluteTestPath.get(i).substring(absoluteTestPath.get(i).indexOf("Run"), absoluteTestPath.get(i).length()).replace("Run_", "").replace("Run", ""));
        }

        return s;
    }

    public static String getProjectDir() {
        return projectDir;
    }
}
