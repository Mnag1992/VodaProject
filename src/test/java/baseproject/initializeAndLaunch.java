package baseproject;

import java.io.File;

import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Log;

import org.apache.log4j.xml.DOMConfigurator;	

public class initializeAndLaunch {
	protected static WebDriver driver;
	
	public void launchBrowser() {
		driver = new ChromeDriver();
		System.out.println("Launching chrome browser");
		driver.get("https://www.vodafone.co.uk/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	public initializeAndLaunch() {
		if(driver == null) {
			initiateLogger();
			launchBrowser();
			
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void initiateLogger() {
		String currentDateTime = new DateTime().toString("dd-MM-yy HH:mm;ss");
		String replaceHyphn = currentDateTime.replace('-','_');
		String dateTime = replaceHyphn.replace(':', '_');
		String LogPath = System.getProperty("user.dir")+File.separator+"report"+File.separator+"Log Reports"+File.separator+"logfile"+dateTime+".html";
		System.setProperty("LogFilePath",LogPath);
		DOMConfigurator.configure("log4j.xml");
	}
	
}
