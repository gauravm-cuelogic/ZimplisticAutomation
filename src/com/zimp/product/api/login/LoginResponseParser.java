package com.zimp.product.api.login;

import org.json.JSONObject;
//import org.json.simple.parser.JSONParser;

/**
 * Created by ninad on 15/01/16.
 *
 *
 * Response:
 *
 * { "fname": "Gaurv", "isVerified": true, "email": "gaurav@cuelogic.com",
 * "authToken": "$2a$10$6VHleljGZfm6YODatKMMA.R.29GdsZ6EQNo26E8K9RFxptG5wqObC",
 * "lname": "NA", "id": "9dc23dd0-bb62-11e5-bf78-21bf94489042" }
 */

public class LoginResponseParser {
	private String responseJSON;

	public LoginResponseParser(String response) {
		this.responseJSON = response;
	}

	public LoginResponse getResponse() {
		LoginResponse response = new LoginResponse();
		//JSONParser parser = new JSONParser();
		
		try {
			
			//Object obj = parser.parse(responseJSON);
			
			JSONObject jobj = new JSONObject(responseJSON);

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