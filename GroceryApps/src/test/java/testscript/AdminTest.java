package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constant;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminTest extends TestNGBase {
	HomePage hp;
	AdminPage ap;
	@Test(description="user is able to add new user data")
public void verifyUserAbleToAddNewUserData() throws IOException {
		String usernamevalue=ExcelUtility.readStringData(0, 0, "loginpage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "loginpage");
			LoginPage lp=new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnLoginButton();
		
		
		ap=hp.clickOnMoreInfo();
		RandomDataUtility rdu=new RandomDataUtility();
		String newusernamevalue =rdu.randomusername();
		String newpasswordvalue =rdu.randompassword();
		
		ap.clickOnNewButton().enterUserName(newusernamevalue).enterPassword(newpasswordvalue).userTypeInput().saveButton();
	    Boolean userdatadisplayed=ap.userIsPresent();
		Assert.assertTrue(userdatadisplayed,Constant.VALIDATENEWUSERNAMECANBEADDED);
		
		
	
}
	@Test(description="user is able to search data")
	public void verifyUserAbleToSearch() throws IOException {
		String usernamevalue=ExcelUtility.readStringData(0, 0, "loginpage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "loginpage");
			LoginPage lp=new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnLoginButton();
		
		ap=hp.clickOnMoreInfo();
		String newusernamevalue=ExcelUtility.readStringData(0, 0, "newuser");
		
		ap.clickOnSearchButton().enterUserData(newusernamevalue).userTypeValue().forSearching();
		Boolean userdatadisplay=ap.userDataIsPresent();
		Assert.assertTrue(userdatadisplay,Constant.VALIDATEUSERABLETOSEARCH);
		
	}
	@Test(description="user able is to use reset")
	public void verifyuserAbleToUseResetButton() throws IOException {
		String usernamevalue=ExcelUtility.readStringData(0, 0, "loginpage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "loginpage");
			LoginPage lp=new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnLoginButton();
		
		ap=hp.clickOnMoreInfo();
		
		
		
		ap.resetData();
		 Boolean userdatadisplayed=ap.userIsPresent();
			Assert.assertTrue(userdatadisplayed,Constant.VALIDATEUSERABLETORESET);
		
	}
}
