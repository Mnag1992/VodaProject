package baseproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProject {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Launching chrome browser");
		driver.get("https://www.vodafone.co.uk/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebElement acceptAllCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
		acceptAllCookies.click();
		System.out.println("Accept all cookies clicked");
		Thread.sleep(2000);
		WebElement shopElement = driver.findElement(By.xpath("//div[contains(text(),'Shop')]"));
		Actions mouseAction = new Actions(driver);
		mouseAction.moveToElement(shopElement).build().perform();
		System.out.println("Hovered to shop");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'iPad and tablets')]")).click();
		Thread.sleep(5000);	
		WebElement ipadElement = driver.findElement(By.xpath("//h2[text()='iPad Pro 13-inch (M4)']"));
		mouseAction.moveToElement(ipadElement).build().perform();
		ipadElement.click();
		System.out.println("Ipad has been clicked");
		Thread.sleep(10000);
		WebElement newCustElement = driver.findElement(By.xpath("//button[@data-cy='device-modal-button']"));
		newCustElement.click();
		System.out.println("I am new customer has been clicked");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		WebElement spaceBlackElement = driver.findElement(By.xpath("//span[text()='Space Black']/preceding-sibling::span/span"));
		System.out.println(spaceBlackElement.getCssValue("background-color"));
		Assert.assertEquals(spaceBlackElement.getCssValue("background-color"), "rgba(46, 44, 46, 1)", "Space black ipad assertion failed");
		System.out.println("Space black ipad assertion Passed");
		driver.quit();

	}

}
