package mobileGuestures;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Assignment4 {

	public static void main(String[] arg) throws MalformedURLException
	{
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability("platformName", "Android");
	cap.setCapability("appium:automationName", "UiAutomator2");
	cap.setCapability("appium:deviceName", "pixel_7");
	cap.setCapability("appium:udid", "emulator-5554");
	
	//app
	String appPath=System.getProperty("user.dir")+"\\src\\test\\resources\\ApiDemos-debug.apk";
	
	cap.setCapability("appium:app", appPath);
	
	//server connectivity
	URL url=new URL("http://0.0.0.0:4723");
	
	//create appium session for connection
	AppiumDriver driver=new AndroidDriver(url,cap);
	
	Utility.getScreenshot(driver);
	
	System.out.println("Session id :"+driver.getSessionId());
	
	
	
	}

}
