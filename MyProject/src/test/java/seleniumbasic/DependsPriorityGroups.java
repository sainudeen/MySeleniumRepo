package seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DependsPriorityGroups {
	WebDriver driver;
	DependsPriorityGroups(){
		 WebDriverManager.edgedriver().setup();
		  this.driver=new EdgeDriver();
	}
	
	/* @Test(priority=-5,groups = { "demo" }) */
	@Test(priority=-5)
  public void Launch() throws Exception {
	  driver.get("https://phptravels.com/demo");
	  driver.manage().window().maximize();
  }
  
  
  @Test(priority=2,groups = { "Smoke" },dependsOnMethods = { "Launch" })
  public void EnterUserName() throws InterruptedException {
	  WebElement userName=driver.findElement(By.xpath("//input[@name='first_name']"));
	  userName.sendKeys("sainu");	
	  Thread.sleep(5000);
  }
  
  
  @Test(priority=-4,groups = { "demo" },dependsOnMethods = { "EnterUserName" })
  public void EnterPassword() {
	  WebElement lastName=driver.findElement(By.name("last_name"));
	  lastName.sendKeys("aabid");
	  System.out.println("LastName");
  }
  
  
  @Test(priority=-3,groups = { "demo" },dependsOnMethods = { "EnterUserName" ,"EnterPassword"},enabled=false)
  public void EnterBussiness() {
	  WebElement bussinessName=driver.findElement(By.name("business_name"));
	  bussinessName.sendKeys("Hotel"); 
	  System.out.println("Bussinessname");
  }
}
