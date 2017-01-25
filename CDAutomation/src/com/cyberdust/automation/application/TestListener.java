package com.cyberdust.automation.application;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TestListener extends RunListener {
	public static String currentTest;
	public String testResult;
	public String failResult;
	public String passResult;
	public static String exceptionResult;

	@Override
	public void testStarted (Description description) throws Exception {
		currentTest = description.getMethodName();
	}
	
	@Override
    public void testFailure (Failure failure) throws Exception {
		testResult = failure.getDescription().getMethodName();
		failResult = failure.getDescription().getMethodName();
		exceptionResult = failure.getException().toString();
	}

	@Override
	public void testFinished (Description description) throws Exception {
		if (!description.getMethodName().equals(failResult)) {
			passResult = description.getMethodName();
		}
	}

	@Override
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
