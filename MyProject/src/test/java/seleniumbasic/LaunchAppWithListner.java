package seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchAppWithListner {
  @Test(retryAnalyzer = RetryFailedTestCase.class)
  public void ListnerSample() {
	  WebDriverManager.edgedriver().setup();
	  WebDriver driver=new EdgeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://phptravels.com/demo");
	  
	  //locators
	  WebElement userName=driver.findElement(By.name("first_name"));
	  //actions	 
	  userName.sendKeys("sainu");	
	  
	  WebElement lastName=driver.findElement(By.name("last_name"));
	  lastName.sendKeys("aabid");
	  
	  WebElement bussinessName=driver.findElement(By.name("business_name"));
	  bussinessName.sendKeys("Hotel");  
	  
	  driver.close();
	 
  }
}
