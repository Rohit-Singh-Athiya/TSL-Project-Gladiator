package testCases;

import org.testng.annotations.Test;

import pages.OneWayFlightScript;
import util.BeforeAfterTest;
import util.BrowserFactory;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class OneWayFlightBookingTest  extends BeforeAfterTest
{ 
	 Properties prop = new Properties();                                                               // Creating an Object of Properties 
  
  @Test(priority = 1,enabled =true,description = "Passing the Test Case" , dataProvider="test1data")   // dataProvider is present in BeforeAfterTest class
  public void oneWayTest1(String email,String fName,String lName,String contact) throws Exception
  {   
	  prop.load(new FileInputStream("Settings.property"));                                             // To import from Settings.property file
	  driver.get(prop.getProperty("url"));                                                             // Getting URL from property file
      driver.manage().deleteAllCookies();                                                              // Deleting all previous cookies
      OneWayFlightScript obj =  PageFactory.initElements(driver,OneWayFlightScript.class);             // initializing PageFactory
	  obj.searchOneWay4(email,fName,lName,contact);                                                    // Calling Method
	  String chc = driver.getCurrentUrl();                                                             // get URL of current page
	  Assert.assertTrue(chc.contains("CheckOut"), "https://flight.easemytrip.com/Review/CheckOut?CSU=&SearchID=4wj4xhewd3q&ft=7&bc=&ISWL="); //check for assertion
  }
  

   @Test( priority = 2 ,enabled =true,description = "Error With Email",dataProvider="test2data" )      // dataProvider is present in BeforeAfterTest class  
  public void oneWayTest2(String email,String fName,String lName,String contact) throws Exception  
  {   
	  prop.load(new FileInputStream("Settings.property"));                                             // To import from Settings.property file
	  driver.get(prop.getProperty("url"));                                                             // Getting URL from property file
	  driver.manage().deleteAllCookies();                                                              // Deleting all previous cookies
	  OneWayFlightScript obj =  PageFactory.initElements(driver,OneWayFlightScript.class);             // initializing PageFactory
	  obj.searchOneWay4(email,fName,lName,contact);                                                    // Calling Method
	  Thread.sleep(3000);
      String em = driver.findElement(By.id("divErrorEmail")).getText();                                // get Text of error
	  Assert.assertTrue(em.contains("email"), "Please enter a valid email Id");                        // Using Assertion to verify error message
  }
  
  
   
  @Test(priority = 3,enabled =true,description = "Error With contact number",dataProvider="test3data")      // dataProvider is present in BeforeAfterTest class 
  public void oneWayTest3(String email,String fName,String lName,String contact) throws Exception 
  {   
      prop.load(new FileInputStream("Settings.property"));                                                  // To import from Settings.property file
	  driver.get(prop.getProperty("url"));                                                                  // Getting URL from property file 
      driver.manage().deleteAllCookies();                                                                   // Deleting all previous cookies
      OneWayFlightScript obj =  PageFactory.initElements(driver,OneWayFlightScript.class);                  // initializing PageFactory
      obj.searchOneWay4(email,fName,lName,contact);                                                         // Calling Method
	  Thread.sleep(3000);
	  String cn = driver.findElement(By.id("spanError")).getText();                                         // get Text of error
	  Assert.assertTrue(cn.contains("mobile number"), "Please enter a valid mobile number");                // Using Assertion to verify error message
         
  }
  
  
  
  @Test( priority = 4 ,enabled =true,description = "Error With First Name")  
  public void oneWayTest4() throws Exception
  {    
	  prop.load(new FileInputStream("Settings.property"));                                                  // To import from Settings.property file
	  driver.get(prop.getProperty("url"));                                                                  // Getting URL from property file 
      driver.manage().deleteAllCookies();                                                                   // Deleting all previous cookies
      OneWayFlightScript obj =  PageFactory.initElements(driver,OneWayFlightScript.class);                  // initializing PageFactory
	  obj.searchOneWay4("admin123@gmail.com" , " ","Wells", "8888899999");                          
	  Thread.sleep(3000);
	  String firstn = driver.findElement(By.id("spanErrorAdult0")).getText();                               // get Text of error
	  Assert.assertTrue(firstn.contains("First Name"), "Adult 1 First Name should have minimum 1");         // Using Assertion to verify error message
  
  }
  
  
  
  @Test(priority = 5,enabled =true,description = "Error With Last Name") 
  public void oneWayTest5() throws Exception
  {  
	  prop.load(new FileInputStream("Settings.property"));                                                  // To import from Settings.property file
	  driver.get(prop.getProperty("url"));                                                                  // Getting URL from property file
      driver.manage().deleteAllCookies();                                                                   // Deleting all previous cookies
	  OneWayFlightScript obj =  PageFactory.initElements(driver,OneWayFlightScript.class);                  // initializing PageFactory
	  obj.searchOneWay4("admin123@gmail.com" , "Barry","", "8888899999");                              
	  Thread.sleep(3000);
	  String firstn = driver.findElement(By.id("divErrorAdult0")).getText();                                // get Text of error
	  Assert.assertTrue(firstn.contains("Last Name"), "Adult 1 Last Name should have minimum 1character  and in case there is no last name kindly enter space bar key 3 times.");    // Using Assertion to verify error message
  }
  
  
  
  @Test(priority = 6,enabled =true,description="Alert-Source and Destination Cannot be Same")  
  public void oneWayTest6() throws Exception
  
  {  
	  Properties prop = new Properties();
	  prop.load(new FileInputStream("Settings.property"));                    // Loading Properties file 
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);        // Implicit wait
	 
	  driver.get(prop.getProperty("url"));                                    // Getting URL from property file
	  driver.findElement(By.id(prop.getProperty("to"))).click();              // importing from property file
	  driver.findElement(By.id(prop.getProperty("airport"))).click();         // importing from property file
	  driver.findElement(By.className(prop.getProperty("class"))).click();    // importing from property file
      driver.findElement(By.xpath(prop.getProperty("search"))).click();       // importing from property file
      
      String al=driver.switchTo().alert().getText();                          // Getting Text from ALERT BOX
      System.out.println("ALERT : "+ al);
      Assert.assertEquals("Source and Destination cannot be same", al);       // Using assertion to check condition
      
  }
  
  
 

}
  

