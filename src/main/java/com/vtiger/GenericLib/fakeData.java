package com.vtiger.GenericLib;

import java.util.Random;

import com.github.javafaker.Faker;


/**
 * 
 * @author pinja
 * @description : This class is Going to Generate random Interger and String value 
 *
 */
public class fakeData {
	
	
	Faker faker=new Faker();
	
	/**
	 * @author pinja
	 * @description : This method is going to give us fake FirstName 
	 * @return firstName
	 * 
	 */
	public String firstName()
	{
		return faker.name().firstName();
	}
	
	/**
	 * @author pinja
	 * @description : This method is going to give us fake lastName 
	 * @return String fake lastName
	 */
	public String lastName()
	{
		return faker.name().lastName();
	}
	
	/**
	 * @author pinja
	 * @description : This method is going to give us fake comapnyName 
	 * @return String fake comapyName
	 */
	public String companyName()
	{
		return faker.company().name();
	}
	
	/**
	 * @author pinja
	 * @description : This method is going to give us Fake campaignName
	 * @return String fake campaignName
	 */
	public String campaignName()
	{
		return faker.name().title();
	}
	
	/**
	 * @author pinja
	 * @description : This method is going to Generate randomNumber
	 * @return int random number
	 */
	public int randomData()
	{
		Random random= new Random();
		int number=random.nextInt(10000);
		return number;
	}
	
	/**
	 * @author pinja
	 * @description : This method is going to generate random_integer value for select salute Dropdown value
	 * @return random integer value
	 */
	public int saluteData()
	{
		Random random =new Random();
		random.nextInt(3);
		return random.nextInt(3);
	}
	
	/**
	 * @author pinja
	 * @description : This method is going to Generate integer value for select Organization name from table 
	 * @return  random integer value 
	 */
	public int orgSelectData()
	{
		Random random =new Random();
		int org_select=random.nextInt(1, 18);
		return org_select;
	}

}
