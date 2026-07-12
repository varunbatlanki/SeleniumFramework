package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;

public class AdminTest extends BaseTest {

	@Test

	public void verifyAdminPage() {

		LoginPage login = new LoginPage();

		DashboardPage dashboard = login.login("Admin", "admin123");

		AdminPage adminPage = dashboard.goToAdmin();

		Assert.assertTrue(

				adminPage.isAdminPageDisplayed());

	}

}