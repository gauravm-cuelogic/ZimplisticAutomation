package test.com.cuelogic.framework.network;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.cuelogic.framework.network.ContentType;
import com.cuelogic.framework.network.HTTPHelper;
import com.cuelogic.framework.network.HTTPParser;
import com.cuelogic.framework.network.HTTPRequest;
import com.cuelogic.framework.network.HTTPResponse;

public class HTTPHelperForgotPwdTest implements HTTPParser {

	@Test
	public void testSendPOSTRequest() throws Exception {
		HTTPRequest request = new HTTPRequest();
		// request.url = "";

		request.url = "http://ec2-52-2-75-121.compute-1.amazonaws.com:5000/v1/users/forgotpassword";
		request.contentType = ContentType.JSON;
		request.payload = "{\"email\": \"gauravm@yopmail.com\",\"logintype\": 0}";

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
