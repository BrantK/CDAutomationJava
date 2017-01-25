package com.cyberdust.automation.application;

import java.awt.Desktop;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.DefaultListModel;

public class LogFinder {
	private DefaultListModel<String> testList = ListHelper.getAbsoluteTestList();
	
	public void openLog(List<String> selectedTests) throws Exception {
		String projectPath = ListHelper.PROJECT_DIR;
		String logLocation = "";
		String testName;
		String logName;
		
		for (int i = 0; i < testList.size(); i++) {
			testName = testList.get(i).substring(testList.get(i).indexOf("Run"), testList.get(i).length()).replace("Run_", "").replace("Run", "");
			
			if (selectedTests.contains(testName)) {
				logName = testList.get(i).substring(testList.get(i).indexOf("tests"), testList.get(i).indexOf("Run")-1).replace("/", ".").replace("\\", ".");
				
				if (projectPath.contains("/")) {
					logLocation = projectPath+"/testlogs/"+logName+".log";
				} else {
					logLocation = projectPath+"\\testlogs\\"+logName+".log";
				}
			}
		}
		
		try {
			Desktop.getDesktop().open(new File(logLocation));
		} catch (Exception ignored) {
			
		}
	}
	
	@SuppressWarnings("ResultOfMethodCallIgnored")
	public void clearLog(List<String> selectedTests) throws Exception {
		String projectPath = Paths.get("").toAbsolutePath().normalize().toString();
		String logLocation = "";
		String testName;
		String logName;
		
		for (int i = 0; i < testList.size(); i++) {
			testName = testList.get(i).substring(testList.get(i).indexOf("Run"), testList.get(i).length()).replace("Run_", "").replace("Run", "");
			
			if (selectedTests.contains(testName)) {
				logName = testList.get(i).substring(testList.get(i).indexOf("tests"), testList.get(i).indexOf("Run")-1).replace("/", ".").replace("\\", ".");
				
				if (projectPath.contains("/")) {
					logLocation = projectPath+"/testlogs/"+logName+".log";
				} else {
					logLocation = projectPath+"\\testlogs\\"+logName+".log";
				}
			}
		}

		File logFile = new File(logLocation);

		logFile.delete();
		logFile.createNewFile();
	}	
}
