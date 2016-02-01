package com.zimp.product.api.login;

import org.json.JSONObject;

import java.io.StringWriter;

/**
 * Created by ninad on 15/01/16.
 *
 *
 *
 Request

 {
 email (string): Email address,
 password (string): User Password
 }

 Response

 */

public class LoginJSONGenerator {
    LoginRequest request;

    public LoginJSONGenerator(LoginRequest request) {
        this.request = request;
    }


    public String getJSONString() {
        try {
            
        	JSONObject login = new JSONObject();
            
            login.put("email", request.email);
        	login.put("password", request.password);
                       
            StringWriter out = new StringWriter();
            
            login.write(out);
            
            //((String)login).writeJSONString(out);
            
            String jsonText = out.toString();
            System.out.println("Login payload: " +jsonText);
                        
            return jsonText;
            
        } catch (Exception e) {
            return null;
        }
    }

}