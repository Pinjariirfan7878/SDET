package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	@FindBy(xpath="//select[@name='salutationtype']") private WebElement salute_dd;
	@FindBy(xpath="//input[@name='firstname']") private WebElement FirstName_TextField;
	@FindBy(xpath="//input[@name='lastname']") private WebElement LastName_TextField;
	@FindBy(xpath="//img[@tabindex='']") private WebElement Table_Index;
	@FindBy(xpath="(//table[@class='small'])[3]") private WebElement table;
	@FindBy(xpath="//input[@class='crmButton small save']") private WebElement Save_Button;


	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getTable() {
		return table;
	}

	public WebElement getSave_Button() {
		return Save_Button;
	}


	public WebElement getSalute_dd() {

		return salute_dd;
	}


	public WebElement getFirstName_TextField() {
		return FirstName_TextField;
	}

	public WebElement getLastName_TextField() {
		return LastName_TextField;
	}

	public WebElement getTable_Index() {
		return Table_Index;
	}


}
