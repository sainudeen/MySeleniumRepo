package seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiLocatorsExample {
  @Test
  public void MultiLocatorSampleMethod() {
	  
	  //driver initialization and launch the browser
	  WebDriverManager.edgedriver().setup();
	  WebDriver driver=new EdgeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://phptravels.com/demo");
	  
	  //Xpath locator
	  WebElement userName=driver.findElement(By.xpath("//input[@name='first_name']"));
	  userName.sendKeys("sainu");	
	  
	  //CSS Locator
	  WebElement lastName=driver.findElement(By.cssSelector("input[name='last_name']"));
	  lastName.sendKeys("aabid");
	  
	  
	  //Xpath contains 
	  WebElement bussinessName=driver.findElement(By.xpath("//input[contains(@name,'business')]"));
	  bussinessName.sendKeys("Hotel");  
	   
	  
	 
	  
	  

  }
}
