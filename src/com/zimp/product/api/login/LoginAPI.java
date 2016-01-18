package com.zimp.product.api.login;

import com.cuelogic.framework.network.ContentType;
import com.cuelogic.framework.network.HTTPRequest;
import com.cuelogic.framework.network.HTTPResponse;
import com.zimp.product.api.APIHandler;
import sun.jvm.hotspot.utilities.SystemDictionaryHelper;

import javax.swing.text.AbstractDocument;

/**
 * Created by ninad on 15/01/16.
 */
public class LoginAPI extends APIHandler {

    private HTTPRequest generateLoginRequest (LoginRequest loginRequest) {
        HTTPRequest httpRequest = new HTTPRequest();
        httpRequest.contentType = ContentType.JSON;
        httpRequest.url = "http://ec2-52-2-75-121.compute-1.amazonaws.com:4000/users/login"; // Generate URL
        httpRequest.payload = new LoginJSONGenerator(loginRequest).getJSONString();
        return httpRequest;
    }


    private void triggerLogin(LoginRequest request) {
        try {
            sendHTTPPostRequest(generateLoginRequest(request));
        } catch (Exception e) {

        }
    }

    public boolean loginVerifySuccess(LoginRequest request) {
        triggerLogin(request);
        return true;
    }

    public boolean loginVerifyFailure(LoginRequest request) {
        return true;
    }

    public boolean loginVerifyFailure(LoginRequest request, Integer expectedStatusCode) {
        return true;
    }

    @Override
    public void parseAndVerifyAPIResponse() {
        if (verifyHTTPCode(200) == true) {
            String payload = getPayload();
            System.out.println(payload);

            LoginResponseParser parser = new LoginResponseParser(payload);
            LoginResponse response = parser.getResponse();
            System.out.println(response.email);
        }
    }

    @Override
    public void httpRequestFailed(Exception e) {

    }
}
