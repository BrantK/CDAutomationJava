package com.cyberdust.automation.application;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;

public class FileFinder {
    private static String projectDir = ListHelper.PROJECT_DIR;
    private static DefaultListModel<String> files = new DefaultListModel<>();

	// For custom test list order, add tests here from top to bottom
	private static List<String> customOrder () {
		List<String> list = new ArrayList<>();
		
		//////////////////////////////
		list.add("run_signup");
		list.add("run_blasttest");
		//////////////////////////////

		return list;
	}

	// Gets the absolute file path
	public static DefaultListModel<String> getFilePath () {
		DefaultListModel<String> filePathList = new DefaultListModel<>();
	    File dir = new File(projectDir);

	    // Get all files from directory and sub directories
	    File[] fList = dir.listFiles();
		assert fList != null;

		for (File file : fList) {

	        if (file.isFile() && file.getAbsolutePath().toLowerCase().contains("run_")
                    && file.getAbsolutePath().toLowerCase().contains("src")
                    && !file.getAbsolutePath().toLowerCase().contains("out/production/")
                    && !file.getAbsolutePath().toLowerCase().contains("out\\production\\")) {

	            files.addElement(file.getAbsolutePath().replace(".java", ""));

	        } else if (file.isDirectory()) {
	            projectDir = file.getAbsolutePath();
	            getFilePath();
	        }
	    }
	    for (int i = 0; i < files.size(); i++) {
    		if (!filePathList.contains(files.elementAt(i))) {
    			filePathList.add(i, files.getElementAt(i));
	    	}
	    }
	    
	    // Puts the specified tests from testOrder() at the top of the list
	    List<String> sortedList = new ArrayList<>();
	    for (int i = 0; i < filePathList.size(); i++) {
	    	sortedList.add(filePathList.get(i));
	    }

	    filePathList.removeAllElements();

	    for (String list : sortedList) {

	    	for (int i = 0; i < customOrder().size(); i++) {
	    		if (list.toLowerCase().contains(customOrder().get(i))) {
		    		filePathList.add(0, list);
	    		}
	    	}
	    	
	    	if (!filePathList.contains(list)) {
	    		filePathList.addElement(list);
	    	}
	    }

		return filePathList;
	}

    // Finds @test method names
    public static List<String> getTestMethods(List<String> selectedTests) throws Exception {
        DefaultListModel<String> testList = ListHelper.getAbsoluteTestList();
        DefaultListModel<String> simpleTestList = ListHelper.getSimpleTestList();
        List<Class> myClassList = new ArrayList<>();
        List<String> methodList = new ArrayList<>();

        for (int i = 0; i < simpleTestList.size(); i++) {
            if (selectedTests.contains(simpleTestList.get(i))) {
                myClassList.add(Class.forName((testList.get(i).substring(testList.get(i).indexOf("com"), testList.get(i).length()).replace("\\", ".").replace("/", "."))));
            }
        }

        try {
            for (int i = 0; i < selectedTests.size(); i++) {
                Method[] classMethods = myClassList.get(i).getDeclaredMethods();

                for (Method classM : classMethods) {
                    String classMLower = classM.getName().toLowerCase();

                    if (classMLower.contains("test0") || classMLower.contains("test1") || classMLower.contains("test2")) {
                        String className = classM.getDeclaringClass().getSimpleName().replace("Run", "").replace("_", "");
                        String classMethodName = classM.getName();

                        if (!methodList.contains(className)) {
                            methodList.add(className);
                        }

                        methodList.add(classMethodName);
                        Collections.sort(methodList.subList(methodList.indexOf(className), methodList.size()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return methodList;
    }
}
