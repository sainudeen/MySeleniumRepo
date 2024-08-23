package seleniumbasic;

import java.util.concurrent.TimeUnit;

import org.bouncycastle.jce.provider.BrokenJCEBlockCipher.BrokePBEWithSHA1AndDES;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertClass {
  @Test
  public void AlertSample() {
	  
	  WebDriverManager.edgedriver().setup();
	  WebDriver driver=new EdgeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demo.automationtesting.in/Alerts.html");
	  
	  WebElement findElement = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
	  findElement.click();
	  Alert al=driver.switchTo().alert();
	  al.accept();
	  
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	 	  
  }
}
