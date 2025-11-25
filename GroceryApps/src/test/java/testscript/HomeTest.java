package testscript;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseDemo;
import automationcore.TestNGBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase  {
	HomePage hp;
	@Test(description="user is able to logout successfully")
	public void verifyUserAbleToSuccessfullyLogout() throws IOException {
		
		
		String usernamevalue=ExcelUtility.readStringData(0, 0, "loginpage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "loginpage");
			LoginPage lp=new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnLoginButton();
		
			hp.clickOnAdminButton();
			lp=hp.clickOnLogOutButton();
			Boolean pagetitledisplayed=hp.pageTitleIsDisplayed();
			Assert.assertTrue(pagetitledisplayed,Constant.VALIDATEUSERABLETOLOGOUTSUCCESSSFULLY);	
	}

}
