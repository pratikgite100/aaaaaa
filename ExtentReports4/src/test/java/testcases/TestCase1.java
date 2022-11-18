package testcases;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.reporter.ExtentReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestCase1 {
	
	public ExtentReporter reporter;
	public ExtentReports reports;
	public ExtentTest test;
	
	
	@BeforeTest
	public void setReport(){
		//reporter= new ExtentReporter("./reports.extent.html");
		
		
	}

}
