package E2EcargoProject;




	import java.io.IOException;


	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import com.bkg.base.base;
import com.bkg.bookingpageobjects.Elogin;




	public class EcargoLoginFail_Test extends base {
		public WebDriver driver;
		public  static Logger log =LogManager.getLogger(base.class.getName());
		

		@BeforeTest
		public void Intialize () throws IOException {
			driver = Initializedriver();		
			log.info("Driver is Intialized");
			driver.get(Prop.getProperty("uaturl"));	
			log.info("Login Page Navigated");
			
		}
		
		@Test(dataProvider="getData")
		
		public void Browser (String Username ,String Password) throws IOException
		{
			
			Elogin login = new Elogin(driver);		
			login.Username().sendKeys(Username);
			login.Password().sendKeys(Password);
			login.Login().click();		
			  String Loginname = login.user().getText();
			  log.info(Loginname);
			  		    Assert.assertEquals("Fail",Username);
			    			}
		
		
		
		@DataProvider
		public Object[][] getData()
		{
			Object[][] data =new Object[1][2];
			
			//oth row		
			data[0][0]="sky.admin";
			data[0][1]="Skyadmin1!";
			
			return data;
			
		}
		
		
		@AfterTest

		public void teardown()
		{
		driver.close();	
		log.info("Browser Closed");

		}
		
		
		}
		
		


