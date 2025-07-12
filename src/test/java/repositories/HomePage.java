package repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver = null;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccount;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(name = "search")
	private WebElement searchField;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	public void clickOnMyAccount() {

		myAccount.click();

	}

	public LoginPage clickOnLoginOption() {

		loginOption.click();
		return new LoginPage(driver);
		

	}

	public RegisterPage clickOnRegisterOption() {

		registerOption.click();
		return new RegisterPage(driver);

	}

	public void enterProductName(String productName) {

		searchField.sendKeys(productName);

	}

	public SearchPage clickOnSearchButton() {

		searchButton.click();
		return new SearchPage(driver);
	}

}
