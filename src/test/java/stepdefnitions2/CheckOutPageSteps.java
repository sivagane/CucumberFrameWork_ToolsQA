package stepdefnitions2;

import java.awt.AWTException;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageobjects.CheckoutPage;
import testDataTypes.Customer;

public class CheckOutPageSteps {

	TestContext testcontext;
	CheckoutPage checkoutpage;
	
	public CheckOutPageSteps(TestContext context) {
		testcontext = context;
		checkoutpage = testcontext.getPageobjectmanger().getCheckoutpage();
	}
	
	@When("User enters {string} the Personal Details")
	public void user_enters_the_Personal_Details(String customerName) throws InterruptedException, AWTException {
	   Customer customer= FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
	   checkoutpage.fillPersonalDetails(customer);
	}

	@When("User selects Payment Method and Clicks the Place Order button")
	public void user_selects_Payment_Method_and_Clicks_the_Place_Order_button() {
	    checkoutpage.enterPaymentMethod("cashondelivery");
	    checkoutpage.placeorder();
	    
	   
	}
}
