package tests;


import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	WebDriver driver;
	
	@Test
	public void Test() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Desktop\\webdriver\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.id("timerAlertButton")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));     // alert açılması için bekleme süresi
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		driver.switchTo().alert().accept();                  // uyarı kabul etme
		
		
		//Alert is OK/CANCEL
		driver.findElement(By.id("confirmButton")).click();
		
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(5));     
		wait2.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(driver.switchTo().alert().getText());
		//driver.switchTo().alert().accept();  
		driver.switchTo().alert().dismiss();              // uyarı iptal etme
		
		
		//Textbox with alert
		driver.findElement(By.id("promtButton")).click();
		
		
		WebDriverWait wait3=new WebDriverWait(driver, Duration.ofSeconds(5));     
		wait3.until(ExpectedConditions.alertIsPresent());
		
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		
		alert.sendKeys("test");
		alert.accept();
	}
}
