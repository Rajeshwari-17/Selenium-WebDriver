package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import base.BaseTest;

public class SuiteListner implements ITestResult, IAnnotationTransformer{
	
	public void onTestFailure(ITestResult result)
	{
		String filename = System.getProperty("user.dir") + File.separator + "screenshot" + File.separator + result.getMethod().getMethodName();
		File fis = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(fis, new File(filename + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod){
		
		annotation.getRetryAnalyzerClass();
		
	}
	@Override
	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setAttribute(String name, Object value) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Set<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object removeAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int compareTo(ITestResult o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setStatus(int status) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ITestNGMethod getMethod() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] getParameters() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setParameters(Object[] parameters) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public IClass getTestClass() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Throwable getThrowable() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setThrowable(Throwable throwable) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public long getStartMillis() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public long getEndMillis() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setEndMillis(long millis) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isSuccess() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] getFactoryParameters() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getTestName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getInstanceName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ITestContext getTestContext() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setTestName(String name) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean wasRetried() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setWasRetried(boolean wasRetried) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String id() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
