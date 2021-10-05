package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OneWayFlightScript
{ 
	WebDriver driver;
	public OneWayFlightScript(WebDriver driver) 
	{
		this.driver=driver;
	}   
	 
     @FindBy(id = "FromSector_show") WebElement from;                           // From Location
     @FindBy(id = "Editbox13_show") WebElement to;                              // To destination
     @FindBy(id = "airport12") WebElement from_airport;                         // Airport from
     @FindBy(id = "airport3") WebElement to_airport;                            // Airport To
     @FindBy(id = "ddate") WebElement calendar;                                 // calendar
     @FindBy(id = "trd_0_10/10/2021") WebElement calender_date;                 // select date
     @FindBy(className = "drpNoTrv") WebElement traveller;                      // Select Number of Travelers
     @FindBy(className = "dropbtn_n10") WebElement classoftravel;               // select Class 
     @FindBy(className = "chk_flt") WebElement economy;
     @FindBy(xpath = "//body/form[@id='frmHome']/div[5]/div[2]/div[3]/div[1]/div[7]/input[1]") WebElement srch_btn;            // Search Button
     @FindBy(xpath = "//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]") WebElement book_now;       // Click on Book Flight
     @FindBy(xpath = "//*[@id=\"divReview\"]/div[15]/div[4]/div[1]/label") WebElement medical_insu;                            // Medical refund policy;
     @FindBy(xpath = "//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label") WebElement travel_insu;                               // Travel insurance Policy;
     @FindBy(name= "txtEmailId") WebElement email;                              // Email ID
     @FindBy(id = "spnVerifyEmail") WebElement continue_booking1;               // Continue Booking Button1
     @FindBy(className = "cmark_cbox") WebElement tra_det_cb;                   // Traveler details Check box
     @FindBy(className = "select_trvl") WebElement gdr_title;                   // Select gender title
     @FindBy(xpath = "//*[@id=\"titleAdult0\"]/option[2]") WebElement gdr_MR;   // Selecting MR 
     @FindBy(name= "txtFNAdult0") WebElement fname;                             // for sending first name 
     @FindBy(name= "txtLNAdult0") WebElement lastname;                          // for sending last name
     @FindBy(id = "txtCPhone") WebElement phn_no;                               // phone number 
     @FindBy(id = "divContinueTransactionSCD") WebElement cnt_booking2;         // Continue Booking Button 2
     
     
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
     
     public void searchOneWay4(String emailID,String FirstName,String lastName,String Contact) throws Exception    
     {   
    	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);    // Implicit Wait
    	      to.click();                                                      // Click on from Location Text field        
    	      to_airport.click();                                              // Click and Select Airport
    	      calendar.click();                                                // Click date of traveling
    	      calender_date.click();                                           // Select date of traveling       
              traveller.click();                                               // Select Number of Travelers
              classoftravel.click();                                           // Click on Class of travel
    	      economy.click();                                                 // Select Economy
    	      srch_btn.click();                                                // Search For Flights
    	//    Thread.sleep(4000);           
    	      book_now.click();                                                // Select and click on Flight
    	      medical_insu.click();                                            // Selecting YES in medical refund policy            
    	      travel_insu.click();                                             // Selecting NO in Travel insurance
    	      email.clear();                                                   // Clear Email field
    	      email.sendKeys(emailID);                                         // Enter Email ID
    	        if(emailID.contains("@"))                                      // If else condition for Invalid Email ID
    		      {
    		       continue_booking1.click();                                  // Click on Continue Booking 
                   WebElement fp = driver.findElement(By.id("titleAdult0"));   // Finding Drop down of Title
                   Select s1 = new Select(fp);                                 // Using SELECT class to handle drop down 
                   s1.selectByVisibleText("MR");                               // Using selectbyVisibleText method to select title MR
                   fname.clear();                                              // Clear first name
                   fname.sendKeys(FirstName);                                  // Send First name
                   lastname.clear();                                           // Clear last name
                   lastname.sendKeys(lastName);                                // Send  last name
                   Thread.sleep(2000);                                         // Sleep script for 2 seconds
                   phn_no.click();                                             // Click on phone number
                   phn_no.clear();                                             // Clear phone number 
                   phn_no.sendKeys(Contact);                                   // Enter phone number
                      if(Contact.isBlank())                                    // If else condition for handling contact field
                        { 
                    	 cnt_booking2.click();                                 // Click on continue booking button
                         System.out.println("Please Enter a valid Contact Number");              	 
                        }
                 else if(FirstName.isBlank())                                  // Condition for handling First name field
                        { 
                         cnt_booking2.click();             	                   // Click on continue booking button
                         System.out.println("Please Enter a valid First Name "); 	
                        } 
                 else if(lastName.isEmpty())                                   // Condition for handling Last Name field
                        {
                         cnt_booking2.click();             	                   // Click on continue booking
                         System.out.println("Please Enter a valid Last Name "); 
                        }
                   
                    else 
                        {
                         Thread.sleep(2000);
                         cnt_booking2.click();                                 // Click on continue booking
                        }
    		      }
    	   else                                                               // else block for email id
    	      {
    		   continue_booking1.click();                                     // Click on continue booking button
    		   System.out.println("Enter Correct EmailID");  
    	      }
    	 
    	 
    	    	 
     }
     
     
    
     
 }


