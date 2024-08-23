package pageclass;

import org.eclipse.jetty.http.HttpGenerator.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import definitions.Hooks;

public class SignOnPagePOM {
	
	WebDriver driver;
	
	
	By userName= By.name("userName");
	By userPassword= By.name("password");
	By btn_Login= By.name("submit");
	
	
	public SignOnPagePOM(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void enterUserName(String username) {
		try {
			driver.findElement(userName).sendKeys(username);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterPassword(String password) {
		try {
			driver.findElement(userPassword).sendKeys(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickOnSignOn() {
		try {
			driver.findElement(btn_Login).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
