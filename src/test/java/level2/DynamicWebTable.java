package level2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class DynamicWebTable {
	
  public WebDriver driver;	
  
    @BeforeClass
	public void setUp() {
	 	 
	System.setProperty("webdriver.chrome.driver","E:\\server\\chromedriver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("http://suvian.in/selenium/2.9greenColorBlock.html");
	
	}
  
  @Test
  public void clickBlocktestinDynamicTable() throws Exception {
	  
	  WebElement greenbox=driver.findElement(By.xpath("//div[@class='greenbox']"));
	  
	  greenbox.click();
	  
	  Thread.sleep(3000);
	  
	  driver.switchTo().alert().accept();
	  
	  
  }
 

  @AfterClass
  public void tearDown() {
	  
	  driver.quit();
  }


}
