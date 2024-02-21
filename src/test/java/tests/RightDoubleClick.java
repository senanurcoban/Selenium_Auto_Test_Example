package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightDoubleClick {

public static void main(String [] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Desktop\\webdriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/buttons");
		
		WebElement doubleClickButton=driver.findElement(By.id("doubleClickBtn"));
		
		//Çift tıklama için WebElement içerisinde bir metot/fonsiyon yok.
		//Actions kütüphanesi kullanaraK çift tıklama işlemi gerçekleştirilebilir.
		
		Actions action=new Actions(driver);
		action.doubleClick(doubleClickButton).perform();
		
		WebElement message=driver.findElement(By.id("doubleClickMessage"));
		String messageText=message.getText();
		System.out.println(messageText);
		
		WebElement rightClickButton=driver.findElement(By.id("rightClickBtn"));
		action.contextClick(rightClickButton).perform();
		
		WebElement rightClickMessage=driver.findElement(By.id("rightClickMessage"));
		String rightMessageText=rightClickMessage.getText();
		System.out.println(rightMessageText);
		
		// DİNAMİK ELEMENTLER
		
		WebElement dynamicClickButton=driver.findElement(By.xpath("//div/button[starts-with(text(),'Click Me')]"));
		//WebElement dynamicClickButton=driver.findElement(By.xpath("//div[last()]/button"));
		dynamicClickButton.click();
		
}
}
