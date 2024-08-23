package seleniumbasic;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DataDrivenTesting {
	WebDriver driver;
	WebElement firstName;
	WebElement LastName;
	WebElement business;


	@BeforeMethod
	public void OpenApp() {

		//driver initialization and launch the browser
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://phptravels.com/demo");
	}
	@DataProvider(name="readExcel")
	public static Object[][] readExcelvalues() throws IOException{
		Object[][] datavalues=ReadExcelFile.readExcel("TestData.xlsx", "First");
		return datavalues;
	}
	

	@Test(dataProvider = "readExcel")
	public void validateDataDrivenTestingExcel(String fname,String lname,String bussinessName) {

		firstName=driver.findElement(By.name("first_name"));
		//actions	 
		firstName.sendKeys(fname);	

		LastName=driver.findElement(By.name("last_name"));
		LastName.sendKeys(lname);

		business=driver.findElement(By.name("business_name"));
		business.sendKeys(bussinessName);  


	}


	@AfterMethod
	public void closeBrowser(ITestResult result)throws IOException {

		if(ITestResult.FAILURE==result.getStatus()){
			System.out.println("TestExecution Status======="+ result.getStatus());
			System.out.println("Name------------- : "+result.getName());
			ScreenShotUtility.takeScreenShot(driver);
		}

		if(ITestResult.SUCCESS==result.getStatus()){
			System.out.println("TestExecution Status======="+ result.getStatus());
			System.out.println("Name------------- : "+result.getName());
			ScreenShotUtility.takeScreenShot(driver);
		}

		if(ITestResult.SKIP==result.getStatus()){
			System.out.println("TestExecution Status======="+ result.getStatus());
			System.out.println("Name------------- : "+result.getName());
			ScreenShotUtility.takeScreenShot(driver);
		}
		
		driver.close();
	}

}




