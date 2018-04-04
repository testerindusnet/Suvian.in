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
  //driver.get("http://suvian.in/selenium/2.3frame.html");
 // driver.get("http://www.suvian.in/selenium/1.2text_field.html");
  
  
}	
	
	
  @Test
  public void readQuoteTest() throws Exception {
	  
	  WebElement textelement=driver.findElement(By.xpath("//div[@class='intro-message']/h3"));
	  String text=textelement.getText();
	  int quotestart=text.indexOf("Paste");
	  int quoteend=text.lastIndexOf("x")+1;
	  String quotetext=text.substring(quotestart, quoteend);
	  driver.findElement(By.id("copyandpasteadvanced")).sendKeys(quotetext);  
	  
	/*  driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='intro-message']//child::iframe")));
	  driver.findElement(By.xpath("//button[text()='Click Me']")).click();
	  Thread.sleep(3000);
	  driver.switchTo().alert().accept();*/
	  
	//  driver.findElement(By.name("yourname")).sendKeys("SomaShekar");
	  
  }
  
  @AfterClass
  public void tearDown() {
	  
	 //driver.quit();
  }


}
