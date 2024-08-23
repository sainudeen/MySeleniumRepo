package seleniumbasic;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigPropertiesSample {
  @Test
  public void propertSampleMethod() {
	  
	  WebDriverManager.edgedriver().setup();
	  WebDriver driver=new EdgeDriver();
	  driver.manage().window().maximize();
	  try {
		driver.get(ConfigProp.readProperties("URL"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
}
