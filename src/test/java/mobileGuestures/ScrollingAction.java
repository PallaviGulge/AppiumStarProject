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

public class ScrollingAction {

public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AppiumDriver driver=CreateSession.initilizeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		//view
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//list of options on second page
		
		WebElement ele=driver.findElement(AppiumBy.id("android:id/list"));
	
		boolean scrolldown1 = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) ele).getId(),
			    "down", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 0.75
			));
		
		System.out.println(" scroll down Done!");
		
		Thread.sleep(2000);
		
		boolean scrollup = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) ele).getId(),
			    "up", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "up",
			    "percent", 0.75
			));
		
		System.out.println(" scroll up Done!");
		
	}

}


