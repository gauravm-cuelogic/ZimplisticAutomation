package com.cuelogic.framework.network;

/**
 * Created by ninad on 14/01/16.
 */

public interface HTTPParser {
    void onResponseRecevied(HTTPResponse response);
    void onRequestFailed(Exception e);
}