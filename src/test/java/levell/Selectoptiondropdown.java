package levell;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
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

public class Selectoptiondropdown {
 
	public WebDriver driver;
	  
	  
	  @BeforeClass
		public void setUp() {
		 	 
		System.setProperty("webdriver.chrome.driver","E:\\server\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://suvian.in/selenium/1.10selectElementFromDD.html");
			
		}	
	
	
		 @Test(priority=1)
		  public void testSelectOptionAndHandleWindow() throws Exception {
			 
			 WebElement menu=driver.findElement(By.className("dropbtn"));
			 WebElement option2=driver.findElement(By.xpath("//div[@id='myDropdown']/a[2]"));
			 WebElement next=driver.findElement(By.partialLinkText("Finish Level 1"));
			 WebDriverWait w= new WebDriverWait(driver,10);
			 
			 menu.click();
			 w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dropdown-content show']"))); 
			 option2.click();
			 w.until(ExpectedConditions.numberOfWindowsToBe(2));			 
			 ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
			 driver.switchTo().window(tabs.get(1));
			 driver.close();
			 driver.switchTo().window(tabs.get(0));
			 next.click();
			 
			 driver.navigate().back();	
		  }
		 
		 
		 
		 @Test(priority=2)
		  public void testSelectOptionAndHandleWindowUsingSet() throws Exception {
			 
			 WebElement menu=driver.findElement(By.className("dropbtn"));
			 WebElement option2=driver.findElement(By.xpath("//div[@id='myDropdown']/a[2]"));
			 WebElement next=driver.findElement(By.partialLinkText("Finish Level 1"));
			 WebDriverWait w= new WebDriverWait(driver,10);
			 String parentwindow=driver.getWindowHandle();
			 
			 
			 menu.click();
			 w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dropdown-content show']"))); 
			 option2.click();
			 w.until(ExpectedConditions.numberOfWindowsToBe(2));			 
			
			 Set<String>windowname=driver.getWindowHandles();
			 Iterator<String> I1= windowname.iterator();
			 while(I1.hasNext())				 
			 {
			 
				 String childwindowname=I1.next();
				 if(!childwindowname.equals(parentwindow))
					 
				 {
			       driver.switchTo().window(childwindowname);
			       driver.close();
				 }  
				 
			 }	 
			 driver.switchTo().window(parentwindow);
			 next.click();
			 
		  }
		 

		 @AfterClass
		  public void tearDown() {
			  
			  driver.quit();
		  }
}
