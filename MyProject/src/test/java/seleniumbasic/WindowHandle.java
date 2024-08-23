package seleniumbasic;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
  @Test
  public void WindowhandleSample() throws InterruptedException {
	  
	  WebDriverManager.edgedriver().setup();
	  WebDriver driver=new EdgeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demoqa.com/browser-windows");
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  String windowTitle=driver.getTitle();
	  String parentwindowHandle=driver.getWindowHandle();
	  
	  WebElement w=driver.findElement(By.id("messageWindowButton"));
	  
	  System.out.println("Main window Title: "+windowTitle);
	  JavascriptExecutor js=  ((JavascriptExecutor)driver);
	  js.executeScript("arguments[0].scrollIntoView(true);", w);
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", w);
	  Thread.sleep(500); 
	  w.click();
	  
	  Set<String> windowHandles = driver.getWindowHandles();
	  
	  for (String sub : windowHandles) {
		  if(!sub.equals(parentwindowHandle)) {
			  driver.switchTo().window(sub);
			  System.out.println("Child window title: "+driver.getTitle());			  
			  break;
		  }
		
	}
	  
  }
}
