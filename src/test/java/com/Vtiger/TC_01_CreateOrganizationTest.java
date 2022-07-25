package com.Vtiger;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.HomePage;
import com.ObjectRepo.OrganizationCreatePage;
import com.ObjectRepo.OrganizationPage;
import com.ObjectRepo.ResponsePage;
import com.vtiger.GenericLib.BaseUtilityClass;
import com.vtiger.GenericLib.RetryAnalyser;
import com.vtiger.GenericLib.fakeData;

@Listeners(com.vtiger.GenericLib.Mylistener.class)
public class TC_01_CreateOrganizationTest  extends BaseUtilityClass{

	@Test(priority = 1,retryAnalyzer = RetryAnalyser.class)
	public void createOrg() throws Throwable
	{


		fakeData fakerdata=new fakeData();
		String Org_name=fakerdata.companyName();

		HomePage homepage=new HomePage(driver);
		homepage.getOrganization_Linkbutton().click();
		

		OrganizationPage organizatingPage=new OrganizationPage(driver);
		organizatingPage.getCreate_Organization_linkButton().click();

		OrganizationCreatePage organizationCreatePage=new OrganizationCreatePage(driver);
		organizationCreatePage.getOrganization_name_Fill_TextBox().sendKeys(Org_name);
		organizationCreatePage.getSave_Button().click();



		//validation statement
		ResponsePage organizationCreatedPage=new ResponsePage(driver);
		String confirm_message=organizationCreatedPage.getHeader_output().getText();
		//Assert.assertEquals(confirm_message, Org_name);

		if(confirm_message.contains(Org_name))
		{
			System.out.println("Organization is added and verified PAssed");
		}
		else 
		{
			System.out.println("Organization is not added and verified Failed");
		}
		//Assert.assertFalse(true);
	}
}

