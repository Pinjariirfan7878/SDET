package com.Vtiger;

import org.testng.annotations.Test;

import com.vtiger.GenericLib.FileLib;
import com.vtiger.GenericLib.IAutoconsts;

public class timeepass {

	public void tt() throws Throwable
	{
		FileLib flib=new FileLib();
		String browser=flib.readPropertyData(IAutoconsts.PROP_PATH, "browser");
		System.out.println(browser);
	}

}
