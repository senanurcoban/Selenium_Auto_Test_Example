package tests;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoComplete {

WebDriver driver;
	
	@Test
	public void Test() {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/auto-complete");
		
		WebElement input=driver.findElement(By.id("autoCompleteSingleInput"));
		input.sendKeys("R");
		
		List<WebElement> suggestions=driver.findElements(By.cssSelector("div.auto-complete__option"));
		for(WebElement suggestion:suggestions) {
			
			String text=suggestion.getText();
			
			System.out.println(text);
			
			if(text.toLowerCase().contains("r")) {
				System.out.println(text+ " has r letter");
			}
			
			/*if(text.equalsIgnoreCase("red")) {           sadece belirlenen değeri seçme
				suggestion.click();
				break;
			}*/
		}
		
		suggestions.get(0).click();                    // açılan listede ilk elemana tıklandı.
		
	}
}
