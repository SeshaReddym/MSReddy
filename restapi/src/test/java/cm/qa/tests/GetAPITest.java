package cm.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase{

	TestBase testbase;
	String serviceURl;
	String apiUrl;
	String url;
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException
	{
		
		testbase = new  TestBase();
		 serviceURl = prop.getProperty("URL");
		 apiUrl = prop.getProperty("ServiceURL");
		 url = serviceURl+apiUrl;		
	}	
	@Test
	public void getAPITest() throws ClientProtocolException, IOException{
		
		RestClient restCllient = new RestClient();
		
		restCllient.get(url);
	}
	}
