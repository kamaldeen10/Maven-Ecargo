package E2EcargoProject;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bkg.base.base;
import com.bkg.bookingpageobjects.Elogin;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing  extends base {
	
	static String url ="https://uat.e-cargoware.com/index.html#!/resDashboard?active";
	static String Username = "sky.admin";
	static String Password = "Skyadmin1!";
	static String Flight_1 ="MS5252";
	static String Flight_2 = "MS6262";
	static String Flight_Date_1 ="01/09/2021";
	static String Flight_Date_2 ="01/09/2021";
	static String Origin_1 = "CGN";
	static String Destination_1 = "TLV";
	static String Origin_2 = "TLV";
	static String Destination_2 = "DXB";
	
	public WebDriver driver;
	public  static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void Intialize () throws IOException {
		driver = Initializedriver();
		log.info("Driver is Intialized");
		driver.get(Prop.getProperty("uaturl2"));			
				
	}
	
	
	@Test
	
	

	
	public void Pract () throws IOException, InterruptedException, AWTException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Elogin login = new Elogin(driver);
		System.setProperty("webdriver.chrome.driver", "D:\\chromedrivers\\chromedriver_95.exe");
		//System.setProperty("webdriver.chrome.driver",(System.getProperty("user.dir")+"\\driver\\chromedriver.exe"));
			
			//System.setProperty("webdriver.gecko.driver", "D:\\Automation\\geckodriver.exe");
		
		
			 	Thread.sleep(8000);
			 	Actions actions = new Actions(driver);
			 	String WinHan = driver.getWindowHandle();
		//Login
				driver.findElement(By.xpath("//descendant::input[@ng-model='userLogin.userName']")).sendKeys(Username);
				driver.findElement(By.xpath("//descendant::input[@type='password']")).sendKeys(Password);
				driver.findElement(By.xpath("//descendant::button[@type='submit']")).click();
			    
			
				

				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						WebElement element2 = driver.findElement(By.xpath("//descendant::button[@ng-click='menuClick(menu)'][4]"));
						js.executeScript("arguments[0].click()", element2);
						//wait.until(ExpectedConditions.elementToBeClickable(element2)).click();						
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					//	Waittilljquesryupdated(driver);
						Elogin.Waittilljquesryupdated(driver);
						WebElement element3 = driver.findElement(By.xpath("//span[contains(@class,'ng-binding') and contains(text(), 'RES Dashboard')]"));	
						js.executeScript("arguments[0].click()", element3);		
					//	Waittilljquesryupdated(driver);
						Elogin.Waittilljquesryupdated(driver);
						WebElement element1 = driver.findElement(By.xpath("//button[@ng-click='toggleSideNav()']"));	
						js.executeScript("arguments[0].click()", element1);
					//Waittilljquesryupdated(driver);
						Elogin.Waittilljquesryupdated(driver);
						
						//Flight MGT:
						
						WebElement element11 = driver.findElement(By.xpath("//button[@ng-click='menuClick(menu)'][1]//span[contains(@class , 'pull-left ng-binding ng-scope') and contains(text(), 'Flight Mgt')]"));	 
						js.executeScript("arguments[0].click()", element11);
			         	Thread.sleep(3000);
						WebElement element12 = driver.findElement(By.xpath("//span[contains(@class,'ng-binding') and contains(text(), 'Freight Booking List')]"));
						js.executeScript("arguments[0].click()", element12);
						Thread.sleep(3000);
					
						WebElement element13 = driver.findElement(By.xpath("//descendant::md-select[@ng-model='ui.searchCriteria.carrier'][1]"));
						js.executeScript("arguments[0].click()", element13);
						
						WebElement element14 = driver.findElement(By.xpath("//md-content//md-option[contains(@class,'ng-scope ng-binding') and contains(text(), 'MS')]"));
						js.executeScript("arguments[0].click()", element14);
						
						
		driver.findElement(By.xpath("//input[@ng-model='ui.searchCriteria.flight']")).sendKeys(Flight_1);
		
		driver.findElement(By.xpath("//ecw-autocomplete[@name='origin'][@md-search-text='ui.searchCriteria.origin']//input[@ng-model='$mdAutocompleteCtrl.scope.searchText'][1]")).sendKeys(Origin_1);
		driver.findElement(By.xpath("//ecw-autocomplete[@name='destination'][@md-search-text='ui.searchCriteria.destination']//input[@ng-model='$mdAutocompleteCtrl.scope.searchText'][1]")).sendKeys(Destination_1);
		driver.findElement(By.xpath("//md-datepicker[@name='fltdate'][@ng-model='ui.searchCriteria.$$fromDate']//input[@class='md-datepicker-input md-input'][1]")).clear();
		driver.findElement(By.xpath("//md-datepicker[@name='fltdate'][@ng-model='ui.searchCriteria.$$fromDate']//input[@class='md-datepicker-input md-input'][1]")).sendKeys(Flight_Date_1)	;			
		driver.findElement(By.xpath("//md-datepicker[@name='fltdate'][@ng-model='ui.searchCriteria.$$toDate']//input[@class='md-datepicker-input md-input'][1]")).sendKeys(Flight_Date_1);		
		
		Thread.sleep(3000);
		
		
		WebElement element16 = driver.findElement(By.xpath("//button[@ng-click='searchPreAlert()']"));
		js.executeScript("arguments[0].click()", element16);
		
		
		Thread.sleep(3000);
		WebElement element17 =  driver.findElement(By.xpath("//i[@class='ng-scope ui-grid-icon-plus-squared']"));
		js.executeScript("arguments[0].click()", element17);
		//i[@class='ng-scope ui-grid-icon-minus-squared'] - 
		Thread.sleep(3000);
		//Boolean verifyAwbsNOIsPresent = Ressearch.Res_Verify_AwbNosearch().getText().equalsIgnoreCase(testdata.get("Full_AwbNo "));
		//assertTrue(verifyAwbsNOIsPresent ); 
		WebElement element15 = driver.findElement(By.xpath("//td//span[contains(@class,'ng-binding') and contains(text(), '3')][1]"));
				
				Boolean verifyAwbsNOIsPresent = element15.getText().equalsIgnoreCase("3");
		assertTrue(verifyAwbsNOIsPresent ); 
		
		
		WebElement element18 = driver.findElement(By.xpath("//md-checkbox[@ng-model='row.entity.isPreAlert']"));
		js.executeScript("arguments[0].click()", element18);
		
		WebElement element19 = driver.findElement(By.xpath("//button[@ng-click='printPreAlert()']"));
		js.executeScript("arguments[0].click()", element19);
		
	
		//verify:
		//td//span[contains(@class,'ng-binding') and contains(text(), '3')][1]
		//td//span/a[contains(@class,'grid-link pd-l5 ng-binding') and contains(text(), '  07733333333')][1]
		//td//span[contains(@class,'ng-binding') and contains(text(), 'TESTAGENT')][1]
		//td//span[contains(@class,'ng-binding') and contains(text(), 'CGN')][1]
		//td//span[contains(@class,'ng-binding') and contains(text(), 'DXB')][1]
		//td//span[contains(@class,'ng-binding') and contains(text(), '15/15')][1]
		//td//span[contains(@class,'ng-binding') and contains(text(), '125.00/125.00')][1]
		//td//span[contains(@class,'ng-binding') and contains(text(), '125.00/125.00')][1]
		//td//span[contains(@class,'ng-binding') and contains(text(), '0.75/0.75')]
		//td//span[contains(@class,'ng-binding') and contains(text(), 'AVI,DGR')]
		//td//span[contains(@class,'ng-binding') and contains(text(), 'CGNUPS')]
		//td//span[contains(@class,'ng-binding') and contains(text(), '03/11/2021')]
		//td//span[contains(@class,'ng-binding') and contains(text(), 'Being Processed')]
	
		
		
		
		
					/*	
					System.out.println("List size is " +drop.size());
					Thread.sleep(3000);
					
					for ( WebElement listitem:drop)
					{
						
						if (listitem.getText().equals("EGYPT AIR (MS)"))
						{
							listitem.click();
							break;
						}
					}
					*/
			       	
	}
			       	
						

	
}
