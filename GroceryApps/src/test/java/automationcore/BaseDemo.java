package automationcore;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotUtility;

public class BaseDemo {
	public WebDriver driver;
	@BeforeMethod
	
public void initializeBrowser() {
		 
			driver=new ChromeDriver();
		
	
	driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
	@AfterMethod
	public void driverQuit() {

		
		//driver.quit();

		}

}
