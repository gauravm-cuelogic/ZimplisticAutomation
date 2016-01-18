package com.zimp.product.api.login;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ninad on 15/01/16.
 */
public class LoginAPITest {

    @Test
    public void testLoginVerifySuccess() throws Exception {
        LoginAPI login = new LoginAPI();

        LoginRequest request = new LoginRequest();
        request.email = "gaurav@cuelogic.com";
        request.password = "asdf123";

        login.loginVerifySuccess(request);

        assertTrue(true);
    }
}