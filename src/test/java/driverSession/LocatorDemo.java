package driverSession;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LocatorDemo {

	public static void main(String[] args) throws MalformedURLException {
		
		AppiumDriver driver=CreateSession.initilizeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//Identify moblie element for different locators
		
		//mobile element
		WebElement ele1=driver.findElement(AppiumBy.accessibilityId("Accessibility"));
		
		System.out.println("Text is :"+ele1.getText());
		ele1.click();
		
		
		
		//element 2
		driver.findElement(AppiumBy.accessibilityId("Accessibility Service")).click();
		
		System.out.println("Using accessibilityId element clicked!");
		
		//class name
		//driver.findElement(AppiumBy.className("android.widget.TextView")).click();
		
		//driver.findElements(AppiumBy.className("android.widget.TextView")).get(3).click();
		
		System.out.println("Clicked!");
		
		System.out.println("Using className element clicked!");
		
		driver.navigate().back();
		
		//xpath
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility Service\"]")).click();
		
		System.out.println("Using Xpth element clicked!");
		
		driver.navigate().back();
		
		driver.findElements(AppiumBy.id("android:id/text1")).get(2).click();
		
		System.out.println("Using resource id element clicked!");
		
	}

}
