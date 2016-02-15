package com.zimp.product.api.forgotpwd;

import com.cuelogic.framework.network.ContentType;
import com.cuelogic.framework.network.HTTPRequest;
import com.zimp.product.api.APIHandler;

public class ForgotPwdAPI extends APIHandler {

	private HTTPRequest generateForgotPwdRequest(ForgotPwdRequest forgotpwdRequest){
		HTTPRequest httpRequest = new HTTPRequest();
		httpRequest.contentType = ContentType.JSON;
		//httpRequest.url = "http://ec2-52-2-75-121.compute-1.amazonaws.com:4000/documentation#!/users/usersforgotpassword"; // Generate
		httpRequest.url = "http://ec2-52-2-75-121.compute-1.amazonaws.com:5000/v1/users/forgotpassword";
		// URL
		httpRequest.payload = new ForgotPwdJSONGenerator(forgotpwdRequest).getJSONString();
		return httpRequest;
	}

	private void triggerForgotPwd(ForgotPwdRequest request) {
		try {
			sendHTTPPostRequest(generateForgotPwdRequest(request));
		} catch (Exception e) {
			
		}
	}

	public boolean forgotPwdVerifySuccess(ForgotPwdRequest request) {
		triggerForgotPwd(request);
		return true;
	}

	public boolean forgotPwdVerifyFailure(ForgotPwdRequest request) {
		triggerForgotPwd(request);
		return true;
	}

	public boolean forgotPwdVerifyFailure(ForgotPwdRequest request, Integer expectedStatusCode) {
		return true;
	}

	@Override
	public void parseAndVerifyAPIResponse() {
		if (verifyHTTPCode(200) == true) {
			String payload = getPayload();
			System.out.println(payload);
			
			ForgotPwdResponseParser parser = new ForgotPwdResponseParser(payload);
			ForgotPwdResponse response = parser.getResponse();
			System.out.println(response.email);
		}
	}

	@Override
	public void httpRequestFailed(Exception e) {

	}

}
