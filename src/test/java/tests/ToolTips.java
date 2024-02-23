package tests;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolTips {
WebDriver driver;
	
	@Test
	public void Test() {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/tool-tips");
		
		WebElement toolTipButton=driver.findElement(By.id("toolTipButton"));
		// buton üzerine imleç gelme ve yazının okunma olayı
		Actions action=new Actions(driver);
		action.moveToElement(toolTipButton).perform();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tooltip-inner")));     // o element sayfada gözükene kadar bekle
		
		WebElement toolTip=driver.findElement(By.className("tooltip-inner"));
		System.out.println("text:"+toolTip.getText());
		
	}
}
