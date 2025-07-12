package repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver = null;

	public SearchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "iMac")
	private WebElement validProductDisplay;

	@FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
	private WebElement noResult;

	public boolean validProductDisplay() {

		return validProductDisplay.isDisplayed();

	}

	public boolean noResult() {

		return noResult.isDisplayed();

	}

}
