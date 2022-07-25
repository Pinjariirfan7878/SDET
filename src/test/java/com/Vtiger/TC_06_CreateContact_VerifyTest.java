package com.Vtiger;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ObjectRepo.ContactPage;
import com.ObjectRepo.CreateContactPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.ResponsePage;
import com.vtiger.GenericLib.BaseUtilityClass;
import com.vtiger.GenericLib.WebDriverUtility;
import com.vtiger.GenericLib.fakeData;

public class TC_06_CreateContact_VerifyTest extends BaseUtilityClass{

	@Test(priority = 6)
	public void createcontactTest() throws InterruptedException {

		fakeData fakerdata=new fakeData();
		String firstName=fakerdata.firstName();
		String lastName=fakerdata.lastName();
		int org_select=fakerdata.orgSelectData();
		int salute_dd=fakerdata.saluteData();


		HomePage homepage=new HomePage(driver);
		homepage.getContactlinkbtn().click();
		ContactPage contactpage=new ContactPage(driver);
		contactpage.getCreatecontactlinkbtn().click();

		CreateContactPage createcontactpage=new CreateContactPage(driver);
		WebElement dd=createcontactpage.getSalute_dd();
		dd.click();
		WebDriverUtility webutil=new WebDriverUtility(driver);
		webutil.select_dd(dd, salute_dd);

		createcontactpage.getFirstName_TextField().sendKeys(firstName);
		createcontactpage.getLastName_TextField().sendKeys(lastName);
		createcontactpage.getTable_Index().click();

		String parent_WH=driver.getWindowHandle();
		Set<String>allWH=driver.getWindowHandles();

		for(String wh:allWH)
		{
			if(!parent_WH.equals(wh))
			{
				webutil.switchWindow(wh);
			}
		}
		//WebElement table=createcontactpage.getTable();
		WebElement Organization_Name=driver.findElement(By.xpath("//a[@id='"+org_select+"']"));
		Organization_Name.click();
		webutil.switchWindow(parent_WH);

		WebElement Save_Button=createcontactpage.getSave_Button();
		Save_Button.click();
		ResponsePage responsepage=new ResponsePage(driver);
		String created_statement=responsepage.getHeader_output().getText();

		if(created_statement.contains(firstName))
		{
			System.out.println("contact is added and verify Passed");
		}
		else
		{
			System.out.println("contact added and verify Failed");
		}

	}

}
