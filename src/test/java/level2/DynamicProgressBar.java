package level2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class DynamicProgressBar {
 

	public WebDriver driver;
	  @BeforeClass
  public void setUp() {
	 	 
  System.setProperty("webdriver.chrome.driver","E:\\server\\chromedriver\\chromedriver.exe");
  driver=new ChromeDriver();
  driver.manage().deleteAllCookies();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  driver.get("http://suvian.in/selenium/2.8progressBar.html");

 }
	 
	
	
  @Test
  public void clickButtonAfterEnabletest() throws Exception{
	  
	  
	  WebElement disablebutton=driver.findElement(By.id("button2"));
	  WebElement enablebutton= driver.findElement(By.xpath("//button[contains(text(),'Click Me')]"));
	  enablebutton.click();
	  WebDriverWait w=new WebDriverWait(driver,60);
	  w.until(ExpectedConditions.elementToBeClickable(disablebutton));
	 // Thread.sleep(3000);
	  disablebutton.click();
	 // Thread.sleep(2000);
	  driver.switchTo().alert().accept();
	  
	  
  }


  @AfterClass
  public void tearDown() {
	  
	  driver.quit();
  }

}
