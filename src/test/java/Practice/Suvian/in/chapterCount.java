package Practice.Suvian.in;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class chapterCount {
	
	public WebDriver driver;
	
  
 @BeforeClass
 public void setUp() {
	 
	 System.setProperty("webdriver.chrome.driver","E:\\server\\chromedriver\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().deleteAllCookies();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 driver.get("http://suvian.in/selenium/2.6liCount.html");
	  }
	
	@Test(priority=1)
  public void testTotalChapterCount() {
		
		WebElement totalchaptertextbox=driver.findElement(By.id("chapall"));
		List<WebElement>totalchapter=driver.findElements(By.xpath("//li[contains(text(),'Chapter')]"));		
		int totalchaptercount=totalchapter.size();		
		System.out.println(totalchaptercount);
		totalchaptertextbox.sendKeys(String.valueOf(totalchaptercount));
  }
	
		
	

	@Test(priority=2)
  public void testTotalChapterCountinBook2() {		
		WebElement totalchapterbook2textbox=driver.findElement(By.id("chapbook2"));		
		List<WebElement>totalchapterinbook2=driver.findElements(By.xpath("//li[contains(text(),'Book 2')]//child::ul/li[contains(text(),'Chapter')]"));
		int totalbook2chapter=totalchapterinbook2.size();
		System.out.println(totalbook2chapter);
		totalchapterbook2textbox.sendKeys(String.valueOf(totalbook2chapter));
  }
	
	
	
	
	
  

  @AfterClass
  public void tearDown() {
	  
	  driver.quit();
  }

}
