package com.test.combined;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.test.utils.DriverUtils;


public class AdminPageParabankFlow {
	
	static WebDriver driver;
	static DriverUtils util;
	static String adminPageTab = "//ul[@class='leftmenu']//a[text()='Admin Page']";
	static String soapEndPoint = "//input[@id='soapEndpoint']";
	static String soapValue = "ABCDE";
	static String restEndPoint = "//input[@id='restEndpoint']";
	static String restValue = "FGHIjK";
	static String endPoint = "//input[@id='endpoint']";
	static String endPointValue = "LMNOP";
	static String dataAccess_Soap = "//table[@class='form']//input[@value='jdbc']";
	static String initBalance = "//input[@id='initialBalance']";
	static String initBalance_Amt = "23250";
	static String minBalance = "//input[@id='minimumBalance']";
	static String minBalance_Amt = "50";
	static String loanProvider = "//select[@id='loanProvider']";
	static String loanProvider_JMS = "JMS";
	static String loanProcessor = "//select[@id='loanProcessor']";
	static String loanProcessor_Combined = "Combined";
	static String submit = "//input[@value='Submit']";
	static String successMsg = "//div[@id='rightPanel']//b[text()='Settings saved successfully.']";
	static String expectedMsg = "Settings successfully.";

	@Test
	public static void ParaBankDemo(){
		OpenApplication();
		openAdminPage();
		selectDataAccessMode();
		fillWebServiceDetails();
		fillApplicationSettings();
		submitData();
		closeApplication();
	}


//	public static void main(String[] args) {
//		
//		OpenApplication();
//		openAdminPage();
//		selectDataAccessMode();
//		fillWebServiceDetails();
//		fillApplicationSettings();
//		submitData();
//		closeApplication();
//	}
	
	private static WebDriver OpenApplication() {
		System.setProperty("webdriver.chrome.exe", "C:/Users/snthadev/Documents/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
		util=new DriverUtils(driver);
		System.out.println("Apllication Opened");
		return driver;
	}
	
	private static void openAdminPage() {
		util.Click(adminPageTab);
	}
	
	private static void selectDataAccessMode() {
		util.Click(dataAccess_Soap);
	}
	
	private static void fillWebServiceDetails() {
		util.SendKeys(soapEndPoint, soapValue);
		util.SendKeys(restEndPoint, restValue);
		util.SendKeys(endPoint, endPointValue);
		
	}
	
	private static void fillApplicationSettings() {
		util.SendKeys(initBalance, initBalance_Amt);
		util.SendKeys(minBalance, minBalance_Amt);
		util.Select(loanProvider, loanProvider_JMS);
		util.Select(loanProcessor, loanProcessor_Combined);	
	}
	
	
	private static void submitData() {
		util.Click(submit);
		System.out.println(util.GetText(successMsg));
		Assert.assertEquals(expectedMsg,util.GetText(successMsg), "Admin settings are not saved successfully");	
		
//		try {
//			Assert.assertEquals(expectedMsg,util.GetText(successMsg), "Admin settings are not saved successfully");	
//
//		} catch (java.lang.AssertionError e) {
//			driver.quit();
//		}
	}
	
	@AfterClass
	private static void closeApplication() {
		driver.quit();
		System.out.println("Application closed");
	}
	
	
	
}
