package com.cyberdust.automation.elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeviceReader {

    public static boolean runningIOSSimulator;
    public static boolean runningAndroidDevice;
    public static boolean runningIOSDevice;
    public static boolean IOSOverride;
    public static String connectedDevice;
    public static String IOS_UDID;
	
	public void checkDevice () throws Exception {
        boolean connectedIOS = false;
        boolean connectedAndroid = false;
		String output;

        runningIOSSimulator = false;
        runningAndroidDevice = false;
        runningIOSDevice = false;

		ProcessBuilder processBuilder = new ProcessBuilder("system_profiler", "SPUSBDataType");
		Process process = processBuilder.start();
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		while ((output = stdInput.readLine()) != null) {
			
			if (output.toLowerCase().contains("serial") && output.length() > 45) {
				IOS_UDID = output.replace("          Serial Number: ", "");
			}
			
			if (output.toLowerCase().contains("iphone")) {
				connectedIOS = true;
			}
			
			if (output.toLowerCase().contains("android")) {
				connectedAndroid = true;
			}
		}
		
		processBuilder = new ProcessBuilder(System.getenv("ANDROID_HOME")+"/platform-tools/adb", "devices");
		process = processBuilder.start();
		stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		if (!connectedIOS && !connectedAndroid) {
			while ((output = stdInput.readLine()) != null) {
				if (!output.contains("List of devices attached") && !output.isEmpty()) {
					connectedAndroid = true;
					connectedIOS = false;
				}
			}
		}

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            runningAndroidDevice = true;
        }

		if ((IOSOverride && (connectedIOS || connectedAndroid)) || (!connectedIOS && !connectedAndroid)) {
            runningIOSSimulator = true;
            connectedDevice = "iOS simulator";

            if (IOSOverride) {
                System.out.println("Using iOS simulator");
            } else {
                System.out.println("No devices detected, using iOS simulator");
            }
		}

        if (!IOSOverride && connectedIOS && !connectedAndroid) {
            runningIOSDevice = true;
            connectedDevice = "iOS device";
            System.out.println("Using connected iOS device");
        }

        if (!IOSOverride && connectedAndroid) {
            runningAndroidDevice = true;
            connectedDevice = "Android device";
            System.out.println("Using connected Android device");
        }
    }
}
