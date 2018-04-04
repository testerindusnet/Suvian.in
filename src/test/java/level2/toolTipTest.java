package level2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class toolTipTest {
	
	
	public WebDriver driver;
	
	@BeforeClass
	  public void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver","E:\\server\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://suvian.in/selenium/2.4mouseHover.html");		
		
	  }
	
	
  @Test
  public void testTooltip() throws Exception {
	  
	  
	  WebElement link=driver.findElement(By.xpath("//a[contains(text(),'This link has tooltip')]"));
	  
	  WebElement textbox=driver.findElement(By.id("mouseover"));
	  
	  String tooltiptext=link.getAttribute("title");
	
	  Point p = link.getLocation();
	  int xcord=p.getX();
	  System.out.println(xcord);
	  int ycord=p.getY();
	  System.out.println(ycord);
	  Actions action=new Actions(driver);
	  action.moveToElement(link,(xcord+15),ycord).build().perform();
	  Thread.sleep(3000);
	  textbox.sendKeys(tooltiptext);
	  
	  
	  
  }
  

  @AfterClass
  public void afterTest() {
	  
	  driver.quit();
  }

}
