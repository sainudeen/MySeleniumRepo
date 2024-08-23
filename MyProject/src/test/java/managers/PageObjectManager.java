package managers;

import org.openqa.selenium.WebDriver;

import pageclass.HomePage;
import pageclass.SignOnPagePOM;

public class PageObjectManager {
	
	WebDriver driver;
	SignOnPagePOM signOnPagePOM;
	HomePage homePage;
	
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}
	
	public SignOnPagePOM getSignOnPagePOM(){

		return (signOnPagePOM == null) ? signOnPagePOM = new SignOnPagePOM(driver) : signOnPagePOM;

	}
	
	public HomePage getHomePage(){

		return (homePage == null) ? homePage = new HomePage(driver) : homePage;

	}

}
