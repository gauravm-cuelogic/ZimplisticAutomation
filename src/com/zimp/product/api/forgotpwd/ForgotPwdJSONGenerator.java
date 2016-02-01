package com.zimp.product.api.forgotpwd;

import java.io.StringWriter;
import org.json.JSONObject;

public class ForgotPwdJSONGenerator {
	ForgotPwdRequest request;

	public ForgotPwdJSONGenerator(ForgotPwdRequest request) {
		this.request = request;
	}

	public String getJSONString() {
		try {
			JSONObject forgotPwd = new JSONObject();
			forgotPwd.put("email", request.email);
			forgotPwd.put("login type", request.logintype);

			StringWriter out = new StringWriter();
			// ((Object) login).writeJSONString(out);

			String jsonText = out.toString();
			System.out.println("Login payload: " + jsonText);
			return jsonText;
		} catch (Exception e) {
			return null;
		}
	}

}