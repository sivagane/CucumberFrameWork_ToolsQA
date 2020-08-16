package managers;

import org.openqa.selenium.WebDriver;

import pageobjects.AddToCartPage;
import pageobjects.CheckoutPage;
import pageobjects.HomePage;
import pageobjects.SearchPage;

public class PageObjectManager  {

	public  WebDriver driver;
	private AddToCartPage addtocartpage;
	private CheckoutPage checkoutpage;
	private HomePage homepage;
	private SearchPage searchpage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public AddToCartPage getAddtocartpage() {
		return (addtocartpage == null) ? addtocartpage = new AddToCartPage(driver) : addtocartpage;
	}

	public CheckoutPage getCheckoutpage() {
		return (checkoutpage == null) ? checkoutpage = new CheckoutPage(driver) : checkoutpage;
	}

	public HomePage getHomepage() {
		return (homepage == null) ? homepage = new HomePage(driver) : homepage;
	}

	public SearchPage getSearchpage() {
		return (searchpage == null) ? searchpage = new SearchPage(driver) : searchpage;
	}
	
	
}
