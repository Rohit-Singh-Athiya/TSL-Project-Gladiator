package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BeforeAfter
{    
	public WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	  public void beforeTest(String browserName) throws Exception
	      {
	         driver = BrowserFactory.startBrowser(browserName);
	         Thread.sleep(4000);
		  }

    @AfterTest
	  public void afterTest() throws Exception 
	  {
		  Thread.sleep(5000);
		  driver.quit();
	  }
    
   
    @DataProvider(name = "test1data")
	 public Object[][] getData1() 
	 {
		Object data[][] = testData("C:\\LTI-Eclipse Workspace\\easeMyTripDemo1\\Excel\\data.xlsx","Sheet1");
		return data;
	 }
    
    @DataProvider(name ="test2data")
    public Object[][] getData2()
    {
    	return new Object[][]
    	   {
    	     	{"admin12" , "Harrison" ,"Wells", "9988776655"},
    	     	{"Barry234" , "Barry" ,"Allen", "9955113355"}	
    		     	    };
    }

    @DataProvider(name = "test3data")
  	 public Object[][] getData3() 
  	 {
  		Object data[][] = testData("C:\\LTI-Eclipse Workspace\\easeMyTripDemo1\\Excel\\data.xlsx","Sheet2");
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
}
