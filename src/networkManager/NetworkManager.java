package networkManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

public class NetworkManager {

	public void sendHttpRequest(String apiEndPoint, String Payload, String Header, String Method) {

		try {
			
			DefaultHttpClient httpClient = new DefaultHttpClient();
			StringEntity input = new StringEntity(Payload);
			input.setContentType(Header);
			
			switch (Method) {
			
			case "POST":
				System.out.println("Calling Post Method");
				HttpPost postRequest = new HttpPost(apiEndPoint);
				postRequest.setEntity(input);
				HttpResponse response = httpClient.execute(postRequest);
				
				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException(
							"Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
				}
						
				BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}
				break;

			case "GET":
				System.out.println("Calling Get Method");
				HttpGet getRequest = new HttpGet(apiEndPoint);
				HttpResponse getresponse = httpClient.execute(getRequest);
				
				if (getresponse.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException(
							"Failed : HTTP error code : " + getresponse.getStatusLine().getStatusCode());
				}
				
				BufferedReader br1 = new BufferedReader(new InputStreamReader((getresponse.getEntity().getContent())));
				
				String getOutput;
				System.out.println("Output from Server .... \n");
				while ((getOutput = br1.readLine()) != null) {
					System.out.println(getOutput);
				}
				break;
				
			case "PUT":
				break;

			case "DELETE":
				break;

			default:
				break;
			}

			httpClient.getConnectionManager().shutdown();
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}