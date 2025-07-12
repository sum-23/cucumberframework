package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import repositories.AccountPage;
import repositories.HomePage;
import repositories.LoginPage;
import utils.Utility;

public class Login1 {

	WebDriver driver = null;
	private LoginPage lp = null;
	private AccountPage ap = null;
	DriverFactory df = null;

	@Given("User navigates to login page")
	public void User_navigates_to_login_page() {

		df = new DriverFactory();
		driver = df.getDriver();
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		lp = hp.clickOnLoginOption();

	}

	@When("^User enters valid email (.*)$")
	public void user_enters_valid_email(String email) {

		lp.enterEmail(email);

	}

	@And("^User enters valid password (.*)$")
	public void user_enters_valid_password(String password) {

		lp.enterPassword(password);

	}

	@And("Click on login button")
	public void click_on_login_button() {

		ap = lp.clickOnLoginButton();

	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {

		Assert.assertTrue(ap.editAccountText());

	}

	@When("User enters invalid email")
	public void user_enters_invalid_email() {

		lp.enterEmail((new Utility()).getEmailTimeStamp());

	}

	@And("User enters invalid password {string}")
	public void user_enter_invalid_password(String password) {

		lp.enterPassword(password);

	}

	@Then("Invalid credentials warning message should display")
	public void invalid_credentials_waring_message_should_display() {

		Assert.assertTrue(lp.isErrorMessageDisplay());

	}

	@When("Don't enter any credentials")
	public void don_t_enter_any_email() {

		// Nothing to execute
		Assert.fail();

	}

}
