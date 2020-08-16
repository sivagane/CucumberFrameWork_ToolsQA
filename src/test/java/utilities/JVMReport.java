package utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {

	public static void generateReport(String jsonfile) {
		Configuration con = new Configuration(
			new File(System.getProperty("user.dir")+"\\target"),"Cucumber End 2 End FrameWork"
				);
		
		con.addClassifications("os", "windows");
		con.addClassifications("Env", "UAT");
		
		List<String> jsonfiles = new ArrayList<String>();
		jsonfiles.add(jsonfile);
		ReportBuilder builder = new ReportBuilder(jsonfiles, con);
		builder.generateReports();
				
	}
}
