package stepDefinition;

import utility.Log;

import org.openqa.selenium.WebDriver;
import baseproject.initializeAndLaunch;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends initializeAndLaunch {
	protected WebDriver driver = getDriver();
	
	@Before
	public void BeforeSteps(Scenario scenario) {
		WebDriverManager.chromedriver().setup();
		String testCase = scenario.getName();
		Log.startTestCase(testCase);
	}
	
	@After
	public void AfterSteps(Scenario scenario) {
		Log.endTestCase("Scenario Finished");
		driver.quit();
	}

}
