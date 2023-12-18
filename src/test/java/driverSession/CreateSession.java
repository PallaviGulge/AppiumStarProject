package driverSession;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class CreateSession {
	
	//it will return us original driver so this will your fix code no need to create session again and again
	public static AppiumDriver initilizeDriver() throws MalformedURLException
	{
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability("platformName", "Android");
	cap.setCapability("appium:automationName", "UiAutomator2");
	cap.setCapability("appium:deviceName", "pixel_7");
	cap.setCapability("appium:udid", "emulator-5556");
	
	//app
	String appPath=System.getProperty("user.dir")+"\\src\\test\\resources\\ApiDemos-debug.apk";
	
	cap.setCapability("appium:app", appPath);
	
	//server connectivity
	URL url=new URL("http://0.0.0.0:4723");
	
	//create appium session for connection
	AppiumDriver driver=new AndroidDriver(url,cap);
	
	System.out.println("Session id :"+driver.getSessionId());
	return driver;
	
	
	}

}
