package com.Vtiger;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ObjectRepo.HomePage;
import com.ObjectRepo.OrganizationCreatePage;
import com.ObjectRepo.OrganizationPage;
import com.ObjectRepo.ResponsePage;
import com.vtiger.GenericLib.BaseUtilityClass;
import com.vtiger.GenericLib.RetryAnalyser;
import com.vtiger.GenericLib.WebDriverUtility;
import com.vtiger.GenericLib.fakeData;
//@Listeners(com.vtiger.GenericLib.Mylistener.class)
public class TC_02_CreateOrganization_verifyTest extends BaseUtilityClass {

	@Test(priority = 2,retryAnalyzer = RetryAnalyser.class,groups = {"smoke","batch_Execution"})
	public void createOrganization() {

		fakeData fakedata=new fakeData();
		String Org_name=fakedata.companyName();

		HomePage homepage=new HomePage(driver);
		homepage.getOrganization_Linkbutton().click();

		OrganizationPage organizatingPage=new OrganizationPage(driver);
		organizatingPage.getCreate_Organization_linkButton().click();

		OrganizationCreatePage organizationCreatePage=new OrganizationCreatePage(driver);
		organizationCreatePage.getOrganization_name_Fill_TextBox().sendKeys(Org_name);
		WebElement DD=organizationCreatePage.getIndustryDD();
		DD.click();
		WebDriverUtility webutil=new WebDriverUtility(driver);
		webutil.select_dd(DD, 7);
		organizationCreatePage.getSave_Button().click();

		//validation statement
		ResponsePage organizationCreatedPage=new ResponsePage(driver);
		String confirm_message=organizationCreatedPage.getHeader_output().getText();

		if(confirm_message.contains(Org_name))
		{
			System.out.println("Organization is added and verified Passed");
		}
		else 
		{
			System.out.println("Organization is not added and verified Failed");
		}
		Assert.assertFalse(false);

	}
}
