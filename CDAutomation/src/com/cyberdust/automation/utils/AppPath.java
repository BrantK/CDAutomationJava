package com.cyberdust.automation.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppPath {
	
	public static String localAppPath;
	
	public void findApp () throws Exception {
		String output;

		ProcessBuilder processBuilder = new ProcessBuilder("find", System.getenv("HOME"), "-iname", "CyberDust.app");
		Process process = processBuilder.start();
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		while ((output = stdInput.readLine()) != null) {
			if (!output.toLowerCase().contains("trash") && !output.toLowerCase().contains("/library/developer/xcode")
					&& !output.toLowerCase().contains("/library/developer/coresimulator/")) {
				localAppPath = output;
			}
		}
	}
}
