package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public Properties initializeProperties() {

		Properties prop = new Properties();
		FileInputStream fis = null;
		File file = new File(
				"C:\\Users\\SumitKumar\\eclipse-workspace\\CucumberFramwork\\src\\test\\java\\config.properties");
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

}
