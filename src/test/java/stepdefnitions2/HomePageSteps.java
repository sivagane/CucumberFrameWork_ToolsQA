package stepdefnitions2;

import cucumber.TestContext;
import dataProviders.ConfigFileReader;
import io.cucumber.java.en.Given;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageobjects.HomePage;

public class HomePageSteps {
   
	TestContext testcontext;
    HomePage  homepage;
    
    public HomePageSteps(TestContext context) {
    	testcontext = context;
    	homepage = testcontext.getPageobjectmanger().getHomepage();
    }
    
    @Given("User Navigates to Homepage")
	public void user_Navigates_to_Homepage() {
		homepage.navigateTo_HomePage();
	}


	
}
