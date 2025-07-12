package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import repositories.AccountPage;
import repositories.HomePage;
import repositories.RegisterPage;
import utils.Utility;

public class Register1 {

	WebDriver driver = null;
	private HomePage hp = null;
	private RegisterPage rp = null;
	private AccountPage ap = null;
	private DriverFactory df = null;
	
	@Given("User navigates to registration page")
	public void User_navigates_to_registration_page() {

		df = new DriverFactory();
		driver = df.getDriver();
		hp = new HomePage(driver);
		hp.clickOnMyAccount();
		rp = hp.clickOnRegisterOption();

	}

	@When("User enter below details")
	public void user_enter_below_details(DataTable data) {

		Map<String, String> dataMap = data.asMap(String.class, String.class);

		rp.enterFirstName(dataMap.get("firstName"));
		rp.enterLastName(dataMap.get("lastName"));
		rp.enterEmail((new Utility().getEmailTimeStamp()));
		rp.enterTelephone(dataMap.get("telephone"));
		rp.enterPassword(dataMap.get("password"));
		rp.enterConfirmPassword(dataMap.get("confirmPassword"));

	}

	@When("User enter below details with duplicate email")
	public void user_enter_below_details_with_duplicate_email(DataTable data) {

		Map<String, String> dataMap = data.asMap(String.class, String.class);

		rp.enterFirstName(dataMap.get("firstName"));
		rp.enterLastName(dataMap.get("lastName"));
		rp.enterEmail(dataMap.get("email"));
		rp.enterTelephone(dataMap.get("telephone"));
		rp.enterPassword(dataMap.get("password"));
		rp.enterConfirmPassword(dataMap.get("confirmPassword"));

	}

	@And("Check privacy policy")
	public void check_privacy_policy() {

		rp.selectPrivacyPolicy();

	}

	@And("Click on continue button")
	public void click_on_continue_button() {

		ap = rp.clickOnContinueButton();

	}

	@Then("User should register successfully")
	public void user_should_register_successfully() {

		Assert.assertTrue(ap.isSuccessMessageDisplay());

	}

	@When("Check subscribe yes")
	public void check_subscribe_yes() {

		rp.selectSubsciptionYes();

	}

	@Then("Error message of email should display")
	public void error_message_of_email_should_display() {

		Assert.assertTrue(rp.checkInvalidEmailMessage());

	}

	@When("Don't enter any details")
	public void don_t_enter_any_details() {

		// Nothing to run
		Assert.fail();

	}

	@Then("Warning message for mandatory fields should display")
	public void warning_message_for_mandatory_fields_should_display() {

		boolean isPrivacyPolicy = rp.privacyPolicyWarningMessage().isDisplayed();
		boolean isFirstName = rp.firstNameWarningMessage().isDisplayed();
		boolean isLastName = rp.lastNameWarningMessage().isDisplayed();
		boolean isEmail = rp.emailWaringMessageElement().isDisplayed();
		boolean isTelephone = rp.telephoneWarningMessage().isDisplayed();
		boolean isPassword = rp.passwordWarningMessage().isDisplayed();

		Assert.assertTrue(isPrivacyPolicy && isFirstName && isLastName && isEmail && isTelephone && isPassword);

	}

}
