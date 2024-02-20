package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

	public static void main(String [] args) {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Desktop\\webdriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/checkbox");
		
		String homeCheckBoxCssValue="label[for='tree-node-home'] span.rct-checkbox svg";
		WebElement homeCheckBox =driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));
		homeCheckBox.click();
		 
		//DOM değiştiği için tekrar bulmak gerekti!
		
		homeCheckBox =driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));
		
		//Check or Uncheck
		String  homeCheckBoxClassName=homeCheckBox.getAttribute("class");
		
		if(homeCheckBoxClassName.equals("rct-icon rct-icon-check")) {
			System.out.println("Chechkbox is checked!");
			
		}else {
			System.out.println("Chechkbox is unchecked!");
		}
	}
}
