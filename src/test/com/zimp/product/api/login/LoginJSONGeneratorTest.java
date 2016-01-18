package com.zimp.product.api.login;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ninad on 15/01/16.
 */
public class LoginJSONGeneratorTest {

    @Test
    public void testLoginJSONRequest() {
        LoginRequest request = new LoginRequest();
        request.email = "abc@abc.com";
        request.password = "122334";
        LoginJSONGenerator generator = new LoginJSONGenerator(request);
        System.out.println("Login JSON String: " + generator.getJSONString());

        assertTrue(true);
    }

}