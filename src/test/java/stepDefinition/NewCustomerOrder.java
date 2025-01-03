package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitionSteps.NewCustomerOrderStep;

public class NewCustomerOrder {
	NewCustomerOrderStep newCustomerOrderStep = new NewCustomerOrderStep();
	
	@Given("Launch Vodafone UK url")
	public void launch_vodafone_uk_url() {
		newCustomerOrderStep.launchVfUkUrl();
	}
	
	@When("Hover on shop")
	public void hover_on_shop() {
		newCustomerOrderStep.hoverOnShop();
	}
	
	@And("Click on hyperlink {string}")
	public void click_on_hyperlink(String item) {
		newCustomerOrderStep.clickOnHyperlink(item);
	}
	
	@And("Click on device {string}")
	public void click_on_device(String item) {
		newCustomerOrderStep.clickOnDevice(item);
	}
	
	@And("Click on I am new customer")
	public void click_on_iamnewcustomer() {
		newCustomerOrderStep.clickOnNewCust();
	}
	
	@And("Scroll up")
	public void scroll_up() {
		newCustomerOrderStep.scrollUp();
	}
	
	@Then("Verify color of Samsung ipad tablet")
	public void verify_color_of_Samsung_ipad_tablet() {
		newCustomerOrderStep.verifyColorOfSamsungIpadTab();
	}
}
