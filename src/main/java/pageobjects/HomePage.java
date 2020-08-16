package pageobjects;

import org.openqa.selenium.WebDriver;

import dataProviders.ConfigFileReader;
import managers.FileReaderManager;

public class HomePage {
    ConfigFileReader configfilereader = new ConfigFileReader();
	public static WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigfilereader().getUrl());
		
	}
}
