package helper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	public static void getScreenshot(WebDriver driver)
	{
		 TakesScreenshot ts = (TakesScreenshot) driver;
		  File temp=ts.getScreenshotAs(OutputType.FILE);
		  File dest=new File("./"+"\\Screenshots\\APIDemons"+System.currentTimeMillis()+".png");//dynamic time
		  
		  try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Dropdown
	
	public static void SelectBaseDropDown(WebElement ele,String value)
	{
	
	Select dd = new Select(ele);
	
	System.out.println("Is dropdown support multiple selection : ?"+dd.isMultiple());
	
    List<WebElement> list= dd.getOptions();
	
	System.out.println("Total option are :"+list.size());
	
	for(WebElement i :list)
	{
		System.out.println(i.getText());
		if(i.getText().contains(value))
		{
			i.click();
			break;
		}
	}

	}	//Explicit Wait
	
	public static WebElement waitForElementPresent(WebDriver driver, By loc)
    {
	         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
	         return wait.until(ExpectedConditions.presenceOfElementLocated(loc));//it will return webElement
	   }
	
	public static WebElement waitForElementVisibility(WebDriver driver, By loc)
	   {
		     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		     return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));//it will return webElement
	   }

	public static WebElement waitForElementToClickable(WebDriver driver, By loc)
	   {
		     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		     return wait.until(ExpectedConditions.elementToBeClickable(loc));//it will return webElement
	   }
	public  static boolean waitForurlContains(WebDriver driver, String text)
	   {
		     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		     return wait.until(ExpectedConditions.urlContains(text));//it will return webElement
	   }
	public static boolean waitForTitleContains(WebDriver driver, String text)
	   {
		     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		     return wait.until(ExpectedConditions.titleContains(text));//it will return webElement
	   }
	
	//Scroll up/down/to Element
	
	public static void scrollUp(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
	}
	public static void scrollToElement(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",ele);
		
	}

	
	

}
