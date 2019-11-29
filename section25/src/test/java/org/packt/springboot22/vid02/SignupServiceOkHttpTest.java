package org.packt.springboot22.vid02;

import java.io.IOException;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import org.junit.jupiter.api.Test;
import org.packt.springboot22.vid02.model.Profile;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignupServiceOkHttpTest {
	
	@Test
    public void testGetOkHttp() {
		
    	Request request = new Request.Builder()
    	        .url("http://localhost:8082/farmservice/signup/users")
    	        .get()
    	        .build();
    	OkHttpClient client = new OkHttpClient();
    	Response response;
		try {
			response = client.newBuilder()
					.hostnameVerifier(new HostnameVerifier() {
						@Override
						public boolean verify(String hostname, SSLSession session) {
							return true;
						}
					})
					.followRedirects(true)
					.retryOnConnectionFailure(true)
					.build().newCall(request).execute();
			
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
    }
	
	@Test
	public void testPostOkHttp() {
		Profile profile = new Profile();
		profile.setName("John Coala");
		profile.setMobile("1111111");
		profile.setEmail("jcoala@yahoo.com");
		profile.setApproved(true);
		profile.setUsername("jcoala");
		profile.setPassword("jcoala@@&$");
		
		Jsonb jsonb = JsonbBuilder.create();
		String json = jsonb.toJson(profile);
		
		RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json"), json );
    	Request request = new Request.Builder()
    	        .url("http://localhost:8082/farmservice/signup/user/add")
    	        .post(body)
    	        .build();
    	OkHttpClient client = new OkHttpClient();
    	Response response;
		try {
			response = client.newBuilder().hostnameVerifier(new HostnameVerifier() {
		        @Override
		        public boolean verify(String hostname, SSLSession session) {
		            return true;
		        }
		    }).followRedirects(true)
			  .retryOnConnectionFailure(true).build().newCall(request).execute();
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
