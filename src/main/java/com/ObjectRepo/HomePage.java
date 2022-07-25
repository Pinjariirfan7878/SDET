package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath="(//a[.='Organizations'])[1]") private WebElement Organization_Linkbutton;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") private WebElement Logout_Symbol;
	@FindBy(xpath="//a[text()='Sign Out']") private WebElement Sign_Out_Button;
	@FindBy(xpath="//a[text()='More']") private WebElement moveModul;
	@FindBy(xpath="//a[text()='Campaigns']") private WebElement campaignbtn;
	@FindBy(xpath="//a[text()='Contacts']") private WebElement contactlinkbtn;


	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogout_Symbol() {
		return Logout_Symbol;
	}

	public WebElement getContactlinkbtn() {
		return contactlinkbtn;
	}

	public WebElement getSign_Out_Button() {
		return Sign_Out_Button;
	}

	public WebElement getOrganization_Linkbutton() {
		return Organization_Linkbutton;
	}

	public WebElement getMoveModul() {
		return moveModul;
	}

	public WebElement getCampaignbtn() {
		return campaignbtn;
	}
}
