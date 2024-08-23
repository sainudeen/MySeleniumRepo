package pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class HomePage {
	
	WebDriver driver;
	
	By home_Page= By.tagName("h3");
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public String getHomePageSuccessfullMessage() {
		String actual = null;
		try {
			actual = driver .findElement(home_Page).getText();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return actual;
	}

}
