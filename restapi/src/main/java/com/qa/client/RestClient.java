package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	// GET Method
	public void get(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); // http get request
		
		CloseableHttpResponse closablehttprepsonse= httpclient.execute(httpget); // hit the GET URL
	
		//1.Status Code
		int statuscode = closablehttprepsonse.getStatusLine().getStatusCode();
		System.out.println("Ststus Code is " + statuscode);
		
		// 2.JSON String
		String responseString = EntityUtils.toString(closablehttprepsonse.getEntity(),"UTF-8");
		JSONObject responsejson = new JSONObject(responseString);
		System.out.println("Response JSON from API " +responsejson );
	
		//3.All Headers
		Header[] headerarray = closablehttprepsonse.getAllHeaders();
		HashMap<String,String> allHeaders = new HashMap<String,String>();
		
		for (Header header : headerarray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		
		System.out.println("Header Array -->"+allHeaders );
	}
	}