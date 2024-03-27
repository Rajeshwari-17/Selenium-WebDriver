package CommonUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int count =0;
	int retrycount =1;
	
	
	@Override
	public boolean retry(ITestResult result) {
		while(count<retrycount)
		{
			count++;
			return true;
		}
		
		// TODO Auto-generated method stub
		return false;
	}

}
