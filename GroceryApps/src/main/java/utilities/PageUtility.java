package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDragDropWithValue(WebElement element, String value) {
	    Select object=new Select(element);
	    object.selectByValue(value); 
	}
	public void selectDragDropWithIndex(WebElement element,int index) {
	    Select object=new Select(element);
	    object.selectByIndex(index); 
	}
	public void selectDragDropWithVisibleText(WebElement element,String value) {
	    Select object=new Select(element);
	    object.selectByVisibleText(value);
	}
	public void mouseover(WebElement element,WebDriver driver) {
		Actions a= new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	public void click(WebElement element) {
		element.click();
	}
	public void click(WebElement element,String value) {
		element.sendKeys(value);
	}

}
