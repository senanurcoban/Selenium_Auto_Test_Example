package tests;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames2 {
WebDriver driver;
	
	@Test
	public void Test() {
		
		// Sayfa sonunda bulunan reklamı kapatma işlemi.
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));     
		wait.until(ExpectedConditions.alertIsPresent());
		
		WebElement addFrame=driver.findElement(By.cssSelector("iframe[title='3rd party ad content']"));
		driver.switchTo().frame(addFrame);
		
		WebElement closeButton=driver.findElement(By.id("cbb"));
		closeButton.click();
		
		/************************************************************************************************/
		
		//Nested--İç içe Frame
		
		driver.switchTo().frame("frame1");        //parent frame id ile ulaşıldı
		WebElement parentBody=driver.findElement(By.tagName("body"));
		System.out.println(parentBody.getText());
		
		// child frame geçiş
		driver.switchTo().frame(0);          // index değeri ile
		WebElement childBody=driver.findElement(By.tagName("p"));
		System.out.println(childBody.getText());
		
		driver.switchTo().parentFrame();   // childframe den parentframe çıkış yapıldı.
		
		driver.switchTo().parentFrame();  // parentframe den ana frame/sayfa çıkış yapıldı.
	}
}
