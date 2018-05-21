package level2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class newWindowHandle {
	
  WebDriver driver;	
 
  @BeforeMethod
  public void setUp() {
	  
	  System.setProperty("webdriver.chrome.driver","E:\\server\\chromedriver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.get("http://suvian.in/selenium/2.2browserPopUp.html");
	  
  }
  
  @Test(priority=1)
  public void testHandleNewWindow() throws Exception {
	  
	 driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
	 ArrayList<String> windowname=new ArrayList<String>(driver.getWindowHandles());
	 driver.switchTo().window(windowname.get(1));
	 System.out.println(driver.getTitle());
	 driver.close();
	 driver.switchTo().window(windowname.get(0));
	 System.out.println(driver.getTitle());
  }
  
  
  @Test(priority=2)
  public void testHandleNewWindowUsingSet() throws Exception {
	  
	
	 String parentwindowname=driver.getWindowHandle();
	 driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
	 Set<String> windownames=driver.getWindowHandles();
	 Iterator<String>wnames=windownames.iterator();
	 while(wnames.hasNext())
	 {
		 
		 String wname=wnames.next();
		 if(!wnames.equals(parentwindowname))
		 {
			 
			 driver.switchTo().window(wname);
			 System.out.println(driver.getTitle());
		 }
	 }
	 driver.close();
	 driver.switchTo().window(parentwindowname);
	 System.out.println(driver.getTitle());
	 
     
  }
  
  
  
  
  @Test(priority=3)
  public void testHandleNewWindowUsingfor() throws Exception {
	 String parentwindowname=driver.getWindowHandle();
	 driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
	 for(String windownames:driver.getWindowHandles())
	 {
		 String wname=windownames.toString();
		 if(!wname.equals(parentwindowname))
		 {
			  driver.switchTo().window(wname);
			 System.out.println(driver.getTitle());
		 }
	 }
	 driver.close();
	 driver.switchTo().window(parentwindowname);
	 System.out.println(driver.getTitle());
  }
  
  

  @AfterMethod
  public void afterTest() {
	  
	  driver.quit();
	  
  }

}
