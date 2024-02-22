package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DynamicElement {

public static void main(String [] args) {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/dynamic-properties");
		
		WebElement textElement=driver.findElement(By.xpath("//div/p"));
		String text=textElement.getText();
		System.out.println(text);
		

        // 5 saniye beklenip buton aktif hale getirildi.		
		WebElement firstButton=driver.findElement(By.id("enableAfter"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(firstButton));
		firstButton.click();
		
		// Color Change
		// Renk değişmeden önceki className değerini elde ettik.
		WebElement colorChangeButton=driver.findElement(By.id("colorChange"));
		String className=colorChangeButton.getAttribute("class");
		System.out.println("Before change:"+className);
		
		// className Attribute değeri mt-4... olana kadar 5 saniye bekle.
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.attributeToBe(colorChangeButton, "class", "mt-4 text-danger btn btn-primary"));
		className=colorChangeButton.getAttribute("class");         // className güncellenmeli
		System.out.println("After change:"+className);
		
		// 5 saniye bekledikten sonra tıklama
		WebDriverWait wait3=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
		driver.findElement(By.id("visibleAfter")).click();
		
		
}
}
