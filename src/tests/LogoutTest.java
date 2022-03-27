package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import messages.URL;

public class LogoutTest extends BaseTest{
	
	
	@Test
	public void loggingOut() {
		page.login.authenticate(testData.mainUser);
		Assert.assertEquals(URL.PRODUCTS,driver.getCurrentUrl());
		page.menu.clickOnMenu();
		page.menu.clickOnLogoutLink();
		Assert.assertEquals(URL.LOGIN,driver.getCurrentUrl());	
	}

}
