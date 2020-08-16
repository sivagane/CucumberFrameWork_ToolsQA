package managers;

import dataProviders.ConfigFileReader;
import dataProviders.JsonDataReader;

public class FileReaderManager {
	
	private static FileReaderManager filereadermanager = new FileReaderManager();
	private static ConfigFileReader configfilereader;
	private static JsonDataReader jsondatareader;
	private FileReaderManager() {
		
	}
	
	public static FileReaderManager getInstance() {
		return filereadermanager;
	}

	public ConfigFileReader getConfigfilereader() {
		return (configfilereader==null) ? new ConfigFileReader() : configfilereader;
	}
	
	public JsonDataReader getJsonReader() {
		return (jsondatareader == null) ? new JsonDataReader() : jsondatareader;
	}
	}
