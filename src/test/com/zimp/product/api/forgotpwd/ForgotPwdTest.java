package test.com.zimp.product.api.forgotpwd;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.zimp.product.api.forgotpwd.ForgotPwdAPI;
import com.zimp.product.api.forgotpwd.ForgotPwdRequest;

public class ForgotPwdTest {

	@Test
	public void testForgotPwdVerifySuccess() throws Exception {
		ForgotPwdAPI forgotPwd = new ForgotPwdAPI();

		ForgotPwdRequest request = new ForgotPwdRequest();
		/*
		 * request.email = "gaurav@cuelogic.com"; request.password = "asdf123";
		 */

		request.email = "gauravm@yopmail.com";
		request.logintype = 0;

		forgotPwd.forgotPwdVerifySuccess(request);

		assertTrue(true);
	}

}