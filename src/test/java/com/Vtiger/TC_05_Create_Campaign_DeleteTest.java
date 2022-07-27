package com.Vtiger;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ObjectRepo.CampaignCreatePage;
import com.ObjectRepo.CampaignPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.ResponsePage;
import com.vtiger.GenericLib.BaseUtilityClass;
import com.vtiger.GenericLib.WebDriverUtility;
import com.vtiger.GenericLib.fakeData;
//@Listeners(com.vtiger.GenericLib.Mylistener.class)
public class TC_05_Create_Campaign_DeleteTest extends BaseUtilityClass {

	@Test(priority = 5,retryAnalyzer = com.vtiger.GenericLib.RetryAnalyser.class)
	public void campaignTest() throws InterruptedException {

		fakeData fakerdata=new fakeData();
		String fake_campaignName=fakerdata.campaignName();


		HomePage homepage=new HomePage(driver);
		WebDriverUtility webutil=new WebDriverUtility(driver);
		webutil.moveToElement(homepage.getMoveModul());
		homepage.getCampaignbtn().click();

		CampaignPage campaignpage =new CampaignPage(driver);
		campaignpage.getCampaigncreatelinkbtn().click();

		CampaignCreatePage campaigncreatepage=new CampaignCreatePage(driver);
		campaigncreatepage.getCampaignTextbox().sendKeys(fake_campaignName);
		campaigncreatepage.getSavebtn().click();

		ResponsePage responsepage= new ResponsePage(driver);
		String Output=responsepage.getHeader_output().getText();

		if (Output.contains(fake_campaignName))
		{
			System.out.println("Campaign is Created and verified Pass");
		}
		else
		{
			System.out.println("Campaign is not Created and verified Pass");

		}
		Thread.sleep(1000);
		responsepage.getCampaignlinkbtn().click();
		responsepage.getSearchTextBox().sendKeys(fake_campaignName);
		WebElement dd=responsepage.getType_DD();
		webutil.select_dd(dd, "campaignname");
		responsepage.getSearchbtn().click();

		Thread.sleep(2000);
		campaignpage.getSearchcampcheckbox().click();
		campaignpage.getDeleteCheckboxbtn().click();
		webutil.alertAccept();

		WebElement info_data=responsepage.getConfirmMassege();
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


	}

}
