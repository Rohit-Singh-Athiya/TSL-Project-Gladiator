package util;
/*
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.C_OneWayFlight;

//public class ExcelDataProvider extends BeforeAfter {

	//public static void main(String[] args) 
//	{
//		String excelPath = "C:\\LTI-Eclipse Workspace\\easeMyTripDemo1\\Excel\\data.xlsx";
	//	testData(excelPath,"Sheet1");
	//}
	
/*	 @Test(priority = 1,enabled =true,description = "Passing the Test Case",dataProvider="test1data")  
	  public void oneWayTest1(String email,String fName,String lName,String contact) throws Exception
	  {   
		  driver.get("https://www.easemytrip.com/");
	      driver.manage().deleteAllCookies();
		  C_OneWayFlight obj =  PageFactory.initElements(driver, C_OneWayFlight.class); 
		  obj.searchOneWay4(email,fName,lName,contact);
		  String chc = driver.getCurrentUrl();
		  Assert.assertTrue(chc.contains("CheckOut"), "https://flight.easemytrip.com/Review/CheckOut?CSU=&SearchID=4wj4xhewd3q&ft=7&bc=&ISWL=");
	  }
	
	 @DataProvider(name = "test1data")
	 public Object[][] getData() 
	 {
		Object data[][] = testData("C:\\LTI-Eclipse Workspace\\easeMyTripDemo1\\Excel\\data.xlsx","Sheet1");
		return data;
	 }
	 
	 
	 
	 
	 
	 
	public  Object[][] testData(String excelPath,String sheetName) 
	{
		ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
	
	Object data[][] = new Object[rowCount-1][colCount];	
		
		for (int i =1;i<rowCount;i++) {
			for(int j=0;j<colCount;j++){
				String cellData = excel.getCellDataString(i, j);  
				System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
			}
		  System.out.println();
		}
		return data;
		
	}
	
	
	
}*/
