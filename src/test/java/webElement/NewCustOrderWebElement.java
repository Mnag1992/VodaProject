package webElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseproject.initializeAndLaunch;

public class NewCustOrderWebElement {
	WebDriver driver;
	
	public NewCustOrderWebElement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	public WebElement acceptAllCookies;
	
	@FindBy(xpath = "//div[contains(text(),'Shop')]")
	public WebElement shopElement;
	
	@FindBy(xpath = "//a[contains(text(),'iPad and tablets')]")
	public WebElement ipadTabletText;
	
	@FindBy(xpath = "//h2[text()='iPad Pro 13-inch (M4)']")
	public WebElement ipadElement;
	
	@FindBy(xpath = "//button[@data-cy='device-modal-button']")
	public WebElement newCustElement;
	
	@FindBy(xpath = "//span[text()='Space Black']/preceding-sibling::span/span")
	public WebElement spaceBlackElement;

}
