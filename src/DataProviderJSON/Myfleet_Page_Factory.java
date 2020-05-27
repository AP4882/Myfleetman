package DataProviderJSON;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class Myfleet_Page_Factory {
	
	@FindBy(how = How.ID, using = "myLogin_UserName")
	
	public static WebElement User1;
	 
	@FindBy(id = "myLogin_Password")
	public static WebElement Pass1;
	
	
	@FindBy(id = "myLogin_LoginButton") 
	 public static WebElement LoginButton;
	

	
	@FindBy(how = How.ID, using = "txtCompanyName") 
    public static WebElement Comp_Prefix;
	
	@FindBy(how = How.CLASS_NAME, using = "ui-menu-item")
	 public static List<WebElement> Comp_name;
	
	@FindBy(how = How.ID, using = "ddlCity")
	public static WebElement City;
	
	@FindBy(how = How.ID, using = "ddlBookingMode")
	public static WebElement Book_mode;
	
	@FindBy(how = How.ID, using = "txtFromDate")
	public static WebElement FromDate;
	
	@FindBy(how = How.CSS, using = "#ui-datepicker-div > div > div > select.ui-datepicker-year")
	public static WebElement SelectYear;
	
	@FindBy(how = How.CSS, using = "#ui-datepicker-div > div > div > select.ui-datepicker-month")
	public static WebElement SelectMonth;
	
	@FindBy(how = How.XPATH, using ="//*[@id='ui-datepicker-div']/table/tbody/tr/td/a")
	public static List<WebElement> SelectDays;
	
	
	@FindBy(how = How.ID, using = "ddlGuestsNo")
	public static WebElement GuestCount;
	
	@FindBy(how = How.ID, using = "txtBookingGivenBy")
	public static WebElement BookingBy;
	
	@FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_txtBookingContactNo")
	public static WebElement BookingByContact;
	
	@FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_txtBoookerEmailId")
	public static WebElement BookingByEmail;
	
	@FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_txtCmpReference")
	public static WebElement CompanyRef;
	
	@FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_chkIsSecurityNeed")
	public static WebElement Chk_Security;
	
	@FindBy(how = How.ID, using = "ddlVehicalType")
	public static WebElement Vehicle_Type;
	
	@FindBy(how = How.ID, using = "ddlPackageFor")
	public static WebElement Package;
	
	@FindBy(how = How.ID, using ="ddlPackageName")
	public static WebElement Package_Name;
	
	@FindBy(how = How.ID, using ="ctl00_ContentPlaceHolder1_ddlPaymentType")
	public static WebElement Payment_Mode;
	
	
	@FindBy(how = How.ID, using ="btnSaveAllocaion")
	public static WebElement SubmitClick;
	
	@FindBy(how = How.ID, using ="txtVehicleSearch")
	public static WebElement Search_Vehicle;
	
	
	@FindBy(how = How.XPATH, using ="//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")
	public static WebElement KeysTAB1;
	
	@FindBy(how = How.ID, using ="txtDriverSearch")
	public static WebElement Driver_Name;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"txtDriverSearch\"]")
	public static WebElement KeysTAB2;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"ddlAllocationType\"]")
	public static WebElement Allocation_Type;
	
	@FindBy(how = How.ID, using ="btnSavelAllocation")
	public static WebElement Submit1;
	
	@FindBy(how = How.ID, using ="Vendor")
	public static WebElement VendorRadioClick;	
	
	@FindBy(how = How.CLASS_NAME, using = "ui-menu-item")
	public static List<WebElement> Search_veh;

	@FindBy(how = How.ID, using ="txtDriverMobNo")
	public static WebElement Driver_Contact;
	
	@FindBy(how = How.CLASS_NAME, using = "ui-corner-all")
	public static List<WebElement> Search_driver;
	
	@FindBy(how = How.XPATH, using ="/html/body/div[4]/div[3]/div/button[1]")
	public static WebElement Final_Submit;
	
	@FindBy(how = How.XPATH, using ="/html/body/div[5]/div[3]/div/button[1]")
	public static WebElement NewVehicleSubmit;
	
}
