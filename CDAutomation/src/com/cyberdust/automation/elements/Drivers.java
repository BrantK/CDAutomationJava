package com.cyberdust.automation.elements;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.*;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public abstract class Drivers extends TestAccounts {
	
	public static AppiumDriver <WebElement> driver;
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static String appiumServerAddress = "127.0.0.1";
	public static String appiumServerPort = "4723";
	
	public WebDriverWait wait = new WebDriverWait(driver, 20);
	public int screenWidth = driver.manage().window().getSize().getWidth();
	public int screenHeight = driver.manage().window().getSize().getHeight();
    protected static boolean IOSSimulator = false;
	public static boolean IOSEnabled = false;
	
	@BeforeClass
	public static void setUp() throws Exception {
		DeviceReader.AndroidDevice = false;
		DeviceReader.IOSDevice = false;
        IOSSimulator = false;
		resetCapabilities();
		
		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			new VariableCheck().environmentVariable();
			new DeviceReader().checkDevice();
			new AppPath().findApp();
		}
		
		if (System.getProperty("os.name").toLowerCase().contains("win")) {
			DeviceReader.AndroidDevice = true;
		}

        try {
            AppiumDriverLocalService service = AppiumDriverLocalService
                    .buildService(new AppiumServiceBuilder()
                            .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                            .withArgument(GeneralServerFlag.LOG_NO_COLORS)
							.withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                            .withIPAddress(appiumServerAddress)
                            .usingPort(Integer.parseInt(appiumServerPort)));

            if ((IOSEnabled && (DeviceReader.IOSDevice || DeviceReader.AndroidDevice)) || (!DeviceReader.IOSDevice && !DeviceReader.AndroidDevice)) {
                if (IOSEnabled) {
                    System.out.println("Using iOS simulator");
                } else {
                    System.out.println("No devices detected, using iOS simulator");
                }

                IOSSimulator = true;
                capabilities.setCapability("platformName", "IOS");
                capabilities.setCapability("platformVersion", "");
                capabilities.setCapability("deviceName", "=iPhone 6 (");
                capabilities.setCapability("noReset", true);
                capabilities.setCapability("nativeInstrumentsLib", true);
                capabilities.setCapability("bundleId", "com.mentionmobile.cyberdust");
                capabilities.setCapability("app", AppPath.localAppPath);
                System.out.println("\n------ Starting Appium Server ------");
                driver = new IOSDriver<>(service, capabilities);
            }

            if (!IOSEnabled && DeviceReader.IOSDevice && !DeviceReader.AndroidDevice) {
                System.out.println("iOS device detected");
                capabilities.setCapability("platformName", "IOS");
                capabilities.setCapability("platformVersion", "");
                capabilities.setCapability("deviceName", "iPhone");
                capabilities.setCapability("noReset", true);
                capabilities.setCapability("nativeInstrumentsLib", true);
                capabilities.setCapability("bundleId", "com.mentionmobile.cyberdust");
                capabilities.setCapability("udid", DeviceReader.IOS_UDID);
                System.out.println("\n------ Starting Appium Server ------");
                driver = new IOSDriver<>(service, capabilities);
            }

            if (!IOSEnabled && DeviceReader.AndroidDevice) {
                System.out.println("Android device detected");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "");
                capabilities.setCapability("deviceName", "Android");
                capabilities.setCapability("noReset", true);
                capabilities.setCapability("appPackage", "com.radicalapps.cyberdust");
                capabilities.setCapability("appActivity", "com.radicalapps.cyberdust.activities.LauncherActivity");
                System.out.println("\n------ Starting Appium Server ------");
                driver = new AndroidDriver<>(service, capabilities);
            }

        } catch (UnreachableBrowserException e) {
            System.out.println("Browser unreachable, restarting server...");
            setUp();
        } catch (SessionNotCreatedException e) {
            System.out.println("Appium server already running, trying a different port...\n");
            appiumServerPort += 5;
            setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
	// Resets capabilities to default
	private static void resetCapabilities() {
		capabilities.setCapability("platformName", "");
		capabilities.setCapability("platformVersion","");
		capabilities.setCapability("deviceName","");
		capabilities.setCapability("bundleId","");
		capabilities.setCapability("udid","");
		capabilities.setCapability("app","");
        if (capabilities.getCapability("appPackage") != null) {
            capabilities.setCapability("appPackage", "");
            capabilities.setCapability("appActivity", "");
        }
	}
	
	// Checks if device is Android
	public boolean Android() {
		return capabilities.getCapability("platformName").equals("Android");
	}
	
	// Checks if device is iOS
	public boolean IOS() {
		return capabilities.getCapability("platformName").equals("IOS");
	}
	
	// For calling the Android driver from other classes
	public static AndroidDriver<WebElement> aDriver() {
		return (AndroidDriver<WebElement>) driver;
	}
	
	// For calling the iOS driver from other class
	public static IOSDriver<WebElement> iDriver() {
		return (IOSDriver<WebElement>) driver;
	}

    // For using TouchAction
    public static TouchAction action () {
        return new TouchAction(driver);
    }

	// Relaunches the app
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	// Prints text to console and to a log file in the project folder / test logs folder
	public void log(String text) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
		String projectPath = Paths.get("").toAbsolutePath().normalize().toString();
		String logLocation;
		
		String dateTime = LocalDateTime.now().format(formatter)+" ";
		String logName = getClass().getPackage().toString().substring(33, getClass().getPackage().toString().length());
		String testName = ("["+getClass().getSimpleName()+"]: ").replace("Run_", "").replace("Run", "").replace("Android_", "").replace("IOS_", "");
		
		if (projectPath.contains("/")) {
			new File(projectPath+"/testlogs/").mkdir();
			logLocation = projectPath+"/testlogs/"+logName+".log";
		} else {
			new File(projectPath+"\\testlogs\\").mkdir();
			logLocation = projectPath+"\\testlogs\\"+logName+".log";
		}

		if (text.contains("org.openqa.selenium.remote.SessionNotFoundException")) {
			System.err.print("Test Stopped" + "\n");	
		} 
		
		if (!text.contains("org.openqa.selenium.remote.SessionNotFoundException")) {
			if (text.toLowerCase().contains("fail") || text.toLowerCase().contains("exception") 
					|| text.toLowerCase().contains("warning") || text.toLowerCase().contains("error")) {
				System.err.print(dateTime + testName + text + "\n");
			
			} else {
				System.out.print(dateTime + testName + text + "\n");
			}
		}
		
		try {
			FileWriter myWriter = new FileWriter(logLocation, true);
			
			if (!text.contains("org.openqa.selenium.remote.SessionNotFoundException")) {
				myWriter.append(dateTime + testName + text + "\n");
			}
			
			myWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}