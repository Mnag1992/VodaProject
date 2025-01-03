package stepDefinitionSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import baseproject.initializeAndLaunch;
import commonMethods.CommonFunc;
import commonMethods.WaitFunc;
import utility.Log;
import webElement.NewCustOrderWebElement;

public class NewCustomerOrderStep extends initializeAndLaunch {
	public WebDriver driver = getDriver();
    
	NewCustOrderWebElement element = new NewCustOrderWebElement(driver);
	CommonFunc CommonMethods = new CommonFunc(driver);
	WaitFunc wait = new WaitFunc(driver);
	
	public void launchVfUkUrl() {
		try {
			CommonMethods.highlightElement(element.acceptAllCookies);
			element.acceptAllCookies.click();
			Log.info("Accept all cookies clicked");
			wait.threadWait(2000);
			String title = driver.getTitle();
			Assert.assertEquals(title, "Vodafone - Our Best Ever Network | Now With 5G","Title not matched hence failed");
			Log.info("Vodafone UK site opened successfully");
			
		}catch(Exception e) {
			Log.error("Exception occurred while verifying Vodafone UK Url is launched");
			Assert.assertFalse(true,"Exception occurred while verifying Vodafone UK Url is launched");
		}
	}
	
	public void hoverOnShop() {
		try {
			wait.explicitWait(element.shopElement);
			CommonMethods.moveToElement(element.shopElement);
			Log.info("Hovered to shop");
			wait.threadWait(2000);
			Assert.assertTrue(element.ipadTabletText.isDisplayed(), "Hovered on shop failed");
			Log.info("Hovered on shop successfully");
			
		}catch(Exception e) {
			Log.error("Exception occurred while verifying item visibility after hovered on shop");
			Assert.assertFalse(true,"Exception occurred while verifying item visibility after hovered on shop");
		}
	}
	
	public void clickOnHyperlink(String item) {
		try {
			WebElement itemElement = driver.findElement(By.xpath("//a[contains(text(),'"+item+"')]"));
			CommonMethods.moveToElement(itemElement);
			Log.info("Moved to element "+itemElement);
			wait.explicitWait(itemElement);
			CommonMethods.highlightElement(itemElement);
			itemElement.click();
			Log.info(itemElement+" clicked successfully");
			wait.waitForLoaderToDisappear();
		}catch(Exception e) {
			Log.error("Exception occurred while clicking on hperlink "+item);
		}
	}
	
	public void clickOnDevice(String item) {
		try {
			WebElement itemElement = driver.findElement(By.xpath("//h2[text()='"+item+"']"));
			CommonMethods.moveToElement(itemElement);
			Log.info("Moved to element "+itemElement);
			wait.explicitWait(itemElement);
			CommonMethods.highlightElement(itemElement);
			itemElement.click();
			Log.info(itemElement+" clicked successfully");
			wait.waitForLoaderToDisappear();
		}catch(Exception e) {
			Log.error("Exception occurred while clicking on device "+item);
		}
	}
	
	public void clickOnNewCust() {
		try {
			wait.explicitWait(element.newCustElement);
			CommonMethods.highlightElement(element.newCustElement);
			element.newCustElement.click();
			Log.info("I am new customer has been clicked");
			wait.waitForLoaderToDisappear();
		}catch(Exception e) {
			Log.error("Exception occurred while clicking on I am new customer ");
		}
	}
	
	public void scrollUp() {
		try {
			CommonMethods.scrollUp();
			Log.info("Scroll bar has been moved up successfully");
		}catch(Exception e) {
			Log.error("Exception occurred while scrolling up ");
		}
	}
	
	public void verifyColorOfSamsungIpadTab() {
		try {
			wait.explicitWait(element.spaceBlackElement);
			CommonMethods.highlightElement(element.spaceBlackElement);
			Assert.assertEquals(element.spaceBlackElement.getCssValue("background-color"), "rgba(46, 44, 46, 1)", "Space black ipad assertion failed");
			Log.info("Space black ipad assertion Passed");
		}catch(Exception e) {
			Log.error("Exception occurred while verifying color of ipad "+ e);
	        Assert.assertFalse(true,"Exception occurred while verifying color of ipad");
		}
	}
}
