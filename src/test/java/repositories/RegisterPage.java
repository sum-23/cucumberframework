package repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver = null;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstName;

	@FindBy(id = "input-lastname")
	private WebElement lastName;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-telephone")
	private WebElement telephone;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;

	@FindBy(name = "newsletter")
	private WebElement newsletter;

	@FindBy(name = "agree")
	private WebElement privacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//div[text()='Warning: E-Mail Address is already registered!']")
	private WebElement invalidEmailMessage;

	@FindBy(xpath = "//div[text()='Warning: You must agree to the Privacy Policy!']")
	private WebElement privacyPolicyWarningMessage;

	@FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement lastNameWarningMessage;

	@FindBy(xpath = "//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement telephoneWarningMessage;

	@FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
	private WebElement passwordWarningMessage;

	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement emailWarningMessageElement;

	public void enterFirstName(String firstName) {

		this.firstName.sendKeys(firstName);

	}

	public void enterLastName(String lastName) {

		this.lastName.sendKeys(lastName);

	}

	public void enterEmail(String email) {

		this.email.sendKeys(email);

	}

	public void enterTelephone(String telephone) {

		this.telephone.sendKeys(telephone);

	}

	public void enterPassword(String password) {

		this.password.sendKeys(password);

	}

	public void enterConfirmPassword(String confirmPassword) {

		this.confirmPassword.sendKeys(confirmPassword);

	}

	public void selectSubsciptionYes() {

		newsletter.click();

	}

	public void selectPrivacyPolicy() {

		privacyPolicy.click();

	}

	public AccountPage clickOnContinueButton() {

		continueButton.click();
		return new AccountPage(driver);

	}

	public boolean checkInvalidEmailMessage() {

		return invalidEmailMessage.isDisplayed();

	}

	public WebElement privacyPolicyWarningMessage() {

		return privacyPolicyWarningMessage;

	}

	public WebElement firstNameWarningMessage() {

		return firstNameWarningMessage;

	}

	public WebElement lastNameWarningMessage() {

		return lastNameWarningMessage;

	}

	public WebElement telephoneWarningMessage() {

		return telephoneWarningMessage;

	}

	public WebElement passwordWarningMessage() {

		return passwordWarningMessage;

	}

	public WebElement emailWaringMessageElement() {

		return emailWarningMessageElement;

	}

}
