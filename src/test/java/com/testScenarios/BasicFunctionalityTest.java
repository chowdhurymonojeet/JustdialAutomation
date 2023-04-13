package com.testScenarios;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.baseUI.BaseUI;
import com.mainObjectFunctions.FreeListingFunctions;
import com.utils.DriverSetup;
import com.utils.ExtentReportFile;
import com.utils.GetPropertiesFile;
import com.utils.ScreenShot;

public class BasicFunctionalityTest extends BaseUI {

	public static WebDriver driver;
	public static Properties prop = GetPropertiesFile.getPropertiesInstance();
	public static String browser;
	public static String filename;
	public static String path;
	public static ExtentReports report;
	public static ExtentTest logger;

	@BeforeClass(alwaysRun = true)
	public void driverConfig() {
		browser = prop.getProperty("browser");
		driver = DriverSetup.getWebDriver(browser);
		report = ExtentReportFile.getReportInstance("BasicFunctionalityTest_");

	}

	@Test(priority = 0)
	public static void verifyHomeTitle() {
		logger = report.createTest("Title verification of the Home page");
		try {
			String expectedTitle = getTitle(driver);
			logger.log(Status.INFO, "Get page title");

			String actualTitle = "Justdial - Local Search, Social, News, Videos, Shopping";
			Assert.assertEquals(expectedTitle, actualTitle);
			logger.log(Status.PASS, "Titled verified successfully");
			path = ScreenShot.takePassSnapShotBasicFunctionality("HomePage_", driver);
			logger.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	@Test(priority = 1)

	public static void navigateToFreeListing() {
		logger = report.createTest("Title verification of the Free Listing Page");
		FreeListingFunctions.navigateToFreeListingPage(driver);
		try {
			String expectedTitle = getTitle(driver);
			logger.log(Status.INFO, "Get Free Listing page title");

			String actualTitle = "Free Listing - Just Dial - List In Your Business For Free";
			Assert.assertEquals(expectedTitle, actualTitle);
			logger.log(Status.PASS, "Titled verified successfully");
			System.out.println(FreeListingFunctions.freeListingMsg());

			path = ScreenShot.takePassSnapShotBasicFunctionality("FreeListing_", driver);
			logger.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}


	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		report.flush();
	}

}
