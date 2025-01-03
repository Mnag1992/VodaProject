package commonMethods;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;


public class WaitFunc {
	protected WebDriver driver;
	
	public WaitFunc(WebDriver driver) {
		this.driver = driver;
	}
	
	public void threadWait(int time) throws InterruptedException {
		Thread.sleep(time);
		Log.info("Wait of "+time+ " applied");
	}
	
	public void explicitWait(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(element));
			Log.info(element+ " Element is visible after waiting explicitly");
		}catch(Exception e) {
			Log.error("Exception occurred in explicit wait while waiting for element to be visible");
		}
		
	}
	
	public void fluentWait(WebElement element) {
		try {
			FluentWait wait = new FluentWait(driver);
			wait.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e) {
			Log.error("Exception occurred in fluent wait while waiting for element to be visible");
		}
	}
	
	public void waitForLoaderToDisappear() {
		try {
			FluentWait wait = new FluentWait(driver);
			wait.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'Spinner')]")));
			Log.error("Exception occurred in fluent wait while waiting for element to be visible");
		}catch(Exception e) {
			Log.error("Exception occurred while waiting for loader to disappear");
		}
		
	}

}
