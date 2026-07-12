package reports;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FrameworkConstants;
import utils.ConfigReader;
import utils.DateTimeUtils;

public final class ExtentManager {

	private static ExtentReports extent;

	private ExtentManager() {
	}

	public static ExtentReports getInstance() {

		if (extent == null) {

			extent = createReport();

		}

		return extent;

	}

	private static ExtentReports createReport() {

		try {

			Path reportFolder =

					Paths.get(

							FrameworkConstants.REPORT_FOLDER,

							DateTimeUtils.getTimeStamp());

			Files.createDirectories(reportFolder);

			Path reportPath =

					reportFolder.resolve(

							"AutomationReport.html");

			ExtentSparkReporter spark =

					new ExtentSparkReporter(

							reportPath.toString());

			spark.config()

					.setReportName(

							"Enterprise Selenium Framework");

			spark.config()

					.setDocumentTitle(

							"Automation Execution Report");

			ExtentReports report =

					new ExtentReports();

			report.attachReporter(spark);

			report.setSystemInfo(

					"Operating System",

					System.getProperty("os.name"));

			report.setSystemInfo(

					"Java Version",

					System.getProperty("java.version"));

			report.setSystemInfo(

					"Browser",

					ConfigReader.getBrowser());

			report.setSystemInfo(

					"Environment",

					ConfigReader.getProperty("environment"));

			return report;

		}

		catch (Exception e) {

			throw new RuntimeException(

					"Unable to create report",

					e);

		}

	}

}