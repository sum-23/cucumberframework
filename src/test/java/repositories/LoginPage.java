package repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver = null;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement errorMessage;

	public void enterEmail(String email) {

		emailField.sendKeys(email);

	}

	public void enterPassword(String password) {

		passwordField.sendKeys(password);

	}

	public AccountPage clickOnLoginButton() {

		loginButton.click();
		
		return new AccountPage(driver);
		

	}

	public boolean isErrorMessageDisplay() {

		return errorMessage.isDisplayed();

	}

	public void performLogin(String email, String password) {

		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();

	}

}
