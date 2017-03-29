package com.cyberdust.automation.elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.junit.BeforeClass;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.io.File;
import java.io.IOException;

public class Drivers extends DriverActions {

    private static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static AppiumDriver <WebElement> driver;

    private static String appiumServerAddress = "127.0.0.1";
    private static String appiumServerPort = "4723";

    private boolean IOSSimulator;
    private boolean IOSSetup = false;
    private static boolean ranSetup = false;

    @BeforeClass
    public void setUp() throws Exception {
        System.out.println("SETUP");
        if (!ranSetup) {
            initialSetup();
        }
    }

    public void initialSetup() throws Exception {
        IOSSimulator = false;

        System.out.println("INITIAL_SETUP");

        setRanSetup(true);
        resetCapabilities();

        if (!IOSSetup && System.getProperty("os.name").toLowerCase().contains("mac")) {
            IOSSetup = true;
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
                capabilities.setCapability("udid", DeviceReader.getIOSUdid());
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
            appiumServerPort = String.valueOf(Integer.parseInt(appiumServerPort) + 1);
            System.out.println("[Appium] Server already running, trying port "+appiumServerPort+"\n");
            setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static void tearDown() {
        driver.quit();
        service.stop();
	}

	private void resetCapabilities() {
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

	public boolean isAndroid() {
		return capabilities.getCapability("platformName").equals("Android");
	}

	public boolean isIOS() {
		return capabilities.getCapability("platformName").equals("IOS");
	}

	public AndroidDriver<WebElement> getAndroidDriver() {
		return (AndroidDriver<WebElement>) driver;
	}

	public IOSDriver<WebElement> getIOSDriver() {
		return (IOSDriver<WebElement>) driver;
	}

    public void swipe(int startX, int startY, int endX, int endY, int duration) {
        action().press(startX, startY).waitAction(duration).moveTo(endX, endY).release();
        action().perform();
    }

	public void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	// Prints text to console and to a log file in the project folder / test logs folder
    public void log(String text) {
        try {
            new Logging(text, getClass().getSimpleName());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

    // GETTERS and SETTERS //
    public boolean isIOSSimulator() {
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