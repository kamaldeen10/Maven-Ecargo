package E2EcargoProject;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bkg.base.base;
import com.bkg.bookingpageobjects.EBookingTabscreens;
import com.bkg.bookingpageobjects.EBookingverify;
import com.bkg.bookingpageobjects.ELandingpage;
import com.bkg.bookingpageobjects.Elogin;

public class EcargoBkg_Cancel_Test extends base {

	public WebDriver driver;
	public  static Logger log =LogManager.getLogger(base.class.getName());
	
		
	@BeforeTest
	public void Intialize () throws IOException {
		driver = Initializedriver();
		log.info("Driver is Intialized");
		driver.get(Prop.getProperty("uaturl"));	
					
	}
	
	@Test
	public void Booking_Cancel_Flow () throws IOException, InterruptedException, AWTException
	{
		Prop = new Properties();
		FileInputStream Fis1 = new FileInputStream(System.getProperty("user.dir")+"\\resources\\dataset.properties");	
	    Prop.load(Fis1);
	    String Username =Prop.getProperty("Username");	
	    String Password =Prop.getProperty("Password");
	    String Awb_Prefix =Prop.getProperty("Awb_Prefix");
	    String Awb_No =Prop.getProperty("Awb_No");
	    String Full_AwbNo =Prop.getProperty("Full_AwbNo");		
	    String Flight_1  =Prop.getProperty("Flight_1");		  	
	    String Flight_Date_1 =Prop.getProperty("Flight_Date_1");
	    String CancelStatus =Prop.getProperty("CancelStatus");
	    
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Elogin login = new Elogin(driver);		
		ELandingpage home = new ELandingpage(driver);			
		EBookingTabscreens Tab = new EBookingTabscreens(driver);		
		EBookingverify Ressearch = new EBookingverify (driver);	
		
		 
			// driver.get(Url);
			login.Username().sendKeys(Username);
			login.Password().sendKeys(Password);
			login.Login().click();	
			Elogin.Waittilljquesryupdated(driver);
			  String Loginname = login.user().getText();		 
			  log.info(Loginname);
			    System.out.println(Loginname);
			    Assert.assertEquals(Loginname,Username);
			    
			    
			    js.executeScript("arguments[0].click()", home.Togglelink());
			    js.executeScript("arguments[0].click()",home.menuReservationMgt());
			    js.executeScript("arguments[0].click()",home.ResDashboard());
			
			    
	    
	js.executeScript("arguments[0].click()", Ressearch.OpenSearch_list());
	Elogin.Waittilljquesryupdated(driver);
	  Ressearch.S_AwbPrefix().sendKeys(Awb_Prefix); 
   	 Elogin.Waittilljquesryupdated(driver);
     Ressearch.S_AwbNo().sendKeys(Awb_No);
 	 Elogin.Waittilljquesryupdated(driver);
		Ressearch.S_Flightno().sendKeys(Flight_1);
		Elogin.Waittilljquesryupdated(driver);
		Ressearch.S_FlightFrom().sendKeys(Flight_Date_1);
		Elogin.Waittilljquesryupdated(driver);
		Ressearch.S_FlightTo().sendKeys(Flight_Date_1);	
		Elogin.Waittilljquesryupdated(driver);
		js.executeScript("arguments[0].click()", Ressearch.Res_Search());
		Elogin.Waittilljquesryupdated(driver);
		Thread.sleep(3000); 
		js.executeScript("arguments[0].click()", Ressearch.Res_Verify_AwbNosearch());	   	    
		
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	

		Elogin.Waittilljquesryupdated(driver);
		js.executeScript("arguments[0].click()",Tab.ShowCancelbutton());
		Elogin.Waittilljquesryupdated(driver);
		js.executeScript("arguments[0].click()",Tab.BkgCancelbutton());
		Elogin.Waittilljquesryupdated(driver);
		Thread.sleep(2000); 
		js.executeScript("arguments[0].click()",Tab.Allcateto());
		Elogin.Waittilljquesryupdated(driver);
		js.executeScript("arguments[0].click()",Tab.Choose_AllcatetoGSA());
		Elogin.Waittilljquesryupdated(driver);
		Thread.sleep(3000); 
		
		js.executeScript("arguments[0].click()",Tab.CancelSave());
		Elogin.Waittilljquesryupdated(driver);
				
		
		js.executeScript("arguments[0].click()", Tab.CloseTab());
		Elogin.Waittilljquesryupdated(driver);					
		Thread.sleep(3000); 
		js.executeScript("arguments[0].click()", Ressearch.OpenSearch_list());
		Elogin.Waittilljquesryupdated(driver);
		js.executeScript("arguments[0].click()", Ressearch.Res_Search());
		Elogin.Waittilljquesryupdated(driver);
		Thread.sleep(5000); 
		
		Boolean verifyAwbsNOIsPresent = Ressearch.Res_Verify_AwbNosearch().getText().equalsIgnoreCase(Full_AwbNo);
    	assertTrue(verifyAwbsNOIsPresent );
    	Boolean verifybkgCancellStatusIsPresent  =Ressearch.Res_Verify_BkgCancelled().getText().equalsIgnoreCase(CancelStatus);		
    	assertTrue(verifybkgCancellStatusIsPresent);
    	  log.info("Booking Cancelled Sucessfully" );

}

	@AfterTest

	public void teardown()
	{
	driver.close();	

	}
}
