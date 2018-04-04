package level3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class ChooseDate {
	
	public WebDriver driver;
	
	@BeforeClass
	  public void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver","E:\\server\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://suvian.in/selenium/3.10select1stFriday.html");		
		
	  }
	
	
	
  @Test
  public void testEnterFirstFriOfMonth() {
	  
	  
	  
	  
	  
  }
 

  @AfterClass
  public void afterTest() {
	  
	  driver.quit();
  }


}
