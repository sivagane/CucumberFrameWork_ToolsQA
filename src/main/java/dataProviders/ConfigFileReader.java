package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {
 
 private Properties properties;
 private final String propertyFilePath="C:\\Users\\Hp\\eclipse WorkSpace\\CucumberFramework\\configs\\Configuration.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
		reader = new BufferedReader(new FileReader(propertyFilePath));
		properties = new Properties();
		try {
			properties.load(reader);
			reader.close();
			}
		catch(IOException e) {
			e.printStackTrace();
		}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties File not found at "+propertyFilePath);
		}
	}
	
	public String getDriverPath() {
		String DriverPath = properties.getProperty("driverPath");
		if(DriverPath != null) return DriverPath;
		else throw new RuntimeException("driverPath not Specified in Configuration.properites file");
		}
	
	public long getImplicitWait() {
	    String ImplicitlyWait = properties.getProperty("implicitlyWait");	
	    if(ImplicitlyWait!=null) return Long.parseLong(ImplicitlyWait);
	    else throw new RuntimeException("ImplicitlyWait path not specified in Configuration.properties file");
	}
	
	public String getUrl() {
		String Url = properties.getProperty("url");
		if(Url!=null)return Url;
		else throw new RuntimeException("Url Path not Specified in Configuration.properties file");
		
	}
	
	public EnvironmentType getEnvironmentType() {
		String Environment = properties.getProperty("environment");
		if(Environment == null || Environment.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(Environment.equals("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Enviroment Type is not defined in Configuration.properties file");
	}
	
	public DriverType getDriverType() {
		String Browser = properties.getProperty("browser");
		if(Browser == null || Browser.equalsIgnoreCase("chrome")) return DriverType.CHROME;
		else if (Browser.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(Browser.endsWith("internetexplorer")) return DriverType.INTERNETEXPLORER;
		else throw new RuntimeException("Driver Type is not defined in Configuration.properties");
	}
	
	public Boolean getBrowserWindowSize() {
		String windowsize = properties.getProperty("windowMaximize");
		if(windowsize != null) return Boolean.valueOf(windowsize);
		return true;
		
	}
	
	public String getTestResourcesPath() {
		String testDataResource = properties.getProperty("testDataResourcesPath");
		if(testDataResource != null) return testDataResource;
		else throw new RuntimeException("testResourcesPath is not defined in Configuration.properties");
	}

	public String getConfigReaderPath() {
		String reportconfigpath = properties.getProperty("reportConfigPath");
		if(reportconfigpath!=null) return reportconfigpath;
		else throw new RuntimeException("reportconfigpath is not defined in Configuration.properties");
	}
	
}
