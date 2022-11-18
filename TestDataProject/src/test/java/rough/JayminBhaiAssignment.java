package rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class JayminBhaiAssignment {
	
	Float sum=0.0f;
	ChromeDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	@BeforeTest
	public void bef() throws IOException {
		WebDriverManager.chromedriver().setup();
		
		  
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@Test(dataProvider = "empdataprovider1")
	public void postNewEmployeeAndValidateResp(String No, String Category, String ItemId, String ProductId, String Name, String Price, String Description) throws IOException, NullPointerException  {
		
		String sheetName="PetStoreData";
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\xpaths.properties");
		Properties prop = new Properties();
		prop.load(file);
		
	   String productNumber = ""+(int)(Double.parseDouble(No));
  	   String price =Price+"0";
	   int quantity;
	     
	   String icon_xpath = prop.getProperty("Icon_xpath").replace("${No}", productNumber);
	   String productLink_xpath = prop.getProperty("ProductLink_xpath").replace("${ProductId}", ProductId);
 	   String addToCartBtn_xpath = (prop.getProperty("AddToCartBtn_xpath").replace("${ProductId}", ProductId).replace("${ItemId}", ItemId));
	   String listPrice_xpath = (prop.getProperty("ListPrice_xpath").replace("${ProductId}", ProductId).replace("${Price}", price));
	   String productQuantity_xpath = prop.getProperty("ProductQuantity_xpath").replace("${ProductId}", ProductId);
		
	   driver.findElement(By.xpath(icon_xpath)).click();
	   driver.findElement(By.xpath(productLink_xpath)).click();
	   driver.findElement(By.xpath(addToCartBtn_xpath)).click();
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(listPrice_xpath)));
	   WebElement e = driver.findElement(By.xpath(listPrice_xpath));
	   quantity = Integer.parseInt(driver.findElement(By.xpath(productQuantity_xpath)).getAttribute("value"));
	   sum = sum + Float.parseFloat(e.getText().substring(1))*quantity;
	   
	  System.out.println("Sum is: "+sum);
	   
	}
	
	
	public void aff() {
		System.out.println("Sum is: "+sum+"0");
	}
	
	
	
	@DataProvider(name = "empdataprovider1")
	String[][] getEmpData() throws NullPointerException{ 
		
       //String empdata[][] = {{"abc123","30000","40"},{"xyz123","40000","30"},{"pqr123", "80000", "50"}};
		
	   ExcelReader excel = new ExcelReader("C:\\Users\\141572\\eclipse-workspace\\RestAssured\\TestDataProject\\src\\test\\resources\\testdata\\TestSuiteData4.xlsx");
		
	   int rownum = excel.getRowCount("PetStoreData");
	   int colcount = excel.getColumnCount("PetStoreData");
		
	   //System.out.println("*******************"+rownum+"**********************"+colcount+"**********************************");
	   String empData[][] = new String[rownum][colcount];
		
	   for(int i=2;i<=rownum;i++) {
	     for(int j=0;j<colcount;j++) {
	    	empData[i-1][j] = excel.getCellData("PetStoreData",j,i);
				
		 }
	   }
		
	   return empData;
	}

}
