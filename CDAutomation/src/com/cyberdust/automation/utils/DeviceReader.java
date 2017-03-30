package com.cyberdust.automation.utils;

import com.cyberdust.automation.application.AutomationUI;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeviceReader {

    private static boolean runningIOSSimulator;
    private static boolean runningAndroidDevice;
    private static boolean runningIOSDevice;

    private static boolean IOSOverride;
    private static boolean checkingDevice = true;

    private static String connectedDevice;
    private static String IOS_UDID;

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
            connectedDevice = "Android";
        }

		if ((IOSOverride && (connectedIOS || connectedAndroid)) || (!connectedIOS && !connectedAndroid)) {
            runningIOSSimulator = true;
            connectedDevice = "iOS Simulator";
		}

        if (!IOSOverride && connectedIOS && !connectedAndroid) {
            runningIOSDevice = true;
            connectedDevice = "iPhone";
        }

        if (!IOSOverride && connectedAndroid) {
            runningAndroidDevice = true;
            connectedDevice = "Android";
        }
    }

    public static void runDeviceWorker() {
        SwingWorker<Void, Void> deviceWorker = new SwingWorker<Void, Void>() {
            DeviceReader reader = new DeviceReader();

            public Void doInBackground() throws Exception {
                while (checkingDevice) {
                    try {
                        Thread.sleep(1000);
                        reader.checkDevice();
                        AutomationUI.setCurrentDevice(connectedDevice);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };

        deviceWorker.execute();
    }

    public static boolean isRunningIOSSimulator() {
        return runningIOSSimulator;
    }

    public static boolean isRunningAndroidDevice() {
        return runningAndroidDevice;
    }

    public static boolean isRunningIOSDevice() {
        return runningIOSDevice;
    }

    public static boolean isCheckingDevice() {
        return checkingDevice;
    }

    public static String getConnectedDevice() {
        return connectedDevice;
    }

    public static String getIOSUdid() {
        return IOS_UDID;
    }

    public static void setIOSOverride(boolean IOSOverride) {
        DeviceReader.IOSOverride = IOSOverride;
    }
}
