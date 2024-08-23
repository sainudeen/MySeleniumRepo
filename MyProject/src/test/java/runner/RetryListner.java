package runner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListner implements IRetryAnalyzer {
	private int retryCount=0;
	private int maxretryCount=2;
	
	
	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
		if(retryCount<maxretryCount) {
			System.out.println("Trying to execute method "+ result.getName()+ "  again and count is "+ (retryCount+1));
			retryCount++;
			return true;
		}
		
		}
		
		
		// TODO Auto-generated method stub
		return false;
	}

}
