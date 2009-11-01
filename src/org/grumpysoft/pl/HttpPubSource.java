package org.grumpysoft.pl;

import java.util.ArrayList;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

public class HttpPubSource implements PubSource {

	private final HttpClient client_;
	private final ResponseTranslator linguist_;
	
	public HttpPubSource(ResponseTranslator linguist) {
		client_ = new DefaultHttpClient();
		linguist_ = linguist;
	}
	
	
	public ArrayList<Pub> findPubs(double latitude, double longitude) {
		HttpGet httpget = new HttpGet("http://www.digihippo.net/find_pubs");
        HttpParams params = new BasicHttpParams();
        params.setDoubleParameter("latitude", latitude);
        params.setDoubleParameter("longitude", longitude);
        httpget.setParams(params);
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
