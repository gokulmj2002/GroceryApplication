package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminPage {
	public WebDriver driver;
	public AdminPage(WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
}
	PageUtility page=new PageUtility();
@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newbutton;
@FindBy(xpath="//input[@id='username']") WebElement newuserinput;
@FindBy(xpath="//input[@id='password']") WebElement newpasswordinput;
@FindBy(xpath="//select[@id='user_type']") WebElement usertypeinput;
@FindBy(xpath="//button[@name=\"Create\"]") WebElement save;
@FindBy(xpath="//body[@style='height: auto;']")WebElement userdata;
@FindBy(xpath="//a[@onclick='click_button(2)'and@class='btn btn-rounded btn-primary']")WebElement search;
@FindBy(xpath="//input[@id='un']")WebElement uservalue;
@FindBy(xpath="//select[@id='ut']")WebElement usertype;
@FindBy(xpath="//button[@type='submit'and@name='Search']")WebElement searching;
@FindBy(xpath="//body[@style='height: auto;']")WebElement userdatavalue;
@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")WebElement reset;
@FindBy(xpath="//a[@class='small-box-footer'and@href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement managenewsmoreinfo;

public AdminPage clickOnNewButton(){
	newbutton.click();
	return this;
}
public AdminPage enterUserName(String newusernamevalue) {
	newuserinput.sendKeys(newusernamevalue);
	return this;
}
public AdminPage enterPassword(String newpasswordvalue) {
	newpasswordinput.sendKeys(newpasswordvalue);
	return this;
}
public AdminPage userTypeInput() {
	page.selectDragDropWithVisibleText(usertypeinput, "Admin");
	return this;
	
}
public AdminPage saveButton() {
	save.click();
	return this;
}


public Boolean userIsPresent() {
	// TODO Auto-generated method stub
	return userdata.isDisplayed();
}
public AdminPage clickOnSearchButton() {
	search.click();
	return this;
}
public AdminPage enterUserData(String newusernamevalue) {
	uservalue.sendKeys(newusernamevalue);
	return this;
}
public AdminPage userTypeValue() {
	page.selectDragDropWithVisibleText(usertype,"Admin" );
	return this;
	
}
public AdminPage forSearching() {
	searching.click();
	return this;
}
public boolean userDataIsPresent() {
	return userdatavalue.isDisplayed();
}
public AdminPage resetData() {
	reset.click();
	return this;
}


}