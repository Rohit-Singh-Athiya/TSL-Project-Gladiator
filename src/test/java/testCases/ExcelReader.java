package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.C_OneWayFlight;
import util.BeforeAfter;
import util.ExcelUtils;

public class ExcelReader extends BeforeAfter
{
	@Test(priority = 1,enabled =true,description = "Passing the Test Case",dataProvider = "test1data")  
	  public void oneWayTest1(String email,String Fname,String Lname,String Contact) throws Exception
	  {   
		  driver.get("https://www.easemytrip.com/");
	      driver.manage().deleteAllCookies();
		  C_OneWayFlight obj =  PageFactory.initElements(driver, C_OneWayFlight.class); 
		  obj.searchOneWay4(email,Fname,Lname,Contact);
		  String chc = driver.getCurrentUrl();
		  Assert.assertTrue(chc.contains("CheckOut"), "https://flight.easemytrip.com/Review/CheckOut?CSU=&SearchID=4wj4xhewd3q&ft=7&bc=&ISWL=");
	  }
	
	
	
	
	@DataProvider (name = "test1data")
	public Object[][] getData() 
	{
		String excelPath="C:\\LTI-Eclipse Workspace\\easeMyTripDemo1\\Excel\\Excel.xlsx";
		Object data[][] = testData(excelPath,"Sheet1");
		return data;
	}
	
      public static Object[][] testData(String excelPath,String sheetName)
      { 
    	  ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
    	  
    	  int rowCount = excel.getRowCount();
    	  int colCount = excel.getColCount();
    	  
      Object data[][] = new Object[rowCount-1][colCount];	  
    	  
    	  for(int i =2;i<rowCount;i++) 
    	  {
    		  for(int j=0;j<colCount;j++) 
    		  {
    			 String cellData= excel.getCellDataString(i,j);
    			 System.out.print(cellData+" | ");
    			 data[i-1][j] = cellData;
    			 
    			  
    		  }
    		 System.out.println();
    	  }
    	  return data;
      }
}
