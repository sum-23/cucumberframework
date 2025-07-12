package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import repositories.HomePage;
import repositories.SearchPage;

public class Search1 {

	WebDriver driver = null;
	private HomePage hp = null;
	private SearchPage sp = null;
	private DriverFactory df = null;

	@Given("User navigate to search page")
	public void user_navigate_to_search_page() {

		df = new DriverFactory();
		driver = df.getDriver();

	}

	@When("User enter valid product name {string}")
	public void user_enter_valid_product_name(String name) {

		hp = new HomePage(driver);
		hp.enterProductName(name);

	}

	@When("Click on search button")
	public void click_on_search_button() {

		sp = hp.clickOnSearchButton();

	}

	@Then("Valid product should display")
	public void valid_product_should_display() {

		Assert.assertTrue(sp.validProductDisplay());

	}

	@When("User enter invalid product name {string}")
	public void user_enter_invalid_product_name(String name) {

		hp = new HomePage(driver);
		hp.enterProductName(name);

	}

	@Then("User should get a message no product matching")
	public void user_should_get_a_message_no_product_matching() {

		Assert.assertTrue(sp.noResult());

	}

	@When("User doesn't enter any product name")
	public void user_doesn_t_enter_any_product_name() {

		hp = new HomePage(driver);

	}

}
