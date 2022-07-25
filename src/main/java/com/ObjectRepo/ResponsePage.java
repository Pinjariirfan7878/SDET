package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResponsePage {


	@FindBy(xpath="//span[@class='dvHeaderText']") private WebElement Header_output;
	@FindBy(xpath="//span[@class='genHeaderSmall']") private WebElement confirmMassege;
	@FindBy(xpath="(//a[text()='Campaigns'])[1]") private WebElement campaignlinkbtn;
	@FindBy(xpath="//input[@name='search_text']") private WebElement searchTextBox;
	@FindBy(xpath="//select[@id='bas_searchfield']") private WebElement type_DD;
	@FindBy(xpath="//input[@name='submit']") private WebElement searchbtn;
	
	WebDriver driver;
	public ResponsePage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	public WebElement getType_DD() {
		return type_DD;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getConfirmMassege() {
		return confirmMassege;
	}

	
	public WebElement getHeader_output() {
		return Header_output;
	}
	
	public WebElement getCampaignlinkbtn() {
		return campaignlinkbtn;
	}
}
