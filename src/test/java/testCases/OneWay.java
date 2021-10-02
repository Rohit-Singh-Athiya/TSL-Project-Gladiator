package testCases;

import org.testng.annotations.Test;

import pages.C_OneWayFlight;
import util.BeforeAfter;
import util.BrowserFactory;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class OneWay extends BeforeAfter
{ 
   
  
  @Test(priority = 1,enabled =true,description = "Passing the Test Case" , dataProvider="test1data")  
  public void oneWayTest1(String email,String fName,String lName,String contact) throws Exception
  {   
	  driver.get("https://www.easemytrip.com/");
      driver.manage().deleteAllCookies();
	  C_OneWayFlight obj =  PageFactory.initElements(driver, C_OneWayFlight.class); 
	  obj.searchOneWay4(email,fName,lName,contact);
	  String chc = driver.getCurrentUrl();
	  Assert.assertTrue(chc.contains("CheckOut"), "https://flight.easemytrip.com/Review/CheckOut?CSU=&SearchID=4wj4xhewd3q&ft=7&bc=&ISWL=");
  }
  

  @Test( priority = 2 ,enabled =false,description = "Error With Email" )   
  public void oneWayTest2() throws Exception
  {    driver.get("https://www.easemytrip.com/");
	  C_OneWayFlight obj =  PageFactory.initElements(driver, C_OneWayFlight.class);
	  obj.searchOneWay4("abc","Cisco","Ramon","9885562171");
	  Thread.sleep(3000);
      String em = driver.findElement(By.id("divErrorEmail")).getText();
	  Assert.assertTrue(em.contains("email"), "Please enter a valid email Id");
  }
  
  
  @Test(priority = 3,enabled =false,description = "Error With contact number")    
  public void oneWayTest3() throws Exception 
  {    driver.get("https://www.easemytrip.com/");
       driver.manage().deleteAllCookies();
	   C_OneWayFlight obj =  PageFactory.initElements(driver, C_OneWayFlight.class);
	   obj.searchOneWay4("admin123@gmail.com" , "Cisco","West","22");
	   Thread.sleep(3000);
	   String cn = driver.findElement(By.id("spanError")).getText();
	   Assert.assertTrue(cn.contains("mobile number"), "Please enter a valid mobile number");
  }
  
  @Test( priority = 4 ,enabled =false,description = "Error With First Name")  
  public void oneWayTest4() throws Exception
  {    driver.get("https://www.easemytrip.com/");
       driver.manage().deleteAllCookies();
	   C_OneWayFlight obj =  PageFactory.initElements(driver, C_OneWayFlight.class);
	   obj.searchOneWay4("admin123@gmail.com" , " ","Wells", "8888899999");
	   Thread.sleep(3000);
	   String firstn = driver.findElement(By.id("spanErrorAdult0")).getText();
	   Assert.assertTrue(firstn.contains("First Name"), "Adult 1 First Name should have minimum 1");
  }
  
  
  @Test(priority = 5,enabled =false,description = "Error With Last Name") 
  public void oneWayTest5() throws Exception
  {  
	  driver.get("https://www.easemytrip.com/");
	  driver.manage().deleteAllCookies();
	  C_OneWayFlight obj =  PageFactory.initElements(driver, C_OneWayFlight.class);
	  obj.searchOneWay4("admin123@gmail.com" , "Barry","", "8888899999");
	  Thread.sleep(3000);
	  String firstn = driver.findElement(By.id("divErrorAdult0")).getText();
	  Assert.assertTrue(firstn.contains("Last Name"), "Adult 1 Last Name should have minimum 1character  and in case there is no last name kindly enter space bar key 3 times.");
  }
  
  
  @Test(priority = 6,enabled =false,description="Alert-Source and Destination Cannot be Same")  
  public void oneWayTest6() throws Exception
  
  {   driver.get("https://www.easemytrip.com/");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("Editbox13_show")).click();
	  driver.findElement(By.id("airport12")).click();
	  driver.findElement(By.className("optclass-name")).click();
      driver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input")).click();
      String al=driver.switchTo().alert().getText();
      System.out.println("ALERT : "+ al);
      Assert.assertEquals("Source and Destination cannot be same", al);
  }
  
  
  
  
  
  
  
  
  
  
  
  @Test  (enabled=false)
		public void test3()
          {	
	                driver.get("https://www.easemytrip.com/");
	                driver.manage().deleteAllCookies();
					driver.findElement(By.id("ddate")).sendKeys("02/10/2021");
					driver.findElement(By.id("rdate")).sendKeys("05/10/2021");
					driver.findElement(By.cssSelector(".s_col_7.mgr10")).click();
					driver.findElement(By.className("plus_box1")).click();
					driver.findElement(By.className("plus_boxChd")).click();					
		  }


  @Test(priority = 7,enabled =false,description="Hotel Book Now Button")  
  public void shivanitest() throws Exception
  
  {   driver.get("https://hotels.easemytrip.com/newhotel/Hotel/HotelDescription?e=202110112574&city=Mumbai,%20India&cin=22/10/2021&cOut=24/10/2021&Hotel=NA&Rooms=1&pax=3_1_3&key=15~INR~Mumbai~10-22-2021~10-24-2021~1~3_~1_3_~~EaseMyTrip~NA~NA~NA~IN&ecid=EMTHotel-1097872&hid=00000248");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("/html/body/div[6]/div[3]/div[2]/div[2]/div[6]/a[2]")).click();
	  
  }
  

}
  

