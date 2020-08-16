package stepdefnitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobjects.AddToCartPage;
import pageobjects.CheckoutPage;
import pageobjects.HomePage;
import pageobjects.SearchPage;

public class StepDefinition {
WebDriver driver;
@Given("User is on Home Page")
public void user_is_on_Home_Page() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://practice.automationtesting.in/shop/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("he Search for book JS Data Structures and Algorithm")
public void he_Search_for_book_JS_Data_Structures_and_Algorithm() throws InterruptedException, AWTException {
	Actions action = new Actions(driver);
	WebElement searchicon = driver.findElement(By.className("icon-search"));
	action.moveToElement(searchicon).build().perform();
	driver.findElement(By.id("s")).sendKeys("JS Data Structures and Algorithm");
	Thread.sleep(3000);
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(3000);
}


@When("selects the item")
public void selects_the_item() throws InterruptedException {
	driver.findElement(By.xpath("//a[text()='JS Data Structures and Algorithm']")).click();
	Thread.sleep(3000);
}

@When("Clicks on Add to Cart and Clicks CheckoutButton")
public void clicks_on_Add_to_Cart_and_Clicks_CheckoutButton() throws InterruptedException {
	
	driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).click();
	driver.findElement(By.className("wpmenucart-contents")).click();
    driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();
}

@When("User enters personal details")
public void user_enters_personal_details() throws InterruptedException, AWTException {
	Robot r = new Robot();
	 driver.findElement(By.id("billing_first_name")).sendKeys("Siva");
	    driver.findElement(By.id("billing_last_name")).sendKeys("Ganesh");
	    driver.findElement(By.id("billing_company")).sendKeys("Ajantha");
	    driver.findElement(By.id("billing_email")).sendKeys("siva98@gmail.com");
	    driver.findElement(By.id("billing_phone")).sendKeys("9786458399");
	    driver.findElement(By.xpath("(//span[@class='select2-arrow'])[1]")).click();
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys("United States (US)");
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		driver.findElement(By.id("billing_address_1")).sendKeys("83, Mahatama Gandhi Road");
		driver.findElement(By.id("billing_city")).sendKeys("Pudhucherry");
		driver.findElement(By.xpath("(//span[@class='select2-arrow'])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='select2-search']//child::input)[2]")).sendKeys("Alabama");
		r.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.id("billing_postcode")).sendKeys("35231");
		driver.findElement(By.id("payment_method_cod")).click();
}

@When("Clicks on Place order button")
public void clicks_on_Place_order_button() {
	driver.findElement(By.id("place_order")).click();
}


}
