package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataproviders.LoginDataProvider;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)

	public void verifyLogin(String username,

			String password,

			String expectedResult) {

		LoginPage loginPage = new LoginPage();

		DashboardPage dashboard = loginPage.login(username, password);

		if ("PASS".equalsIgnoreCase(expectedResult)) {

			Assert.assertTrue(dashboard.isDashboardDisplayed());

		} else {

			Assert.assertFalse(dashboard.isDashboardDisplayed());

		}

	}

	@Test

	public void verifySuccessfulLogin() {

		LoginPage login = new LoginPage();

		DashboardPage dashboard = login.login("Admin", "admin123");

		Assert.assertTrue(dashboard.isDashboardDisplayed());

	}

}