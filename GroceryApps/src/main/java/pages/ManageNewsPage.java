package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
public WebDriver driver;
public ManageNewsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newnews;
@FindBy(xpath="//textarea[@id='news']")WebElement addnews;
@FindBy(xpath="//button[@type='submit']")WebElement save;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement search;
@FindBy(xpath="//input[@placeholder='Title']")WebElement newsinsearchtab;
@FindBy(xpath="//button[@name='Search']")WebElement searchbutton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
@FindBy(xpath="//td[text()='19yr old murdered']")WebElement searchresult;



public ManageNewsPage clickOnNew() {
	newnews.click();
	return this;
}
public ManageNewsPage addNewsToTheNewsField(String newstitle) {
	addnews.sendKeys(newstitle);
	return this;
}
public ManageNewsPage clickSaveButton() {
	save.click();
	return this;
}
public  ManageNewsPage clickSearchButton() {
	search.click();
	return this;
}
public ManageNewsPage addNewsInSearchTab(String newstitle) {
	newsinsearchtab.sendKeys(newstitle);
	return this;
}
public ManageNewsPage clickOnSearch() {
	searchbutton.click();
	return this;
}
public boolean alertTitleDisplayed() {
	return alert.isDisplayed();
}
public boolean searchResultIsDisplayed() {
	return searchresult.isDisplayed();
	
}
}
