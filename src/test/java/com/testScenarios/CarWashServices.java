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
import com.mainObjectFunctions.CarWashFunctions;
import com.utils.DriverSetup;
import com.utils.ExtentReportFile;
import com.utils.GetPropertiesFile;
import com.utils.ScreenShot;

public class CarWashServices extends BaseUI {

	public static WebDriver driver;
	public static Properties prop = GetPropertiesFile.getPropertiesInstance();
	public static String browser;
	public static String filename;
	public static String path;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static String readCarWash;

	@BeforeClass(alwaysRun = true)
	public void driverConfig() {
		browser = prop.getProperty("browser");
		readCarWash = prop.getProperty("readCarWash");
		driver = DriverSetup.getWebDriver(browser);
		report = ExtentReportFile.getReportInstance("CarWashServices_");

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
			path = ScreenShot.takePassSnapShotCarWash("JustdialHomePage_", driver);
			logger.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	@Test(priority = 1)
	public static void clickLocationButton() {
		logger = report.createTest("Location Functionality");
		try {
			logger.log(Status.INFO, "Click on the Location Button");
			clickLocation(driver);
			logger.log(Status.PASS, "Successfully clicked on the location button");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	@Test(priority = 2)
	public static void chooseLocation() {
		logger = report.createTest("Choosing Location");
		try {
			logger.log(Status.INFO, "Choose Location from the Location Butthon");
			selectLocation(driver);
			logger.log(Status.PASS, "Location choosen");
			path = ScreenShot.takePassSnapShotCarWash("ChoosingLocation_", driver);
			logger.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	@Test(priority = 3)
	public static void clickSearchTextBox() {
		logger = report.createTest("Search Text Box Functionality");
		try {
			logger.log(Status.INFO, "Click the Search TextBox Button");
			if (clickSearchBox(driver)) {
				logger.log(Status.PASS, "Successfully clicked on Search TextBox button");
				path = ScreenShot.takePassSnapShotCarWash("SearchTextBox_", driver);
				logger.addScreenCaptureFromPath(path);
			} else
				logger.log(Status.FAIL, "Cannot click on Search TextBox button");
		} catch (Exception e) {
			reportFail(e.getMessage());
			logger.log(Status.FAIL, "Cannot click on Search TextBox button");
		}
	}

	@Test(priority = 4)
	public static void enterService() {
		logger = report.createTest("Search for Service");
		try {
			logger.log(Status.INFO, "Enter 'Car Wash Service' in Search Box");
			enterService(driver, readCarWash);
			logger.log(Status.PASS, "Values Entered");
			path = ScreenShot.takePassSnapShotCarWash("ValuesEntered_", driver);
			logger.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	@Test(priority = 5)
	public static void clickSearchButton() {
		logger = report.createTest("Search Button Functionality");
		try {
			logger.log(Status.INFO, "Click on Search Button");
			clickSearch(driver);
			logger.log(Status.PASS, "Successfully clicked on Search button");
			// Thread.sleep(3000);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	@Test(priority = 6)
	public static void verifyCarWashingTitle() {
		logger = report.createTest("Title verification of the Car Washing page");
		try {
			String expectedTitle = CarWashFunctions.getTitle(driver);
			logger.log(Status.INFO, "Get page title");
			System.out.println(expectedTitle);
			String actualTitle = "Top 100 Car Washing Services in Kolkata - Best Car Cleaning Services - Justdial";
			Assert.assertEquals(expectedTitle, actualTitle);
			logger.log(Status.PASS, "Assertion Passed");
			path = ScreenShot.takePassSnapShotCarWash("SearchResults_", driver);
			logger.addScreenCaptureFromPath(path);

		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	@Test(priority = 7)
	public static void getSearchResults() {
		CarWashFunctions.clickTheCancel(driver);

		logger = report.createTest("Search Results");
		try {
			logger.log(Status.INFO, "Getting Search Results");
			CarWashFunctions.searchReults(driver);
			logger.log(Status.PASS, "Got Search Results");
			path = ScreenShot.takePassSnapShotCarWash("GettingSearchResults_", driver);
			logger.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			logger.log(Status.FAIL, "Did not get Search Results");
		}

	}

	@Test(priority = 8)
	public void returnToHomePage() {

		logger = report.createTest("Back To Home Page");

		try {
			logger.log(Status.INFO, "Navigating Back to Home Page");
			CarWashFunctions.goBack(driver);
			logger.log(Status.PASS, "Successfully Navigated back to Home Page");
			// path = ScreenShot.takePassSnapShotCarWash("BackToHome_",driver);
			// logger.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			logger.log(Status.FAIL, "Cannot Navigated back to Home Page");
			// FailReport.reportFail(e.getMessage());
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		report.flush();
	}

}
