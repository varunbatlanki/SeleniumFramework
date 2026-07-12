package dataproviders;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class LoginDataProvider {

	@DataProvider(name = "loginData")
	

	public static Object[][] loginData() {

		return ExcelUtils.getTestData(

				"src/test/resources/testdata/LoginData.xlsx",

				"Login");

	}

}