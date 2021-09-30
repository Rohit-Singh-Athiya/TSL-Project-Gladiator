package util;

import java.nio.file.FileSystemNotFoundException;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider
{
	public static void main(String[] args) 
	{
		String excelPath="C:\\LTI-Eclipse Workspace\\easeMyTripDemo1\\Excel\\Excel.xlsx";
		testData(excelPath,"Sheet1");
	}
	
	@DataProvider (name = "test1data")
	public static Object[][] getData() 
	{
		String excelPath="C:\\LTI-Eclipse Workspace\\easeMyTripDemo1\\Excel\\Excel.xlsx";
	Object[][] data = testData(excelPath,"Sheet1");
	   return data; 
	}
	
      public static Object[][] testData(String excelPath,String sheetName)
      { 
    	  ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
    	  
    	  int rowCount = excel.getRowCount();
    	  int colCount = excel.getColCount();
    	  
      Object data[][] = new Object[rowCount-1][colCount];	  
    	  
    	  for(int i =1;i<rowCount;i++) 
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
