package com.Vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.GenericLib.FileLib;

import io.github.bonigarcia.wdm.WebDriverManager;

public class check {
	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver=new FirefoxDriver();
		
		FileLib pfile=new FileLib();
		
		String un = pfile.readPropertyData("D:\\KCSM13\\SDET\\Data\\config.properties", "url");
		
		driver.get(un);
		
		
	}

}
