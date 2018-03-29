package Practice.Suvian.in;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class resizeTextArea {

	
	public WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver","E:\\server\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://suvian.in/selenium/2.5resize.html");		
  }
  
  
  @Test
  public void testResizeTextAreajs() throws Exception {
	  
	   WebElement textarea=driver.findElement(By.name("resizeArea"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].setAttribute('style','resize: horizontal; max-width: 99%; margin-left: 0px; margin-right: 0px; width: 405px;')", textarea);
	  Thread.sleep(2000);

  }
  
  

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
