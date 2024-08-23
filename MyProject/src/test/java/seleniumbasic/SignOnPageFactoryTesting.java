package seleniumbasic;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageclass.SignOnPageFactory;
import pageclass.SignOnPagePOM;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class SignOnPageFactoryTesting {
	
	
  WebDriver driver;
 SignOnPageFactory signOnPage;
  @Test
 public void VerifyApplicationHomePageISDisplayed() throws InterruptedException {
	  
	  signOnPage=new SignOnPageFactory(driver);
	  signOnPage.enterUserName("mercury");
	  signOnPage.enterPassword("mercury");
	  signOnPage.clickOnSignOn();
	  
	  Thread.sleep(5000);
	  
	  boolean expectedTitle=driver.findElement(By.xpath("//h3[contains(.,'Login Successfully')]")).isDisplayed();
	  Assert.assertTrue(expectedTitle);
  }
  @BeforeMethod
  public void OpenApplication() {
	  
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();	  
	  driver.get("https://demo.guru99.com/test/newtours/");
	  driver.manage().window().maximize();
	  
  }

  @AfterMethod
  public void CloseApplication() throws IOException {
	  ScreenShotUtility.takeScreenShot(driver);
	  driver.close();
  }
}
