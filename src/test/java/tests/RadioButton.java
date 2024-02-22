package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

public static void main(String [] args) {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/radio-button");
		
		WebElement yesRadioButtonLabel=driver.findElement(new By.ByCssSelector("label[for='yesRadio']"));
		boolean isEnabled=yesRadioButtonLabel.isEnabled();        // tıklanabilir olup olmadığı
		
            if(isEnabled) {
			
			try{
				yesRadioButtonLabel.click();
				
			}catch (ElementClickInterceptedException e) {
                yesRadioButtonLabel.click();
				
			}
		}
            
            WebElement yesRadioButton=driver.findElement(By.id("yesRadio"));
            
            boolean isSelected= yesRadioButton.isSelected();              // seçili olup olmadığı
            if(isSelected) {
            	 System.out.println("Yes radio button is selected");
            }
            
         // Tıklama gerçekleşince açıklama kısmı yazdırma.
         WebElement output=driver.findElement(new By.ByCssSelector("p.mt-3"));
         System.out.println(output.getText());
		
         // Tıklama özelliği olmayan bir radio button sonuç:FALSE elde edilir.
         WebElement noRadioButton=driver.findElement(By.id("noRadio"));
         System.out.println(noRadioButton.isEnabled());
		
}
}
