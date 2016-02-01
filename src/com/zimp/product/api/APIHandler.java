package com.zimp.product.api;

import com.cuelogic.framework.network.HTTPHelper;
import com.cuelogic.framework.network.HTTPParser;
import com.cuelogic.framework.network.HTTPRequest;
import com.cuelogic.framework.network.HTTPResponse;

/**
 * Created by ninad on 15/01/16.
 *
 * Base class for the the API's that would be implemented
 */
public abstract class APIHandler implements HTTPParser {

	protected HTTPResponse response;

	public abstract void parseAndVerifyAPIResponse();

	public abstract void httpRequestFailed(Exception e);

	public void sendHTTPPostRequest(HTTPRequest request) throws Exception {
		//response = null;
		System.out.println("Sending POST Request");
		HTTPHelper httpClient = new HTTPHelper(this);
		httpClient.sendPOSTRequest(request);
	}

	public boolean verifyHTTPCode(int code) {
		if (response.statusCode.intValue() == code) {
			return true;
		} else {
			return false;
		}
		// return response.statusCode == code;
	}

	public String getPayload() {
		return response.payload;
	}

	@Override
	public void onResponseRecevied(HTTPResponse response) {
		this.response = response;
		System.out.println(response.payload);
		parseAndVerifyAPIResponse();
	}

	@Override
	public void onRequestFailed(Exception e) {
		httpRequestFailed(e);
	}
}