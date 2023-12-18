package mobileGuestures;

import java.net.MalformedURLException;
import java.time.Duration;

import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class WorkingWithApp {

	public static void main(String[] args) throws MalformedURLException {
		
		AppiumDriver driver=CreateSession.initilizeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Query app state : current status of app 

		System.out.println("Current status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));
		
		//Terminate app- Terminates an existing app 
		/*boolean status=((AndroidDriver)driver).terminateApp("io.appium.android.apis");//app pacakage name
		
		System.out.println("After termination status is :"+status);
		
		System.out.println("Current status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));
		*/
		//Application background execution
		
		((AndroidDriver)driver).runAppInBackground(Duration.ofMillis(5000));

		System.out.println("Current status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));

		//uninstallation any app
		
		((AndroidDriver)driver).removeApp("io.appium.android.apis");
		
		System.out.println("App removed!");

		System.out.println("Current status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));

		//install app
		
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\ApiDemos-debug.apk";
		
		((AndroidDriver)driver).installApp(path);
		
		System.out.println("Current status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));




	}

}
