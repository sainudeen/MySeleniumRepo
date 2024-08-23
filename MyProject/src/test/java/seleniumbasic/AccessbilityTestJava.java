package seleniumbasic;

import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.deque.axe.AXE;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccessbilityTestJava {
	
	WebDriver driver;
	
	private static final URL scriptUrl=AccessbilityTestJava.class.getResource("/axe.min.js");
	@BeforeMethod
	public void setup() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get("https://phptravels.com/demo");
		
		
	}
	@Test
	public void test() {
		
	JSONObject responseJson=new AXE.Builder(driver, scriptUrl).analyze();
	JSONArray vialoationArray = responseJson.getJSONArray("violations");
	if(vialoationArray.length()==0) {
		System.out.println("no error");
	}
	else {
		AXE.writeResults("tour", responseJson);
		Assert.assertTrue(false,AXE.report(vialoationArray));
	}
	}
	@AfterMethod
	public void kill() {
		System.out.println("close");
	
		
	}
	
	
}
