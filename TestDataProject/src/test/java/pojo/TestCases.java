package pojo;

import java.util.List;

public class TestCases {
	private String TestCases;
	private String RunMode;
	
	private List arrr;
	
	
	

	public TestCases(String testCases, String runMode, List arrr) {
		super();
		TestCases = testCases;
		RunMode = runMode;
		this.arrr = arrr;
	}

	public String getTestCases() {
		return TestCases;
	}

	public void setTestCases(String testCases) {
		TestCases = testCases;
	}

	public String getRunMode() {
		return RunMode;
	}

	public void setRunMode(String runMode) {
		RunMode = runMode;
	}

	public  List getArrr() {
		return arrr;
	}

	public void setArrr(List arrr) {
		this.arrr = arrr;
	}

}
