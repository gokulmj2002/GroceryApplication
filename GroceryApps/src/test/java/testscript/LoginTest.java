package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.BaseDemo;
import automationcore.TestNGBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	HomePage home;
	@Test(priority=1,description="user is trying to login with valid credentials",groups= {"smoke"})
	public void validateUserLoginWithValidCredentials() throws IOException {
		String usernamevalue=ExcelUtility.readStringData(0, 0, "loginpage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "loginpage");
			LoginPage lp=new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home=lp.clickOnLoginButton();
		Boolean dashboarddisplayed=lp.dashboardTilePresent();
		Assert.assertTrue(dashboarddisplayed,Constant.VALIDCREDENTIALERROR);
		
		
	}

		@Test(priority=2,description="user is trying to login with invalids username and valid password",retryAnalyzer=retry.Retry.class)
		public void validateUserWithInvalidUserNameValidPassword() throws IOException {
			String usernamevalue=ExcelUtility.readStringData(1, 0, "loginpage");
			String passwordvalue=ExcelUtility.readStringData(1, 1, "loginpage");
				LoginPage lp=new LoginPage(driver);
			lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnLoginButton();
			String expected="7rmart supermarket";
			String actual=lp.titleGet();
			Assert.assertEquals(actual, expected,Constant.VALIDATEUSERWITHINVALIDUSERANDVALIDPASSWORD);
		}
		@Test(priority=3,description="user is trying to login with valid username and invalid password")
		public void validateUserWithvalidUserNameInValidPassword() throws IOException {
			String usernamevalue=ExcelUtility.readStringData(2, 0, "loginpage");
			String passwordvalue=ExcelUtility.readStringData(2, 1, "loginpage");
				LoginPage lp=new LoginPage(driver);
			lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnLoginButton();
			String expected="7rmart supermarket";
			String actual=lp.titleGet();
			Assert.assertEquals(actual, expected,Constant.VALIDATEUSERWITHVALIDUSERANDVALIDPASSWORD);
		}
		@Test(priority=4,description="user is trying to login with valid credentials",groups= {"smoke"},dataProvider="loginProvider")
		public void validateUserWithInvalidUserNameAndInValidPassword(String usernamevalue,String passwordvalue) throws IOException {
			//String usernamevalue=ExcelUtility.readStringData(3, 0, "loginpage");
			//String passwordvalue=ExcelUtility.readStringData(3, 1, "loginpage");
				LoginPage lp=new LoginPage(driver);
			lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnLoginButton();
			String expected="7rmart supermarket";
			String actual=lp.titleGet();
			Assert.assertEquals(actual, expected, Constant.VALIDATEWITHINVALIDCREDENTIALS);
		}
		@DataProvider(name = "loginProvider")
		public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
		// new Object[] {ExcelUtility.getStringData(3,
		// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
		}
}