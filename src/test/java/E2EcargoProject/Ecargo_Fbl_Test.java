package E2EcargoProject;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bkg.base.base;
import com.bkg.bookingpageobjects.EBookingCreate;
import com.bkg.bookingpageobjects.EFlightMgmtFBL;
import com.bkg.bookingpageobjects.ELandingpage;
import com.bkg.bookingpageobjects.Elogin;
import com.bkg.methods.libraries.Download_Uploadfile;

public class Ecargo_Fbl_Test extends base {

	public WebDriver driver;
	public  static Logger log =LogManager.getLogger(base.class.getName());
	
		
	@BeforeTest
	public void Intialize () throws IOException {
		driver = Initializedriver();
		log.info("Driver is Intialized");
		driver.get(Prop.getProperty("uaturl"));			
				
	}
	
	@Test
	public void Manual_Booking_Flow () throws IOException, InterruptedException, AWTException
	{
		Prop = new Properties();		
		FileInputStream Fis1 = new FileInputStream(System.getProperty("user.dir")+"\\resources\\dataset.properties");		
	    Prop.load(Fis1);
	    String Username =Prop.getProperty("Username");	
	    String Password =Prop.getProperty("Password");
	
	    String Full_AwbNo1 =Prop.getProperty("Full_AwbNo1");
	    String Agent =Prop.getProperty("Agent");	
	    String Origin_1 =Prop.getProperty("Origin_1");
	    String Destination_1 =Prop.getProperty("Destination_1");
	    String Destination_2 =Prop.getProperty("Destination_2");	 	
	    String Delivery_Date =Prop.getProperty("Delivery_Date");
	    String SHCS =Prop.getProperty("SHCS");
	    String Flight_1  =Prop.getProperty("Flight_1");		   
	    String Flight_Date_1 =Prop.getProperty("Flight_Date_1");	
	    String Delivery_Point=	Prop.getProperty("Delivery_Point");	
	    String Bkg_status =Prop.getProperty("Bkg_status");	
	    String Priority = Prop.getProperty("Priority");	
	    String pcs = Prop.getProperty("pcs");	
	    String GrossWt = Prop.getProperty("GrossWt");	
	    String ChWt = Prop.getProperty("ChWt");	
	    String Vol = Prop.getProperty("Vol");	

	    JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Elogin login = new Elogin(driver);		
		ELandingpage home = new ELandingpage(driver);	
		EFlightMgmtFBL fbl = new EFlightMgmtFBL (driver);
	
		
		
		login.Username().sendKeys(Username);
		login.Password().sendKeys(Password);
		login.Login().click();	
		Elogin.Waittilljquesryupdated(driver);
		
		Thread.sleep(3000);
		    
		    
		  //  
		  //  js.executeScript("arguments[0].click()",home.menuReservationMgt());
		 //   js.executeScript("arguments[0].click()",home.ResDashboard());
		    			
			
			js.executeScript("arguments[0].click()", home.Togglelink());
			Thread.sleep(3000);
			
		    js.executeScript("arguments[0].click()",fbl.Menu_Flight_Mgt());
			Thread.sleep(3000);
		    js.executeScript("arguments[0].click()",fbl.Menu_Fbl());		    
			Elogin.Waittilljquesryupdated(driver);
			
			
			Thread.sleep(3000);
			
			js.executeScript("arguments[0].click()",fbl.Fbl_Carrier());	
			Elogin.Waittilljquesryupdated(driver);
			js.executeScript("arguments[0].click()",fbl.Fbl_Carrier_Select());
			Elogin.Waittilljquesryupdated(driver);
			
			fbl.Fbl_Flightno().sendKeys(Flight_1);
			fbl.Fbl_Origin().sendKeys(Origin_1);
			fbl.Fbl_Dest().sendKeys(Destination_1);
			fbl.Fbl_FlightfromDate().clear();
			fbl.Fbl_FlightfromDate().sendKeys(Flight_Date_1);
			fbl.Fbl_FlightToDate().sendKeys(Flight_Date_1);
			Thread.sleep(3000);
			 js.executeScript("arguments[0].click()",fbl.Fbl_Search());	
				Thread.sleep(3000);
			Elogin.Waittilljquesryupdated(driver);
				
			
		   
		    js.executeScript("arguments[0].click()",fbl.Fbl_List_Expand());
			Thread.sleep(3000);
		    
		    Boolean VerifyFbl_PriorityIsPresent = fbl.Fbl_Verify_Priority().getText().equalsIgnoreCase(Priority);
			assertTrue(VerifyFbl_PriorityIsPresent);
			Boolean VerifyFbl_AwbIsPresent = fbl.Fbl_Verify_Awb().getText().equalsIgnoreCase(Full_AwbNo1);
			assertTrue(VerifyFbl_AwbIsPresent);
			Boolean VerifyFbl_AgentIsPresent = fbl.Fbl_Verify_Agent().getText().equalsIgnoreCase(Agent);
			assertTrue(VerifyFbl_AgentIsPresent);
			Boolean VerifyFbl_OriginIsPresent = fbl.Fbl_Verify_Origin().getText().equalsIgnoreCase(Origin_1);
			assertTrue(VerifyFbl_OriginIsPresent);
		   Boolean VerifyFbl_DestIsPresent = fbl.Fbl_Verify_Dest().getText().equalsIgnoreCase(Destination_2);
			assertTrue(VerifyFbl_DestIsPresent);
			Boolean VerifyFbl_PcsIsPresent = fbl.Fbl_Verify_Pcs().getText().equalsIgnoreCase(pcs);
			assertTrue(VerifyFbl_PcsIsPresent);
		   Boolean VerifyFbl_GrsWtIsPresent = fbl.Fbl_Verify_GrsWt().getText().equalsIgnoreCase(GrossWt);
		   assertTrue(VerifyFbl_GrsWtIsPresent);
		   Boolean VerifyFbl_ChrgWtIsPresent = fbl.Fbl_Verify_ChrgWt().getText().equalsIgnoreCase(ChWt);
		assertTrue(VerifyFbl_ChrgWtIsPresent);
		Boolean VerifyFbl_VolIsPresent = fbl.Fbl_Verify_Vol().getText().equalsIgnoreCase(Vol);
		assertTrue(VerifyFbl_VolIsPresent);
		Boolean VerifyFbl_SHCIsPresent = fbl.Fbl_Verify_SHC().getText().equalsIgnoreCase(SHCS);
		assertTrue(VerifyFbl_SHCIsPresent);
	  Boolean VerifyFbl_DLVPointIsPresent = fbl.Fbl_Verify_DLVPoint().getText().equalsIgnoreCase(Delivery_Point);
	  assertTrue(VerifyFbl_DLVPointIsPresent);
	// Boolean VerifyFbl_DLVDateIsPresent = fbl.Fbl_Verify_DLVDate().getText().equalsIgnoreCase(Delivery_Date);
    //assertTrue(VerifyFbl_DLVDateIsPresent);
	Boolean VerifyFbl_bkgStatusIsPresent = fbl.Fbl_Verify_bkgStatus().getText().equalsIgnoreCase(Bkg_status);
	assertTrue(VerifyFbl_bkgStatusIsPresent);	
	
	Thread.sleep(4000);
			
		    js.executeScript("arguments[0].click()",fbl.Fbl_Checkbox());
		    
		    js.executeScript("arguments[0].click()",fbl.Fbl_Print());
		    
			Thread.sleep(12000);
		  
			ArrayList<String> tab2 = new ArrayList<String> (driver.getWindowHandles());
      		log.info(tab2.size());
      		System.out.println(tab2.size());
      	    driver.switchTo().window(tab2.get(1));
      	    System.out.println("New window has been opened.");
			String newURL = driver.getCurrentUrl();	       			
			log.info(newURL);		        			
			 Thread.sleep(3000);
			String downloadfilepath = (System.getProperty("user.dir")+"\\Downloads\\Fbl.pdf");					 				 	
		 	Download_Uploadfile.Downloadfile(downloadfilepath);
		 	 Thread.sleep(1000);				              	    
          	// driver.close();
          	 driver.switchTo().window(tab2.get(0));
          	 Thread.sleep(5000);
	     	 				 		
		    
}
}