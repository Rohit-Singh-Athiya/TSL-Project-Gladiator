package util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{    
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath,String sheetName) 
	{
		 try
		 {
			workbook= new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		
		 } catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	
	public static void main(String[] args) 
	{
	   // getRowCount(); 	
		getCellDataString(0,0);
		getCellDataNumber(1,3);

	}
	
 public static int getRowCount() 
 {  int rowCount=0;
	 try 
	 {
		
	     rowCount=sheet.getPhysicalNumberOfRows();
	    // System.out.println("No of Rows " + rowCount);
		 
	 } catch (Exception e) 
	 {
         System.out.println(e.getMessage());
         System.out.println(e.getCause());
         e.printStackTrace();
     }
	 return rowCount;
 }
 
 
 public static int getColCount() 
 {   int colCount=0;
	 try 
	 {
		
	      colCount=sheet.getRow(0).getPhysicalNumberOfCells();
	 //    System.out.println("No of Cols " + colCount);
		 
	 } catch (Exception e) 
	 {
         System.out.println(e.getMessage());
         System.out.println(e.getCause());
         e.printStackTrace();
     }
	 return colCount;
 }
 
 public static String getCellDataString(int rowNum,int colNum) 
 {   String cellData =null;
	 try 
	 {
		 workbook= new XSSFWorkbook("C:\\LTI-Eclipse Workspace\\easeMyTripDemo1\\Excel\\Excel.xlsx");
		 sheet = workbook.getSheet("Sheet1");
		 cellData =sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		// System.out.println(cellData);
		 
	 } catch (Exception e) 
	 {
		System.out.println(e.getMessage());
        System.out.println(e.getCause());
        e.printStackTrace();
	 }
	 return cellData;
}
	
	 
	 public static void getCellDataNumber(int rowNum,int colNum) 
	 {
		 try 
		 {
			
			 double celldata =sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			// System.out.println(celldata);
			 
		 } catch (Exception e) 
		 {
			System.out.println(e.getMessage());
	        System.out.println(e.getCause());
	        e.printStackTrace();
		 }
 }   
 
 
}