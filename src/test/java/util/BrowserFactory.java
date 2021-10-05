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
	   if(browserName.equalsIgnoreCase("Firefox"))                                                            // Checking for Browser parameter while ignoring the case   
	   {
		   System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");        // Specifying property name and path  
		   driver = new FirefoxDriver();                                                                      // Initializing driver based on property
	   }
  else if(browserName.equalsIgnoreCase("Chrome"))                                                             // Checking for Browser parameter while ignoring the case   
        {
	       System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver94.exe");    // Specifying property name and path 
	       driver = new ChromeDriver();                                                                       // Initializing driver based on property
       }
  else 
       {
	   System.out.println("Enter Correct browser name");           
       }
	      
	   driver.manage().window().maximize();                                                                   // Maximize browser window 
	   
	   return driver;
   }
}
