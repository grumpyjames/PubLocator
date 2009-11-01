package org.grumpysoft.pl;

import java.util.ArrayList;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpPubSource implements PubSource {

	private final HttpClient client_;
	private final ResponseTranslator linguist_;
	
	public HttpPubSource(ResponseTranslator linguist) {
		client_ = new DefaultHttpClient();
		linguist_ = linguist;
	}
	
	public ArrayList<Pub> findPubs(double latitude, double longitude) {
		StringBuilder sb = new StringBuilder();
		sb.append("http://foundry.digihippo.net/fancyapint/webroot/Pubs/FindByLocation/");
		sb.append(latitude).append("/").append(longitude).append("/");
		HttpGet httpget = new HttpGet(sb.toString());
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
		String response_body;
        try { 
			response_body = client_.execute(httpget, responseHandler);
		}
		catch (Throwable t) {
			throw new RuntimeException("had a major issue retrieving pubs: " + t.getMessage());
		}
		finally {
			client_.getConnectionManager().shutdown();
		}
		return linguist_.fromString(response_body);
	}

	public ArrayList<Pub> findPubs(String postcode) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
