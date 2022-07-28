package com.vtiger.GenericLib;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility extends BaseUtilityClass {

	//WebDriver driver;

	public WebDriverUtility(WebDriver driver)  
	{
		this.driver=driver;
	}

	public void maximizeWindow()
	{
		driver.manage().window().maximize();
	}

	public void imlicitWait() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void Waitandclickelement(WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void moveToElement(WebElement element) 
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(element).build().perform();
	}

	public void select_dd(WebElement element,int a)
	{
		Select sl=new Select(element);
		sl.selectByIndex(a);

	}
	public void select_dd(WebElement element,String value)
	{
		Select sl=new Select(element);
		sl.selectByValue(value);

	}

	public void select_dd(String visibletext,WebElement element)
	{
		Select sl=new Select(element);
		sl.selectByVisibleText(visibletext);	
	}

	public void alertAccept()
	{
		Alert al=driver.switchTo().alert();
		al.accept();
	}

	public void alertDismiss()
	{
		Alert al=driver.switchTo().alert();
		al.dismiss();
	}
	
	public WebDriver switchWindow(String Wh) 
	{
		driver.switchTo().window(Wh);
		return driver.switchTo().window(Wh);

	}
	 
	public void screenshot(String methodName)
	{
		TakesScreenshot ts=(TakesScreenshot)sdriver;
		File scr=ts.getScreenshotAs(OutputType.FILE);
		String path=IAutoconsts.Screenshot_PATH+methodName+".png";
		File dsn=new File(path);
		try {
			Files.copy(scr, dsn);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
