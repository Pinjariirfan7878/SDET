package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.GenericLib.FileLib;

public class LoginPage {

	@FindBy(xpath="//input[@name='user_name']") private WebElement Username_Textbox;
	@FindBy(xpath="//input[@name='user_password']") private WebElement Password_TextBox;
	@FindBy(xpath="//input[@type='submit']") private WebElement Login_Button;

	FileLib pfile=new FileLib();
	WebDriver driver;


	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserTextBox() {
		return Username_Textbox;
	}
	public WebElement getPasswordTextBox() {
		return Password_TextBox;
	}
	public WebElement getLoginbtn() {
		return Login_Button;
	}

	public void getloginapp(String username,String password ) throws Throwable
	{
		Username_Textbox.sendKeys(username);
		Password_TextBox.sendKeys(password);
		Login_Button.click();

	}
}
