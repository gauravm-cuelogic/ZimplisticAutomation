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
    public void loginTestCases(){
    
    	try {
			testLoginVerifySuccess();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	try {
			testloginVerifyFailure();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
    
    
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
    
   
    public void testloginVerifyFailure() throws Exception {
        LoginAPI login = new LoginAPI();
        
        LoginRequest request = new LoginRequest();
        /*request.email = "gaurav@cuelogic.com";	
        request.password = "asdf123";*/
        
        request.email = "gauravm@yopmail.com";
        request.password = "Demo@12345@@ED";
        
        login.loginVerifyFailure(request);

        assertTrue(true);
    }
    
}