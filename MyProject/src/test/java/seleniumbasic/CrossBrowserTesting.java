package seleniumbasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting {
  
	WebDriver driver; 
	@BeforeTest
	@Parameters("BrowserType")
	public void VerifyCrossbrowserTesting(String browser) {
		if(browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			  driver=new EdgeDriver();
			  driver.manage().window().maximize();
		}else if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			   ChromeOptions options=new ChromeOptions();
			   options.addArguments("start-maximized");
			  driver=new ChromeDriver();
			  driver.manage().window().maximize();
		}
	}
	
	

  @Test
  public void Launch() {
	  
	  driver.get("https://phptravels.com/demo");
  }
  
  @AfterMethod
  public void Kill() {
	  driver.close();
  }
  
  
}
