package com.cuelogic.framework.network;

import org.junit.Assert;
import org.junit.Test;
import sun.jvm.hotspot.utilities.AssertionFailure;
import sun.jvm.hotspot.utilities.SystemDictionaryHelper;

import static org.junit.Assert.*;

/**
 * Created by ninad on 14/01/16.
 */
public class HTTPHelperTest implements HTTPParser {

    @Test
    public void testSendPOSTRequest() throws Exception {
        HTTPRequest request = new HTTPRequest();
//        request.url = "";

        request.url = "http://ec2-52-2-75-121.compute-1.amazonaws.com:4000/users/login";
        request.contentType = ContentType.JSON;
        request.payload = "{\"email\": \"gaurav@cuelogic.com\",\"password\": \"asdf123\"}";

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