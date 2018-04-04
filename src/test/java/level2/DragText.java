package level2;

import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


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
	
  @Test(priority=1)
  public void dragTextTestSikuli() throws Exception {
	  
	  Screen s=new Screen();
	  Pattern drag=new Pattern(System.getProperty("user.dir")+"//image//drag.png");
	  Pattern drop=new Pattern(System.getProperty("user.dir")+"//image//drop.png");
	  s.dragDrop(drag,drop);	  
	  Thread.sleep(2000);
	  
	 
  }
  
  
  @Test(priority=2)
  public void dragTextTestNormal() throws Exception {
	  
	 driver.navigate().refresh(); 
	 Thread.sleep(2000);	  
	 	
	// action.clickAndHold(driver.findElement(By.xpath("//*[@id='drag1']/strong"))).
	// moveToElement(driver.findElement(By.xpath("//*[@id='div1']"))).release().build().perform();
	WebElement source=driver.findElement(By.xpath("//h5[@id='drag1']/strong"));
	WebElement destination=driver.findElement(By.xpath("//div[@class='intro-message']/br"));
	Actions action=new Actions(driver);
	 action.dragAndDrop(source, destination).build().perform();
	  
  }
 

  
  
  @AfterClass
  public void tearDown() {
	  
	  //driver.quit();
  }

}
