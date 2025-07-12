package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {

	WebDriver driver = null;
	private ConfigReader cf = null;
	private DriverFactory df = null;

	@Before
	public void setup() {

		cf = new ConfigReader();
		df = new DriverFactory();
		Properties prop = cf.initializeProperties();
		driver = df.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));

	}

	@After
	public void tearDown(Scenario scenario) {

		String scenarioName = scenario.getName().replace(" ", "_");

		if (scenario.isFailed()) {

			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenarioName);
		}

		driver.quit();
	}

}
