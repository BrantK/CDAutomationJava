package com.cyberdust.automation.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class Settings {
	public static Properties appSettings = new Properties();
	private String projectPath = Paths.get("").toAbsolutePath().normalize().toString();
	private String settingsFile = "";
	
	public void storeSettings () {
		
		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			settingsFile = projectPath+"/settings.cfg";
		} else if (System.getProperty("os.name").toLowerCase().contains("win")) {
			settingsFile = projectPath+"\\settings.cfg";
		}
		
		
		try {
			appSettings.store(new FileOutputStream(settingsFile), null);
		} catch (FileNotFoundException e) {
			System.err.println("No settings file found!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadSettings () {
		
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
			appSettings.load(new FileInputStream(settingsFile));
		} catch (FileNotFoundException e) {
			System.err.println("No settings file found!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
