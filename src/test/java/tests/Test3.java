package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {
	public static void main(String [] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Desktop\\webdriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		
		WebElement sportCheckbox=driver.findElement(By.id("hobbies-checkbox-1"));
		boolean isEnabled= sportCheckbox.isEnabled();
		System.out.println(isEnabled);                  // tıklanabilir olup olmadığı
		
		
		WebElement sportCheckboxLabel=driver.findElement(new By.ByCssSelector("label[for='hobbies-checkbox-1']"));
		
		if(isEnabled) {
			
			try{
				sportCheckbox.click();
				
			}catch (ElementClickInterceptedException e) {
				sportCheckboxLabel.click();
				System.out.println("Entered catch block");
			}
		}
	
		
		boolean isSelected= sportCheckbox.isSelected();
		System.out.println(isSelected);             
			
	}
}
