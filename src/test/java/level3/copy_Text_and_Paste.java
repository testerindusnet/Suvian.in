package level3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class copy_Text_and_Paste {
 
public WebDriver driver;	
	
@BeforeTest
public void setUp() {
	
	System.setProperty("webdriver.chrome.driver","E:\\server\\chromedriver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://suvian.in/selenium/3.6copyTextFromTextField.html");	
	  } 	
	
 @Test(priority=1)
  public void copy_Paste() {
	 
	 String text=driver.findElement(By.name("field_one")).getText();
	 driver.findElement(By.name("field_two")).sendKeys(text);
	 
  }

 @Test(priority=2)
 public void copy_Paste_js() {
	 driver.navigate().refresh();
	 WebElement e=driver.findElement(By.name("field_one"));
	 String text=((JavascriptExecutor)driver).executeScript("return arguments[0].value;",e).toString();
	 System.out.println(text);
	 driver.findElement(By.name("field_two")).sendKeys(text);
	 
 }
  

  @AfterTest
  public void afterTest() {
	  
	  
	  driver.quit();
	  
  }

}
