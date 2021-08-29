package E2EcargoProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;

public class Pdfutil {
	
PDFUtil pu = new PDFUtil();
	
	String Expectedpdf = System.getProperty("user.dir")+"\\Uploadfile\\ExpectedAirwaybill.pdf";
	
	String Actualpdf =System.getProperty("user.dir")+"\\PdfActual\\ActualAirwaybill.pdf";
	
	String Resultfile = System.getProperty("user.dir")+"\\PdfResult";
	

	@Test
	public void pdfTest() throws IOException {	
		
		
		
		pu.excludeText("65565570"+"\\d+");		
			pu.excludeText("28/08/2021"+"\\d+");	
	
			
			pu.excludeText("\\d+");
			
						
	boolean isEquals = pu.compare(Expectedpdf, Actualpdf ,1 ,1);
	
	if (isEquals) {
		System.out.println("Both PDF files Same ");
	}
		
	else
	{
		System.out.println("Both PDF files are NOT Same ");
	}	
	
	
		
  
	}

 	
	
	
}

