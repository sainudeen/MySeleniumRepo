package seleniumbasic;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTourTestCase {
	
	WebDriver driver;
  @Test
  public void VerifyNewTourLogin() {
	  
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  
	  driver.get("https://demo.guru99.com/test/newtours/");
	  driver.manage().window().maximize();
	  
	String lnk_Register="//a[text()='REGISTER']";
	String list_Country="//Select[@name='country']";
	
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  
	driver.findElement(By.xpath(lnk_Register)).click();
	WebElement findElement = driver.findElement(By.xpath(list_Country));
	
	Select countryList= new Select(findElement);
	
	System.out.println("First Selected :    "+countryList.getFirstSelectedOption().getText());
	List<WebElement> allSelectedOptions = countryList.getAllSelectedOptions();
	for (WebElement webElement : allSelectedOptions) {
		webElement.getAttribute("value");
	}
	List<WebElement> options = countryList.getOptions();
	
	for (WebElement webElement : options) {
		System.out.println(webElement.getAttribute("value"));
	}
	
	
	/*
	 * WebElement txt_UserName=driver.findElement(By.name("userName"));
	 * txt_UserName.sendKeys("mercury");
	 * 
	 * WebElement txt_Password=driver.findElement(By.name("password"));
	 * txt_Password.sendKeys("mercury");
	 * 
	 * WebElement btn_Login=driver.findElement(By.name("submit"));
	 * btn_Login.click();
	 * 
	 * 
	 * WebElement lbl_HomeTitle=driver.findElement(By.tagName("h3")); String actual
	 * = lbl_HomeTitle.getText(); String expected="Login Successfully";
	 * 
	 * assertEquals(actual, expected,
	 * actual+" is not matching with expected : "+expected); Reporter.log("Passed");
	 */
	    
	    driver.close();
	  
  }
}
