package test.com.cuelogic.framework.network;

import org.junit.Test;
import com.cuelogic.framework.network.ContentType;
import com.cuelogic.framework.network.HTTPHelper;
import com.cuelogic.framework.network.HTTPParser;
import com.cuelogic.framework.network.HTTPRequest;
import com.cuelogic.framework.network.HTTPResponse;

import static org.junit.Assert.*;

/**
 * Created by ninad on 14/01/16.
 */
public class HTTPHelperTest implements HTTPParser {

	@Test
	public void testSendPOSTRequest() throws Exception {
		HTTPRequest request = new HTTPRequest();

		//request.url = "http://ec2-52-2-75-121.compute-1.amazonaws.com:4000/users/login";
		
		request.url = "http://ec2-52-2-75-121.compute-1.amazonaws.com:5000/v1/users/login";
		request.contentType = ContentType.JSON;
		request.payload = "{\"email\": \"gauravm@yopmail.com\",\"password\": \"Demo@12345\"}";
		
		HTTPHelper helper = new HTTPHelper(this);
		helper.sendPOSTRequest(request);
		
		System.out.println("POST Request sent");
	}

	@Override
	public void onResponseRecevied(HTTPResponse response) {
		System.out.println("POST Success");
		System.out.println("Response code: " + response.statusCode.toString());
		System.out.println("Payload: " + response.payload);
		assertTrue(true);
	}

	@Override
	public void onRequestFailed(Exception e) {
		System.out.println("Exception: " + e.getLocalizedMessage());
		assertTrue(false);
	}
}