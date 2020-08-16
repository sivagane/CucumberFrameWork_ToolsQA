package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {

	private WebDriverManager webdrivermanager;
	private PageObjectManager pageobjectmanger;
	
	public TestContext() {
	 webdrivermanager = new WebDriverManager();
	 pageobjectmanger = new PageObjectManager(webdrivermanager.getDriver());
	}

	public WebDriverManager getWebdrivermanager() {
		return webdrivermanager;
	}

	public PageObjectManager getPageobjectmanger() {
		return pageobjectmanger;
	}
	
	
}
