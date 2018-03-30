package level2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class ReadQuote {
	
	
public WebDriver driver;
	  
	  
 @BeforeClass
 public void setUp() {
		 	 
  System.setProperty("webdriver.chrome.driver","E:\\server\\chromedriver\\chromedriver.exe");
  driver=new ChromeDriver();
  driver.manage().deleteAllCookies();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  driver.get("http://suvian.in/selenium/1.9copyAndPasteTextAdvanced.html");
			
}	
	
	
  @Test
  public void readQuoteTest() {
	  
	  WebElement textelement=driver.findElement(By.xpath("//div[@class='intro-message']/h3"));
	  String text=textelement.getText();
	  int quotestart=text.indexOf("Paste");
	  int quoteend=text.lastIndexOf("x")+1;
	  String quotetext=text.substring(quotestart, quoteend);
	  driver.findElement(By.id("copyandpasteadvanced")).sendKeys(quotetext);
	  
	  
	  
  }
  
  @AfterClass
  public void tearDown() {
	  
	 driver.quit();
  }


}
