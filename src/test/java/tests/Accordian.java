package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Accordian {

WebDriver driver;
	
	@Test
	public void Test() {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/accordian");
		
		
	}
}
