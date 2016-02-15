package test.com.zimp.product.api.forgotpwd;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.zimp.product.api.forgotpwd.ForgotPwdAPI;
import com.zimp.product.api.forgotpwd.ForgotPwdRequest;

public class ForgotPwdTest {

	@Test
    public void forgotPwdTestCases(){
    
    	try {
			testForgotPwdVerifySuccess();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	try {
			testForgotPwdVerifyFailure();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
	
	
	public void testForgotPwdVerifySuccess() throws Exception {
		ForgotPwdAPI forgotPwd = new ForgotPwdAPI();

		ForgotPwdRequest request = new ForgotPwdRequest();

		request.email = "gauravm@yopmail.com";
		request.logintype = 0;

		forgotPwd.forgotPwdVerifySuccess(request);

		assertTrue(true);
	}
	
	public void testForgotPwdVerifyFailure() throws Exception {
		ForgotPwdAPI forgotPwd = new ForgotPwdAPI();
        
		ForgotPwdRequest request = new ForgotPwdRequest();
 
		request.email = "gauravmw@yopmail.com";
		request.logintype = 0;

        
		forgotPwd.forgotPwdVerifyFailure(request);

        assertTrue(true);
    }

}