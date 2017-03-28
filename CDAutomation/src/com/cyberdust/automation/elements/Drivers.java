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

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public abstract class Drivers extends TestAccounts {

    private static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
    public static AppiumDriver <WebElement> driver;

    public int screenWidth = driver.manage().window().getSize().getWidth();
    public int screenHeight = driver.manage().window().getSize().getHeight();

    private static String appiumServerAddress = "127.0.0.1";
	private static String appiumServerPort = "4723";

    private static boolean IOSSimulator = false;
    private static boolean iOSSetup = false;
    private static boolean ranSetup = false;

    public static void initialSetup() throws Exception {
        ranSetup = true;
        IOSSimulator = false;
        resetCapabilities();

        if (!iOSSetup && System.getProperty("os.name").toLowerCase().contains("mac")) {
            iOSSetup = true;
            new DeviceReader().checkDevice();
            new AppPath().findApp();
        }

        System.out.println("\n------ Starting Appium Server ------");

        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                        .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                        .withArgument(GeneralServerFlag.LOG_NO_COLORS)
                        .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                        .withIPAddress(appiumServerAddress)
                        .usingPort(Integer.parseInt(appiumServerPort)));

        service.start();

        try {
            if (DeviceReader.isRunningIOSSimulator()) {
                IOSSimulator = true;
                capabilities.setCapability("platformName", "IOS");
                capabilities.setCapability("platformVersion", "");
                capabilities.setCapability("deviceName", "=iPhone 6 (");
                capabilities.setCapability("noReset", true);
                capabilities.setCapability("nativeInstrumentsLib", true);
                capabilities.setCapability("bundleId", "com.mentionmobile.cyberdust");
                capabilities.setCapability("app", AppPath.localAppPath);
                driver = new IOSDriver<>(service.getUrl(), capabilities);
            }

            if (DeviceReader.isRunningIOSDevice()) {
                capabilities.setCapability("platformName", "IOS");
                capabilities.setCapability("platformVersion", "");
                capabilities.setCapability("deviceName", "iPhone");
                capabilities.setCapability("noReset", true);
                capabilities.setCapability("nativeInstrumentsLib", true);
                capabilities.setCapability("bundleId", "com.mentionmobile.cyberdust");
                capabilities.setCapability("udid", DeviceReader.getIosUdid());
                driver = new IOSDriver<>(service.getUrl(), capabilities);
            }

            if (DeviceReader.isRunningAndroidDevice()) {
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "");
                capabilities.setCapability("deviceName", "Android");
                capabilities.setCapability("noReset", true);
                capabilities.setCapability("appPackage", "com.radicalapps.cyberdust");
                capabilities.setCapability("appActivity", "com.radicalapps.cyberdust.activities.LauncherActivity");
                driver = new AndroidDriver<>(service.getUrl(), capabilities);
            }

        } catch (UnreachableBrowserException e) {
            System.out.println("Browser unreachable, restarting server...");
            setUp();
        } catch (SessionNotCreatedException e) {
            appiumServerPort = String.valueOf(Integer.parseInt(appiumServerPort) + 5);
            System.out.println("[Appium] Server already running, trying port "+appiumServerPort+"\n");
            setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@BeforeClass
	public static void setUp() throws Exception {
        if (!ranSetup) {
            initialSetup();
        }
	}

	public static void tearDown() {
        driver.quit();
        service.stop();
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
	
	// For calling the iOS driver from other classes
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
		new Logging(text, getClass().getSimpleName());
	}

    public static boolean isIOSSimulator() {
        return IOSSimulator;
    }

    public static String getAppiumServerAddress() {
        return appiumServerAddress;
    }

    public static String getAppiumServerPort() {
        return appiumServerPort;
    }

    public static AppiumDriver<WebElement> getDriver() {
        return driver;
    }

    public static void setAppiumServerAddress(String appiumServerAddress) {
        Drivers.appiumServerAddress = appiumServerAddress;
    }

    public static void setAppiumServerPort(String appiumServerPort) {
        Drivers.appiumServerPort = appiumServerPort;
    }

    public static void setRanSetup(boolean ranSetup) {
        Drivers.ranSetup = ranSetup;
    }
}