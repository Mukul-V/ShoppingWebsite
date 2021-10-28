package Models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class APICall {

	public static HttpResponse getRequest(String url) {
		HttpRequest req=HttpRequest
				.newBuilder()
				.GET()
				.uri(URI.create(url))
				.build();
		
		HttpClient client= HttpClient.newBuilder().build();
		HttpResponse res=null;

		String str="";
		try {
			res = client.send(req, HttpResponse.BodyHandlers.ofString());
			str=res.body().toString();
		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
		}
		return res;
	}
	
	public static HttpResponse postRequest(String url, String data) {
		HttpRequest req=HttpRequest
				.newBuilder()
				.header("Content-Type", "application/json")
				.POST(BodyPublishers.ofString(data))
				.uri(URI.create(url))
				.build();
		
		HttpClient client= HttpClient.newBuilder().build();
		HttpResponse res=null;

		String str="";
		try {
			res = client.send(req, HttpResponse.BodyHandlers.ofString());

			str=res.body().toString();
		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
		}
		return res;
	}


}
