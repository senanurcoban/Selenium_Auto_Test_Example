package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

WebDriver driver;
	
	@Test
	public void Test() {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/slider");
		
		WebElement slider=driver.findElement(By.cssSelector("input[type='range']"));
		Actions action=new Actions(driver);
		action.dragAndDropBy(slider, 20, 0).perform();
		
		WebElement sliderValue=driver.findElement(By.cssSelector(".range-slider__tooltip__label"));
		String value=sliderValue.getText();
		System.out.println("Recent value:"+ value);
		
		WebElement textValue=driver.findElement(By.id("sliderValue"));
		String sliderValueText=textValue.getAttribute("value");
		System.out.println("Slider text value:"+sliderValueText);
		
		Assert.assertEquals(value, textValue, "values are not equals");
		
		
	}
}
