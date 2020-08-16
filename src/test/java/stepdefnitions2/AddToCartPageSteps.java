package stepdefnitions2;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import pageobjects.AddToCartPage;

public class AddToCartPageSteps {

	TestContext testcontext;
	AddToCartPage addtocartpage;
	
	public AddToCartPageSteps(TestContext context) {
		testcontext = context;
		addtocartpage = testcontext.getPageobjectmanger().getAddtocartpage();
		}
	
	@When("User Adds the Book to Cart and Clicks Checkout button")
	public void user_Adds_the_Book_to_Cart_and_Clicks_Checkout_button() {
	   addtocartpage.doCheckout();
	}
}
