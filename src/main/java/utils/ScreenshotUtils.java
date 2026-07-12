package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import constants.FrameworkConstants;
import driver.DriverFactory;

public final class ScreenshotUtils {

	private ScreenshotUtils() {
	}

	public static String capture(String testName) {

		try {

			String timestamp = DateTimeUtils.getTimeStamp();

			Path folder = Paths.get(FrameworkConstants.SCREENSHOT_FOLDER);

			Files.createDirectories(folder);

			String fileName = testName + "_" + timestamp + ".png";

			Path destination = folder.resolve(fileName);

			File source = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, destination.toFile());

			return destination.toString();

		}

		catch (IOException e) {

			throw new RuntimeException("Unable to capture screenshot", e);

		}

	}

}