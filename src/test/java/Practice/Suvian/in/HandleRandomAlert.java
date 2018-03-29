package Practice.Suvian.in;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class HandleRandomAlert {
 
	public WebDriver driver;
	
	
	 @BeforeClass
	 public void setUp() {
		 
		 System.setProperty("webdriver.chrome.driver","E:\\server\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.get("http://suvian.in/selenium/2.7waitUntil.html");
		}
	
	
	
  @Test
  public void testHandleRandomAlert() throws Exception {
	  
	  WebElement link=driver.findElement(By.linkText("Click Me"));
	  link.click();
	  WebDriverWait w=new WebDriverWait(driver,31);
	  w.until(ExpectedConditions.alertIsPresent());
	  driver.switchTo().alert().accept();
  }
 
  @AfterClass
  public void tearDown() {
	  
	  driver.quit();
  }

}
