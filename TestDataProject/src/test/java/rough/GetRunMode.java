package rough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import utilities.Constants;
import utilities.ExcelReader;

public class GetRunMode {
	
		
		
		public static HashMap<String, String> readexcelData() {
		
		ExcelReader excel = new ExcelReader("C:\\Users\\141572\\eclipse-workspace\\RestAssured\\TestDataProject\\src\\test\\resources\\testdata\\TestSuiteData4.xlsx");
	    
		int rows = excel.getRowCount(Constants.DATA_SHEET_FOR_TESTCASES);
		//System.out.println("Total Rows are: "+rows);
		
		
		String testName = "testcases";
		
		int testCaseRowNum =1;
		
		for(testCaseRowNum=1; testCaseRowNum <= rows; testCaseRowNum++) {
			
			String testCaseName = excel.getCellData(Constants.DATA_SHEET_FOR_TESTCASES, 0, testCaseRowNum);
			
			if(testCaseName.equalsIgnoreCase(testName)) {
				break;
			}
		}
			//System.out.println("test case starts from row numbe: "+testCaseRowNum);
			
			int dataStartRowNum = testCaseRowNum+2;
			
			int testRows = 0;
			
			while(!excel.getCellData(Constants.DATA_SHEET_FOR_TESTCASES, 0, dataStartRowNum+testRows).equals("")) {
				
				testRows++;
			}
			
			//System.out.println("Total rows of data are: "+testRows);
			
			
			int colStartColNum = testCaseRowNum+1;
			int testCols = 0;
			
			while(!excel.getCellData(Constants.DATA_SHEET_FOR_TESTCASES, 0, colStartColNum+testCols).equals("")) {
				
				testCols++;
			}
			
			//System.out.println("Total colums of data are: "+testCols);
			
			Hashtable<String, String> table = new Hashtable<String, String>();
			
			ArrayList<String> a=new ArrayList<String>();
			 HashMap<String, String> data =new HashMap<String, String>();
			//Object[][]data= new Object[rows][1];
			int i=0;
		    
			for(int rNum=dataStartRowNum; rNum<(dataStartRowNum+testRows); rNum++) {
				
				for(int cNum=0;cNum<testCols; cNum++) {
					
					//System.out.println(excel.getCellData(Constants.DATA_SHEET_FOR_TESTCASES, cNum, rNum));
					
					
					String testData = excel.getCellData(Constants.DATA_SHEET_FOR_TESTCASES, cNum, rNum);
					String colName = excel.getCellData(Constants.DATA_SHEET_FOR_TESTCASES, cNum, colStartColNum);
					String testCaseName = excel.getCellData(Constants.DATA_SHEET_FOR_TESTCASES, 0, rNum);

					if(testData.equals("Y")) {
						//System.out.println("############################################");
						//System.out.println(testCaseName);
						a.add(testCaseName);
					}
					
					table.put(colName, testData);
				}
				
				//data[i][0]=table;
				data.put(table.get("TestCases"),table.get("Runmode"));
				i++;
			}
			
			
			//Assert.assertEquals(table.get("username"), "amit@gmail.com");
			//System.out.println(table);
			
			return data;
			
	
	}
	
	
}
