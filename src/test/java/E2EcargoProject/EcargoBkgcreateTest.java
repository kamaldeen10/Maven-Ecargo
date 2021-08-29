package E2EcargoProject;



import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bkg.base.base;
import com.bkg.bookingpageobjects.EAirwaybillTab;
import com.bkg.bookingpageobjects.EBookingCreate;
import com.bkg.bookingpageobjects.EBookingTabscreens;
import com.bkg.bookingpageobjects.EBookingverify;
import com.bkg.bookingpageobjects.EEpouchTab;
import com.bkg.bookingpageobjects.ELandingpage;
import com.bkg.bookingpageobjects.EPricingTab;
import com.bkg.bookingpageobjects.Elogin;
import com.bkg.methods.libraries.Download_Uploadfile;




public class EcargoBkgcreateTest extends base {

	public WebDriver driver;
	public  static Logger log =LogManager.getLogger(base.class.getName());
	
		
	@BeforeTest
	public void Intialize () throws IOException {
		driver = Initializedriver();
		log.info("Driver is Intialized");
		driver.get(Prop.getProperty("uaturl"));	
		
				
	}
	
	@Test
	public void Bookingflow () throws IOException, InterruptedException, AWTException
	{
		Prop = new Properties();
		FileInputStream Fis1 = new FileInputStream("D:\\Automation\\Project\\E2EcargoProject\\resources\\dataset.properties");
	    Prop.load(Fis1);
	    String Username =Prop.getProperty("Username");	
	    String Password =Prop.getProperty("Password");
	    String Awb_Prefix =Prop.getProperty("Awb_Prefix");
	    String Awb_No =Prop.getProperty("Awb_No");
	    String Full_AwbNo =Prop.getProperty("Full_AwbNo");
	    String Agent =Prop.getProperty("Agent");	
	    String Origin_1 =Prop.getProperty("Origin_1");	
	    String Destination_1 =Prop.getProperty("Destination_1");	
	    String Origin_2 =Prop.getProperty("Origin_2");	
	    String Destination_2 =Prop.getProperty("Destination_2");	
	    String Pieces	  =Prop.getProperty("Pieces");	
	    String Gross_Wt	  =Prop.getProperty("Gross_Wt");	
	  	String Commodity =Prop.getProperty("Commodity");	
	    String Delivery_Date =Prop.getProperty("Delivery_Date");	
	    String Flight_1  =Prop.getProperty("Flight_1");	
	    String Flight_2  =Prop.getProperty("Flight_2");	
	    String Flight_Date_1 =Prop.getProperty("Flight_Date_1");	
	    String Flight_Date_2 =Prop.getProperty("Flight_Date_2");	
	    String Delivery_Point=	Prop.getProperty("Delivery_Point");	
	    String Bkg_status =Prop.getProperty("Bkg_status");	
	    String VerifyBookingconfirm =Prop.getProperty("VerifyBookingconfirm");	
	    String Buyamt =Prop.getProperty("Buyamt");	
	    String Sellamt =Prop.getProperty("Sellamt");
        String Volume =Prop.getProperty("Volume");	
	 	    String Security =Prop.getProperty("Security");
			    String Producttype =Prop.getProperty("Producttype");
			    String SHC =Prop.getProperty("SHC");
	    String Othercharge =Prop.getProperty("Othercharge");
	   String Totaldue = Prop.getProperty("Totaldue");	
	   String Shipper = Prop.getProperty("Shipper");	 
		String Consignee = Prop.getProperty("Consignee");	 
		String AccountInfo = Prop.getProperty("AccountInfo");	 
		String HandlingInfo = Prop.getProperty("HandlingInfo");	 
		 
		String CostAmt = Prop.getProperty("CostAmt");	 
		String SoldAmt = Prop.getProperty("SoldAmt");	 
		String VatAmt = Prop.getProperty("VatAmt");	 
		String TotalAmt_A = Prop.getProperty("TotalAmt_A");	 
		String CostAmt_B = Prop.getProperty("CostAmt_B");
		String Commission = Prop.getProperty("Commission");	 
		String Margin = Prop.getProperty("Margin");
	  	
	    	     
		

	    
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Elogin login = new Elogin(driver);		
		ELandingpage home = new ELandingpage(driver);	
		EBookingCreate bkg = new EBookingCreate(driver);		
		EBookingTabscreens Tab = new EBookingTabscreens(driver);		
		EBookingverify Ressearch = new EBookingverify (driver);		
		EAirwaybillTab EATab = new EAirwaybillTab (driver);
		EPricingTab EPTab = new EPricingTab (driver);
		EEpouchTab EPoTab = new EEpouchTab (driver);    	
		 Actions act = new Actions(driver);
		
		 
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
		    Assert.assertEquals( home.Title().getText(),"RES Dashboard");
		    js.executeScript("arguments[0].click()", bkg.CreateTab());
		    js.executeScript("arguments[0].click()", bkg.Toggle());

		    
			Elogin.Waittilljquesryupdated(driver);
			 bkg.Awbprefix().sendKeys(Awb_Prefix);
			 bkg.Awb().sendKeys(Awb_No);			
			js.executeScript("arguments[0].click()", bkg.Stockpopup());				
				js.executeScript("arguments[0].click()", bkg.Stockselect());
				Elogin.Waittilljquesryupdated(driver);				
				bkg.Origin_1().clear();				
				bkg.Origin_1().sendKeys(Origin_1);				
				bkg.Destination_2().clear();			
				bkg.Destination_2().sendKeys(Destination_2);
				bkg.Agentname().clear();
				bkg.Agentname().sendKeys(Agent);
			    Elogin.Waittilljquesryupdated(driver);
				js.executeScript("arguments[0].click()", bkg.Agentnameselect());
				

				 js.executeScript("arguments[0].click()", bkg.AddFlightab1());
				 Elogin.Waittilljquesryupdated(driver);
					bkg.roworigin1().clear();
					bkg.roworigin1().sendKeys(Origin_1);
					bkg.rowDest1().clear();
					bkg.rowDest1().sendKeys(Destination_1);
					bkg.flight1().sendKeys(Flight_1);
					Elogin.Waittilljquesryupdated(driver);
					bkg.flightdetailpopup().click();
					Elogin.Waittilljquesryupdated(driver);
					bkg.flightdetailsearch().click();
					Elogin.Waittilljquesryupdated(driver);
					bkg.flightdetailReset().click();
					Elogin.Waittilljquesryupdated(driver);
					bkg.Searchflight().sendKeys(Flight_1);
					wait.until(ExpectedConditions.visibilityOf(bkg.Flight_From()));
					bkg.Flight_From().sendKeys(Flight_Date_1);
					wait.until(ExpectedConditions.visibilityOf(bkg.Flight_To()));
					bkg.Flight_To().sendKeys(Flight_Date_1);
					wait.until(ExpectedConditions.visibilityOf(bkg.Flight_origin()));
					bkg.Flight_origin().sendKeys(Origin_1);	
					wait.until(ExpectedConditions.visibilityOf(bkg.Flight_destination()));
					bkg.Flight_destination().sendKeys(Destination_1);
					js.executeScript("arguments[0].click()", bkg.Searchbutton());
					Elogin.Waittilljquesryupdated(driver);
					js.executeScript("arguments[0].click()", bkg.Flighttext());	
					Elogin.Waittilljquesryupdated(driver);
					js.executeScript("arguments[0].click()", bkg.Flightselect());
					Elogin.Waittilljquesryupdated(driver);

					
					bkg.roworigin2().clear();
					bkg.roworigin2().sendKeys(Origin_2);
				    bkg.rowDest2().sendKeys(Destination_2);
					bkg.flight2().sendKeys(Flight_2);					
					bkg.flightdetailpopup2().click();
					Elogin.Waittilljquesryupdated(driver);
					bkg.flightdetailsearch2().click();
					Elogin.Waittilljquesryupdated(driver);
					bkg.flightdetailReset2().click();
					Elogin.Waittilljquesryupdated(driver);
					bkg.Searchflight2().sendKeys(Flight_2);	
					wait.until(ExpectedConditions.visibilityOf(bkg.Flight_From()));
					bkg.Flight_From2().sendKeys(Flight_Date_2);	
					wait.until(ExpectedConditions.visibilityOf(bkg.Flight_To()));
					bkg.Flight_To2().sendKeys(Flight_Date_2);
					wait.until(ExpectedConditions.visibilityOf(bkg.Flight_origin()));
					bkg.Flight_origin2().sendKeys(Origin_2);
					wait.until(ExpectedConditions.visibilityOf(bkg.Flight_destination()));
					bkg.Flight_destination2().sendKeys(Destination_2);					
					js.executeScript("arguments[0].click()", bkg.Searchbutton2());
					Elogin.Waittilljquesryupdated(driver);
					js.executeScript("arguments[0].click()", bkg.Flighttext2());
					Elogin.Waittilljquesryupdated(driver);
					js.executeScript("arguments[0].click()", bkg.Flightselect2());
					Elogin.Waittilljquesryupdated(driver);				
					
					bkg.Piece().sendKeys(Pieces);
					bkg.Grosswt().sendKeys(Gross_Wt);
					bkg.Commodity().sendKeys(Commodity);
					
					
					js.executeScript("arguments[0].click()", bkg.Producttype());
					log.info(bkg.Producttype().getText());
					System.out.println(bkg.Producttype().getText());
					//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  	js.executeScript("arguments[0].click()", bkg.SelectProducttype());	
					log.info(bkg.SelectProducttype().getText());
				  	System.out.println(bkg.SelectProducttype().getText());				  	
				  	js.executeScript("arguments[0].click()", bkg.ShcTab());	
				  	//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					js.executeScript("arguments[0].click()", bkg.Shc1());
					js.executeScript("arguments[0].click()", bkg.Shc2());
					js.executeScript("arguments[0].click()", bkg.Shcsave());
					
				 
					
					bkg.Deliverydate().clear();
					bkg.Deliverydate().sendKeys(Delivery_Date);						
				  	js.executeScript("arguments[0].click()", bkg.Deliverypoint());					  	
				  	bkg.Deliverypointsearch().sendKeys(Delivery_Point);	
				  	wait.until(ExpectedConditions.visibilityOf(bkg.Deliverycode()));
					js.executeScript("arguments[0].click()", bkg.Deliverycode());					
					js.executeScript("arguments[0].click()", bkg.Selectdeliverycode());
					Elogin.Waittilljquesryupdated(driver);
										
				
					js.executeScript("arguments[0].click()", bkg.SaveBooking());
					Elogin.Waittilljquesryupdated(driver);
					
					for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
					}
					  
					Elogin.Waittilljquesryupdated(driver);
	             js.executeScript("arguments[0].click()", bkg.PopupClose());
	               log.info("Booking Created Sucessfully");
	System.out.println("Booking Created Sucessfully");
	
 

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	String BkgStatus = bkg.BookingStatusCheck().getText();
	System.out.println("Booking status  is " + BkgStatus);	
	 log.info("Booking status  is " + BkgStatus);
	Assert.assertEquals(BkgStatus, Bkg_status);	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		js.executeScript("arguments[0].click()", Tab.Notesbutton());
	Tab.Notes().sendKeys(VerifyBookingconfirm);
	js.executeScript("arguments[0].click()", Tab.NotesSave());

	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		 				
	String Tariff_Buy = bkg.BuyingAmount().getAttribute("value");
		System.out.println("Buying rate is " + Tariff_Buy);	
		 log.info("Buying rate is " + Tariff_Buy);
		String Tariff_Sell = bkg.SellingAmount().getAttribute("value");		
		System.out.println("Selling rate is " +  Tariff_Sell);	
		log.info("Selling rate is " +  Tariff_Sell);
		 Assert.assertEquals(Tariff_Buy, Buyamt);
	     Assert.assertEquals(Tariff_Sell, Sellamt);
	     
	//Airwaybill Tab Save
	    
	 		 
	 		 
	 		 
	     
	  
		js.executeScript("arguments[0].click()", Tab.BookingClose());
		Elogin.Waittilljquesryupdated(driver);
					
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
//Verify:	
			Boolean verifyAwbsNOIsPresent = Ressearch.Res_Verify_AwbNosearch().getText().equalsIgnoreCase(Full_AwbNo);
	    	assertTrue(verifyAwbsNOIsPresent );          
	    	Boolean verifyoriginIsPresent  = Ressearch.Res_Verify_Originsearch().getText().equalsIgnoreCase(Origin_1);
	    	assertTrue(verifyoriginIsPresent);            
	    	Boolean verifyDestinationIsPresent  = Ressearch.Res_Verify_Destinationsearch().getText().equalsIgnoreCase(Destination_2);
	    	assertTrue(verifyDestinationIsPresent);            	
	    	Boolean verifyFlighIsPresent  = Ressearch.Res_Verify_Fligthsearch().getText().equalsIgnoreCase(Flight_1);
	    	assertTrue(verifyFlighIsPresent);           
	    	Boolean verifyFlightDateIsPresent  = Ressearch.Res_Verify_FligthDatesearch().getText().equalsIgnoreCase(Flight_Date_1);
	    	assertTrue(verifyFlightDateIsPresent );        
	    	Boolean verifyPieceIsPresent  = Ressearch.Res_Verify_Piecesearch().getText().equalsIgnoreCase(Pieces);
	    	assertTrue(verifyPieceIsPresent);            
	    	Boolean verifyGrosswtIsPresent  = Ressearch.Res_Verify_Groswtsearch().getText().equalsIgnoreCase(Gross_Wt);
	    	assertTrue(verifyGrosswtIsPresent );            	
	    	Boolean verifyVolIsPresent  = Ressearch.Res_Verify_Volsearch().getText().equalsIgnoreCase(Volume);
	    	assertTrue(verifyVolIsPresent);            	
	    	Boolean verifyAgentIsPresent  = Ressearch. Res_Verify_Agentsearch().getText().equalsIgnoreCase(Agent);
	    	assertTrue(verifyAgentIsPresent);            
	    	Boolean verifyPoductIsPresent  = Ressearch.Res_Verify_Productsearch().getText().equalsIgnoreCase(Producttype);
	    	assertTrue(verifyPoductIsPresent );            
	    	Boolean verifyShcIsPresent  = Ressearch.Res_Verify_SHCsearch().getText().equalsIgnoreCase(SHC);
	    	assertTrue(verifyShcIsPresent);
	    	Boolean verifySecurityIsPresent  = Ressearch.Res_Verify_Securitysearch ().getText().equalsIgnoreCase(Security);
	    	assertTrue(verifySecurityIsPresent);            	
	    	Boolean verifybkgStatusIsPresent  =Ressearch.Res_Verify_BkgStatussearch().getText().equalsIgnoreCase(Bkg_status);
	    	assertTrue(verifybkgStatusIsPresent);
	    log.info("FightNo and FlightDate search is Pass" );
	    	 

	           
	           
	    	    
//Double lick open awb
	    		
	    	    js.executeScript("arguments[0].click()", Ressearch.Res_Verify_AwbNosearch());	
	    	
	    
	    		
	    		// Act.moveToElement(Ressearch.Res_Verify_BkgStatussearch()).doubleClick().build().perform();
	    	
	    	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    		Elogin.Waittilljquesryupdated(driver);
	    		Thread.sleep(5000);
	    	   String BkgStatus1 = bkg.BookingStatusCheck().getText();
	    	   log.info("Booking status  is " + BkgStatus1);
	    	System.out.println("Booking status  is " + BkgStatus1);	    
		
	  //  Bkgtab:
	    		 String V_Othercharge = Tab.OtherCharges().getAttribute("value");
	 			System.out.println("Othercharge is " + V_Othercharge);
	 			  log.info("Othercharge is " + V_Othercharge);
	 			String V_TotalDue = Tab.TotalDue().getAttribute("value");		
	 			System.out.println("Total due  is " +  V_TotalDue);	
	 			log.info("Total due  is " +  V_TotalDue);	 			
	 			 Assert.assertEquals(V_Othercharge, Othercharge);
	 		     Assert.assertEquals(V_TotalDue, Totaldue); 		     
	 		
	 		  //Airwaybilltab Save	    	 
		    	 
		    	 
		    	 js.executeScript("arguments[0].click()", EATab.Airwaybilltab());
				   Thread.sleep(8000);
				    EATab.AccInfo().sendKeys(AccountInfo);
			 		  Elogin.Waittilljquesryupdated(driver);
			 		 EATab.HandlingInfo().sendKeys(HandlingInfo);
			 		 EATab.Consignee().sendKeys(Consignee);
			 		 Elogin.Waittilljquesryupdated(driver);
				 	js.executeScript("arguments[0].click()", EATab.SelectAction());
					 Elogin.Waittilljquesryupdated(driver);
			 		 EATab.Shipper().sendKeys(Shipper);
			 		 Elogin.Waittilljquesryupdated(driver);
			 		js.executeScript("arguments[0].click()", EATab.SelectAction());
			 		Elogin.Waittilljquesryupdated(driver);	
			 		js.executeScript("arguments[0].click()",  EATab.SaveAirwaybill());
			 	   Thread.sleep(8000);
			 	   
		    	 //Airwaybilltab Print	
		    	 
		    	 js.executeScript("arguments[0].click()", EATab.AirwaybillPrint());
			     Elogin.Waittilljquesryupdated(driver);	
			     Thread.sleep(12000);
			       
	              		 
	              		ArrayList<String> tab2 = new ArrayList<String> (driver.getWindowHandles());
	              		log.info(tab2.size());
	              		System.out.println(tab2.size());
	              	    driver.switchTo().window(tab2.get(1));
	              	    System.out.println("New window has been opened.");
	        			String newURL = driver.getCurrentUrl();	       			
	        			log.info(newURL);			 	
	        			String downloadfilepath = (System.getProperty("user.dir")+"\\Downloads\\ActualAirwaybill.pdf");						 				 	
					 	Download_Uploadfile.Downloadfile(downloadfilepath);
					 	 Thread.sleep(1000);				              	    
		              	// driver.close();
		              	 driver.switchTo().window(tab2.get(0));
		              	 Thread.sleep(5000);
	 		     	 				 		
			 		  
		 		 	 //Pricingtab
			 		 wait.until(ExpectedConditions.elementToBeClickable(EPTab.PricngTab()));
			 		 js.executeScript("arguments[0].click()",  EPTab.PricngTab() );
			 		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 		Thread.sleep(3000);
			 		Elogin.Waittilljquesryupdated(driver);
			 		
			 		String V_TotAmt1 = EPTab.TotAmt().getAttribute("value");
			 		log.info("Totamt is " + V_TotAmt1);
		    		String V_VatAmt1 = EPTab.VatAmt().getAttribute("value");		    	
		    		log.info("VatAmt is " + V_VatAmt1);
		    		String V_LocalCostAmt1 = EPTab.LocalCostAmt().getAttribute("value");	
		    		log.info("LocalCostAmt is " + V_LocalCostAmt1);
		    		String V_Commison1 = EPTab.Commision().getAttribute("value");		    	
		    		log.info("Commison is " + V_Commison1);
		    		String V_Margin1 = EPTab.Margin().getAttribute("value");	
		    		log.info("Margin is " + V_Margin1);
		    		String V_Cost1 = EPTab.Cost().getText();			   		
			   	    log.info("Cost1 is " + V_Cost1);
			   		String V_Sell1 = EPTab.Sell().getText();
			  	    log.info("Sell1 is " + V_Sell1);		    		    	
			    		  
				    	 
				    	 Assert.assertEquals(V_TotAmt1, TotalAmt_A);	
				    	 Assert.assertEquals(V_VatAmt1, VatAmt);	
				    	 Assert.assertEquals(V_LocalCostAmt1, CostAmt_B);	
				    	 Assert.assertEquals(V_Commison1, Commission);	
				    	 Assert.assertEquals(V_Margin1, Margin);	
				    	 Assert.assertEquals(V_Cost1, CostAmt);	
				    	 Assert.assertEquals(V_Sell1, SoldAmt);	
				 
				    			
						    					 			     
					     
		//Epouch Tab:
				    	 js.executeScript("arguments[0].click()", EPoTab.EpouchTab());
					     Elogin.Waittilljquesryupdated(driver);	
					     js.executeScript("arguments[0].click()",EPoTab.Type());
					     Elogin.Waittilljquesryupdated(driver);	
					     js.executeScript("arguments[0].click()",EPoTab.SelectType());
					     Elogin.Waittilljquesryupdated(driver);	
					     Thread.sleep(5000);					     
					 	//Download_Uploadfile.upload();
					 
					 	 js.executeScript("arguments[0].click()",EPoTab.ChooseFile());
					 	   Thread.sleep(3000);
					 	   act.moveToElement(EPoTab.ChooseFile()).perform();
					 	   Thread.sleep(3000);
					 		String path =System.getProperty("user.dir")+"\\Uploadfile\\Uploadfile.pdf";
					 	   EPoTab.ChooseFile().sendKeys(path);
				       
				        
					 	  Elogin.Waittilljquesryupdated(driver);	
				         js.executeScript("arguments[0].click()",EPoTab.SaveEpouch());
				         Elogin.Waittilljquesryupdated(driver);	
				         Thread.sleep(5000);
				      
				         String Epouchverify = 	 EPoTab.VerifyEpouch().getText();
						  log.info(Epouchverify);
						    System.out.println(Epouchverify);						    
						  Assert.assertEquals(Epouchverify,"Airwaybill copy");				     
					     
						    
				
					       			 		
				     
				 	  
				 	  
				    js.executeScript("arguments[0].click()", EATab.Airwaybilltab());
				    Elogin.Waittilljquesryupdated(driver);				 	
				     js.executeScript("arguments[0].click()", 	Tab.SendFWB());
				     Elogin.Waittilljquesryupdated(driver);
				     js.executeScript("arguments[0].click()",Tab.PromptOK());
				     Elogin.Waittilljquesryupdated(driver);
				     js.executeScript("arguments[0].click()", Tab.Bookingtab());
				     Elogin.Waittilljquesryupdated(driver);
				     js.executeScript("arguments[0].click()", Tab.SendFFR());
				     Elogin.Waittilljquesryupdated(driver);
				     js.executeScript("arguments[0].click()",Tab.SendFFRsend());
				     Elogin.Waittilljquesryupdated(driver);
				     js.executeScript("arguments[0].click()",Tab.PromptOK());
				     Elogin.Waittilljquesryupdated(driver);			 	
				 	js.executeScript("arguments[0].click()", Tab.BookingClose());
					Elogin.Waittilljquesryupdated(driver);	
					
					
			     
					js.executeScript("arguments[0].click()", Ressearch.OpenSearch_list());			
					js.executeScript("arguments[0].click()", Ressearch.Res_Search_Reset());			
	            Ressearch.S_AwbPrefix().sendKeys(Awb_Prefix); 
	          	 Elogin.Waittilljquesryupdated(driver);
	            Ressearch.S_AwbNo().sendKeys(Awb_No);
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	           
	           	 Elogin.Waittilljquesryupdated(driver);
				js.executeScript("arguments[0].click()", Ressearch.Res_Search());
				Elogin.Waittilljquesryupdated(driver);
	 	 
				 String Verify_Awb_search_List = Ressearch.Res_Verify_AwbNosearch().getText();		       	  
		       	  log.info(Verify_Awb_search_List);
		    	    Assert.assertEquals(Verify_Awb_search_List,Full_AwbNo);
		    	   log.info("Awb no  Search is Pass" );
		    		Elogin.Waittilljquesryupdated(driver);     
	 		     Ressearch.Res_Verify_Bkg_Milestone_FFR().isDisplayed();
	 		    Ressearch.Res_Verify_Bkg_Milestone_FWB().isDisplayed();
	 		    Ressearch.Res_Verify_Bkg_Milestone_EPOUCH().isDisplayed();	
	 		     
	 		   
	    		
	}
	


public void teardown()
{
driver.close();	

}
}





