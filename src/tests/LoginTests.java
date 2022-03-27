package tests;

import org.junit.Assert;
import org.junit.Test;

import messages.Login;
import messages.URL;

public class LoginTests extends BaseTest{
	
	@Test
	public void loginWithValidCredentials() {
		page.login.authenticate(testData.mainUser);
		Assert.assertEquals(URL.PRODUCTS,driver.getCurrentUrl());
		
	}
	
	@Test
	public void loginWithInvalidCredentials() {
		testData.mainUser.setPassword("test");
		page.login.authenticate(testData.mainUser);
		Assert.assertEquals(Login.INVALID_USER_ERROR, page.login.getError());
		Assert.assertEquals(URL.LOGIN,driver.getCurrentUrl());	
	}
	

}
