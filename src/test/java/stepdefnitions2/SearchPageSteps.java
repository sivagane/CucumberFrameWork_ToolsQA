package stepdefnitions2;

import java.awt.AWTException;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import pageobjects.SearchPage;

public class SearchPageSteps {
	
	TestContext testcontext;
	SearchPage searchpage;
	
	public SearchPageSteps(TestContext context) {
		 testcontext = context;
		searchpage = testcontext.getPageobjectmanger().getSearchpage();
	}
	
	@When("User Searches and Selects the Book")
	public void user_Searches_and_Selects_the_Book() throws AWTException, InterruptedException {
	  searchpage.searchItem("JS Data Structures and Algorithm");
	  searchpage.selectItem();
	}

}
