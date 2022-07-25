package com.vtiger.GenericLib;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * 
 * @author pinja
 * @description : This class is going to help to fetch the data,update the data from Excel file
 */
public class ExcelFile {
	
	/**
	 * @author pinja
	 * @description : This method is going to help read the Data from Excel sheet
	 * @param sheet This is the sheet name of Excel 
	 * @param r This is the Row of sheet 
	 * @param c This is the cell of Row
	 * @return cell String value
	 * @throws Exception
	 */
	public String readDataExcel(String sheet,int r, int c) throws Exception
	{
		FileInputStream file=new FileInputStream(IAutoconsts.EXCEL_PATH);
		 Workbook wb=WorkbookFactory.create(file);
		 String sh=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		 //System.out.println(sh);
		 return sh;
	}

}
