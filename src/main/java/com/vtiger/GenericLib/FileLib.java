package com.vtiger.GenericLib;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author pinja
 * @description : This class is going to help to read values of kye from Properties file
 * return value
 *
 */
public class FileLib {
	
	
	
	public FileLib()
	{
		
	}
	
		/**
		 * @author pinja
		 * @description : This method is going to help Read Data from Properties File
		 * @param path
		 * @param key
		 * @return value
		 * @throws Throwable
		 */
	public String readPropertyData(String path, String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
	    return	prop.getProperty(key, "Incorrect Key");
	}
	
}
	  


