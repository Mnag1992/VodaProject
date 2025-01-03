package commonMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Log;

public class CommonFunc {
	protected WebDriver driver;
	
	public CommonFunc(WebDriver driver) {
		this.driver = driver;
	}
	
	public void scrollUp() {
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		Log.info("Scroll bar moved to top");
		}catch(Exception e) {
			Log.error("Exception occurred while scrolling up");
		}
	
	}
	
	public void moveToElement(WebElement element) {
		try {
		Actions mouseAction = new Actions(driver);
		highlightElement(element);
		mouseAction.moveToElement(element).build().perform();
		Log.info("Mouse successfully hovered to element"+ element);
		}catch(Exception e) {
			Log.error("Exception occurred while moving to element "+ element);
		}
	}
	
	public void highlightElement(WebElement element) {
		try {
			if (driver instanceof JavascriptExecutor) {
		        ((JavascriptExecutor)driver).executeScript("arguments[0].style.background='yellow'", element);
		    }
		}catch(Exception e) {
			Log.error("Exception occurred while highlighting element "+ element);
		}
		
	}

}
