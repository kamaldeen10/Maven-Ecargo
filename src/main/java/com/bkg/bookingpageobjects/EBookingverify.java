package com.bkg.bookingpageobjects;


import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EBookingverify {
	 
	 
	
	public Properties Prop;
	
	WebDriver driver ;
	
	public EBookingverify(WebDriver driver)  {
			this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}
	
	
		
	
	//Res Search Input
	@FindBy(xpath="//button[@ng-click='ui.showSearch=!ui.showSearch']")
	WebElement OpenSearch_list;
	@FindBy(xpath="//input[@ng-model='bookingSearch.$$awbPrefix']")
	WebElement S_AwbPrefix;
	@FindBy(xpath="//input[@ng-model='bookingSearch.$$awbNumber']")
	WebElement S_AwbNo;	
	@FindBy(xpath="//input[@ng-model='bookingSearch.flight']")
	WebElement S_Flightno;		
	@FindBy(xpath="//div[contains(@class ,'md-datepicker-input-container')]//input[@placeholder='Flt From']")
	WebElement S_FlightFrom;	
	@FindBy(xpath="//div[contains(@class ,'md-datepicker-input-container')]//input[@placeholder='Flt To']")
	WebElement S_FlightTo;
	
	//Res Search Button
	@FindBy(xpath="//button[@ng-click='searchQuoteAndBooking()']")
	WebElement Res_Search;	
		
	//Verify Res Search
	@FindBy(xpath="//div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(),  '077-')]")
	WebElement Res_Verify_AwbNosearch ;
	@FindBy(xpath="//button[@ng-click='resetQuoteAndBookingSearch()']")
    WebElement Res_Search_Reset ;	
	
	@FindBy(xpath="//descendant::div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), 'CGN')][1]")
    WebElement Res_Verify_Originsearch  ;
	@FindBy(xpath="//descendant::div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), 'DXB')][1]")
    WebElement Res_Verify_Destinationsearch ;
	@FindBy(xpath="//descendant::div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), 'MS5252')][1]")
    WebElement Res_Verify_Fligthsearch ;
	@FindBy(xpath="//span[contains(@class,'ng-binding') and contains(text(), '01/09/2021')]")
    WebElement Res_Verify_FligthDatesearch ;
	@FindBy(xpath="//descendant::span[contains(@class,'text-align-right ng-binding') and contains(text(), '15')]")
    WebElement Res_Verify_Piecesearch ;
	@FindBy(xpath="//descendant::span[contains(@class,'text-align-right ng-binding') and contains(text(), '125.0')]")
    WebElement Res_Verify_Groswtsearch ;
	@FindBy(xpath="//descendant::span[contains(@class,'text-align-right ng-binding') and contains(text(), '0.75')]")
    WebElement Res_Verify_Volsearch  ;
	@FindBy(xpath="//descendant::div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), 'TESTAGENT')]")
    WebElement Res_Verify_Agentsearch  ;
	@FindBy(xpath="//descendant::div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), 'General Cargo')]")
    WebElement Res_Verify_Productsearch ;
	@FindBy(xpath="//descendant::div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), '3')]")
    WebElement Res_Verify_Prioritysearch ;
	@FindBy(xpath="//descendant::div[contains(@class,'align-items-center display-flex overlay-dropdown-wrapper ng-binding flex') and contains(text(), 'AVI,')]")
    WebElement Res_Verify_SHCsearch ;
	@FindBy(xpath="//span//descendant::div[contains(text(), 'K')]")
    WebElement Res_Verify_Securitysearch ;
	@FindBy(xpath="//descendant::div[contains(@class,'align-items-center display-flex ng-binding flex') and contains(text(), 'Being Processed')]")
    WebElement Res_Verify_BkgStatussearch ;
	@FindBy(xpath="//descendant::div[contains(@class,'align-items-center display-flex ng-binding flex') and contains(text(), 'Cancelled')]")
    WebElement Res_Verify_BkgCancelled ;
	

	// Res- awb-Milestone
	
	@FindBy(xpath="//div//img[@ng-src='images/Icon-1-green.png']")
    WebElement Res_Verify_Bkg_Milestone_FFR ;
	
	@FindBy(xpath="//div//img[@ng-src='images/Icon-8-amber.png']")
	WebElement Res_Verify_Bkg_Milestone_FWB ;
	
	@FindBy(xpath="//div//img[@ng-src='images/Icon-6-green.png']")
	WebElement Res_Verify_Bkg_Milestone_EPOUCH ;
	
	
	
	//Booking screen Verify
	@FindBy(xpath="//input[@ng-model='tab.createRequest.chargesheader.$$otherchargestotAmnt']")
	WebElement Verify_Amt_Othercharge ;
	@FindBy(xpath="//input[@ng-model='tab.createRequest.chargesheader.totAmnt']")
	WebElement Verify_Amt_Totaldue ;
	
	
	public WebElement OpenSearch_list()
	{
		return OpenSearch_list;
	}
	public WebElement S_AwbPrefix()
	{
		return S_AwbPrefix;
	}
	public WebElement S_AwbNo()
	{
		return S_AwbNo;
	}
	public WebElement  S_Flightno()
	{
		return  S_Flightno;
	}
	public WebElement S_FlightFrom()
	{
		return S_FlightFrom;
	}
	public WebElement S_FlightTo()
	{
		return S_FlightTo;
	}
	public WebElement Res_Search()
	{
		return Res_Search;
	}
	public WebElement Res_Verify_AwbNosearch()
	{
		return Res_Verify_AwbNosearch;
	}
	 
		public WebElement Res_Verify_Originsearch()
		{
			return Res_Verify_Originsearch;
		}
		public WebElement Res_Verify_Destinationsearch()
		{
			return Res_Verify_Destinationsearch;
		}
		public WebElement Res_Verify_Fligthsearch()
		{
			return Res_Verify_Fligthsearch;
		}
		public WebElement Res_Verify_FligthDatesearch()
		{
			return Res_Verify_FligthDatesearch;
		}

	public WebElement  Res_Verify_Piecesearch()
		{
			return  Res_Verify_Piecesearch;
		}
		public WebElement  Res_Verify_Groswtsearch()
		{
			return  Res_Verify_Groswtsearch;
		}
		public WebElement  Res_Verify_Volsearch ()
		{
			return   Res_Verify_Volsearch ;
		}
		public WebElement   Res_Verify_Agentsearch ()
		{
			return   Res_Verify_Agentsearch ;
		}
		public WebElement   Res_Verify_Productsearch()
		{
			return   Res_Verify_Productsearch;
		}
		public WebElement Res_Verify_Prioritysearch()
		{
			return Res_Verify_Prioritysearch;
		}
		
		public WebElement  Res_Verify_SHCsearch()
		{
			return  Res_Verify_SHCsearch;
		}
		public WebElement Res_Verify_Securitysearch ()
		{
			return  Res_Verify_Securitysearch ;
		}
		public WebElement   Res_Verify_BkgStatussearch ()
		{
			return    Res_Verify_BkgStatussearch ;
		}
		public WebElement    Res_Verify_Bkg_Milestone_FFR ()
		{
			return    Res_Verify_Bkg_Milestone_FFR ;
		}
		public WebElement    Res_Verify_Bkg_Milestone_FWB ()
		{
			return    Res_Verify_Bkg_Milestone_FWB ;
		}
		public WebElement    Res_Verify_Bkg_Milestone_EPOUCH ()
		{
			return    Res_Verify_Bkg_Milestone_EPOUCH ;
		}
		
		
		
		
	public WebElement Res_Search_Reset()
	{
		return Res_Search_Reset;
	}
	//Booking
	public WebElement Verify_Amt_Othercharge()
	{
		return Verify_Amt_Othercharge;
	}
	public WebElement Verify_Amt_Totaldue()
	{
		return Verify_Amt_Totaldue;
	}
	
	public WebElement 	Res_Verify_BkgCancelled()
	{
		return 	Res_Verify_BkgCancelled;
	}


	
	}
	

