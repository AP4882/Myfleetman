import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ConstantUtil.Constant;
import SignInModule.LoginAction;

public class TestPrograms2 {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

	  System.setProperty(Constant.Chrome_Property,Constant.Set_Property);
	  	
	    driver = new ChromeDriver();

	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    // Launch the Online Store Website using Constant Variable

	    
	     
	    driver.manage().window().maximize();
	    
	 
	    driver.get(Constant.URL);
	    
	       
	      driver.manage().window().maximize();
	      LoginAction.Execute(driver, Constant.Username, Constant.Password);
	      Thread.sleep(4000);
	      
	      LoginAction.PostLogin(driver);
	      
	      
	      
	      //WebElement UploadFile = driver.findElement(By.id("fileBookingModeEmail"));
	      
	      //UploadFile.sendKeys("C:\\Users\\Ashish\\Desktop\\B2C_Booking-issues-10-Dec-19\\2.png");
	
	
}
}
