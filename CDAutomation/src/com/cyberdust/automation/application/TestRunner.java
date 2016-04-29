package com.cyberdust.automation.application;

import java.lang.reflect.Field;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.RunNotifier;

public class TestRunner {
	
	private static String myDir = Paths.get("").toAbsolutePath().normalize().toString();
	private static DefaultListModel<String> fileList = new DefaultListModel<>();
	private static DefaultListModel<String> rawList = new FileFinder().testFilePath(myDir, fileList);
	private static DefaultListModel<String> simpleList = new FileFinder().simpleFileList();
	public static List<String> completedTests = new ArrayList<>();
	public static JUnitCore junit;
	
	// Finds test classes with "Run" in the name and adds them to the application
	public static void runTests (List<String> selectedTests) throws Exception {
		JUnitCore newJunit = new JUnitCore();

		if (!completedTests.isEmpty()) {
			for (int i = 0; i < simpleList.size(); i++) {
				completedTests.remove(simpleList.get(i));
			}
		}
		
		for (int i = 0; i < simpleList.size(); i++) {
			
			if (selectedTests.contains(simpleList.get(i))) {
				System.out.println("[Test] Starting "+simpleList.get(i));

				Class<?> myClass = Class.forName((rawList.get(i).substring(rawList.get(i).indexOf("com"), rawList.get(i).length()).replace("\\", ".").replace("/", ".")));
				newJunit.addListener(new com.cyberdust.automation.application.TestListener());
				junit = newJunit;
				newJunit.run(myClass);
				completedTests.add(simpleList.get(i));
			}
		}
	}
	
	public void stopTests () {
		try {
			Field field = JUnitCore.class.getDeclaredField("notifier");
			field.setAccessible(true);
			RunNotifier runNotifier = (RunNotifier) field.get(junit);
			runNotifier.pleaseStop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
