package com.testScenarios;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
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
import com.utils.ReadExcelFile;
import com.utils.ScreenShot;

public class FreeListing {

	public static WebDriver driver;
	public static Properties prop = GetPropertiesFile.getPropertiesInstance();
	public static String browser;
	public static String filename;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static String path;

	@BeforeClass(alwaysRun = true)
	public void driverConfig() {
		browser = prop.getProperty("browser");
		driver = DriverSetup.getWebDriver(browser);
		report = ExtentReportFile.getReportInstance("FreeListing");

	}

	@Test(priority = 0)
	public static void clickFreeListingLink() {
		logger = report.createTest("FreeListing Functionality");
		try {
			logger.log(Status.INFO, "Click on FreeListing Link Text");
			FreeListingFunctions.clickFreeListing(driver);
			logger.log(Status.PASS, "Successfully clicked on FreeListing Link Text");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
		}
	}

	@Test(priority = 1)
	public static void fillFormValues() {
		logger = report.createTest("FreeListing Form Fillup");
		try {
			logger.log(Status.INFO, "Enter values in the Form");
			FreeListingFunctions.companyName(driver, ReadExcelFile.readExcelData(1, 0));
			FreeListingFunctions.firstName(driver, ReadExcelFile.readExcelData(1, 1));
			FreeListingFunctions.lastName(driver, ReadExcelFile.readExcelData(1, 2));
			FreeListingFunctions.mobileNumber(driver, ReadExcelFile.readExcelData(1, 3));
			FreeListingFunctions.landlineNumber(driver, ReadExcelFile.readExcelData(1, 4));
			logger.log(Status.PASS, "Values Entered");
			path = ScreenShot.takePassSnapShotFreeListing("FreeListingFormFilled_", driver);
			logger.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			e.printStackTrace();
			logger.log(Status.FAIL, "Cannot Enter Values");
		}
	}

	@Test(priority = 2)
	public static void submitForm() {

		logger = report.createTest("Submit the Form");
		try {
			logger.log(Status.INFO, "Try to Submit");
			FreeListingFunctions.formSubmit(driver); 
			logger.log(Status.FAIL, "Cannot Submit - Invalid Data");
			path = ScreenShot.takePassSnapShotFreeListing("SubmitTheForm_", driver);
			logger.addScreenCaptureFromPath(path);

		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			e.printStackTrace();
			logger.log(Status.FAIL, "Cannot Enter Values");
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		report.flush();
	}

}
