package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this); //to initialise elements initElements is used
	
}
WaitUtility wait=new WaitUtility();
@FindBy(name="username") WebElement user;
@FindBy(name="password") WebElement loginpassword;
@FindBy(tagName="button") WebElement signin;
@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement title;

public LoginPage enterUserNameOnUserNameField(String usernamevalue) {
	user.sendKeys(usernamevalue);
	return this;
}
public LoginPage enterPasswordOnPasswordField(String passwordvalue) {
	loginpassword.sendKeys(passwordvalue);
	return this;
}
public HomePage clickOnLoginButton() {
	wait.waitUntilElementToBeClickable(driver, signin);
	signin.click();
	return new HomePage(driver);
}
public boolean dashboardTilePresent() {
	return dashboard.isDisplayed();
}
public String titleGet() {
	return title.getText();
}
}
