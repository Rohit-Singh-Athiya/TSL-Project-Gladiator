package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BeforeAfterTest
{    
	public WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")                                             //Steps to perform Before test
	  public void beforeTest(String browserName) throws Exception
	      {
	         driver = BrowserFactory.startBrowser(browserName);        // Initializing start browser method from Browser factory class
	         Thread.sleep(1000);
	      
		  }

    @AfterTest                                                         //Steps to perform After test
	  public void afterTest() throws Exception 
	  {
		  Thread.sleep(2000);
		  driver.quit();
	  }
    
   
    @DataProvider(name = "test1data")                                  // Data Provider for Test1
	 public Object[][] getData1() 
	 {
		Object data[][] = testData("C:\\LTI-Eclipse Workspace\\easeMyTripDemo1\\Excel\\data.xlsx","Sheet1");   // Location of Excel sheet and Sheet number
		return data;
	 }
    
    @DataProvider(name ="test2data")                                   // Data Provider for Test2
    public Object[][] getData2()
    {
    	return new Object[][]
    	   {
    	     	{"admin12" , "Harrison" ,"Wells", "9988776655"},
    	     	{"Barry234" , "Barry" ,"Allen", "9955113355"}	
    		     	    };
    }

    @DataProvider(name = "test3data")                                   // Data Provider for Test3
  	 public Object[][] getData3() 
  	 {
  		Object data[][] = testData("C:\\LTI-Eclipse Workspace\\easeMyTripDemo1\\Excel\\data.xlsx","Sheet2"); // Location of Excel sheet and Sheet number
  		return data;
  	 }
    
    
    
    
    public  Object[][] testData(String excelPath,String sheetName)      // Method to get test data 
	{
		ExcelUtils excel = new ExcelUtils(excelPath,sheetName);         // Create object of ExcelUtils class
		
		int rowCount = excel.getRowCount();                             // Get number of rows
		int colCount = excel.getColCount();                             // get number of columns
	
	Object data[][] = new Object[rowCount-1][colCount];	                // Creating Object of Object type
		 
		for (int i =1;i<rowCount;i++) {                                 // Loop for Rows
			for(int j=0;j<colCount;j++){                                // Loop for Columns
				String cellData = excel.getCellDataString(i, j);        // Getting data using getcellDataString method from ExcelUtils
				System.out.print(cellData+" | ");                       // Printing out Cell data
				data[i-1][j] = cellData;                                // Giving cell Data to Object data[][]
			}
		  System.out.println();
		}
		return data;
		
    }
}
