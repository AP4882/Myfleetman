package MyFleetBooking;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ConstantUtil.Constant;

import SignInModule.LoginAction;

public class BookingTest {

	protected static WebDriver driver;

	//@BeforeTest
  //public void beforeTest() {
	  
	  
	//  System.setProperty(Constant.Chrome_Property, Constant.Set_Property);
  	
      //driver = new ChromeDriver();

      //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      // Launch the Online Store Website using Constant Variable

      //driver.get(Constant.URL);
       
      //driver.manage().window().maximize();
  //}
  
  @BeforeMethod
 
  public void beforeMethod() throws InterruptedException {
	  System.setProperty(Constant.Chrome_Property, Constant.Set_Property);
	  	
      driver = new ChromeDriver();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      // Launch the Online Store Website using Constant Variable

      driver.get(Constant.URL);
       
      driver.manage().window().maximize();
      LoginAction.Execute(driver, Constant.Username, Constant.Password);
      LoginAction.PostLogin(driver);
  }

  
  @Test
  
  public void JSONDataRead() throws InterruptedException, AWTException, FileNotFoundException, IOException, ParseException {
	  
	  Object obj = new JSONParser().parse(new FileReader(Constant.Json4));
	  JSONObject Ob = (JSONObject)obj;
	  JSONArray Arr = (JSONArray)Ob.get("BookingForm");
	  
	  
	  
	  for (int i = 0; i < Arr.size(); i++) 
		{ 
		  
		  
			JSONObject object1 = (JSONObject)Arr.get(i);
			
			String prefix = String.valueOf(object1.get("Prefix"));
			String CompanyName = String.valueOf(object1.get("Companyname"));
			String servingCity = String.valueOf(object1.get("ServingCity"));
			String BookingMode = String.valueOf(object1.get("BookingMode"));
			String Year1 = String.valueOf(object1.get("Year1"));
			String Month1 = String.valueOf(object1.get("Month1"));
			String Day1 = String.valueOf(object1.get("Day1"));
			String Year2 = String.valueOf(object1.get("Year2"));
			String Month2 = String.valueOf(object1.get("Month2"));
			String Day2 = String.valueOf(object1.get("Day2"));
			String NoofGuests = String.valueOf(object1.get("No.ofGuests"));
			String GuestPrefix = String.valueOf(object1.get("GuestPrefix"));
			String GuestName = String.valueOf(object1.get("GuestName"));
			String EmpID = String.valueOf(object1.get("EmpID"));
			String ProjectCode = String.valueOf(object1.get("ProjectCode"));
			String ProjectName = String.valueOf(object1.get("ProjectName"));
			String ProjectCost = String.valueOf(object1.get("ProjectCost"));
			String CustCode = String.valueOf(object1.get("CustCode"));
			String Time = String.valueOf(object1.get("Time"));
			String Address1 = String.valueOf(object1.get("Address1"));
			String Address2 = String.valueOf(object1.get("Address2"));
			String PickupLocation = String.valueOf(object1.get("PickupLocation"));
			String DropLocation = String.valueOf(object1.get("DropLocation"));
			String BookingGivenBy = String.valueOf(object1.get("BookingGivenBy"));
			String BookingByContactNo = String.valueOf(object1.get("BookingByContactNo"));
			String BookingByEmailId = String.valueOf(object1.get("BookingByEmailId"));
			String CompanyRefNo = String.valueOf(object1.get("CompanyRefNo"));
			String PaymentType = String.valueOf(object1.get("PaymentType"));
			String VehicleType = String.valueOf(object1.get("VehicleType"));
			String PackageFor = String.valueOf(object1.get("PackageFor"));
			String PackageName = String.valueOf(object1.get("PackageName"));
			String PaymentMode = String.valueOf(object1.get("PaymentMode"));
		
			
			
			
	   	    
		Booking.BookTest1(prefix,CompanyName,servingCity,BookingMode,Year1,Month1,Day1,Year2,Month2,Day2,
				NoofGuests,GuestPrefix,GuestName,EmpID,ProjectCode,ProjectName,ProjectCost,CustCode,
				Time,Address1,Address2,PickupLocation,DropLocation,BookingGivenBy,BookingByContactNo,
		        BookingByEmailId,CompanyRefNo,PaymentType,VehicleType,PackageFor,PackageName,PaymentMode
		       );
	   	 	  
  }
	  	   
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	
	   WebElement out = driver.findElement(By.id("ctl00_lblusername"));
	   out.click();
	   Thread.sleep(3000);
	   WebElement Logout = driver.findElement(By.id("ctl00_hyLogOut"));
	   Logout.click();
	   Thread.sleep(4000);
	   
  }
  
}

	

