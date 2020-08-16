package dataProviders;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import managers.FileReaderManager;
import testDataTypes.Customer;

public class JsonDataReader {

	private final String customerFilePath = FileReaderManager.getInstance().getConfigfilereader().getTestResourcesPath() + "Customer.json";
    private List<Customer> customerList;
    
    public JsonDataReader() {
    	customerList = getCustomerData();
    }
    
    private List<Customer> getCustomerData(){
    	
    	Gson gson = new Gson();
    	BufferedReader reader= null;
    	try {
    		reader = new BufferedReader(new FileReader(customerFilePath));
    		Customer[] customers = gson.fromJson(reader, Customer[].class);
    		return Arrays.asList(customers);
    	}
    	catch(FileNotFoundException e) {
    		throw new RuntimeException("Json file is not found in the Path "+customerFilePath);
    	}
    	finally {
    		try{
    			if(reader != null)
    			reader.close();
    			}
    		catch(IOException ignore){}
    	}
    	}
		
    	public final Customer getCustomerByName(String customerName) {
    		for (Customer customer : customerList) {
    			if(customer.firstName.equalsIgnoreCase(customerName))
    				return customer;
		}
    	return null;
        }
}