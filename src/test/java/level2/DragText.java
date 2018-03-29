package level2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class DragText {
	
  public WebDriver driver;
  
  
  @BeforeClass
	public void setUp() {
	 	 
	System.setProperty("webdriver.chrome.driver","E:\\server\\chromedriver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("http://suvian.in/selenium/2.10dragAndDrop.html");
	
	}
	
  @Test
  public void dragTextTest() throws Exception {
	  
	  WebElement drop=driver.findElement(By.xpath("//div[@id='div1']"));
	  WebElement drag=driver.findElement(By.xpath("//h5[@id='drag1']"));
	  
	  Thread.sleep(2000);
	  
	Actions action=new Actions(driver);
	
	action.clickAndHold(drag).moveToElement(drop).release(drop).build().perform();
	//action.dragAndDrop(drag, drop).build().perform();
	
	  
	  
  }
 

  
  
  @AfterClass
  public void tearDown() {
	  
	  //driver.quit();
  }

}
