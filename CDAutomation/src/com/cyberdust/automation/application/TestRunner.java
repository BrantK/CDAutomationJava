package com.cyberdust.automation.application;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.RunNotifier;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    private static List<String> completedTests = new ArrayList<>();

	private static DefaultListModel<String> testList = ListHelper.getAbsoluteTestList();
	private static DefaultListModel<String> simpleTestList = ListHelper.getSimpleTestList();
	private static JUnitCore junit;
	
	// Finds test classes with "Run" in the name and adds them to the application
	public static void runTests (List<String> selectedTests) throws Exception {
		junit = new JUnitCore();

		if (!completedTests.isEmpty()) {
			for (int i = 0; i < simpleTestList.size(); i++) {
				completedTests.remove(simpleTestList.get(i));
			}
		}
		
		for (int i = 0; i < simpleTestList.size(); i++) {
			
			if (selectedTests.contains(simpleTestList.get(i))) {
				System.out.println("[Test] Starting "+ simpleTestList.get(i));

				try {
					Class<?> myClass = Class.forName((testList.get(i).substring(testList.get(i).indexOf("com"), testList.get(i).length()).replace("\\", ".").replace("/", ".")));
					System.out.println(myClass.toString());
					junit.addListener(new com.cyberdust.automation.application.TestListener());
					junit.run(myClass);
					completedTests.add(simpleTestList.get(i));
				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println(simpleTestList.get(i));
			}
		}
	}
	
	public static void stopTests() {
		try {
			Field field = JUnitCore.class.getDeclaredField("notifier");
			field.setAccessible(true);
			RunNotifier runNotifier = (RunNotifier) field.get(junit);
			runNotifier.pleaseStop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<String> getCompletedTests() {
	    return completedTests;
    }
}
