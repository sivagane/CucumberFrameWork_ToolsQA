package selenium;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;

public class Wait {
	
	public static void untilJQueryCallDone(WebDriver driver) {
		untilJQueryCallDone(driver, FileReaderManager.getInstance().getConfigfilereader().getImplicitWait());
	}
	
	public static void untilJQueryCallDone(WebDriver driver, Long timeOutInSeconds) {
		until (driver, (d) ->
		{
		Boolean isJQueryCallDone = (Boolean)((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
		if(!isJQueryCallDone)System.out.println("JQuery Call is in Progress");
		return isJQueryCallDone;
	},timeOutInSeconds
				);
	}
	
	public static void  untilPageLoaded(WebDriver driver) {
		untilPageLoaded(driver, FileReaderManager.getInstance().getConfigfilereader().getImplicitWait());
	}
	
	public static void untilPageLoaded(WebDriver driver, Long timeOutInSeconds) {
		until (driver, (d) ->
		{
			Boolean isPageLoaded = (Boolean)((JavascriptExecutor)driver).executeScript("document.readyState").equals("complete");
			if(!isPageLoaded)System.out.println("Page is Loading");
			return isPageLoaded;
		},timeOutInSeconds
				);
		
		}
	
	public static void until(WebDriver driver, Function<WebDriver , Boolean>waitcondition) {
		until(driver, waitcondition, FileReaderManager.getInstance().getConfigfilereader().getImplicitWait());
	}
	
	public static void until(WebDriver driver, Function<WebDriver, Boolean>waitcondition, Long timeOutInSeconds) {
	   WebDriverWait webdriverwait = new WebDriverWait(driver, timeOutInSeconds);
	   webdriverwait.withTimeout(timeOutInSeconds, TimeUnit.SECONDS);
	   try {
		   webdriverwait.until(waitcondition);
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   }
       
}
