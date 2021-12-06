package com.bkg.bookingpageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EFlightMgmtFBL {
	WebDriver driver ;
	public  EFlightMgmtFBL(WebDriver driver) {		
	this.driver=driver;
	PageFactory.initElements(driver, this);	
	}

	
	@FindBy(xpath="//button[@ng-click='menuClick(menu)'][1]//span[contains(@class , 'pull-left ng-binding ng-scope') and contains(text(), 'Flight Mgt')]")
	WebElement Menu_Flight_Mgt;	
	@FindBy(xpath="//span[contains(@class,'ng-binding') and contains(text(), 'Freight Booking List')]")
	WebElement Menu_Fbl;
	
	@FindBy(xpath="//descendant::md-select[@ng-model='ui.searchCriteria.carrier'][1]")
	WebElement Fbl_Carrier;
	@FindBy(xpath="//md-content//md-option[contains(@class,'ng-scope ng-binding') and contains(text(), 'MS')]")
	WebElement Fbl_Carrier_Select;	
	@FindBy(xpath="//input[@ng-model='ui.searchCriteria.flight']")
	WebElement Fbl_Flightno;
	@FindBy(xpath="//ecw-autocomplete[@name='origin'][@md-search-text='ui.searchCriteria.origin']//input[@ng-model='$mdAutocompleteCtrl.scope.searchText'][1]")
	WebElement Fbl_Origin;	
	@FindBy(xpath="//ecw-autocomplete[@name='destination'][@md-search-text='ui.searchCriteria.destination']//input[@ng-model='$mdAutocompleteCtrl.scope.searchText'][1]")
	WebElement Fbl_Dest;	
	@FindBy(xpath="//md-datepicker[@name='fltdate'][@ng-model='ui.searchCriteria.$$fromDate']//input[@class='md-datepicker-input md-input'][1]")
	WebElement Fbl_FlightfromDate;	
	@FindBy(xpath="//md-datepicker[@name='fltdate'][@ng-model='ui.searchCriteria.$$toDate']//input[@class='md-datepicker-input md-input'][1]")
	WebElement Fbl_FlightToDate;
	
	@FindBy(xpath="//button[@ng-click='searchPreAlert()']")
	WebElement Fbl_Search;	
	
	@FindBy(xpath="//i[@class='ng-scope ui-grid-icon-plus-squared']")
	WebElement Fbl_List_Expand;
	
	@FindBy(xpath="//td//span[contains(@class,'ng-binding') and contains(text(), '3')][1]")
	WebElement Fbl_Verify_Priority;
	@FindBy(xpath="//td//span/a[contains(@class,'grid-link pd-l5 ng-binding') and contains(text(), '  07733333333')][1]")
	WebElement Fbl_Verify_Awb;
	@FindBy(xpath="//td//span[contains(@class,'ng-binding') and contains(text(), 'TESTAGENT')][1]")
	WebElement Fbl_Verify_Agent;
	@FindBy(xpath="//td//span[contains(@class,'ng-binding') and contains(text(), 'CGN')][1]")
	WebElement Fbl_Verify_Origin;
	@FindBy(xpath="//td//span[contains(@class,'ng-binding') and contains(text(), 'DXB')][1]")
	WebElement Fbl_Verify_Dest;
	@FindBy(xpath="//td//span[contains(@class,'ng-binding') and contains(text(), '15/15')][1]")
	WebElement Fbl_Verify_Pcs;
	@FindBy(xpath="//td//span[contains(@class,'ng-binding') and contains(text(), '125.00/125.00')][1]")
	WebElement Fbl_Verify_GrsWt;
	@FindBy(xpath="//td//span[contains(@class,'ng-binding') and contains(text(), '125.00/125.00')][1]")
	WebElement Fbl_Verify_ChrgWt;					
	@FindBy(xpath="//td//span[contains(@class,'ng-binding') and contains(text(), '0.75/0.75')]")
	WebElement Fbl_Verify_Vol;	
	@FindBy(xpath="//td//span[contains(@class,'ng-binding') and contains(text(), 'AVI,DGR')]")
	WebElement Fbl_Verify_SHC;
	@FindBy(xpath="//td//span[contains(@class,'ng-binding') and contains(text(), 'CGNUPS')]")
	WebElement Fbl_Verify_DLVPoint;
	@FindBy(xpath="//td//span[contains(@class,'ng-binding') and contains(text(), '03/11/2021')]")
	WebElement Fbl_Verify_DLVDate;
	@FindBy(xpath="//td//span[contains(@class,'ng-binding') and contains(text(), 'Being Processed')]")
	WebElement Fbl_Verify_bkgStatus;
	@FindBy(xpath="//i[@class='ng-scope ui-grid-icon-minus-squared']")
	WebElement Fbl_List_Collapse;		
			
	
	@FindBy(xpath="//md-checkbox[@ng-model='row.entity.isPreAlert']")
	WebElement Fbl_Checkbox;
	@FindBy(xpath="//button[@ng-click='printPreAlert()']")
	WebElement Fbl_Print;
	
	public WebElement Menu_Flight_Mgt()
	{
		return Menu_Flight_Mgt;
	}

public WebElement Menu_Fbl()
	{
		return Menu_Fbl;
	}
public WebElement Fbl_Carrier()
	{
		return Fbl_Carrier;
	}
public WebElement Fbl_Carrier_Select()
	{
		return Fbl_Carrier_Select;
	}
public WebElement Fbl_Flightno()
	{
		return Fbl_Flightno;
	}
public WebElement Fbl_Origin()
	{
		return Fbl_Origin;
	}
public WebElement Fbl_Dest()
	{
		return Fbl_Dest;
	}
public WebElement Fbl_FlightfromDate()
{
	return Fbl_FlightfromDate ;
}

public WebElement Fbl_FlightToDate()
	{
		return Fbl_FlightToDate;
	}
public WebElement Fbl_Search()
	{
		return Fbl_Search;
	}
public WebElement Fbl_Verify_Priority()
	{
		return Fbl_Verify_Priority;
	}
public WebElement Fbl_Verify_Awb()
	{
		return Fbl_Verify_Awb;
	}
public WebElement Fbl_Verify_Agent()
	{
		return Fbl_Verify_Agent;
	}
public WebElement Fbl_Verify_Origin()
	{
		return Fbl_Verify_Origin;
	}


public WebElement Fbl_Verify_Dest()
	{
		return Fbl_Verify_Dest;
	}

public WebElement Fbl_Verify_Pcs()
	{
		return Fbl_Verify_Pcs;
	}

public WebElement Fbl_Verify_GrsWt()
	{
		return Fbl_Verify_GrsWt;
	}

public WebElement Fbl_Verify_ChrgWt()
	{
		return Fbl_Verify_ChrgWt;
	}

public WebElement Fbl_Verify_Vol()
	{
		return Fbl_Verify_Vol;
	}

public WebElement Fbl_Verify_SHC()
	{
		return Fbl_Verify_SHC;
	}

public WebElement Fbl_Verify_DLVPoint()
	{
		return Fbl_Verify_DLVPoint;
	}
public WebElement Fbl_Verify_DLVDate()
	{
		return Fbl_Verify_DLVDate;
	}
public WebElement Fbl_Verify_bkgStatus()
	{
		return Fbl_Verify_bkgStatus;
	}
public WebElement Fbl_List_Expand()
	{
		return Fbl_List_Expand;
	}
public WebElement Fbl_Checkbox()
	{
		return Fbl_Checkbox;
	}
public WebElement Fbl_Print()
	{
		return Fbl_Print;
	}










	
	
	
}
