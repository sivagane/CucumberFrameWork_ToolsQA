package seleniumTests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class E2E_Test {
    private static WebDriver driver;
	public static void main(String[] args) throws AWTException, InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in/shop/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions action = new Actions(driver);
		WebElement searchicon = driver.findElement(By.className("icon-search"));
		action.moveToElement(searchicon).build().perform();
		driver.findElement(By.id("s")).sendKeys("JS Data Structures and Algorithm");
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='JS Data Structures and Algorithm']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).click();
		driver.findElement(By.className("wpmenucart-contents")).click();
	    driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();
	    driver.findElement(By.id("billing_first_name")).sendKeys("Siva");
	    driver.findElement(By.id("billing_last_name")).sendKeys("Ganesh");
	    driver.findElement(By.id("billing_company")).sendKeys("Ajantha");
	    driver.findElement(By.id("billing_email")).sendKeys("siva98@gmail.com");
	    driver.findElement(By.id("billing_phone")).sendKeys("9786458399");
//	    driver.findElement(By.xpath("(//span[@class='select2-arrow'])[1]")).click();
//		driver.findElement(By.id("s2id_autogen1_search")).sendKeys("United States (US)");
//		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		Select s = new Select(driver.findElement(By.id("billing_country")));
		List<WebElement> options = s.getOptions();
		for (WebElement country : options) {
			if(country.getText().equalsIgnoreCase("United States (US)")) {
				 driver.findElement(By.xpath("(//span[@class='select2-arrow'])[1]")).click();
				 driver.findElement(By.id("s2id_autogen1_search")).sendKeys(country.getText());
			}
			
		
		}
		driver.findElement(By.id("billing_address_1")).sendKeys("83, Mahatama Gandhi Road");
		driver.findElement(By.id("billing_city")).sendKeys("Pudhucherry");
		driver.findElement(By.xpath("(//span[@class='select2-arrow'])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='select2-search']//child::input)[2]")).sendKeys("Alabama");
		r.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.id("billing_postcode")).sendKeys("35231");
		driver.findElement(By.id("payment_method_cod")).click();
		driver.findElement(By.id("place_order")).click();
		}
	
	

}
