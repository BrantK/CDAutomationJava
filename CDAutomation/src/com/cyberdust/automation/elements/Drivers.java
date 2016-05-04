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

    private static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
    public static AppiumDriver <WebElement> driver;
	public static String appiumServerAddress = "127.0.0.1";
	public static String appiumServerPort = "4723";
	public int screenWidth = driver.manage().window().getSize().getWidth();
	public int screenHeight = driver.manage().window().getSize().getHeight();
    public static boolean ranSetup = false;
    protected static boolean IOSSimulator = false;

    static void initialSetup() throws Exception {
        ranSetup = true;
        IOSSimulator = false;
        resetCapabilities();

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            new VariableCheck().environmentVariable();
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
            if (DeviceReader.runningIOSSimulator) {
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

            if (DeviceReader.runningIOSDevice) {
                capabilities.setCapability("platformName", "IOS");
                capabilities.setCapability("platformVersion", "");
                capabilities.setCapability("deviceName", "iPhone");
                capabilities.setCapability("noReset", true);
                capabilities.setCapability("nativeInstrumentsLib", true);
                capabilities.setCapability("bundleId", "com.mentionmobile.cyberdust");
                capabilities.setCapability("udid", DeviceReader.IOS_UDID);
                driver = new IOSDriver<>(service.getUrl(), capabilities);
            }

            if (DeviceReader.runningAndroidDevice) {
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
	@SuppressWarnings("ResultOfMethodCallIgnored")
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

        if (text.toLowerCase().contains("fail") || text.toLowerCase().contains("exception")
                || text.toLowerCase().contains("warning") || text.toLowerCase().contains("error")) {
            System.err.print(dateTime + testName + text + "\n");
        } else {
            System.out.print(dateTime + testName + text + "\n");
        }
		
		try {
			FileWriter myWriter = new FileWriter(logLocation, true);
            myWriter.append(dateTime);
            myWriter.append(testName);
            myWriter.append(text);
            myWriter.append("\n");
			myWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}