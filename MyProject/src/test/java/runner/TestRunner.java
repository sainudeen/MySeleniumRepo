package runner;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import seleniumbasic.RetryFailedTestCase;





//@CucumberOptions(tags = "@DataProvider1",features = {"src/test/resources/features"}, glue = {"definitions"},
//plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//,dryRun = false,monochrome=true)

@CucumberOptions(
		dryRun = false,
		monochrome = true,
		features = {"src/test/resources/features/ParameterWithoutKeyword.feature"},
		plugin = { "pretty"},
		glue = {"definitions"}
		)


public class TestRunner extends AbstractTestNGCucumberTests {
@Override
@DataProvider(parallel=false)
public Object[][] scenarios(){
	return super.scenarios();
}
	
}
