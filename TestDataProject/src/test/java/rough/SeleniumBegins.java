package rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBegins {
	
	
	public static void validateSubTotal() throws IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\xpaths.properties");
		Properties prop = new Properties();
		prop.load(file);
		
		Map<String,String> rowTestDataMap = GetRunMode.readexcelData();
		System.out.println("");
		
		for(Entry<String, String> entry:rowTestDataMap.entrySet()) {
			      Float sum=0f;
   			      if(entry.getValue().equals("Y")) {
			    	  System.out.println("");
					  System.out.println("");
					  System.out.println("testcase and its runmode");  
					  System.out.println("____________________"+entry.getKey()+"======="+entry.getValue()+"______________________________");
					  System.out.println("");
					  System.out.println("");
					
					  Map<String,HashMap<String, String>> eachRowDataMap = ReadingExcelData.readexcelData(entry.getKey());
					
					  WebDriverManager.chromedriver().setup();
					
					  ChromeDriver driver = new ChromeDriver();
					  driver.get("https://petstore.octoperf.com/actions/Catalog.action");
					
					  driver.manage().window().maximize();
					  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					
					  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
					
					  int i=1;
					  for(Entry<String, HashMap<String, String>> entry1:eachRowDataMap.entrySet()) {
						  System.out.println("_______________________________________________________________");
						  System.out.println("loop of "+i+" row of master excel file for manupulation");
						  System.out.println("key of row "+i+" "+entry1.getKey()+"  Value of row "+i+" "+entry1.getValue());
						  System.out.println("");
						  i++;
						
						  String productNumber = ""+(int)(Double.parseDouble(entry1.getValue().get("No")));
						  String price =entry1.getValue().get("Price")+"0";
						  int quantity;
						  
						  String icon_xpath = prop.getProperty("Icon_xpath").replace("${No}", productNumber);
						  String productLink_xpath = prop.getProperty("ProductLink_xpath").replace("${ProductId}", entry1.getValue().get("ProductId"));
						  String addToCartBtn_xpath = (prop.getProperty("AddToCartBtn_xpath").replace("${ProductId}", entry1.getValue().get("ProductId")).replace("${ItemId}", entry1.getValue().get("ItemId")));
						  String listPrice_xpath = (prop.getProperty("ListPrice_xpath").replace("${ProductId}", entry1.getValue().get("ProductId")).replace("${Price}", price));
						  String productQuantity_xpath = prop.getProperty("ProductQuantity_xpath").replace("${ProductId}", entry1.getValue().get("ProductId"));
						
						  
						  driver.findElement(By.xpath(icon_xpath)).click();
						  driver.findElement(By.xpath(productLink_xpath)).click();
						  driver.findElement(By.xpath(addToCartBtn_xpath)).click();
					 	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(listPrice_xpath)));
						  WebElement e = driver.findElement(By.xpath(listPrice_xpath));
						  quantity = Integer.parseInt(driver.findElement(By.xpath(productQuantity_xpath)).getAttribute("value"));
					      sum = sum + Float.parseFloat(e.getText().substring(1))*quantity;
						 
					  }
					  
						  
					
					 Float expectedSubtotal = 305.50f;
					 System.out.print("Expected Subtotal is 305.50 and actual is ");
					 System.out.printf("%.2f",sum);
					 
					 if(Float.compare(expectedSubtotal, sum)==0) {
					 	 System.out.println("");
					 	 System.out.println("TestCase Pass: Subtotal validation is successfull");
					 }
					 
					 
						
	              }       
		 
	    System.out.println("");
		System.out.println("");
	    }
		System.out.println("success");
		
		
	}
	
	
    
	public static void main(String[] args) throws IOException {
		
		
		
			
		
   	}
	
}
		
	



	


