package definitions;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import managers.PageObjectManager;
import pageclass.HomePage;
import pageclass.SignOnPagePOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.datatable.*;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class sampledefinition {

	WebDriver driver;
	HomePage homePage;
	SignOnPagePOM signOnPagePOM;
	PageObjectManager pageObjectManager;
	
	static ExtentTest test;
	static ExtentReports report;

	public ScenarioContext scenarioContext;

	public sampledefinition(ScenarioContext context) {

		
		scenarioContext = new ScenarioContext();
		scenarioContext=context;
	}

	@Given("Open test data")
	public void open_test_data() {
		// Write code here that turns the phrase above into concrete actions
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://phptravels.com/demo");
	}

	@Given("Launch the Application")
	public void launch_the_application() {

		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();		  
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();

	}



	//	"Without Page Object Manager /POM design"
	//	@When("Enter the UserName")
	//	public void enter_the_user_name() {
	//		 WebElement txt_UserName=driver.findElement(By.name("userName"));
	//		  txt_UserName.sendKeys("mercury");
	//	}
	//
	//	@And("Enter the Password")
	//	public void enter_the_password() {
	//		WebElement txt_Password=driver.findElement(By.name("password"));
	//		  txt_Password.sendKeys("mercury");
	//	}
	//	
	//	@And("Click on SignOn")
	//	public void clickOnSign() {
	//		WebElement btn_Login=driver.findElement(By.name("submit"));
	//		String expected="Login Successfully";
	//		scenarioContext.setContext(Context.ExpectedValidation, expected);
	//		
	//		  btn_Login.click();
	//	}
	//
	//	@Then("Verify the Home Page")
	//	public void verify_the_home_page() {
	//		WebElement lbl_HomeTitle=driver.findElement(By.tagName("h3"));
	//		String actual = lbl_HomeTitle.getText();				
	//		assertEquals(actual, scenarioContext.getContext(Context.ExpectedValidation), actual+" is not matching with expected : "+scenarioContext.getContext(Context.ExpectedValidation));
	//		
	//		driver.close();
	//		
	//	    
	//	}
	//	
	//	@When("^Enter the \"(.*)\" as UserName")
	//	public void enter_the_user_name(String user) {
	//		 WebElement txt_UserName=driver.findElement(By.name("userName"));
	//		  txt_UserName.sendKeys(user);
	//	}
	//
	//	@And("^Enter the \"(.*)\" as Password")
	//	public void enter_the_password(String password) {
	//		WebElement txt_Password=driver.findElement(By.name("password"));
	//		  txt_Password.sendKeys(password);
	//	}
	//	
	//	
	//	
	//	
	//	  @When("^Enter the UserCredentials from dttable$") public void
	//	  enter_the_UserName_password(DataTable usercredentials)throws Throwable {
	//		  
	//	List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
	//	  
	//	  WebElement txt_UserName=driver.findElement(By.name("userName"));
	//	  txt_UserName.sendKeys(data.get(0).get("username"));
	//	  
	//	  WebElement txt_Password=driver.findElement(By.name("password"));
	//	  txt_Password.sendKeys(data.get(0).get("password")); 
	//	  
	//	  }


	
	@When("Enter the UserName")
	public void enter_the_user_name() {
		pageObjectManager = new PageObjectManager(driver);
		signOnPagePOM=pageObjectManager.getSignOnPagePOM();
		signOnPagePOM.enterUserName("mercury");
	}

	@And("Enter the Password")
	public void enter_the_password() {
		signOnPagePOM.enterPassword("mercury");
	}

	@And("Click on SignOn")
	public void clickOnSign() {
		String expected="Login Successfully";
		scenarioContext.setContext(Context.ExpectedValidation, expected);
		signOnPagePOM.clickOnSignOn();
	}

	@Then("Verify the Home Page")
	public void verify_the_home_page() {
		homePage=pageObjectManager.getHomePage();
		String actual=homePage.getHomePageSuccessfullMessage();		
		try {
			assertEquals(actual, scenarioContext.getContext(Context.ExpectedValidation), actual+" is not matching with expected : "+scenarioContext.getContext(Context.ExpectedValidation));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		finally {
			driver.close();
		}
		
		
		

	}

//	@When("^Enter the \"(.*)\" as UserName")
//	public void enter_the_user_name(String user) {
//		pageObjectManager = new PageObjectManager(driver);
//		signOnPagePOM=pageObjectManager.getSignOnPagePOM();
//		signOnPagePOM.enterUserName(user);
//	}
//
//	@And("^Enter the \"(.*)\" as Password")
//	public void enter_the_password(String password) {
//		signOnPagePOM.enterPassword(password);
//	}
	
	@When("Enter the {string} as UserName")
	public void enter_the_as_user_name(String string) {
		pageObjectManager = new PageObjectManager(driver);
		signOnPagePOM=pageObjectManager.getSignOnPagePOM();
		signOnPagePOM.enterUserName(string);
	}
	
	@When("Enter the {string} as Password")
	public void enter_the_as_user_Password(String string) {
		pageObjectManager = new PageObjectManager(driver);
		signOnPagePOM=pageObjectManager.getSignOnPagePOM();
		signOnPagePOM.enterPassword(string);
	}






	@When("^Enter the UserCredentials from dttable$") public void
	enter_the_UserName_password(DataTable usercredentials)throws Throwable {

		List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
		pageObjectManager = new PageObjectManager(driver);
		signOnPagePOM=pageObjectManager.getSignOnPagePOM();
		signOnPagePOM.enterUserName(data.get(0).get("username"));
		signOnPagePOM.enterPassword(data.get(0).get("password"));
	}


	@Given("Execute BackGround")
	public void execute_BackGround() {
		System.out.println("Execute the background");
	}




}
