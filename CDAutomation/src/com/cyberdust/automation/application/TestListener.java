package com.cyberdust.automation.application;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TestListener extends RunListener {
	private static String currentTest;
	private static String failedTest;
	private static String passedTest;
	private static String thrownException;

	@Override
	public void testStarted (Description description) throws Exception {
		currentTest = description.getMethodName();
	}
	
	@Override
    public void testFailure (Failure failure) throws Exception {
		failedTest = failure.getDescription().getMethodName();
		thrownException = failure.getException().toString();
	}

	@Override
	public void testFinished (Description description) throws Exception {
		if (!description.getMethodName().equals(failedTest)) {
			passedTest = description.getMethodName();
		}
	}

	@Override
	public void testRunFinished (Result result) throws Exception {
		currentTest = null;
	}
	
	public static String getCurrentTestWithDelay() {
		while (currentTest == null) {
			try {
			    Thread.sleep(1000);
            } catch (Exception ignored) {}
		}
		return currentTest;
	}

	public static String getCurrentTest() {
	    return currentTest;
    }
	
	public static String getFailedTests() {
		return failedTest;
	}
	
	public static String getPassedTests() {
		return passedTest;
	}

	public static String getException() {
	    return thrownException;
    }

    public static void nullCurrentTest() {
	    currentTest = null;
    }
}
