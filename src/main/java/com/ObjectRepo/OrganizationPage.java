package com.ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	@FindBy(xpath="//img[@alt='Create Organization...']") private WebElement Create_Organization_linkButton;
	@FindBy(xpath="//input[@name='search_text']") private WebElement searchOrgTextBox;
	@FindBy(xpath="//select[@id='bas_searchfield']") private WebElement typeofOrg_DD;
	@FindBy(xpath="//input[@name='submit']") private WebElement searchbtn;
	@FindBy(xpath="//input[@name='selected_id']") private WebElement searchOrgcheckbox;
	@FindBy(xpath="(//input[@value='Delete'])[2]") private WebElement deleteCheckboxbtn;
	@FindBy(xpath="//table[@class='lvt small']//tr//td[1]") private List<WebElement> allCheckbox;

	


	public List<WebElement> getAllCheckbox() {
		return allCheckbox;
	}


	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getSearchOrgTextBox() {
		return searchOrgTextBox;
	}

	public WebElement getTypeofOrg_DD() {
		return typeofOrg_DD;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getSearchOrgcheckbox() {
		return searchOrgcheckbox;
	}

	public WebElement getDeleteCheckboxbtn() {
		return deleteCheckboxbtn;
	}


	public WebElement getCreate_Organization_linkButton() {
		return Create_Organization_linkButton;
	}


}
