package com.zimp.product.api.forgotpwd;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class ForgotPwdResponseParser {

	private String responseJSON;

	public ForgotPwdResponseParser(String response) {
		this.responseJSON = response;
	}

	public ForgotPwdResponse getResponse() {
		ForgotPwdResponse response = new ForgotPwdResponse();

		JSONParser parser = new JSONParser();
		try {

			Object obj = parser.parse(responseJSON);
			JSONObject jobj = (JSONObject) obj;
			response.fname = (String) jobj.get("fname");
			response.authToken = (String) jobj.get("authToken");
			response.email = (String) jobj.get("email");
			response.lname = (String) jobj.get("lname");
			response.id = (String) jobj.get("id");

		} catch (Exception e) {

		}

		return response;
	}

}
