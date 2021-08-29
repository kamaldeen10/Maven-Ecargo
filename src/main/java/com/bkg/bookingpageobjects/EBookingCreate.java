package com.bkg.bookingpageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EBookingCreate {
	static String Flight_1 ="MS5252";
	static String Flight_2 = "MS6262";
	static String ProductType = "General Cargo";
	static String Delivery_Point ="CGNUPS";
	static String Bkg_status = "Being Processed";
	static boolean Status = false;
	static String VerifyBookingconfirm = " Booking Confirmation ";
	WebDriver driver ;
	public  EBookingCreate(WebDriver driver) {
		
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}
	
	
	
	@FindBy(xpath="//button[@ng-click='showCreateTab()']")
	WebElement CreateTab;
	@FindBy(xpath="//button[@ng-click='toggleSideNav()']")
	WebElement Toggle;
	
	//booking_Agentdetails
	@FindBy(xpath="//ecw-autocomplete[@md-search-text='tab.createRequest.agent.companyName']//input")
	WebElement Agentname;
	@FindBy(xpath="//li[@ng-click='$mdAutocompleteCtrl.select($index)']")
	WebElement Agentnameselect;
	
	//Awb and booking_Headerdetails
	@FindBy(xpath="//input[@ng-model='tab.createRequest.$$awbPrefix']")
	WebElement Awbprefix;
	@FindBy(xpath="//input[@ng-model='tab.createRequest.$$awbNumber']")
	WebElement Awb;
	@FindBy(css="md-icon[title ='Click to open Stock Details Popup']")
		WebElement Stockpopup;	
	@FindBy(xpath="//input[@ng-model='searchCriteria.awbNumber']")
	WebElement AwbNo;	
		@FindBy(xpath="//button[@ng-click='select()']")
    WebElement Stockselect;	
	@FindBy(xpath="//ecw-autocomplete[@md-search-text='tab.createRequest.origin']//input")
			WebElement Origin_1;	
	@FindBy(xpath="//ecw-autocomplete[@md-search-text='tab.createRequest.destination']//input")
			WebElement Destination_2;
	
	//booking_FlightRoutingdetails1
	
	@FindBy(xpath="//button[@ng-click='add(tab)']")
	WebElement AddFlightab1;
	@FindBy(xpath="//ecw-autocomplete[@md-search-text='row.entity.origin']//input")
	WebElement roworigin1;
	@FindBy(xpath="//ecw-autocomplete[@md-search-text='row.entity.destination']//input")
	WebElement rowDest1;
	@FindBy(xpath="//input[@ng-model='row.entity.flight']")
	WebElement flight1;
	@FindBy(xpath="//descendant::input[@name='Flight'][1]//following-sibling::div//md-icon[@title='Click to open Flight Details Popup']")
	WebElement flightdetailpopup;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//button[text()='Search']")
	WebElement flightdetailsearch;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//button[text()='Reset']")
	WebElement flightdetailReset;
	@FindBy(xpath="//input[@ng-model='searchCriteria.flight']")
	WebElement Searchflight;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//md-datepicker[@name='from']//input")
	WebElement Flight_From;	
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//md-datepicker[@name='to']//input")
	WebElement Flight_To;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//ecw-autocomplete[@name='origin']//input")
	WebElement Flight_origin;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//ecw-autocomplete[@name='destination']//input")
	WebElement Flight_destination;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//descendant::button[text()='Search'][2]")
	WebElement Searchbutton;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//descendant::div[@role='grid'][2]//div[text()='MS5252']")
	WebElement Flighttext;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//button[text()='Select']")
    WebElement Flightselect;
	
	//booking_FlightRoutingdetails2
	
	@FindBy(xpath="//button[@ng-click='add(tab)']")
	WebElement AddFlightab2;
	@FindBy(xpath="//descendant::ecw-autocomplete[@md-search-text='row.entity.origin'][2]//input")
	WebElement roworigin2;
	@FindBy(xpath="//descendant::ecw-autocomplete[@md-search-text='row.entity.destination'][2]//input")
	WebElement rowDest2;
	@FindBy(xpath="//descendant::input[@ng-model='row.entity.flight'][2]")
	WebElement flight2;
	@FindBy(xpath="//descendant::input[@name='Flight'][2]//following-sibling::div//md-icon[@title='Click to open Flight Details Popup']")
	WebElement flightdetailpopup2;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//button[text()='Search']")
	WebElement flightdetailsearch2;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//button[text()='Reset']")
	WebElement flightdetailReset2;
	@FindBy(xpath="//input[@ng-model='searchCriteria.flight']")
	WebElement Searchflight2;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//md-datepicker[@name='from']//input")
	WebElement Flight_From2;	
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//md-datepicker[@name='to']//input")
	WebElement Flight_To2;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//ecw-autocomplete[@name='origin']//input")
	WebElement Flight_origin2;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//ecw-autocomplete[@name='destination']//input")
	WebElement Flight_destination2;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//descendant::button[text()='Search'][2]")
	WebElement Searchbutton2;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//descendant::div[@role='grid'][2]//div[text()='MS6262']")
	WebElement Flighttext2;
	@FindBy(xpath="//md-dialog[contains(@class,'flight-details')]//button[text()='Select']")
    WebElement Flightselect2;

		//	booking_Shipmentdetails
	
	@FindBy(xpath="//input[@ng-model='tab.createRequest.pieces']")
	WebElement Piece;
	@FindBy(xpath="//input[@ng-model='tab.createRequest.grosswt']")
	WebElement Grosswt;
	@FindBy(xpath="//input[@ng-model='tab.createRequest.commodity']")
	WebElement Commodity;
	
	//ProductTYpe
	
	@FindBy(xpath="//descendant::md-select[@ng-model='tab.createRequest.productTypeId']")
	WebElement Producttype;
	@FindBy(xpath="//md-option//div[contains(@class,'md-text ng-binding') and contains(text(), 'General Cargo' )]")
	WebElement SelectProducttype;
	
	//shc
	
	@FindBy(xpath="//md-icon[(@ng-click= 'showSHC(tab)')]")
	WebElement ShcTab;
	@FindBy(xpath="//descendant::md-checkbox[@ng-model='shc.checked'][3]")
	WebElement Shc1;
	@FindBy(xpath="//descendant::md-checkbox[@ng-model='shc.checked'][15]")
	WebElement Shc2;
	@FindBy(xpath="//button[@ng-click='saveSHC()']")
	WebElement Shcsave;
	
	//Delivery
	
	@FindBy(xpath="//md-datepicker[@ng-model='tab.createRequest.deliverydate']//input")
	WebElement Deliverydate;
	@FindBy(xpath="//md-icon[@ng-click='getDeliveryPoint(tab.createRequest)']")
	WebElement Deliverypoint;
	@FindBy(xpath="//input[@ng-model='searchCriteria.deliveryPoint']")	               
	WebElement Deliverypointsearch;

	@FindBy(xpath="//div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), Delivery_Point)]")
	WebElement Deliverycode;
	
	@FindBy(xpath="//button[text()='Select']")
	WebElement Selectdeliverycode;
	
	//Save Booking
	@FindBy(xpath="//button[@ng-click='save()']")
	WebElement SaveBooking;
	@FindBy(xpath="//div[contains(@class,'booking-popup-button ng-scope') and contains(text(), 'Your Booking Has Been confirmed ')]")
	WebElement BookingConfirm;
	@FindBy(xpath="//div[contains(@class,'pd-t5 ng-scope flex') and contains(text(), VerifyBookingconfirm)]")
	WebElement BookingConfirmText;
	
	//Pop-Up close:
		
	@FindBy(xpath="//md-icon[@ng-click='close()']")
  WebElement PopupClose;
	 
		//Booking close:
	
	@FindBy(xpath="//button[@ng-click='close()']")
	WebElement BookingClose;
	

	@FindBy(xpath="//span[contains(@class,'booking-status md-input ng-binding flex') and contains(text(), 'Being Processed')]")
			WebElement BookingStatusCheck;
	@FindBy(xpath="//input[@ng-model='tab.createRequest.buyingamount']")
	WebElement BuyingAmount;
	@FindBy(xpath="//input[@ng-model='tab.createRequest.sellingamount']")
	WebElement SellingAmount;
	
	@FindBy(xpath="//md-icon[@ng-click='removeTab($event)']")
	WebElement BookingAwbclose;
	
public WebElement CreateTab()
{
	return CreateTab;
}
public WebElement Toggle()
{
	return Toggle;
}

//booking_Agentdetails
	
public WebElement Agentname()
{
	return Agentname;
}
public WebElement Agentnameselect()
{
	return Agentnameselect;
}

//Awb and booking_Headerdetails
	
public WebElement Awbprefix()
{
	return Awbprefix;
}
public WebElement Stockpopup()
{
	return Stockpopup;
}
public WebElement AwbNo()
{
	return AwbNo;
}
public WebElement Awb()
{
	return Awb;
}

public WebElement Stockselect()
{
	return Stockselect;
}
public WebElement Origin_1()
{
	return Origin_1;
}
public WebElement Destination_2()
{
	return Destination_2;
}

//Routing1

public WebElement AddFlightab1()
{
	return AddFlightab1;
}
public WebElement roworigin1()
{
	return roworigin1;
}
public WebElement rowDest1()
{
	return rowDest1;
}
public WebElement flight1()
{
	return flight1;
}
public WebElement flightdetailpopup()
{
	return flightdetailpopup;
}
public WebElement flightdetailsearch()
{
	return flightdetailsearch;
}
public WebElement flightdetailReset()
{
	return flightdetailReset;
}
public WebElement Searchflight()
{
	return Searchflight;
}
public WebElement Flight_From()
{
	return Flight_From;
}
public WebElement Flight_To()
{
	return Flight_To;
}
public WebElement Flight_origin()
{
	return Flight_origin;
}
public WebElement Flight_destination()
{
	return Flight_destination;
}
public WebElement Searchbutton()
{
	return Searchbutton;
}
public WebElement Flighttext()
{
	return Flighttext;
}
public WebElement Flightselect()
{
	return Flightselect;
}

//Routing2

public WebElement AddFlightab2()
{
	return AddFlightab2;
}
public WebElement roworigin2()
{
	return roworigin2;
}
public WebElement rowDest2()
{
	return rowDest2;
}
public WebElement flight2()
{
	return flight2;
}
public WebElement flightdetailpopup2()
{
	return flightdetailpopup2;
}
public WebElement flightdetailsearch2()
{
	return flightdetailsearch2;
}


public WebElement flightdetailReset2()
{
	return flightdetailReset2;
}
public WebElement Searchflight2()
{
	return Searchflight2;
}
public WebElement Flight_From2()
{
	return Flight_From2;
}
public WebElement Flight_To2()
{
	return Flight_To2;
}public WebElement Flight_origin2()
{
	return Flight_origin2;
}public WebElement Flight_destination2()
{
	return Flight_destination2;
}
public WebElement Searchbutton2()
{
	return Searchbutton2;
}
public WebElement Flighttext2()
{
	return Flighttext2;
}
public WebElement Flightselect2()
{
	return Flightselect2;
}

//	booking_Shipmentdetails

public WebElement Piece()
{
	return Piece;
}
public WebElement Grosswt()
{
	return Grosswt;
}
public WebElement Commodity()
{
	return Commodity;
}

	//ProductTYpe
	
public WebElement Producttype()
{
	return Producttype;
}
public WebElement SelectProducttype()
{
	return SelectProducttype;
}

 //shc
	
public WebElement ShcTab()
{
	return ShcTab;
}
public WebElement Shc1()
{
	return Shc1;
}
public WebElement Shc2()
{
	return Shc2;
}
public WebElement Shcsave()
{
	return Shcsave;
}

//Delivery
	
public WebElement Deliverydate()
{
	return Deliverydate;
}
public WebElement Deliverypoint()
{
	return Deliverypoint;
}

public WebElement Deliverypointsearch ()
{
	return Deliverypointsearch;
}
public WebElement Deliverycode()
{
	return Deliverycode;
}
public WebElement Selectdeliverycode()
{
	return  Selectdeliverycode;
}

//Save Booking

public WebElement SaveBooking()
{
	return SaveBooking;
}
public WebElement BookingConfirm()
{
	return BookingConfirm;
}
public WebElement BookingConfirmText()
{
	return BookingConfirmText;
	
}

public WebElement PopupClose()
{
	return PopupClose;
}

public WebElement BookingClose()
{
	return BookingClose;
}

public WebElement BookingStatusCheck()
{
	return BookingStatusCheck;
}
public WebElement BuyingAmount()
{
	return BuyingAmount;
}
public WebElement SellingAmount()
{
	return SellingAmount;
}
public WebElement BookingAwbclose()
{
	return BookingAwbclose;
}




}