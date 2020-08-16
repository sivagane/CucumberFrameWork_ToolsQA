package stepdefnitons1;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProviders.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageobjects.AddToCartPage;
import pageobjects.CheckoutPage;
import pageobjects.HomePage;
import pageobjects.SearchPage;

public class StepDefnition {

	WebDriver driver;
	HomePage homepage;
	SearchPage searchpage;
	AddToCartPage addtocartpage;
	CheckoutPage checkoutpage;
	PageObjectManager pageobjectmanager;
	@Given("User Navigates to Homepage")
	public void user_Navigates_to_Homepage() {
		ConfigFileReader configfilereader = new ConfigFileReader();
		WebDriverManager webdrivermanager = new WebDriverManager();
		driver = webdrivermanager.getDriver();
		pageobjectmanager = new PageObjectManager(driver);
		homepage = pageobjectmanager.getHomepage();
		homepage.navigateTo_HomePage();
	}

	@When("User Searches and Selects the Book")
	public void user_Searches_and_Selects_the_Book() throws AWTException, InterruptedException {
	  searchpage = pageobjectmanager.getSearchpage();
	  searchpage.searchItem("JS Data Structures and Algorithm");
	  searchpage.selectItem();
	}

	@When("User Adds the Book to Cart and Clicks Checkout button")
	public void user_Adds_the_Book_to_Cart_and_Clicks_Checkout_button() {
	   addtocartpage = pageobjectmanager.getAddtocartpage();
	   addtocartpage.doCheckout();
	}

	@When("User enters the Personal Details")
	public void user_enters_the_Personal_Details() throws InterruptedException, AWTException {
	    checkoutpage = pageobjectmanager.getCheckoutpage();
	   // checkoutpage.fillPersonalDetails();
	    
	  }

	@When("User selects Payment Method and Clicks the Place Order button")
	public void user_selects_Payment_Method_and_Clicks_the_Place_Order_button() {
	    checkoutpage.enterPaymentMethod("cashondelivery");
	    checkoutpage.placeorder();
	    
	    driver.quit();
	}




}
