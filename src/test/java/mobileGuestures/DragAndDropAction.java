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

public class DragAndDropAction {

	public static void main(String[] args) throws MalformedURLException {
		
		AppiumDriver driver = CreateSession.initilizeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		//click on view
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//drag and drop element
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		//First circle
		WebElement ele = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		
		//drag and drop
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", 580,
			    "endY", 931
			));
		
	String resText=	driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
		
     System.out.println("Is Elememt Dropped ?"+resText);
	}

}
