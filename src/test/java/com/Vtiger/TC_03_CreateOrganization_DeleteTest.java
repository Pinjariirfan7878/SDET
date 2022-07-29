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
public class TC_03_CreateOrganization_DeleteTest extends BaseUtilityClass {


	@Test(priority = 3,retryAnalyzer = RetryAnalyser.class,groups = {"Regression","batch_Execution"})
	public void Endtoend() throws InterruptedException {

		fakeData fakerdata=new fakeData();
		String Org_Name=fakerdata.companyName();
			
		HomePage homepage=new HomePage(driver);
		homepage.getOrganization_Linkbutton().click();

		OrganizationPage organizationpage=new OrganizationPage(driver);
		organizationpage.getCreate_Organization_linkButton().click();

		OrganizationCreatePage organizationCreatePage=new OrganizationCreatePage(driver);
		organizationCreatePage.getOrganization_name_Fill_TextBox().sendKeys(Org_Name);
		WebElement DD=organizationCreatePage.getIndustryDD();
		DD.click();
		WebDriverUtility webutil=new WebDriverUtility(driver);
		webutil.select_dd(DD, 7);
		organizationCreatePage.getSave_Button().click();

		//validation statement
		ResponsePage organizationResponsePage=new ResponsePage(driver);
		String confirm_message=organizationResponsePage.getHeader_output().getText();

		if(confirm_message.contains(Org_Name))
		{
			System.out.println("Organization is added and verified Passed");
		}
		else 
		{
			System.out.println("Organization is not added and verified Failed");
		}
		homepage.getOrganization_Linkbutton().click();
		organizationpage.getSearchOrgTextBox().sendKeys(Org_Name);
		WebElement Type_of_Organization_Dd=organizationpage.getTypeofOrg_DD();
		webutil.select_dd(Type_of_Organization_Dd, "accountname");
		organizationpage.getSearchbtn().click();
		Thread.sleep(2000);
		organizationpage.getSearchOrgcheckbox().click();
		organizationpage.getDeleteCheckboxbtn().click();
		webutil.alertAccept();

		WebElement info_data=organizationResponsePage.getConfirmMassege();
		//String output=info_data.getText();
		if (info_data.isDisplayed())
		{
			System.out.println("Organization is deleted and verified Passed");
		}
		else
		{
			System.out.println("Organization is not deleted and verified Failed");
		}	
		Assert.assertFalse(false);
		//		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		//		Thread.sleep(2000);
		//		List<WebElement> All_Org=driver.findElements(By.xpath("//table[@class='lvt small']//tr//td[3]/a"));
		//		for(WebElement Each_Org:All_Org)
		//		{
		//			if(Org_Name.equalsIgnoreCase(Each_Org.getText()))
		//			{
		//				System.out.println("Organization is not deleted and Test case is Failed");
		//			}
		//
		//		}

		//		webutil.imlicitWait();
		//		webutil.moveToElement(homepage.getLogout_Symbol());
		//		homepage.getSign_Out_Button().click();
		//		driver.close();
	}

}
