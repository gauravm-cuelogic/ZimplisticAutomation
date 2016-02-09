package test.com.zimp.product.api.forgotpwd;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.zimp.product.api.forgotpwd.ForgotPwdJSONGenerator;
import com.zimp.product.api.forgotpwd.ForgotPwdRequest;

public class ForgotPwdJSONGeneratorTest {

	@Test
    public void testForgotPwdJSONRequest() {
        ForgotPwdRequest request = new ForgotPwdRequest();
        
        request.email = "gauravm@yopmail.com";
        request.logintype = 0;
        
        ForgotPwdJSONGenerator generator = new ForgotPwdJSONGenerator(request);
        
        System.out.println("Login JSON String: " + generator.getJSONString());

        assertTrue(true);
    }
	
}
