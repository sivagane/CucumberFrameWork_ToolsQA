package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import selenium.Wait;
import testDataTypes.Customer;

public class CheckoutPage extends HomePage {

    public CheckoutPage(WebDriver driver) {
    	super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="icon-search")
	WebElement searchicon;
	
	@FindBy(id="s")
	WebElement searcharea;
	
	@FindBy(xpath="//a[text()='JS Data Structures and Algorithm']")
	WebElement searchitem;
	
	@FindBy(xpath="//button[@class='single_add_to_cart_button button alt']")
	WebElement addcart_btn;
	
	@FindBy(className="wpmenucart-contents")
	WebElement ItemBtn;
	
	@FindBy(xpath="//a[@class='checkout-button button alt wc-forward']")
	WebElement checkoutbtn;
	
	@FindBy(id="billing_first_name")
	WebElement firstname;
	
	@FindBy(id="billing_last_name")
	WebElement lastname;
	
	@FindBy(id="billing_company")
	WebElement companyname;
	
	@FindBy(id="billing_email")
	WebElement emailid;
	
	@FindBy(id="billing_phone")
	WebElement phoneno;
	
	@FindBy(xpath="(//span[@class='select2-arrow'])[1]")
	WebElement country_dwn_arrow;
	
	@FindBy(id="s2id_autogen1_search")
	WebElement country_txt_area;
	
	@FindBy(id="billing_address_1")
	WebElement address;
	
	@FindBy(id="billing_city")
	WebElement city;
	
	@FindBy(xpath="(//span[@class='select2-arrow'])[2]")
	WebElement state_dwn_arrow;
	
	@FindBy(xpath="(//div[@class='select2-search']//child::input)[2]")
	WebElement state_txt_area;
	
	@FindBy(id="billing_postcode")
	WebElement postcode;
	
	@FindBy(id="payment_method_bacs")
	WebElement Direct_bnk_tras;
	
	@FindBy(id="payment_method_cod")
	WebElement COD;
	
	@FindBy(id="payment_method_cheque")
	WebElement Check_pay;
	
	@FindBy(id="payment_method_ppec_paypal")
	WebElement Pay_PayPal;
	
	@FindBy(id="place_order")
	WebElement placeorder_btn;
	
	public void enterFirstName(String name) {
		firstname.sendKeys(name);
		Wait.untilJQueryCallDone(driver);
	}
	
	public void enterLastName(String name) {
		lastname.sendKeys(name);
		
	}
	
	public void enterCompanyName(String name) {
		companyname.sendKeys(name);
		Wait.untilJQueryCallDone(driver);
	}
	
	public void enterEmailId(String emailId) {
		emailid.sendKeys(emailId);
	}
	
	public void enterPhoneNumber(String phoneNumber) {
		phoneno.sendKeys(phoneNumber);
		Wait.untilJQueryCallDone(driver);
	}
	
	public void enterCountry(String countryName) throws InterruptedException, AWTException {
		
//		Thread.sleep(3000);
//		Select s = new Select(driver.findElement(By.id("billing_country")));
//		List<WebElement> options = s.getOptions();
//		for (WebElement country : options) {
//			if(country.getText().equalsIgnoreCase(countryName)) {
//				country_dwn_arrow.click();
//				country_txt_area.sendKeys(country.getText());
//			}
//			
//		}
		Robot r = new Robot();
		country_dwn_arrow.click();
		country_txt_area.sendKeys("United States (US)");
		r.keyPress(KeyEvent.VK_ENTER);
		}
	
	public void enterAddress(String Address) {
		address.sendKeys(Address);
		Wait.untilJQueryCallDone(driver);
	}
	
	public void enterCity(String City) {
		city.sendKeys(City);
	}
	
	public void enterState(String stateName) throws AWTException, InterruptedException {
		
//		Select s = new Select(driver.findElement(By.id("billing_state")));
//		List<WebElement> options = s.getOptions();
//		for (WebElement state : options) {
//			if(state.getText().equalsIgnoreCase(stateName)) {
//				state_dwn_arrow.click();
//				state.click();
//			}
//		}
		Robot r = new Robot();
		state_dwn_arrow.click();
		state_txt_area.sendKeys("Alabama");
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
	}
	
	
	public void enterPostCode(String postcode1) {
		postcode.sendKeys(postcode1);
		Wait.untilJQueryCallDone(driver);
	}
	
	public void enterPaymentMethod(String paymentmethod) {
		if(paymentmethod.equalsIgnoreCase("directbanktransfer")) {
			Direct_bnk_tras.click();
		}
		else if(paymentmethod.equalsIgnoreCase("checkpayments")) {
			Check_pay.click();
		}
		else if(paymentmethod.equals("paypalexpresscheckout")) {
			Pay_PayPal.click();
		}
		else if(paymentmethod.equalsIgnoreCase("cashondelivery")){
			COD.click();
		}
		else
		{
		System.out.println("Select any one of the payment methods");	
		}
	}
	
	public void placeorder() {
		placeorder_btn.click();
		Wait.untilJQueryCallDone(driver);
	}
	
	public void fillPersonalDetails(Customer customer) throws InterruptedException, AWTException {
		enterFirstName(customer.firstName);
		enterLastName(customer.lastName);
		enterCompanyName(customer.companyName);
		enterEmailId(customer.emailAddress);
		enterPhoneNumber(customer.phone);
		enterCountry(customer.country);
		enterAddress(customer.address);
		enterCity(customer.city);
		enterState(customer.state);
		enterPostCode(customer.postCode);
		}
	
	
	
}
