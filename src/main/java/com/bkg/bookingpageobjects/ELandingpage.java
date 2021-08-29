package com.bkg.bookingpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELandingpage {
	
	
	public WebDriver driver ;
	public ELandingpage(WebDriver driver) {
		
	this.driver=driver;
	
	PageFactory.initElements(driver, this);
	
	
	}
	

	
	@FindBy(xpath="//button[@ng-click='toggleSideNav()']")
	WebElement Togglelink;
	
	
	@FindBy(xpath="//button[@ng-click='menuClick(menu)'][1]//span[contains(@class , 'pull-left ng-binding ng-scope') and contains(text(), 'Reservation Mgt')]")
	WebElement menuReservationMgt;
	@FindBy(xpath="//span[contains(@class,'ng-binding') and contains(text(), 'RES Dashboard')]")
    WebElement ResDashboard;
	
	@FindBy(xpath="//ecw-tab-header//span[contains(@class,'ng-binding') and contains(text(), 'RES Dashboard')]")
	  WebElement Title;
	
			
	
	public WebElement Togglelink()
	{
		return Togglelink;
	}
	
	
	public WebElement menuReservationMgt()
	{
	
			return menuReservationMgt;
	}
	public WebElement ResDashboard()
	{
		return ResDashboard;
	}

	public WebElement Title()
	{
		return Title;
	}
	
	
}
