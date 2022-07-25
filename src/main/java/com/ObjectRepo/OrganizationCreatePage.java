package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreatePage {

	@FindBy(xpath="//input[@name='accountname']") private WebElement Organization_name_Fill_TextBox;
	@FindBy(xpath="//select[@name='industry']") private WebElement industryDD;
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]") private WebElement Save_Button;
	
	
	WebDriver driver;
	public OrganizationCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getOrganization_name_Fill_TextBox() {
		return Organization_name_Fill_TextBox;
	}
	public WebElement getSave_Button() {
		return Save_Button;
	}


	public WebElement getIndustryDD() {
		return industryDD;
	}
	
	
	
	
}
