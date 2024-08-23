package seleniumbasic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SampleAnnotation {
  @Test
  public void mainMethod() {
	  System.out.println("Method Test : Execute the main test method");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method : Launch the browser and setup the cookies");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method : Close the browser and Clean the cookies");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class: Load the class Level Test data");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class: Clean and Close the Class Level Test data");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test: Initailize the DB");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test: Close the DB");
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  System.out.println("Before suite : create the folders");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After suite : Close the folders");
  }

}
