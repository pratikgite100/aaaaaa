package rough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import utilities.ExcelReader;

public class ReadingExcelData {
	
		
		@Test
		public static HashMap<String, HashMap<String, String>> readexcelData(String name) {
		
		ExcelReader excel = new ExcelReader("C:\\Users\\141572\\eclipse-workspace\\RestAssured\\TestDataProject\\src\\test\\resources\\testdata\\TestSuiteData4.xlsx");
	    
		int rows = excel.getRowCount(name);
		//System.out.println("Total Rows are: "+rows);
		
		
		String testName = name;
		
		int testCaseRowNum =1;
		
		for(testCaseRowNum=1; testCaseRowNum <= rows; testCaseRowNum++) {
			
			String testCaseName = excel.getCellData(name, 0, testCaseRowNum);
			
			if(testCaseName.equalsIgnoreCase(testName)) {
				break;
			}
		}
			//System.out.println("test case starts from row numbe: "+testCaseRowNum);
			
			int dataStartRowNum = testCaseRowNum+2;
			
			int testRows = 0;
			
			while(!excel.getCellData(name, 0, dataStartRowNum+testRows).equals("")) {
				
				testRows++;
			}
			
			//System.out.println("Total rows of data are: "+testRows);
			
			
			int colStartColNum = testCaseRowNum+1;
			int testCols = 0;
			
			while(!excel.getCellData(name, 0, colStartColNum+testCols).equals("")) {
				
				testCols++;
			}
			
			//System.out.println("Total colums of data are: "+testCols);
			
			HashMap<String, String> table;
			ArrayList<String> a=new ArrayList<String>();
			HashMap<String, HashMap<String, String>> data = new HashMap<String,HashMap<String, String>>();
			
			int i=0;
		    int j=1;
			for(int rNum=dataStartRowNum; rNum<(dataStartRowNum+testRows); rNum++) {
				table = new HashMap<String, String>();
				for(int cNum=0;cNum<testCols; cNum++) {
					//System.out.print(excel.getCellData(name, cNum, rNum)+"----");
					
					String testData = excel.getCellData(name, cNum, rNum);
					String colName = excel.getCellData(name, cNum, colStartColNum);
					
					table.put(colName, testData);
					
					if(colName.equals("Category") || colName.equals("id") || colName.equals("customer") || colName.equals("username") ) 
					   a.add(testData);
				}
				
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				System.out.println("Array List : " + a);
                data.put(a.get(i),table);
				
				System.out.println("table hashmap:  "+table);
				System.out.println("data HashMap:  "+data);
				i++;
			}
			
			System.out.println("");
			System.out.println("");
			System.out.println("+++++++++++++++++++++++++Final hashmaps++++++++++++++++++++++++++++++++++");
			
			System.out.println(data);
			System.out.println("");
			System.out.println("");
			
			return data;
			
	
	}
	public static void main(String[] args) {
		
		
		
	}
	
}
