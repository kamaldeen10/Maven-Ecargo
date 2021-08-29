package com.bkg.methods.libraries;




import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
import com.bkg.config.Config;
import com.bkg.excel.utility.ExcelUtil;



public class Booking_Library_Test extends base{
	
	public  WebDriver driver;
	protected static String className;
	protected static HashMap<Integer, HashMap<String, String>> testData;
	private ThreadLocal<String> testName = new ThreadLocal<>();
	
	
	
	public   Logger log =LogManager.getLogger(base.class.getName());
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	 Actions act = new Actions(driver);
	 String Winhand1 = driver.getWindowHandle();
	 JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
	 
			
 
	
	


	public   void LoginApp() throws Exception {

		Elogin login = new Elogin(driver);			
		login.Username().sendKeys(Config.APP_Username);
		login.Password().sendKeys(Config.APP_Password);
		login.Login().click();
		String Loginname = login.user().getText();
		log.info(Loginname);
	    System.out.println(Loginname);
	    Assert.assertEquals(Loginname,Config.APP_Username);       	 	    
			}
	public   void NavigateMenu() throws SocketTimeoutException, InterruptedException {
	
		 EBookingCreate bkg = new EBookingCreate(driver);
		 ELandingpage home = new ELandingpage(driver);	
    js.executeScript("arguments[0].click()", home.Togglelink());
    js.executeScript("arguments[0].click()",home.menuReservationMgt());
    js.executeScript("arguments[0].click()",home.ResDashboard());
    Assert.assertEquals( home.Title().getText(),"RES Dashboard");
    js.executeScript("arguments[0].click()", bkg.CreateTab());
    js.executeScript("arguments[0].click()", bkg.Toggle());    
	Elogin.Waittilljquesryupdated(driver);
	}
	
	
	@DataProvider(name = "getData", parallel = false)
	public Iterator<Object[]> getTestData() throws IOException {
		className = this.getClass().getSimpleName();
		//String excelFile = System.getProperty("user.dir")+ "\\TestData\\ECargo_TestData.xlsx";;
		String excelFile  = Config.TEST_DATA_FILE_PATH;
		testData = ExcelUtil.getTestData(excelFile, className);
		ArrayList <Object[]> dataProvider = new ArrayList<Object[]>();
		for (Integer currentKey : testData.keySet()) {
			dataProvider.add(new Object[] { testData.get(currentKey)});		
		}
		return dataProvider.iterator();	
	}
	

	public   void BookingCreateFlow(HashMap<String, String> testdata)  throws SocketTimeoutException, InterruptedException {
	Elogin.Waittilljquesryupdated(driver);
		
	EBookingCreate bkg = new EBookingCreate(driver);
	EBookingTabscreens Tab = new EBookingTabscreens(driver);
	
	 bkg.Awbprefix().sendKeys(testdata.get("Awb_Prefix"));
	 bkg.Awb().sendKeys(testdata.get("Awb_No"));			
	js.executeScript("arguments[0].click()", bkg.Stockpopup());				
		js.executeScript("arguments[0].click()", bkg.Stockselect());
		Elogin.Waittilljquesryupdated(driver);				
		bkg.Origin_1().clear();				
		bkg.Origin_1().sendKeys(testdata.get("Origin_1"));				
		bkg.Destination_2().clear();			
		bkg.Destination_2().sendKeys(testdata.get("Destination_2"));
		bkg.Agentname().clear();
		bkg.Agentname().sendKeys(testdata.get("Agent"));
	    Elogin.Waittilljquesryupdated(driver);
		js.executeScript("arguments[0].click()", bkg.Agentnameselect());
		

		 js.executeScript("arguments[0].click()", bkg.AddFlightab1());
		 Elogin.Waittilljquesryupdated(driver);
			bkg.roworigin1().clear();
			bkg.roworigin1().sendKeys(testdata.get("Origin_1"));
			bkg.rowDest1().clear();
			bkg.rowDest1().sendKeys(testdata.get("Destination_1"));
			bkg.flight1().sendKeys(testdata.get("Flight_1"));
			Elogin.Waittilljquesryupdated(driver);
			bkg.flightdetailpopup().click();
			Elogin.Waittilljquesryupdated(driver);
			bkg.flightdetailsearch().click();
			Elogin.Waittilljquesryupdated(driver);
			bkg.flightdetailReset().click();
			Elogin.Waittilljquesryupdated(driver);
			bkg.Searchflight().sendKeys(testdata.get("Flight_1"));
			wait.until(ExpectedConditions.visibilityOf(bkg.Flight_From()));
			bkg.Flight_From().sendKeys(testdata.get("Flight_Date_1"));
			wait.until(ExpectedConditions.visibilityOf(bkg.Flight_To()));
			bkg.Flight_To().sendKeys(testdata.get("Flight_Date_1"));
			wait.until(ExpectedConditions.visibilityOf(bkg.Flight_origin()));
			bkg.Flight_origin().sendKeys(testdata.get("Origin_1"));
			wait.until(ExpectedConditions.visibilityOf(bkg.Flight_destination()));
			bkg.Flight_destination().sendKeys(testdata.get("Destination_1"));
			js.executeScript("arguments[0].click()", bkg.Searchbutton());
			Elogin.Waittilljquesryupdated(driver);
			js.executeScript("arguments[0].click()", bkg.Flighttext());	
			Elogin.Waittilljquesryupdated(driver);
			js.executeScript("arguments[0].click()", bkg.Flightselect());
			Elogin.Waittilljquesryupdated(driver);

			
			bkg.roworigin2().clear();
			bkg.roworigin2().sendKeys(testdata.get("Origin_2"));
		    bkg.rowDest2().sendKeys(testdata.get("Destination_2"));
			bkg.flight2().sendKeys(testdata.get("Flight_2"));					
			bkg.flightdetailpopup2().click();
			Elogin.Waittilljquesryupdated(driver);
			bkg.flightdetailsearch2().click();
			Elogin.Waittilljquesryupdated(driver);
			bkg.flightdetailReset2().click();
			Elogin.Waittilljquesryupdated(driver);
			bkg.Searchflight2().sendKeys(testdata.get("Flight_2"));
			wait.until(ExpectedConditions.visibilityOf(bkg.Flight_From()));
			bkg.Flight_From2().sendKeys(testdata.get("Flight_Date_2"));
			wait.until(ExpectedConditions.visibilityOf(bkg.Flight_To()));
			bkg.Flight_To2().sendKeys(testdata.get("Flight_Date_2"));
			wait.until(ExpectedConditions.visibilityOf(bkg.Flight_origin()));
			bkg.Flight_origin2().sendKeys(testdata.get("Origin_2"));
			wait.until(ExpectedConditions.visibilityOf(bkg.Flight_destination()));
			bkg.Flight_destination2().sendKeys(testdata.get("Destination_2"));				
			js.executeScript("arguments[0].click()", bkg.Searchbutton2());
			Elogin.Waittilljquesryupdated(driver);
			js.executeScript("arguments[0].click()", bkg.Flighttext2());
			Elogin.Waittilljquesryupdated(driver);
			js.executeScript("arguments[0].click()", bkg.Flightselect2());
			Elogin.Waittilljquesryupdated(driver);				
			
			bkg.Piece().sendKeys(testdata.get("Pieces"));
			bkg.Grosswt().sendKeys(testdata.get("Gross_Wt"));
			bkg.Commodity().sendKeys(testdata.get("Commodity"));
			
			
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
			bkg.Deliverydate().sendKeys(testdata.get("Delivery_Date"));					
		  	js.executeScript("arguments[0].click()", bkg.Deliverypoint());					  	
		  	bkg.Deliverypointsearch().sendKeys(testdata.get("Delivery_Point"));
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


driver.switchTo().window(Winhand1);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
String BkgStatus = bkg.BookingStatusCheck().getText();
System.out.println("Booking status  is " + BkgStatus);	
log.info("Booking status  is " + BkgStatus);
Assert.assertEquals(BkgStatus, testdata.get("Bkg_status"));	
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
js.executeScript("arguments[0].click()", Tab.Notesbutton());
Tab.Notes().sendKeys(testdata.get("VerifyBookingconfirm"));
js.executeScript("arguments[0].click()", Tab.NotesSave());
}

	public   void Verify_Tariff(HashMap<String, String> testdata)
	{
		EBookingCreate bkg = new EBookingCreate(driver);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		 				
	String Tariff_Buy = bkg.BuyingAmount().getAttribute("value");
		System.out.println("Buying rate is " + Tariff_Buy);	
		 log.info("Buying rate is " + Tariff_Buy);
		String Tariff_Sell = bkg.SellingAmount().getAttribute("value");		
		System.out.println("Selling rate is " +  Tariff_Sell);	
		log.info("Selling rate is " +  Tariff_Sell);
		 Assert.assertEquals(Tariff_Buy, testdata.get("Buyamt"));
	     Assert.assertEquals(Tariff_Sell, testdata.get("Sellamt"));

}
	
	public   void Res_Search_Parameter(HashMap<String, String> testdata) throws SocketTimeoutException, InterruptedException
	{
		EBookingTabscreens Tab = new EBookingTabscreens(driver);
		EBookingverify  Ressearch = new EBookingverify (driver) ;	
		
	js.executeScript("arguments[0].click()", Tab.BookingClose());
	Elogin.Waittilljquesryupdated(driver);				
	js.executeScript("arguments[0].click()", Ressearch.OpenSearch_list());
	Elogin.Waittilljquesryupdated(driver);
	  Ressearch.S_AwbPrefix().sendKeys(testdata.get("Awb_Prefix"));
   	 Elogin.Waittilljquesryupdated(driver);
     Ressearch.S_AwbNo().sendKeys(testdata.get("Awb_No"));
 	 Elogin.Waittilljquesryupdated(driver);
		Ressearch.S_Flightno().sendKeys(testdata.get("Flight_1"));
		Elogin.Waittilljquesryupdated(driver);
		Ressearch.S_FlightFrom().sendKeys(testdata.get("Flight_Date_1"));
		Elogin.Waittilljquesryupdated(driver);
		Ressearch.S_FlightTo().sendKeys(testdata.get("Flight_Date_1"));
		Elogin.Waittilljquesryupdated(driver);
		js.executeScript("arguments[0].click()", Ressearch.Res_Search());
		Elogin.Waittilljquesryupdated(driver);
		Thread.sleep(3000); 
	}
	
	public   void Res_Search_Verify(HashMap<String, String> testdata) 
	{
		EBookingverify  Ressearch = new EBookingverify (driver) ;	
	Boolean verifyAwbsNOIsPresent = Ressearch.Res_Verify_AwbNosearch().getText().equalsIgnoreCase(testdata.get("Full_AwbNo "));
	assertTrue(verifyAwbsNOIsPresent );          
	Boolean verifyoriginIsPresent  = Ressearch.Res_Verify_Originsearch().getText().equalsIgnoreCase(testdata.get("Origin_1"));
	assertTrue(verifyoriginIsPresent);            
	Boolean verifyDestinationIsPresent  = Ressearch.Res_Verify_Destinationsearch().getText().equalsIgnoreCase(testdata.get("Destination_2"));
	assertTrue(verifyDestinationIsPresent);            	
	Boolean verifyFlighIsPresent  = Ressearch.Res_Verify_Fligthsearch().getText().equalsIgnoreCase(testdata.get("Flight_1"));
	assertTrue(verifyFlighIsPresent);           
	Boolean verifyFlightDateIsPresent  = Ressearch.Res_Verify_FligthDatesearch().getText().equalsIgnoreCase(testdata.get("Flight_Date_1"));
	assertTrue(verifyFlightDateIsPresent );        
	Boolean verifyPieceIsPresent  = Ressearch.Res_Verify_Piecesearch().getText().equalsIgnoreCase(testdata.get("Pieces"));
	assertTrue(verifyPieceIsPresent);            
	Boolean verifyGrosswtIsPresent  = Ressearch.Res_Verify_Groswtsearch().getText().equalsIgnoreCase(testdata.get("Gross_Wt"));
	assertTrue(verifyGrosswtIsPresent );            	
	Boolean verifyVolIsPresent  = Ressearch.Res_Verify_Volsearch().getText().equalsIgnoreCase(testdata.get("Volume"));
	assertTrue(verifyVolIsPresent);            	
	Boolean verifyAgentIsPresent  = Ressearch. Res_Verify_Agentsearch().getText().equalsIgnoreCase(testdata.get("Agent"));
	assertTrue(verifyAgentIsPresent);            
	Boolean verifyPoductIsPresent  = Ressearch.Res_Verify_Productsearch().getText().equalsIgnoreCase(testdata.get("Producttype"));
	assertTrue(verifyPoductIsPresent );            
	Boolean verifyShcIsPresent  = Ressearch.Res_Verify_SHCsearch().getText().equalsIgnoreCase(testdata.get("SHC"));
	assertTrue(verifyShcIsPresent);
	Boolean verifySecurityIsPresent  = Ressearch.Res_Verify_Securitysearch ().getText().equalsIgnoreCase(testdata.get("Security"));
	assertTrue(verifySecurityIsPresent);            	
	Boolean verifybkgStatusIsPresent  =Ressearch.Res_Verify_BkgStatussearch().getText().equalsIgnoreCase(testdata.get("Bkg_status"));
	assertTrue(verifybkgStatusIsPresent);
log.info("FightNo and FlightDate search is Pass" );
}
	public   void Res_Verify_Rates(HashMap<String, String> testdata) throws SocketTimeoutException, InterruptedException 
	{
		EBookingCreate bkg = new EBookingCreate(driver);
		EBookingverify  Ressearch = new EBookingverify (driver) ;	
		EBookingTabscreens Tab = new EBookingTabscreens(driver);
		
		
	js.executeScript("arguments[0].click()", Ressearch.Res_Verify_AwbNosearch());	
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Elogin.Waittilljquesryupdated(driver);
	Thread.sleep(5000);
   String BkgStatus1 = bkg.BookingStatusCheck().getText();
   log.info("Booking status  is " + BkgStatus1);
System.out.println("Booking status  is " + BkgStatus1);	    

	 String V_Othercharge = Tab.OtherCharges().getAttribute("value");
		System.out.println("Othercharge is " + V_Othercharge);
		  log.info("Othercharge is " + V_Othercharge);
		String V_TotalDue = Tab.TotalDue().getAttribute("value");		
		System.out.println("Total due  is " +  V_TotalDue);	
		log.info("Total due  is " +  V_TotalDue);	 			
		 Assert.assertEquals(V_Othercharge, testdata.get("Othercharge"));
	     Assert.assertEquals(V_TotalDue,testdata.get("Totaldue"));
}
	
	public   void Res_AirwaybillTab_Save(HashMap<String, String> testdata) throws SocketTimeoutException, InterruptedException 
	{
		EAirwaybillTab EATab = new EAirwaybillTab (driver);
		
	 js.executeScript("arguments[0].click()", EATab.Airwaybilltab());
	   Thread.sleep(8000);
	    EATab.AccInfo().sendKeys(testdata.get("Shipper"));
		  Elogin.Waittilljquesryupdated(driver);
		 EATab.HandlingInfo().sendKeys(testdata.get("HandlingInfo"));
		 EATab.Consignee().sendKeys(testdata.get("Consignee"));
		 Elogin.Waittilljquesryupdated(driver);
	 	js.executeScript("arguments[0].click()", EATab.SelectAction());
		 Elogin.Waittilljquesryupdated(driver);
		 EATab.Shipper().sendKeys(testdata.get("Shipper"));
		 Elogin.Waittilljquesryupdated(driver);
		js.executeScript("arguments[0].click()", EATab.SelectAction());
		Elogin.Waittilljquesryupdated(driver);	
		js.executeScript("arguments[0].click()",  EATab.SaveAirwaybill());	
	}

	public   void Res_PricingTab_Save(HashMap<String, String> testdata) throws SocketTimeoutException, InterruptedException 
	{
		EPricingTab EPTab = new EPricingTab (driver);
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
    		  
	    	 
	     Assert.assertEquals(V_TotAmt1, testdata.get("TotalAmt_A"));	
	     Assert.assertEquals(V_VatAmt1, testdata.get("VatAmt"));	
	     Assert.assertEquals(V_LocalCostAmt1, testdata.get("CostAmt_B"));	
	     Assert.assertEquals(V_Commison1, testdata.get("Commission"));	
	     Assert.assertEquals(V_Margin1,testdata.get("Margin"));	
	     Assert.assertEquals(V_Cost1, testdata.get("CostAmt"));	
	     Assert.assertEquals(V_Sell1, testdata.get("SoldAmt"));	
	}
	
	
		public   void Res_EpouchTab_Save(HashMap<String, String> testdata) throws InterruptedException, IOException 
				
		{
			EEpouchTab  EPoTab = new EEpouchTab (driver);
			
   	 js.executeScript("arguments[0].click()", EPoTab.EpouchTab());
	     Elogin.Waittilljquesryupdated(driver);	
	     js.executeScript("arguments[0].click()",EPoTab.Type());
	     Elogin.Waittilljquesryupdated(driver);	
	     js.executeScript("arguments[0].click()",EPoTab.SelectType());
	     Elogin.Waittilljquesryupdated(driver);	
	     Thread.sleep(5000);
	   //  js.executeScript("arguments[0].click()",EPoTab.ChooseFile());
	     
	     act.sendKeys(Keys.TAB).build().perform();
	     act.sendKeys(Keys.TAB).build().perform();
	     act.sendKeys(Keys.ENTER).build().perform();
	     
	     Thread.sleep(5000);
        Runtime.getRuntime().exec("D:\\Automation\\Project\\Autoit\\Epouch.exe");
        Elogin.Waittilljquesryupdated(driver);	
        js.executeScript("arguments[0].click()",EPoTab.SaveEpouch());
        Elogin.Waittilljquesryupdated(driver);	
        Thread.sleep(5000);
        
        String Epouchverify = 	 EPoTab.VerifyEpouch().getText();
		  log.info(Epouchverify);
		    System.out.println(Epouchverify);
		    
		  Assert.assertEquals(Epouchverify,"Airwaybill copy");
	}
		
		public   void Res_Send_CIMP_OUT_Msg(HashMap<String, String> testdata) throws InterruptedException, IOException 
		{
			EAirwaybillTab EATab = new EAirwaybillTab (driver);		
		EBookingTabscreens Tab = new EBookingTabscreens(driver);
		
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
		}
		public   void Res_Verify_Milestone(HashMap<String, String> testdata) throws InterruptedException, IOException 
		{
			EBookingverify  Ressearch = new EBookingverify (driver) ;
			js.executeScript("arguments[0].click()", Ressearch.OpenSearch_list());			
			js.executeScript("arguments[0].click()", Ressearch.Res_Search_Reset());			
        Ressearch.S_AwbPrefix().sendKeys(testdata.get("Awb_Prefix"));
      	 Elogin.Waittilljquesryupdated(driver);
        Ressearch.S_AwbNo().sendKeys(testdata.get("Awb_No"));
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	           
       	 Elogin.Waittilljquesryupdated(driver);
		js.executeScript("arguments[0].click()", Ressearch.Res_Search());
		Elogin.Waittilljquesryupdated(driver);
	 
		 String Verify_Awb_search_List = Ressearch.Res_Verify_AwbNosearch().getText();		       	  
       	  log.info(Verify_Awb_search_List);
    	    Assert.assertEquals(Verify_Awb_search_List,testdata.get("Full_AwbNo "));
    	   log.info("Awb no  Search is Pass" );
    		Elogin.Waittilljquesryupdated(driver);     
		     Ressearch.Res_Verify_Bkg_Milestone_FFR().isDisplayed();
		    Ressearch.Res_Verify_Bkg_Milestone_FWB().isDisplayed();
		    Ressearch.Res_Verify_Bkg_Milestone_EPOUCH().isDisplayed();	
		     
		}
		

		@BeforeTest
		public void Intialize () throws IOException {
			driver = Initializedriver();		
			log.info("Driver is Intialized");
			driver.get(Config.UAT_URL);
			log.info("Login Page Navigated");
			
		}
		
		@Test(dataProvider = "getData")
		public void BookingflowTest (HashMap<String, String> testdata) throws Exception
		{
			LoginApp();
			NavigateMenu();
			BookingCreateFlow(testdata);
			BookingCreateFlow(testdata);
			Verify_Tariff(testdata);
			Res_Search_Parameter(testdata);
			Res_Search_Verify(testdata);
			Res_Verify_Rates(testdata);
			Res_AirwaybillTab_Save(testdata);
			Res_PricingTab_Save(testdata);
			Res_EpouchTab_Save(testdata);
			Res_Send_CIMP_OUT_Msg(testdata);
			Res_Verify_Milestone(testdata);
			
			 
			 
		}
		
}
