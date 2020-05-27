package DataProviderJSON;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
    import org.openqa.selenium.StaleElementReferenceException;
    import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.How;
    import org.openqa.selenium.support.PageFactory;
    import org.openqa.selenium.support.ui.Select;
    import java.awt.AWTException;
		import java.io.File;
		import java.io.FileNotFoundException;
		import java.io.FileOutputStream;
        import java.io.FileReader;
        import java.io.IOException;
		import java.sql.Date;
		import java.util.HashMap;
		import java.util.LinkedHashMap;
	    import java.util.List;
	    import java.util.Map;
		import java.util.Set;
		import java.util.concurrent.TimeUnit;

		import org.apache.poi.hssf.usermodel.HSSFSheet;
		import org.apache.poi.hssf.usermodel.HSSFWorkbook;
		import org.apache.poi.ss.usermodel.Row;
        import org.json.simple.JSONArray;
        import org.json.simple.JSONObject;
        import org.json.simple.parser.JSONParser;
        import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
	    import org.openqa.selenium.interactions.Actions;
	    import org.openqa.selenium.support.ui.Select;
	

		import com.google.common.collect.Table.Cell;

import ConstantUtil.Constant;

import SignInModule.LoginAction;

import bsh.ParseException;
import DataProviderJSON.Myfleet_Page_Factory;



		
		public class MultipleGuestBookingMain extends Myfleet_Page_Factory {

			protected static WebDriver driver;
			HSSFWorkbook workbook;
			// Declare An Excel Work Sheet
			HSSFSheet sheet;
			// Declare A Map Object To Hold TestNG Results
			protected static Map<String, Object[]> TestNGResults;
			public int s=1;
			public String add1= "Airport";
			public String add2= "Office";
			public String add3= "Hotel";
						
			//@FindBy(how = How.ID, using = "txtCompanyName") 
		    //WebElement Comp_Prefix;
			
			public MultipleGuestBookingMain() {
				
			}
				
		@DataProvider
		  public Iterator<Object[]> getTestData() throws FileNotFoundException, ParseException, IOException, org.json.simple.parser.ParseException, InterruptedException {
			  ArrayList<Object[]> Testdata = GetJSONDataMultipleGuest.getJSONdata(Constant.Json3, "BookingForm");
			  return Testdata.iterator();
		  }
		  
		  @Test(dataProvider="getTestData")	  
	  public void WebderiverTest (String Prefix,String CompanyName,String ServingCity,String BookingMode,String Year,String Month,
				String Day,String NoofGuest,String BookingGivenBy, String BookingByContactNo,String BookingByEmailId, String CompanyRefNo, String PaymentType,String Security,String VehicleType, String PackageFor, String PackageName,String PaymentMode,
				String RadioSelection,String Vehicle_Prefix, String SearchVehicle,String NewVehicle,String VehicleCat,
				String VehicleState, String VehicleCityCode,String VehicleSeries, String VehicleNumber,String DriverPrefix, String DriverName, String Driver_Mob,String AllocationType,int Index) throws InterruptedException, AWTException, FileNotFoundException, IOException, org.json.simple.parser.ParseException 
			{
			      
		 
		    LoginAction.PostLogin(driver);
		
		    Myfleet_Page_Factory POF = PageFactory.initElements(driver, Myfleet_Page_Factory.class);
			
		    try {
				
		        System.out.println("------------------------Output:"+s+"------------------------------");
		        
		       
		        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		        POF.Comp_Prefix.clear();
		        POF.Comp_Prefix.sendKeys(Prefix);
		        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		       
				//driver.findElement(By.id("txtCompanyName")).clear();
				//driver.findElement(By.id("txtCompanyName")).sendKeys(Prefix);
				//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				
				Thread.sleep(2000);
				List<WebElement> list = POF.Comp_name;
			      for (WebElement listview : list) {
			    	 
					if(listview.getText().equalsIgnoreCase(CompanyName)) {
					
					 Actions actions = new Actions(driver);
					    actions.moveToElement(listview);
					    Thread.sleep(1000);
						    listview.click();
						    System.out.println("Company Name:"+CompanyName);
						    Thread.sleep(1000);
					
					 }    
			      }
						    
								   TestNGResults.put("3", new Object[] { 2d,
											"Check and confirm company name", "Company details shouild be correct","As Expected",
											"Test Case is Pass" });
					
			      
								   }  catch (Exception e) {
									TestNGResults.put("3", new Object[] { 2d,
											"Check and confirm company details", "Company details should be correct","Result not as expected",
											"Test Case is Fail" });   
								   }
					
			try {
				Select s1 = new Select(POF.City);
				s1.selectByVisibleText(ServingCity);
				System.out.println("CityName:"+ServingCity);
				
					   TestNGResults.put("4", new Object[] { 3d,
								"Select city as per company selected", "City should be selected from drop down","As Expected",
								"Test Case is Pass" });
					    
					   }  catch (Exception e) {
						TestNGResults.put("4", new Object[] { 3d,
								"Select city as per company selected", "City should be selected from drop down","Result not as expected",
								"Test Case is Fail" });   
			}
				
			try {
				
				Select s2 = new Select(POF.Book_mode);
				s2.selectByVisibleText(BookingMode);
				System.out.println("Booking Mode:"+BookingMode);
				Thread.sleep(1000);
				 
					   TestNGResults.put("5", new Object[] { 4d,
								"Select Booking Mode", "Booking mode should be selected from drop down","As Expected",
								"Test Case is Pass" });
					    
					   }  catch (Exception e) {
						TestNGResults.put("5", new Object[] { 4d,
								"Select Booking mode", "Booking Mode should be selected from drop down","Result not as expected",
								"Test Case is Fail" });   
						
					   }
						 
				
			try {
				 WebElement selectdate = POF.FromDate;
				 Actions actions = new Actions(driver);
				 actions.moveToElement(selectdate).click().build().perform();
				 Thread.sleep(1000);
		

				try {
					
				Select s3 = new Select(POF.SelectYear);	
		      // Select s3 = new Select(driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-year")));
				s3.selectByVisibleText(Year);
				System.out.println("Year:"+Year);
				Thread.sleep(1000);
			
				
			   Select s4 = new Select(POF.SelectMonth);
			   s4.selectByVisibleText(Month);
			   System.out.println("Month:"+Month);
			   Thread.sleep(1000);
				
				Thread.sleep(1000);
				List <WebElement> Days = POF.SelectDays;
				for(WebElement d:Days){
					d.getText();
					if(d.getText().equals(Day )){
						d.click();
						System.out.println("Day:"+Day);
					}
				}
		   }catch(StaleElementReferenceException e) {
				
				}
				
				 
					   TestNGResults.put("6", new Object[] { 5d,
								"Select date from date picker", "User should allow to select date","As Expected",
								"Test Case is Pass" });
					    
					   }  catch (Exception e1) {
						TestNGResults.put("6", new Object[] { 5d,
								"Select date from date picker", "User should allow to select date","Result not as expected",
								"Test Case is Fail" });   
					   }
				
			try {
				Thread.sleep(1000);
				
				Select s5 = new Select(POF.GuestCount);
				//Select s5 = new Select(driver.findElement(By.id("ddlGuestsNo")));
				s5.selectByVisibleText(NoofGuest);
				System.out.println("Total Guest:"+NoofGuest);
				Thread.sleep(1000);
				
					   TestNGResults.put("7", new Object[] { 6d,
								"Select No of Guest", "Guest should be selected from drop down","As Expected",
								"Test Case is Pass" });
					    
					   }  catch (Exception e1) {
						TestNGResults.put("7", new Object[] { 6d,
								"Select No of guest", "Guest should be selected from drop down","Result not as expected",
								"Test Case is Fail" });   
					   }
			
			POF.BookingBy.clear();
		    POF.BookingBy.sendKeys(BookingGivenBy);
		    //driver.findElement(By.id("txtBookingGivenBy")).clear();
			//driver.findElement(By.id("txtBookingGivenBy")).sendKeys(BookingGivenBy);
			System.out.println("Booking Given By:"+BookingGivenBy);
			Thread.sleep(1000);
		    
			
			POF.BookingByContact.clear();
			POF.BookingByContact.sendKeys(BookingByContactNo);
			//driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtBookingContactNo")).clear();
		    //driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtBookingContactNo")).sendKeys(BookingByContactNo);
		    System.out.println("Booking Contact:"+BookingByContactNo);
		    Thread.sleep(1000);
		    
		    
		    POF.BookingByEmail.clear();
		    POF.BookingByEmail.sendKeys(BookingByEmailId);
		    //driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtBoookerEmailId")).clear();
			//driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtBoookerEmailId")).sendKeys(BookingByEmailId);
			System.out.println("Booking Mail ID:"+BookingByEmailId);
			Thread.sleep(1000);
		    
			
			POF.CompanyRef.clear();
		    POF.CompanyRef.sendKeys(CompanyRefNo);
			//driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtCmpReference")).clear();
			//driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtCmpReference")).sendKeys(CompanyRefNo);
			System.out.println("Company Ref No:"+CompanyRefNo);
			Thread.sleep(1000);
				
			int GuestCount = Integer.parseInt(NoofGuest);
			
			if(GuestCount>=1) {
				 
				 
				 Object obj1 = new JSONParser().parse(new FileReader(Constant.Json3));
					JSONObject jo2 = (JSONObject)obj1;
					JSONArray Arr2 = (JSONArray) jo2.get("BookingForm");
				 
				 //for(int m=0;m<GuestCount;m++) {
					 JSONObject Myobj1 = (JSONObject) Arr2.get(Index);
					 
					 JSONArray Arr3 = 	(JSONArray) Myobj1.get("GuestDetails");
					 int k=1;
					 
			for(int j=0;j<Arr3.size();j++) {
						 		
					JSONObject Myobj2 = (JSONObject) Arr3.get(j);
					String GuestPrefix = String.valueOf(Myobj2.get("GuestPrefix"));
					String GuestName = String.valueOf(Myobj2.get("GuestName"));
					String Mob = String.valueOf(Myobj2.get("Mob"));
					String Email = String.valueOf(Myobj2.get("Email"));
					String Time = String.valueOf(Myobj2.get("Time"));
					String Address1 = String.valueOf(Myobj2.get("Address1"));
					String Address2 = String.valueOf(Myobj2.get("Address2"));
					String PickupLocation = String.valueOf(Myobj2.get("PickupLocation"));
					String DropLocation = String.valueOf(Myobj2.get("DropLocation"));
					String FlightNo = String.valueOf(Myobj2.get("FlightNo"));
					String VIP = String.valueOf(Myobj2.get("VIP"));
					String Lady = String.valueOf(Myobj2.get("Lady"));
					
				
				try {
					
					driver.findElement(By.id("txtCustomerName_"+k)).sendKeys(GuestPrefix);
					Thread.sleep(1000);
					
					List<WebElement> list1 = driver.findElements(By.className("ui-corner-all"));
				      for (WebElement listview1 : list1) {
						if(listview1.getText().equalsIgnoreCase(GuestName)) {
						
						 Actions actions1 = new Actions(driver);
						    actions1.moveToElement(listview1);
						    Thread.sleep(1000);
							 listview1.click();
							 Thread.sleep(2000);
						}
				      }
					
						   TestNGResults.put("7", new Object[] { 6d,
									"Select Guest Name", "Guest name should be selected","As Expected",
									"Test Case is Pass" });
						    
						   }  catch (Exception e1) {
							TestNGResults.put("7", new Object[] { 6d,
									"Select Guest name", "Guest name should be selected","Result not as expected",
									"Test Case is Fail" });   
						   }
				
				/*try {
					
					driver.findElement(By.id("txtMobileNo_"+k)).sendKeys(Mob);
					Thread.sleep(2000);
					driver.findElement(By.id("txtEmailId_"+k)).sendKeys(Email);
				
					Thread.sleep(1000);
					
						   TestNGResults.put("9", new Object[] { 8d,
									"Enter Mob no", "Mobile no should be valid","As Expected",
									"Test Case is Pass" });
						    
						   }  catch (Exception e1) {
							TestNGResults.put("9", new Object[] { 8d,
									"Enter Mob No", "Mob No should be valid","Result not as expected",
									"Test Case is Fail" });   
						   }*/
					
				
				//driver.findElement(By.id("txtEmailId_"+k)).sendKeys(EmailId);
				//Thread.sleep(1000);
				
				try {
					
					driver.findElement(By.id("txtReportingTime_"+k)).sendKeys(Time);
					
						   TestNGResults.put("8", new Object[] { 7d,
									"Select Time", "Time should be selected","As Expected",
									"Test Case is Pass" });
						    
						   }  catch (Exception e1) {
							TestNGResults.put("8", new Object[] { 7d,
									"Select Time", "Time should be selected","Result not as expected",
									"Test Case is Fail" });   
						   }
				

				try {
					
				Select s6 = new Select(driver.findElement(By.id("ddlPickupPlace_"+k)));
				s6.selectByVisibleText(Address1);
				Thread.sleep(1000);
				
					   TestNGResults.put("9", new Object[] { 8d,
								"Select pick up point", "pick up should be selected","As Expected",
								"Test Case is Pass" });
					    
					   }  catch (Exception e1) {
						TestNGResults.put("9", new Object[] { 8d,
								"Select pick up point", "pick up should be selected","Result not as expected",
								"Test Case is Fail" });   
					   }
				
				try {
					Select s7 = new Select(driver.findElement(By.id("ddlDropPlace_"+k)));
					s7.selectByVisibleText(Address2);
					Thread.sleep(1000);
					
						   TestNGResults.put("10", new Object[] { 9d,
									"Select drop up place", "drop up should be selected","As Expected",
									"Test Case is Pass" });
						    
						   }  catch (Exception e1) {
							TestNGResults.put("10", new Object[] { 9d,
									"Select drop up place", "drop up should be selected","Result not as expected",
									"Test Case is Fail" });   
						   }
			
				if(Address1.equalsIgnoreCase(add1)) 
				{
			    driver.findElement(By.id("PickupField1_"+k)).sendKeys(PickupLocation);
			    Thread.sleep(1000);
			    
				//driver.findElement(By.id("txtpickuplaceto_"+k)).sendKeys(DropLocation);
				//Thread.sleep(1000);

				driver.findElement(By.id("PickupField2_"+k)).sendKeys(FlightNo);
				Thread.sleep(1000);
				}
				
				if(Address1.equalsIgnoreCase(add2)) 
				{
				driver.findElement(By.id("txtpickuplacefrom_"+k)).clear();
			    driver.findElement(By.id("txtpickuplacefrom_"+k)).sendKeys(PickupLocation);
			    Thread.sleep(1000);
			    
				driver.findElement(By.id("txtpickuplaceto_"+k)).sendKeys(DropLocation);
				Thread.sleep(1000);
				}
                
				if(Address1.equalsIgnoreCase(add3))
				{
				driver.findElement(By.id("PickupField1_"+k)).clear();
				driver.findElement(By.id("PickupField1_"+k)).sendKeys(PickupLocation);
				Thread.sleep(1000);
				
				driver.findElement(By.id("txtpickuplaceto_"+k)).sendKeys(DropLocation);
				Thread.sleep(1000);
					
				}
				
				try {
					
				
					Thread.sleep(1000);
				if(VIP.equalsIgnoreCase("Yes") && Lady.equalsIgnoreCase("No")) {
					WebElement checkbox1 = driver.findElement(By.id("chkVIP_"+k));
					checkbox1.click();
					
				}else if(Lady.equalsIgnoreCase("Yes") && VIP.equalsIgnoreCase("No") ) {
					WebElement checkbox2 = driver.findElement(By.id("chkLady_"+k));
					checkbox2.click();
					}
				else if(VIP.equalsIgnoreCase("Yes") && Lady.equalsIgnoreCase("Yes"))
				{
					WebElement checkbox1 = driver.findElement(By.id("chkVIP_"+k));
					checkbox1.click();
					WebElement checkbox2 = driver.findElement(By.id("chkLady_"+k));
					checkbox2.click();
					
				}

				TestNGResults.put("11", new Object[] { 10d,
								"VIP & Lady checkbox selection", "should allow to check Vip and Lady","As Expected",
								"Test Case is Pass" });
					    
					   }  catch (Exception e1) {
						TestNGResults.put("11", new Object[] { 10d,
								"VIP & Lady checkbox selection", "should allow to check Vip and Lady","Result not as expected",
								"Test Case is Fail" });   
					   }	
				
				if(k<GuestCount) {
				 driver.findElement(By.id("btnAddGuest"+k)).click();
				 Thread.sleep(2000);
		         k++;}
		                
					 }
			}
					
			    
				
				try {
				List<WebElement> radio = driver.findElements(By.xpath("//input[@name = 'ctl00$ContentPlaceHolder1$Direct' and @type = 'radio']"));
				for(int i=0;i<radio.size();i++){
					WebElement local_radio = radio.get(i);
					String value = local_radio.getAttribute("value");
					
					if(value.equals(PaymentType)){
						System.out.println("Payment type : " + value);
						local_radio.click();
					}
				}
				
					   TestNGResults.put("12", new Object[] { 11d,
								"select payment type", "should allow to select payment type","As Expected",
								"Test Case is Pass" });
					    
					   }  catch (Exception e1) {
						TestNGResults.put("12", new Object[] { 11d,
								"select payment type", "should allow to select payment type","Result not as expected",
								"Test Case is Fail" });   
					   }
				
				if(Security.equalsIgnoreCase("Yes")) 
				{
				WebElement ele = POF.Chk_Security;
				ele.click();
				}
				
				try {
			    Select s8 = new Select(POF.Vehicle_Type);
				s8.selectByVisibleText(VehicleType);
				System.out.println("Vehicle Type:"+VehicleType);
				Thread.sleep(1000);
				
					   TestNGResults.put("13", new Object[] { 12d,
								"Select Vehicle Type", "should allow to select Vehicle type","As Expected",
								"Test Case is Pass" });
					    
					   }  catch (Exception e1) {
						TestNGResults.put("13", new Object[] { 12d,
								"Select Vehicle Type", "should allow to select Vehicle type","Result not as expected",
								"Test Case is Fail" });   
					   }	
				

				
				Select s9 = new Select(POF.Package);
				//Select s9 = new Select(driver.findElement(By.id("ddlPackageFor")));
				s9.selectByVisibleText(PackageFor);
				System.out.println("Package For:"+PackageFor);
				Thread.sleep(1000);
				
				
				Select s10 = new Select(POF.Package_Name);
				s10.selectByVisibleText(PackageName);
				System.out.println("Package Name:"+PackageName);
				Thread.sleep(1000);
				
				
				//Select s11 = new Select(POF.Payment_Mode);
				//s11.selectByVisibleText(PaymentMode);
				//Thread.sleep(1000);
				
				String parentWindowHandle = driver.getWindowHandle();
				
				try {
				WebElement Submit = POF.SubmitClick;
				Submit.click();
				Thread.sleep(4000);
				
					   TestNGResults.put("14", new Object[] { 13d,
								"Save Booking", "Booking should be saved","As Expected",
								"Test Case is Pass" });
					    
					   }  catch (Exception e1) {
						TestNGResults.put("14", new Object[] { 13d,
								"Save Booking", "Booking should be saved","Result not as expected",
								"Test Case is Fail" });   
					   }	
				
				
				/* Alert alert = driver.switchTo().alert();
				 String alertMessage= driver.switchTo().alert().getText();
				 System.out.println(alertMessage);*/
				Robot r = new Robot();
	            r.keyPress(KeyEvent.VK_ENTER);
	            r.keyRelease(KeyEvent.VK_ENTER);
	            Thread.sleep(3000);
	            
	           /* ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	            driver.close();
	            driver.switchTo().window(tabs2.get(1));*/
	           
	            Set<String> allWindowHandles = driver.getWindowHandles();
	            
	           /* for(String handle : allWindowHandles)
	            {
	            System.out.println("Window handle - > " + handle);
	           
	            }*/
	            
	            driver.switchTo().window(parentWindowHandle);
	            String Title = driver.getTitle();
	            //System.out.println(Title);
	            Thread.sleep(3000);
	       
			
	            
	            
			
	      
	            
	            	
	            
	            /*for (WebElement listview2 : Li) {
	            System.out.println(listview2);
	            	if(listview2.getText().equalsIgnoreCase(RadioSelection)) {
						
						 Actions actions = new Actions(driver);
						    actions.moveToElement(listview2);
						    Thread.sleep(2000);
							    listview2.click();
							    //System.out.println("Vehicle no:"+SearchVehicle);
							    Thread.sleep(3000);*/
	            	
	            
	            
	            
	            
			
		  
		  
	           // List<WebElement> Li = driver.findElements(By.className("col-lg-9 col-md-8 col-sm-8 col-xs-6 col-xxs-8 text-nowrap lg-no-paddingright"));
	            
	         
	            
	            
	         ///Allocation of Booking
	            
			    //String Vendorname = reader.getCellData("Allocation", "Vendorname", 2);
			    //System.out.println(Vendorname);
			    
	            
	            
	            //WebElement Radio =  driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_rdBookingType_0"));
	            //Radio.click();
	            
	            
	         if(RadioSelection.equalsIgnoreCase("Self ")) {
	            	
	            	try {	
	           
	            		POF.Search_Vehicle.clear();
		            	POF.Search_Vehicle.sendKeys(Vehicle_Prefix);
		            	
		            	//PageFactory.Search_Vehicle.sendKeys(SearchVehicle);
		            //driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch")).clear();
		            //driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch")).sendKeys(SearchVehicle);
		            //System.out.println("Vehicle No:"+SearchVehicle);
		            Thread.sleep(2000);
		            
		            List<WebElement> list2 = POF.Search_veh;                                                                                                                                     
				      for (WebElement listview2 : list2) {
						if(listview2.getText().equalsIgnoreCase(SearchVehicle)) {
						
						 Actions actions = new Actions(driver);
						    actions.moveToElement(listview2);
						    Thread.sleep(2000);
							    listview2.click();
							    System.out.println("Vehicle no:"+SearchVehicle);
							    Thread.sleep(2000);
						
		            
		           
		           // POF.KeysTAB1.sendKeys(Keys.TAB);
		            //PageFactory.KeysTAB1.sendKeys(Keys.TAB);
		            //driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")).sendKeys(Keys.TAB);
		           // Thread.sleep(3000);
							    
		            
						   TestNGResults.put("15", new Object[] { 14d,
									"Type Vehicle No to search", "should select vehicle on type","As Expected",
									"Test Case is Pass" });
						}
				      }
						    
						   }  catch (Exception e1) {
							TestNGResults.put("15", new Object[] { 14d,
									"Type Vehicle no to search", "Should select vehicle on type","Result not as expected",
									"Test Case is Fail" });   
						   }	
		            
		            
		           // POF.Driver_Name.clear();
		            //POF.Driver_Name.sendKeys(DriverPrefix);
		            //PageFactory.Driver_Name.sendKeys(DriverName);
		            //driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).clear();
		            //driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).sendKeys(DriverName);
		            //System.out.println("Driver Name:"+DriverName);
		            //Thread.sleep(3000);
		            
		           // List<WebElement> list3 = POF.Search_driver;                                                                                                                                     
				     // for (WebElement listview3 : list3) {
				    	  //System.out.println(listview3.getText());
				      
				    	  
						//if(listview3.getText().equalsIgnoreCase(DriverName)) {
						
						 //Actions actions = new Actions(driver);
						   //actions.moveToElement(listview3);
						    //Thread.sleep(2000);
							  //listview3.click();
							    //System.out.println("Driver Name:"+DriverName);
							   //Thread.sleep(2000);
						//}
				      //}
		           
		            //WebElement Driver_Mobile = POF.Driver_Contact;
		            //Driver_Mobile.sendKeys(Driver_Mob);
		           //POF.KeysTAB2.sendKeys(Keys.TAB);
		            //PageFactory.KeysTAB2.sendKeys(Keys.TAB);
		            //driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad\"]")).sendKeys(Keys.TAB);
		           
		            
		            
		            Select AT = new Select (POF.Allocation_Type);
		            //Select AT = new Select (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_ddlAllocationType']")));
		    		AT.selectByVisibleText(AllocationType);
		    		System.out.println("Allocation Type:"+AllocationType);
		    		Thread.sleep(3000);
		    		
		    		
		    		String parentWindowHandle1 = driver.getWindowHandle();
		    		
		    		try {
		    			
		    		WebElement Submit1 = POF.Submit1;
		    		//WebElement Submit1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_btnSave"));
		    		Submit1.click();
		    		Thread.sleep(3000);
		    		 
						   TestNGResults.put("16", new Object[] { 15d,
									"Allocation submit", "should allow allocation to submit","As Expected",
									"Test Case is Pass" });
						    
						   }  catch (Exception e1) {
							TestNGResults.put("16", new Object[] { 15d,
									"Allocation submit", "should allow allocation to submit","Result not as expected",
									"Test Case is Fail" });   
						   }	
		    		
		    		
		    		 Alert alert = driver.switchTo().alert();
		    		 String alertMessage= driver.switchTo().alert().getText();		
		        		
		    	        // Displaying alert message		
		    	        System.out.println(alertMessage);	
		    	        
		    	        Thread.sleep(2000);	
		    	        // Accepting alert		
		    	        alert.accept();	
		    	        Thread.sleep(2000);
		    		 driver.switchTo().window(parentWindowHandle1);
		             String Title1 = driver.getTitle();
		             System.out.println(Title1);
		             Thread.sleep(3000);
		    	        
		    	        
		    	       /* WebElement Last_submit = POF.Final_Submit;
		    	        Last_submit.click();
		    	        Thread.sleep(5000);
		    	        
		    	        Alert alert1 = driver.switchTo().alert();
		    	        alert1.accept();
		    	        Thread.sleep(4000);*/
		    	       
	    		
	            }else if(RadioSelection.equalsIgnoreCase("Vendor")) {
	            	
	            WebElement select = POF.VendorRadioClick;
	            //WebElement select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_rdBookingType_1"));
	            select.click();
	            Thread.sleep(3000);
	            //driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVendorName")).sendKeys(Vendorname);
	            //Thread.sleep(4000);
	            //driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVendorName")).sendKeys(Keys.TAB);
	            //Thread.sleep(10000);
	            
	            try {
	            	
	            	POF.Search_Vehicle.clear();
	            	POF.Search_Vehicle.sendKeys(Vehicle_Prefix);
	            	
	            	//PageFactory.Search_Vehicle.sendKeys(SearchVehicle);
	            //driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch")).clear();
	            //driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch")).sendKeys(SearchVehicle);
	            //System.out.println("Vehicle No:"+SearchVehicle);
	            Thread.sleep(2000);
	            
	            List<WebElement> list2 = POF.Search_veh;                                                                                                                                     
			      for (WebElement listview2 : list2) {
					if(listview2.getText().equalsIgnoreCase(SearchVehicle)) {
					
					 Actions actions = new Actions(driver);
					    actions.moveToElement(listview2);
					    Thread.sleep(1000);
						    listview2.click();
						    System.out.println("Vehicle no:"+SearchVehicle);
						    Thread.sleep(2000);
					
	            
	           
	           // POF.KeysTAB1.sendKeys(Keys.TAB);
	            //PageFactory.KeysTAB1.sendKeys(Keys.TAB);
	            //driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")).sendKeys(Keys.TAB);
	           // Thread.sleep(3000);
						    
	            
					   TestNGResults.put("15", new Object[] { 14d,
								"Type Vehicle No to search", "should select vehicle on type","As Expected",
								"Test Case is Pass" });
					}
			      }
					    
					   }  catch (Exception e1) {
						TestNGResults.put("15", new Object[] { 14d,
								"Type Vehicle no to search", "Should select vehicle on type","Result not as expected",
								"Test Case is Fail" });   
					   }	
	            
	            
	            if(NewVehicle.equalsIgnoreCase("Yes")) {
	            	
	            	driver.findElement(By.id("ImgButtonAddVehicleNo")).click();
	                Thread.sleep(4000);
	                
	                Select s25 = new Select(driver.findElement(By.id("ddlVehicleCategory")));
	                s25.selectByVisibleText(VehicleCat);
	            	Thread.sleep(1000);
	                
	            	Select s26 = new Select(driver.findElement(By.id("ddlVehicleNoPop")));
	                s26.selectByVisibleText(VehicleState);
	            	Thread.sleep(1000);
	            	
	            	Select s27 = new Select(driver.findElement(By.id("ddlVehicleNoPop1")));
	                s27.selectByVisibleText(VehicleCityCode);
	            	Thread.sleep(1000);
	            	
	            	driver.findElement(By.id("txtVehicleNoPop1")).clear();
	                driver.findElement(By.id("txtVehicleNoPop1")).sendKeys(VehicleSeries);
	                Thread.sleep(1000);
	                
	                driver.findElement(By.id("txtVehicleNoPop2")).clear();
	                driver.findElement(By.id("txtVehicleNoPop2")).sendKeys(VehicleNumber);
	                Thread.sleep(1000);
	                
	                driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/button[1]")).click();
	                Thread.sleep(3000);
	            	
	            	
	            }
	            
	            POF.Driver_Name.clear();
	            POF.Driver_Name.sendKeys(DriverPrefix);
	            //PageFactory.Driver_Name.sendKeys(DriverName);
	            //driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).clear();
	            //driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).sendKeys(DriverName);
	            //System.out.println("Driver Name:"+DriverName);
	            Thread.sleep(2000);
	            
	            List<WebElement> list3 = POF.Search_driver;                                                                                                                                     
			      for (WebElement listview3 : list3) {
			    	  //System.out.println(listview3.getText());
			      
			    	  
					if(listview3.getText().equalsIgnoreCase(DriverName)) {
					
					 Actions actions = new Actions(driver);
					   actions.moveToElement(listview3);
					    Thread.sleep(1000);
						  listview3.click();
						    System.out.println("Driver Name:"+DriverName);
						   Thread.sleep(2000);
					}
			      }
	           
	            //WebElement Driver_Mobile = POF.Driver_Contact;
	            //Driver_Mobile.sendKeys(Driver_Mob);
	           POF.KeysTAB2.sendKeys(Keys.TAB);
	            //PageFactory.KeysTAB2.sendKeys(Keys.TAB);
	            //driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad\"]")).sendKeys(Keys.TAB);
	           
	            
	            
	            Select AT = new Select (POF.Allocation_Type);
	            //Select AT = new Select (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_ddlAllocationType']")));
	    		AT.selectByVisibleText(AllocationType);
	    		System.out.println("Allocation Type:"+AllocationType);
	    		Thread.sleep(3000);
	    		
	    		
	    		String parentWindowHandle1 = driver.getWindowHandle();
	    		
	    		try {
	    			
	    		WebElement Submit1 = POF.Submit1;
	    		//WebElement Submit1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_btnSave"));
	    		Submit1.click();
	    		Thread.sleep(3000);
	    		 
					   TestNGResults.put("16", new Object[] { 15d,
								"Allocation submit", "should allow allocation to submit","As Expected",
								"Test Case is Pass" });
					    
					   }  catch (Exception e1) {
						TestNGResults.put("16", new Object[] { 15d,
								"Allocation submit", "should allow allocation to submit","Result not as expected",
								"Test Case is Fail" });   
					   }	
	    		
	    		
	    		 Alert alert = driver.switchTo().alert();
	    		 String alertMessage= driver.switchTo().alert().getText();		
	        		
	    	        // Displaying alert message		
	    	        System.out.println(alertMessage);	
	    	        
	    	        Thread.sleep(2000);	
	    	        // Accepting alert		
	    	        alert.accept();	
	    	        Thread.sleep(2000);
	    		 driver.switchTo().window(parentWindowHandle1);
	             String Title1 = driver.getTitle();
	             System.out.println(Title1);
	             Thread.sleep(3000);
	    	        
	    	        
	    	    /*  if(NewVehicle.equalsIgnoreCase("Yes")) {
	    	        	
	    	        	WebElement AddVehicleSubmit = POF.NewVehicleSubmit;
	    	        	AddVehicleSubmit.click();
	    	        	Thread.sleep(5000);
	    	        	
	    	        }else {
	    	        
	    	        WebElement Last_submit = POF.Final_Submit;
	    	        Last_submit.click();
	    	        Thread.sleep(5000);
	    	        }
	    	        
	    	        
	    	        Alert alert1 = driver.switchTo().alert();
	    	        alert1.accept();
	    	        Thread.sleep(4000);*/
	    	       
	    		}
	  		
	            s++;
	  	
	  			}
	            
			
	  		
	@BeforeClass(alwaysRun = true)

	public void Suitesetup() throws InterruptedException {

	// create a new work book
			workbook = new HSSFWorkbook();
		// create a new work sheet
			sheet = workbook.createSheet("TestNG Result Summary");
			TestNGResults = new LinkedHashMap<String, Object[]>();
		// add test result excel file column header
		// write the header in the first row
		TestNGResults.put("1", new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output","Status" });

			
		try {
		  System.setProperty(Constant.Chrome_Property,Constant.Set_Property);
		  	
	    driver = new ChromeDriver();

	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    // Launch the Online Store Website using Constant Variable

	    
	     
	    driver.manage().window().maximize();
	    
	 
	    driver.get(Constant.URL);
	    
	       
	      driver.manage().window().maximize();
	      LoginAction.Execute(driver, Constant.Username, Constant.Password);
	      TestNGResults.put("2", new Object[] { 1d,
					"To check User Login", "should allow user to Login","As Expected",
					"Test Case is Pass" });
		 }  catch (Exception e1) {
				TestNGResults.put("2", new Object[] { 1d,
						"To check User Login", "should allow user to Login","Result not as expected",
						"Test Case is Fail" });   
			   }	
	   
	}
	
	@AfterClass
	public void suiteTearDown() throws InterruptedException {
		// write excel file and file name is SaveTestNGResultToExcel.xls
			Set<String> keyset = TestNGResults.keySet();
			int rownum = 0;
			for (String key : keyset) {
				Row row = sheet.createRow(rownum++);
				Object[] objArr = TestNGResults.get(key);
				int cellnum = 0;
				for (Object obj : objArr) {
					org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellnum++);
					if (obj instanceof Date)
						cell.setCellValue((Date) obj);
					else if (obj instanceof Boolean)
						cell.setCellValue((Boolean) obj);
					else if (obj instanceof String)
						cell.setCellValue((String) obj);
					else if (obj instanceof Double)
						cell.setCellValue((Double) obj);
				}
			}
			
	try {
				FileOutputStream out = new FileOutputStream(new File("SaveTestNGResultToExcel.xls"));
				workbook.write(out);
				out.close();
				System.out.println("-------------------------------------------------------");
				System.out.println("Successfully saved Selenium WebDriver TestNG result to Excel File!!!");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// close the browser
	   WebElement out = driver.findElement(By.id("ctl00_lblusername"));
	   out.click();
	   Thread.sleep(2000);
	   WebElement Logout = driver.findElement(By.id("ctl00_hyLogOut"));
	   Logout.click();
	   Thread.sleep(2000);
	   driver.quit();
		}
	}

	
