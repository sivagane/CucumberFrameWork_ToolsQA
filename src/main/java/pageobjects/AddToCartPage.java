package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends HomePage {

	public AddToCartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='single_add_to_cart_button button alt']")
	WebElement addcart_btn;
	
	@FindBy(className="wpmenucart-contents")
	WebElement ItemBtn;
	
	@FindBy(xpath="//a[@class='checkout-button button alt wc-forward']")
	WebElement checkoutbtn;
	
	public void doCheckout() {
		addcart_btn.click();
		ItemBtn.click();
		checkoutbtn.click();
	}
}
