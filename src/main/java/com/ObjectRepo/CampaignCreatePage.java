package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreatePage {
	@FindBy(xpath="//input[@name='campaignname']") private WebElement campaignTextbox;
	@FindBy(xpath="//input[@class='crmButton small save']") private WebElement savebtn;

	WebDriver driver;

	public CampaignCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getCampaignTextbox() 
	{
		return campaignTextbox;
	}

	public WebElement getSavebtn() 
	{
		return savebtn;
	}
}
