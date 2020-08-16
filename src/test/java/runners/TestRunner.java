package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import managers.FileReaderManager;
import utilities.JVMReport;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/FunctionalTests",glue= "stepdefnitions2"
,plugin="json:target\\cucumber.json"
,dryRun=false)
public class TestRunner {

	@AfterClass
	public static void writeExtentReport() {
		JVMReport.generateReport(System.getProperty("user.dir")+"\\target\\cucumber.json");
	}
}
