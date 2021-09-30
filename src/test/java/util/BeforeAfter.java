package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BeforeAfter
{    
	public WebDriver driver;
	@BeforeTest
	  public void beforeTest() throws Exception
	      {
	         driver = BrowserFactory.startBrowser("Chrome");
	         Thread.sleep(4000);
		  }

    @AfterTest
	  public void afterTest() throws Exception 
	  {
		  Thread.sleep(5000);
		  driver.quit();
	  }
}
