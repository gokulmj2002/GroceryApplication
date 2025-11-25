package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotUtility;

public class TestNGBase {
	Properties pro;
	FileInputStream fis;
	public WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
public void initializeBrowser(String browsers) throws IOException {
		
		pro=new Properties();
		fis= new FileInputStream(Constant.CONFIGFILE);
		pro.load(fis);
		if(browsers.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browsers.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver();
			driver=new EdgeDriver();
		}
	
	driver.get(pro.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
	@AfterMethod(alwaysRun=true)
	public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			ScreenShotUtility screenShot = new ScreenShotUtility();
		screenShot.getScreenshot(driver, iTestResult.getName());
		}
		//driver.quit();

		}

}
