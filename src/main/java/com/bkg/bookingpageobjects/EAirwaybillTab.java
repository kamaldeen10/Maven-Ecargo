package com.bkg.bookingpageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class EAirwaybillTab {
	WebDriver driver ;
	public EAirwaybillTab(WebDriver driver) {
		
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	//public Orange_HRM_Objects() {
	//	WebDriver driver = DriverManager.WEB_DRIVER_THREAD.get();
		//PageFactory.initElements(driver, this);
	//}


	
	
	@FindBy(xpath="//md-pagination-wrapper//md-tab-item[contains(@class,'md-tab ng-scope ng-isolate-scope') and contains(text(), 'Airway Bill')]")
	WebElement Airwaybilltab;
	@FindBy(xpath="//md-autocomplete-wrap//div//input[@aria-label='Shipper']")
	WebElement Shipper;
	@FindBy(xpath="//li[@ng-click='$mdAutocompleteCtrl.select($index)']")
	WebElement SelectAction;
	@FindBy(xpath="//md-autocomplete-wrap//div//input[@aria-label='Consignee']")
	WebElement Consignee;

	@FindBy(xpath="//md-input-container//textarea[@ng-model='tab.awbRequest.airwaybill.$$accountingInformation']")
	WebElement AccInfo;
	@FindBy(xpath="//md-input-container//textarea[@ng-model='tab.awbRequest.airwaybill.$$handlingInformation']")
	WebElement HandlingInfo; 
	@FindBy(xpath="//button[@ng-click='saveAWBCharges(tab)']")
	WebElement SaveAirwaybill;
	 
	@FindBy(xpath="//div//button[@ng-click='generateBookingAwbReport(tab)']")
	WebElement AirwaybillPrint;
	
	
	   
	public WebElement Airwaybilltab()
	{
		return Airwaybilltab;
	}
		public WebElement Shipper()
	{
		return Shipper;
	}
		public WebElement SelectAction()
	{
		return SelectAction;
	}
		public WebElement Consignee()
	{
		return Consignee;
	}
		public WebElement AccInfo()
	{
		return AccInfo;
	}
		public WebElement HandlingInfo()
	{
		return HandlingInfo;
	}
		public WebElement SaveAirwaybill()
	{
		return SaveAirwaybill;
	} 
	      
		public WebElement AirwaybillPrint()
		{
			return AirwaybillPrint;
		}
	   
	   
	  
	   
	   
	   
	  
	   
}

