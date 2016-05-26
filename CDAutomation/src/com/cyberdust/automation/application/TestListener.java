package com.cyberdust.automation.application;

import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TestListener extends RunListener {
	static public String currentTest = "";
	static public String testResult = "";
	static public String failResult = "";
	static public String passResult = "";
	static public String exceptionResult = "";
	
	// Finds test method names
	public static List<String> getTestMethods(List<String> selectedTests) throws Exception {
		String myDir = Paths.get("").toAbsolutePath().normalize().toString();
		DefaultListModel<String> fileList = new DefaultListModel<>();
		DefaultListModel<String> rawList = new FileFinder().testFilePath(myDir, fileList);
		DefaultListModel<String> simpleList = new FileFinder().simpleFileList();
        List<Class> myClassList = new ArrayList<>();
        List<String> methodList = new ArrayList<>();

		for (int i = 0; i < simpleList.size(); i++) {
			if (selectedTests.contains(simpleList.get(i))) {
                myClassList.add(Class.forName((rawList.get(i).substring(rawList.get(i).indexOf("com"), rawList.get(i).length()).replace("\\", ".").replace("/", "."))));
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
	
	public void testStarted (Description description) throws Exception {
		currentTest = description.getMethodName();
	}
	
	@SuppressWarnings("ThrowableResultOfMethodCallIgnored")
    public void testFailure (Failure failure) throws Exception {
		testResult = failure.getDescription().getMethodName();
		failResult = failure.getDescription().getMethodName();
		exceptionResult = failure.getException().toString();
	}
	
	public void testFinished (Description description) throws Exception {
		if (!description.getMethodName().equals(failResult)) {
			passResult = description.getMethodName();
		}
	}
	
	public void testRunFinished (Result result) throws Exception {
		currentTest = "done";
	}
	
	public String runningTest() {
		while (currentTest.length() == 0 || currentTest.equals("done")) {
			System.out.flush();
		}
		return currentTest;
	}
	
	public String failedTests() {
		return failResult;
	}
	
	public String passedTests() {
		return passResult;
	}
}
