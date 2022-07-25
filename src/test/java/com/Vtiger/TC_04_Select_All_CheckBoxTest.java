package com.Vtiger;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ObjectRepo.HomePage;
import com.ObjectRepo.OrganizationPage;
import com.vtiger.GenericLib.BaseUtilityClass;

public class TC_04_Select_All_CheckBoxTest extends BaseUtilityClass {

	@Test(priority = 4)
	public void selectallTest() throws InterruptedException {

		

		HomePage homepage=new HomePage(driver);
		homepage.getOrganization_Linkbutton().click();

		OrganizationPage orgpage=new OrganizationPage(driver);
		List <WebElement> allbox1=orgpage.getAllCheckbox();
		for(int i=2;i<allbox1.size();i++)
		{
			WebElement box=allbox1.get(i);
			box.click();
			Thread.sleep(300);
		}	
	}

}
//driver.findElements(By.xpath("//table[@class='lvt small']//tr//td[1]"));









//List <WebElement> All_Organization =driver.findElements(By.xpath(" //table[@class='lvt small']//tr"));
//List <WebElement>All_ChechBox=driver.findElements(By.xpath("//table[@class='lvt small']//tr//td[1]"));
//
//for (int i=3;i<=All_Organization.size();i++)
//{
//	WebElement Organization=driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]/td[3]"));
//	String s=Organization.getText();
//	
//	if(s.equalsIgnoreCase("Qspider12 Pvl Ltd."))
//			{
//		       WebElement box=driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]/td[1]"));
//		       box.click();
//			}	
//}
//Thread.sleep(2000);
////driver.findElement(By.xpath("//input[@id='selectCurrentPageRec']")).click();
