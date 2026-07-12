package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SearchPage;

public class SearchTest extends BaseTest {

	@Test

	public void verifyEmployeeSearch() {

		LoginPage login = new LoginPage();

		DashboardPage dashboard = login.login("Admin", "admin123");

		SearchPage search = dashboard.goToPIM();
		

	//	search.searchEmployee("Linda");

	}

}