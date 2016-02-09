package test.com.zimp.product.api.login;

import org.junit.Test;
import com.zimp.product.api.login.LoginAPI;
import com.zimp.product.api.login.LoginRequest;
import static org.junit.Assert.*;

/**
 * Created by ninad on 15/01/16.
 */
public class LoginAPITest {

    @Test
    public void testLoginVerifySuccess() throws Exception {
        LoginAPI login = new LoginAPI();
        
        LoginRequest request = new LoginRequest();
        /*request.email = "gaurav@cuelogic.com";	
        request.password = "asdf123";*/
        
        request.email = "gauravm@yopmail.com";
        request.password = "Demo@12345";
        
        login.loginVerifySuccess(request);

        assertTrue(true);
    }
}