package stepdefnitions2;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	TestContext testcontext;
	public Hooks(TestContext context) {
		testcontext = context;
	}
	
	@Before
	public void BeforeSteps() {
		
	}
	
	@After
	public void AfterSteps() {
		testcontext.getWebdrivermanager().closeDriver();
	}
}
