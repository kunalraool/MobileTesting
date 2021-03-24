package appiumFramework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class capabilities {
	
	protected static String appactivity;
	protected static String apppackage;
	protected static String devicename;
	protected static String platform;
	public AppiumDriverLocalService Service;
	

	
	public AppiumDriverLocalService startServer()   {
		boolean flag = checkServerRunning(4723);
		if(!flag) {
		
		
		
		
//		Service = AppiumDriverLocalService.buildDefaultService();
		Service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("c:\\Program Files\\nodejs\\node.exe"))
                .withAppiumJS(new File("C:\\Users\\KunalRaool\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723));
	
		Service.start();
		
	
		
		
		
		}
		return Service;
		
		
	}
	
	//method to check if port is up...if it is up then kill it
	public static boolean checkServerRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serversocket;
		try {
			serversocket = new ServerSocket(port);
			serversocket.close();
		}
		catch(IOException e) {
			isServerRunning = true;
		}
		finally {
			serversocket=null;
		}
		return isServerRunning;
	}
	
	
	public static void StartEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\resources\\emulator.bat");
		Thread.sleep(5000);
		
	}
	public static AndroidDriver<AndroidElement> capability(String appactivity, String apppackage, String devicename, String platform) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		//creating object of property file
		FileReader fis = new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\global.properties");
		Properties property = new Properties();
		property.load(fis);
		
		appactivity = property.getProperty("APP_ACTIVITY");
		apppackage = property.getProperty("APP_PACKAGE");
		devicename = property.getProperty("DEVICE_NAME");
		platform = property.getProperty("PLATFORM_NAME");
		
		if (devicename.contains("Kunal")) {
		StartEmulator();
		}
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, apppackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appactivity);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\KunalRaool\\Downloads\\chromedriver_win32_89\\chromedriver.exe");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		

		return driver;
	
	}

}
