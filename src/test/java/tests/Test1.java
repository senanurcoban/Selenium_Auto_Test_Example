package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	
	public static void main(String [] args) {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Desktop\\webdriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.get("https://demoqa.com/");
		
		driver.get("https://demoqa.com/text-box");
		//driver.manage().window().maximize();
		
		
		WebElement fullName=driver.findElement(By.id("userName"));
		fullName.click();
		fullName.sendKeys("Test");
		
		WebElement email=driver.findElement(new By.ByCssSelector("input.mr-sm-2[id='userEmail']"));
		email.click();
		email.sendKeys("test123@gmail.com");
		
		WebElement currentAddres=driver.findElement(new By.ByCssSelector(".form-control[placeholder='Current Address']"));
		currentAddres.click();
		currentAddres.sendKeys("Ankara,Türkiye");
		
		WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
		permanentAddress.click();
		permanentAddress.sendKeys("Ankara,Türkiye");
		
		WebElement submitButton=driver.findElement(By.id("submit"));
		submitButton.click();
		
		/**************************************************************************/
		
		WebElement nameText=driver.findElement(By.xpath("//div/p[@id='name']"));
		String name = nameText.getText();
		System.out.println(name);
		
		
		
		
	}
}
