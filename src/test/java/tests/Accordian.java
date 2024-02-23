package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Accordian {

WebDriver driver;
	
	@Test
	public void Test() {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/accordian");
		
		
		WebElement firstCard=driver.findElement(By.xpath("//div[@class='card'][1]/div[2]"));
		String className=firstCard.getAttribute("class");
		System.out.println(className);
		
		driver.findElement(By.id("section1Heading")).click();
	    className=firstCard.getAttribute("class");
	    System.out.println(className);
	}
}
