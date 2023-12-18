package mobileGuestures;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class SwipeLeftRightAction {
	
public static void main(String[] args) throws MalformedURLException {
		
		AppiumDriver driver=CreateSession.initilizeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		//view
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//gallary
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();;
	
		//photots
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		//swipe to left 
		WebElement ele=driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));
		

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) ele).getId(),
				"left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "left",
			    "percent", 0.75
			    
			));
		
		System.out.println("Done!");
	}

}



