package com.cuelogic.framework.network;

/**
 * Created by ninad on 14/01/16.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;


public class HTTPHelper {

    private HTTPParser listener;

    public HTTPHelper(HTTPParser listener) {
        this.listener = listener;
    }

    private String getAllDataFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String data = new String();
        String buffer;
        while ((buffer = reader.readLine()) != null) {
            data += buffer;
        }
        return  data;
    }

    private void convertAndSendResponse(HttpResponse libHTTPResponse) {
        try {
            HTTPResponse response = new HTTPResponse();

            response.statusCode = libHTTPResponse.getStatusLine().getStatusCode();
            response.payload = getAllDataFromInputStream(libHTTPResponse.getEntity().getContent());

            listener.onResponseRecevied(response);
        } catch (Exception e) {
            listener.onRequestFailed(e);
        }
    }

    public void sendPOSTRequest (HTTPRequest request) {

        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            StringEntity input = new StringEntity(request.payload);
            input.setContentType(request.contentType.toString());

            HttpPost postRequest = new HttpPost(request.url);
            postRequest.setEntity(input);
            HttpResponse response = httpClient.execute(postRequest);
            convertAndSendResponse(response);

        } catch (Exception e) {
            listener.onRequestFailed(e);
        }
    }

}
