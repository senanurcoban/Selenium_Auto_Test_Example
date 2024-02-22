package tests;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	WebDriver driver;
	
	@Test
	public void Test() {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		
		// Frame'ler iç içe sayfa yapısı mantığındadır. Bu sebeple frame'ler arası geçiş yapılmalı.
		
		driver.switchTo().frame(0);                  // index yapısı ile erişim
		
		//driver.switchTo().frame("frame1");           // frame id adı ile erişim
		
		
		WebElement heading=driver.findElement(By.id("sampleHeading"));
		String text=heading.getText();
		System.out.println(text);
		
		// Bir üst frame 'e geçiş-tekrar ana sayfaya geçiş
		driver.switchTo().parentFrame();
		
		List<WebElement> elementList=driver.findElements(By.cssSelector("div[id='framesWrapper'] div"));
		String paragraph=elementList.get(0).getText();
		System.out.println(paragraph);
		
		//2.frame geçiş.[önce ana grame geçmek gerekli]
		driver.switchTo().frame("frame2");
		WebElement heading2=driver.findElement(By.id("sampleHeading"));
		String text2=heading2.getText();
		System.out.println(text2);
		
		
		
		
		
		
		
		
		
		
		
	}
}
