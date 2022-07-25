package com.vtiger.GenericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtilityClass implements IAutoconsts{

	public static WebDriver driver;

	@BeforeSuite
	public void connectToDatabase()
	{
		System.out.println("Connected To Database");
	}
	@AfterSuite
	public void diconnectToDatabase()
	{
		System.out.println("Disconnected To Database");
	}

	@BeforeClass
	public void  lauchBrowser() throws Throwable
	{
		FileLib flib=new FileLib();
		String browser=flib.readPropertyData(PROP_PATH,"browser");

		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}

		WebDriverUtility webutil=new WebDriverUtility(driver);
		webutil.maximizeWindow();
		webutil.imlicitWait();
		String url=flib.readPropertyData(PROP_PATH,"url");
		driver.get(url);
	}
	@BeforeMethod
	public void loginToApp() throws Throwable
	{
		LoginPage loginpage=new LoginPage(driver);
		FileLib flib=new FileLib();
		String un=flib.readPropertyData(PROP_PATH,"username");
		String pwd=flib.readPropertyData(PROP_PATH,"password");
		loginpage.getloginapp(un, pwd);

	}
	@AfterMethod
	public void logout()
	{
		WebDriverUtility webutil=new WebDriverUtility(driver);
		webutil.imlicitWait();
		HomePage homepage=new HomePage(driver);
		webutil.moveToElement(homepage.getLogout_Symbol());
		homepage.getSign_Out_Button().click();
	}
	@AfterClass
	public void closebrowser()
	{
		driver.close();
	}

}


