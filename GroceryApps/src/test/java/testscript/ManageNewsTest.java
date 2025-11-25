package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase {
	HomePage hp;
	ManageNewsPage mnp;
@Test(description="user is able to add new news title")
	public void verifyUserAbleToAddNews() throws IOException {
		String usernamevalue=ExcelUtility.readStringData(0, 0, "loginpage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "loginpage");
			LoginPage lp=new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnLoginButton();
		
		mnp=hp.clickOnMoreInfoOnManageNewstile();
		
		
		mnp.clickOnNew();
		String newstitle=ExcelUtility.readStringData(0, 0, "managenews");
		mnp.addNewsToTheNewsField(newstitle).clickSaveButton();
		Boolean alertdisplayed=mnp.alertTitleDisplayed();
		Assert.assertTrue(alertdisplayed,Constant.VALIDATEUSERABLETOADDNEWS);
		
		
	}
@Test(description="user is able to search the news title")
public void verifyUserAbleToSearchNews() throws IOException {
	String usernamevalue=ExcelUtility.readStringData(0, 0, "loginpage");
	String passwordvalue=ExcelUtility.readStringData(0, 1, "loginpage");
		LoginPage lp=new LoginPage(driver);
	lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
	hp=lp.clickOnLoginButton();
	
	mnp=hp.clickOnMoreInfoOnManageNewstile();
	
	mnp.clickSearchButton();
	String newstitle=ExcelUtility.readStringData(0, 0, "managenews");
	mnp.addNewsInSearchTab(newstitle).clickOnSearch();
	Boolean searchresultdisplayed=mnp.searchResultIsDisplayed();
	Assert.assertTrue(searchresultdisplayed,Constant.VALIDATEUSERABLETOSEARCHNEWSTITLE);
	
	
}
}
