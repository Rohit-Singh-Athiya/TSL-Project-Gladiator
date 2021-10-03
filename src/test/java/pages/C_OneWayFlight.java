package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class C_OneWayFlight
{ 
	WebDriver driver;
	public C_OneWayFlight(WebDriver driver) 
	{
		this.driver=driver;
	}   
	 
     @FindBy(id = "FromSector_show") WebElement from; // From Location
     @FindBy(id = "Editbox13_show") WebElement to;     // To destination
     @FindBy(id = "airport12") WebElement from_airport; // Airport from
     @FindBy(id = "airport3") WebElement to_airport;   // Airport To
     @FindBy(id = "ddate") WebElement calendar;        // calendar
     @FindBy(id = "trd_0_10/10/2021") WebElement calender_date;        // select date
     @FindBy(className = "drpNoTrv") WebElement traveller;  
     @FindBy(className = "dropbtn_n10") WebElement classoftravel;   // select Class 
     @FindBy(className = "chk_flt") WebElement economy;
     @FindBy(xpath = "//body/form[@id='frmHome']/div[5]/div[2]/div[3]/div[1]/div[7]/input[1]") WebElement srch_btn;    // Search Button
     @FindBy(xpath = "//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]") WebElement book_now; // Click on Book Flight
     @FindBy(xpath = "//*[@id=\"divReview\"]/div[15]/div[4]/div[1]/label") WebElement medical_insu;  // Selecting 'YES' in medical refund policy;
     @FindBy(xpath = "//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label") WebElement travel_insu;  // Selecting 'NO' in travel insurance Policy;
     @FindBy(name= "txtEmailId") WebElement email;
     @FindBy(id = "spnVerifyEmail") WebElement continue_booking1; 
     @FindBy(className = "cmark_cbox") WebElement tra_det_cb;  // Traveller details Check box
     @FindBy(className = "select_trvl") WebElement gdr_title;   // Select gender title
     @FindBy(xpath = "//*[@id=\"titleAdult0\"]/option[2]") WebElement gdr_MR;   // Selecting MR 
     @FindBy(name= "txtFNAdult0") WebElement fname;    // for sending first name 
     @FindBy(name= "txtLNAdult0") WebElement lastname;  // for sending last name
     @FindBy(id = "txtCPhone") WebElement phn_no;   // phone number 
     @FindBy(id = "divContinueTransactionSCD") WebElement cnt_booking2;
     
     
     public void selectFrom() 
     {
    	 from.click();
    	 from_airport.click();
     }
     public void selectTo() 
     {   
    	 to.click();
    	 to_airport.click();
     }
     
     public void searchOneWay4(String emailID,String FirstName,String lastName,String Contact) throws Exception    // edits for fname 
     {   
    	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	 to.click();
    	 to_airport.click();
    	 calendar.click();
    	 calender_date.click();
    	 traveller.click();
    	 classoftravel.click();
    	 economy.click();
    	 srch_btn.click();
    	 Thread.sleep(4000);
    	 book_now.click();
    	 medical_insu.click();
    	 travel_insu.click();
    	 email.clear();
    	 email.sendKeys(emailID);
    	  if(emailID.contains("@"))
    		  {
    		     continue_booking1.click();
                 WebElement fp = driver.findElement(By.id("titleAdult0"));
                 Select s1 = new Select(fp);
                 s1.selectByVisibleText("MR");
                 fname.clear();
                 fname.sendKeys(FirstName);
                 lastname.clear();
                 lastname.sendKeys(lastName);
                 Thread.sleep(2000);
                 phn_no.click();
                 phn_no.clear();
                 phn_no.sendKeys(Contact);
                    if(Contact.isBlank()) 
                     { 
                    	cnt_booking2.click();
                       System.out.println("Please Enter a valid Contact Number");              	 
                     }
                    else if(FirstName.isBlank())
                    { 
                    	cnt_booking2.click();             	
                        System.out.println("Please Enter a valid First Name "); 	
                    } 
                    else if(lastName.isEmpty()) 
                    {
                    	cnt_booking2.click();             	
                        System.out.println("Please Enter a valid Last Name "); 
                    }
                   
                  else 
                     {
                       Thread.sleep(2000);
                       cnt_booking2.click();
                     }
    		   }
    	else 
    	  {
    		continue_booking1.click();
    		System.out.println("Enter Correct EmailID");  
    	  }
    	 
    	 
    	    	 
     }
     
     
    
     
 }


