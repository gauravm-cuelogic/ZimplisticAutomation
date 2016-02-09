package com.zimp.product.api.forgotpwd;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class ForgotPwdResponseParser {

	private String responseJSON;

	public ForgotPwdResponseParser(String response) {
		this.responseJSON = response;
	}

	public ForgotPwdResponse getResponse() {
		ForgotPwdResponse fpwdresponse = new ForgotPwdResponse();

		JSONParser parser = new JSONParser();
		try {

			Object obj = parser.parse(responseJSON);
			JSONObject jobj = (JSONObject) obj;
			fpwdresponse.fname = (String) jobj.get("fname");
			fpwdresponse.authToken = (String) jobj.get("authToken");
			fpwdresponse.email = (String) jobj.get("email");
			fpwdresponse.lname = (String) jobj.get("lname");

		} catch (Exception e) {

		}

		return fpwdresponse;
	}

}
