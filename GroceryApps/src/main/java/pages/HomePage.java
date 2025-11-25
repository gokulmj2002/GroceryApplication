package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) { //constructor
		this.driver=driver;
		PageFactory.initElements(driver, this); //to initialise elements initElements is used
		
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement adminbutton;
	@FindBy(xpath="//a[@class='dropdown-item']//child::i[@class='ace-icon fa fa-power-off']")WebElement logout;
	@FindBy(xpath="//a[@class='small-box-footer'and@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement moreinfo;
	@FindBy(xpath="//a[@class='small-box-footer'and@href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement managenewsmoreinfo;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement pagetitle;
	
	public HomePage clickOnAdminButton() {
		adminbutton.click();
		return this;
	}
	public LoginPage clickOnLogOutButton() {
		logout.click();
		return new LoginPage(driver);
	}
	public AdminPage clickOnMoreInfo() {
		moreinfo.click();
		return new AdminPage(driver);
	}
	public ManageNewsPage clickOnMoreInfoOnManageNewstile() {
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}
	public boolean pageTitleIsDisplayed() {
		return pagetitle.isDisplayed();
	}
}
