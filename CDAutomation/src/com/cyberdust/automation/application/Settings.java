package com.cyberdust.automation.application;

import java.io.*;
import java.nio.file.Paths;
import java.util.Properties;

public class Settings {

	private static Properties appSettings = new Properties();

	private String projectPath = Paths.get("").toAbsolutePath().normalize().toString();
	private String settingsFile = "";
	
	public void storeSettings() throws IOException {
		FileOutputStream fileOutputStream = null;
		
		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			settingsFile = projectPath+"/settings.cfg";
		} else if (System.getProperty("os.name").toLowerCase().contains("win")) {
			settingsFile = projectPath+"\\settings.cfg";
		}
		
		try {
			appSettings.store(fileOutputStream = new FileOutputStream(settingsFile), null);
		} catch (FileNotFoundException e) {
			System.err.println("No settings file found!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOutputStream != null) {
				fileOutputStream.close();
			}
		}
	}
	
	public void loadSettings() throws IOException {
		FileInputStream fileInputStream = null;
		
		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			settingsFile = projectPath+"/settings.cfg";
		} else if (System.getProperty("os.name").toLowerCase().contains("win")) {
			settingsFile = projectPath+"\\settings.cfg";
		}
		
		if (!new File(settingsFile).exists()) {
			try {
				new File(settingsFile).createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			appSettings.load(fileInputStream = new FileInputStream(settingsFile));
		} catch (FileNotFoundException e) {
			System.err.println("No settings file found!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				fileInputStream.close();
			}
		}
	}

	public static Properties getAppSettings() {
	    return appSettings;
    }
}
