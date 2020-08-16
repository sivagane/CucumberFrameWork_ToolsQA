package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends HomePage{
	
	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(className="icon-search")
	WebElement searchicon;
	
	@FindBy(id="s")
	WebElement searcharea;
	
	@FindBy(xpath="//a[text()='JS Data Structures and Algorithm']")
	WebElement searchitem;
	
	public void searchItem(String SearchItem) throws AWTException, InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(searchicon).build().perform();
		searcharea.sendKeys(SearchItem);
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void selectItem() throws InterruptedException {
		Thread.sleep(3000);
		searchitem.click();
	}
	
}
