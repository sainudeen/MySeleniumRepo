package definitions;


import io.cucumber.java.After;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class Hooks{
	
	
//@AfterStep
//public void AfterStep() {
//	System.out.println("AfterStep Tag in Cucumber");
//}
//
//@BeforeStep
//public void BeforeStep() {
//	System.out.println("Before Step Tag in Cucumber");
//}
	
@Before(order=-1)
public void setup(Scenario scenario) {
//	System.out.println(scenario.getName());
//	System.out.println(scenario.getStatus());
//	System.out.println("Execution Started with SetUp");
	System.out.println("Before Tag in Cucumber");
	
	
	
}

@Before(order=2)
public void Aetup(Scenario scenario) {
//	System.out.println(scenario.getName());
//	System.out.println(scenario.getStatus());
//	System.out.println("Execution Started with SetUp");
	System.out.println("Before Tag in Cucumber");
	
}

@After
public void teardown() {
	
	System.out.println("After Tag in Cucumber");
	
}

@After
public void teardown1() {
	System.out.println("After Tag in Cucumber");
	
}







}
