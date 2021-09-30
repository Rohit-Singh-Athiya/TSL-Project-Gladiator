package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory
{
   static WebDriver driver;
   
   public static WebDriver startBrowser(String browserName) throws Exception
   {
	   if(browserName.equalsIgnoreCase("Firefox")) 
	   {
		   driver = new FirefoxDriver();
	   }
  else if(browserName.equalsIgnoreCase("Chrome")) 
        {
	      System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver94.exe");
	       driver = new ChromeDriver();
       }
  else 
       {
	   System.out.println("Enter Correct browser name");
       }
	      
	   driver.manage().window().maximize();
	   
	   return driver;
   }
}
