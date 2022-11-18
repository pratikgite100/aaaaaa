

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import setUp.BaseTest;

public class DataUtil extends BaseTest{
	
	@DataProvider(name="data", parallel=true)
	public static Object[][] getData(Method m) {

		
		//int rows = excel.getRowCount(config.getProperty("testDataSheetName"));
		int rows = excel.getRowCount("test1");
		System.out.println("Total rows are : " + rows);

		String testName = m.getName();
		System.out.println("Test name is : "+testName);

		// Find the test case start row

		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {

			String testCaseName = excel.getCellData("test1", 0, testCaseRowNum);

			if (testCaseName.equalsIgnoreCase(testName))
				break;

		}

		System.out.println("Test case starts from row num: " + testCaseRowNum);

		// Checking total rows in test case
         //need here testCaseRowNum+2
		int dataStartRowNum = testCaseRowNum+2;

		int testRows = 0;
		while (!excel.getCellData("test1", 0, dataStartRowNum + testRows).equals("")) {

			testRows++;
		}

		System.out.println("Total rows of data are : " + testRows);

		// Checking total cols in test case

		int colStartColNum = testCaseRowNum + 1;
		int testCols = 0;

		while (!excel.getCellData("test1", testCols, colStartColNum).equals("")) {

			testCols++;

		}

		System.out.println("Total cols are : " + testCols);

		// Printing data

		Object[][] data = new Object[testRows][1];

		int i = 0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {

			Hashtable<String, String> table = new Hashtable<String, String>();

			for (int cNum = 0; cNum < testCols; cNum++) {

				// System.out.println(excel.getCellData(config.getProperty("testDataSheetName"),
				// cNum, rNum));
				String testData = excel.getCellData("test1", cNum, rNum);
				String colName = excel.getCellData("test1", cNum, colStartColNum);

				table.put(colName, testData);

			}

			data[i][0] = table;
			i++;

		}

		return data;
	}

	
	

}
