package pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOnPageFactory {
	
	@FindBy(name="userName")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement userPassword;
	
	@FindBy(name="submit")
	WebElement btn_Login;
	
	@FindBy(xpath="\\input[@value=''")
	WebElement txt_Input;
	
	WebDriver driver;
	
	public SignOnPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String username) {
		userName.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		userPassword.sendKeys(password);
	}
	
	public void clickOnSignOn() {
		btn_Login.click();
	}
	
	


}
