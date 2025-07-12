package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver = null;

	public ElementUtils(WebDriver driver) {

		this.driver = driver;

	}

	public void clickOnElement(WebElement element, long duration) {

		WebElement webElement = waitForElement(element, duration);
		webElement.click();

	}

	public void typeTextIntoWebElement(WebElement element, String text, long duration) {

		WebElement webElement = waitForElement(element, duration);

		webElement.click();
		webElement.clear();
		webElement.sendKeys(text);

	}

	public WebElement waitForElement(WebElement element, long duration) {

		WebElement webElement = null;

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Throwable e) {

			e.printStackTrace();

		}

		return webElement;
	}

	public void selectDropDownOption(WebElement element, String option, long duration) {

		WebElement webElement = waitForElement(element, duration);

		Select select = new Select(webElement);
		select.deselectByVisibleText(option);

	}

	public void acceptAlert() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public void mouseHoverAndClick(WebElement element, long duration) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));

		Actions action = new Actions(driver);
		action.moveToElement(webElement).click().build().perform();

	}
}
