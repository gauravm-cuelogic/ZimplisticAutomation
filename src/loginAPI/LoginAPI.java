package loginAPI;

import networkManager.NetworkManager;

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;*/

public class LoginAPI {
	public static void main(String[] args) {

	  /*try {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost(
		"http://ec2-52-2-75-121.compute-1.amazonaws.com:4000/users/login");
		
		StringEntity input = new StringEntity("{\"email\":\"gaurav@cuelogic.com\",\"password\":\"asdf123\"}");
		input.setContentType("application/json");
		postRequest.setEntity(input);
		
		HttpResponse response = httpClient.execute(postRequest);
		
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(
                        new InputStreamReader((response.getEntity().getContent())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		httpClient.getConnectionManager().shutdown();

	  } catch (MalformedURLException e) {

		  e.printStackTrace();
	
	  } catch (IOException e) {

		e.printStackTrace();

	  }*/
		
	String baseUrl = "http://ec2-52-2-75-121.compute-1.amazonaws.com:4000";
	
	String apiEndPoint = baseUrl+"/users/login";
	//String apiEndPoint = "http://ec2-52-2-75-121.compute-1.amazonaws.com:4000/users/login";
	String Payload = "{\"email\":\"gaurav@cuelogic.com\",\"password\":\"asdf123\"}";
	String Header = "application/json";
	String Method = "POST";
	
	NetworkManager nt = new NetworkManager();
	nt.sendHttpRequest(apiEndPoint, Payload, Header, Method);

	}

}