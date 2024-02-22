package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindows {

	WebDriver driver;
	
	@Test
	public void Test() {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		
		WebElement tabButton=driver.findElement(By.id("tabButton"));
		//WebElement windowButton=driver.findElement(By.id("windowButton"));          YENİ PENCERE AÇMA
		tabButton.click();
		
		List<String> tabs=new ArrayList<>(driver.getWindowHandles());
		System.out.println(tabs.size());                               // yeni açılan sayfa adedi
		driver.switchTo().window(tabs.get(1));                        // istenilen tab sayfasına geçildi                    
		
		System.out.println(driver.getCurrentUrl());                    // açılan sayfa url adresi ekrana yazdırıldı.
		
		try {
		    Thread.sleep(2000);
		} catch(InterruptedException e) {
		   e.printStackTrace();
		}
		
		driver.close();                                                // açılan sayfa kapatılır.
		
	}
}
