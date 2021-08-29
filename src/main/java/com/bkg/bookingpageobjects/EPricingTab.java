package com.bkg.bookingpageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EPricingTab {

	WebDriver driver ;
	public EPricingTab(WebDriver driver) {
		
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//md-pagination-wrapper//md-tab-item[contains(@class,'md-tab ng-scope ng-isolate-scope') and contains(text(), 'Pricing')]")
	WebElement PricngTab;
	
	@FindBy(xpath="//button[@ng-mousedown='showAirlineCharges(tab)']")
	WebElement RecharageTab;	
	@FindBy(xpath="//button[@ng-click='close()']")
	WebElement RecharageTabClose;
	@FindBy(xpath="//tr//td[contains(@class,'text-align-right pd5 header-size ng-binding') and contains(text(), '618.75')]")
	WebElement Cost;
	@FindBy(xpath="//tr//td[contains(@class,'text-align-right pd5 header-size ng-binding') and contains(text(), '912.50')]")
	WebElement Sell;
	@FindBy(xpath="//div//md-input-container[@class = 'header-size mr-r0 layout-gt-xs-row flex md-input-has-value']//input[@ng-model='tab.createRequest.chargesheader.totAmnt']")
	WebElement TotAmt;
	@FindBy(xpath="//div//md-input-container[@class = 'header-size mr-r0 layout-gt-xs-row flex md-input-has-value']//input[@ng-model='tab.createRequest.chargesheader.vatAmnt']")
	WebElement VatAmt;
	@FindBy(xpath="//md-input-container[@class ='header-size mr-r0 layout-row flex md-input-has-value']//input[@ng-model='tab.createRequest.chargesheader.$$localCostAmnt']")
	WebElement LocalCostAmt;
	@FindBy(xpath="//div//input[@ng-model='tab.createRequest.gsaAgentCommission']")
	WebElement Commision;
	@FindBy(xpath="//div//input[@class='text-align-right flex']")
	WebElement Margin;
	
	
	public WebElement RecharageTab()
	{
		return RecharageTab;
	}
	public WebElement RecharageTabClose()
	{
		return RecharageTabClose;
	}
	public WebElement Cost()
	{
		return Cost;
	}
	
		public WebElement Sell()
	{
		return Sell;
	}
		public WebElement TotAmt()
		{
			return TotAmt;
		}
		public WebElement VatAmt()
		{
			return VatAmt;
		}
		public WebElement LocalCostAmt()
		{
			return LocalCostAmt;
		}
		public WebElement Commision()
		{
			return Commision;
		}
		public WebElement Margin()
		{
			return Margin;
		}
		public WebElement PricngTab()
		{
			return PricngTab;
		}
	
	
		
	
	
	}


