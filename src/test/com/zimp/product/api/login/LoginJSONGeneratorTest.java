package test.com.zimp.product.api.login;

import org.junit.Test;

import com.zimp.product.api.login.LoginJSONGenerator;
import com.zimp.product.api.login.LoginRequest;

import static org.junit.Assert.*;

/**
 * Created by ninad on 15/01/16.
 */
public class LoginJSONGeneratorTest {

    @Test
    public void testLoginJSONRequest() {
        LoginRequest request = new LoginRequest();
        /*request.email = "abc@abc.com";
        request.password = "122334";*/
        
        request.email = "gauravm@yopmail.com";
        request.password = "Demo@12345";
                
        
        LoginJSONGenerator generator = new LoginJSONGenerator(request);
           
        System.out.println("Login JSON String: " + generator.getJSONString());

        assertTrue(true);
    }

}