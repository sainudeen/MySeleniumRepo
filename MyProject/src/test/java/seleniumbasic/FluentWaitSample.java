package seleniumbasic;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitSample {

	WebDriver driver;
	
  @Test
  public void FluentWaitTestSample() {
	  
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  
	  driver.get("https://demo.guru99.com/test/newtours/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  WebDriverWait wbwait=new WebDriverWait(driver,30);
	  wbwait.until(ExpectedConditions.titleContains(driver.getTitle()));
	  
	  
	  
	  Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
			  .withTimeout(20, TimeUnit.SECONDS)
			  .pollingEvery(5, TimeUnit.SECONDS)
			  .ignoring(NoSuchElementException.class)
			  .withMessage("Expected Element is not dispolayed ");
	  
	  
	  
	  WebElement user=wait.until((new Function<WebDriver,WebElement>(){
		  public WebElement apply(WebDriver driver) {
			  return driver.findElement(By.name("userName"));
		  }
	  }
	  
	  
			  
			  ));
	  
	  
	  user.sendKeys("mercury");
	  
	  WebElement txt_Password=driver.findElement(By.name("password"));
	  txt_Password.sendKeys("mercury");
	  
	  WebElement btn_Login=driver.findElement(By.name("submit"));
	  btn_Login.click();
	  
	  
	  WebElement lbl_HomeTitle=driver.findElement(By.tagName("h3"));
		String actual = lbl_HomeTitle.getText();
		String expected="Login Successfully";
		
		assertEquals(actual, expected, actual+" is not matching with expected : "+expected);
	    Reporter.log("Passed");
	    
	    driver.close();
	  
  }
}
