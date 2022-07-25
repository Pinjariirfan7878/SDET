package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	@FindBy(xpath="//img[@title='Create Campaign...']") private WebElement campaigncreatelinkbtn;
	@FindBy(xpath="//input[@name='selected_id']") private WebElement searchcampcheckbox;
	@FindBy(xpath="(//input[@value='Delete'])[2]") private WebElement deleteCheckboxbtn;


	WebDriver driver;
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCampaigncreatelinkbtn() 
	{
		return campaigncreatelinkbtn;
	}

	public WebElement getSearchcampcheckbox() {
		return searchcampcheckbox;
	}

	public WebElement getDeleteCheckboxbtn() {
		return deleteCheckboxbtn;
	}

}
