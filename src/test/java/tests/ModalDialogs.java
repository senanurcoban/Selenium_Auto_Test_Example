package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModalDialogs {

WebDriver driver;
	
	@Test
	public void Test() {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/modal-dialogs");
		
		
		WebElement smallButton=driver.findElement(By.id("showSmallModal"));
		smallButton.click();
		
		WebElement modelText=driver.findElement(By.cssSelector("div.modal-body"));
		System.out.println(modelText.getText());
		
		WebElement smallCloseButton=driver.findElement(By.id("closeSmallModal"));
		smallCloseButton.click();
	}
}
