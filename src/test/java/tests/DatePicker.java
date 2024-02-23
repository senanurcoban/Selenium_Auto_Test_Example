package tests;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker {

WebDriver driver;
	
	@Test
	public void Test() {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/date-picker");
		
		selectDate("2023", "January", "12");
	}
		
	public void selectDate(String year,String month,String day) {
		WebElement dateSelection=driver.findElement(By.id("datePickerMonthYearInput"));
		dateSelection.click();
		
		WebElement monthElement=driver.findElement(By.className("react-datepicker__month-select"));
		Select select=new Select(monthElement);                  // dropdown menüden bir eleman seçmek için
		select.selectByVisibleText(month);
		
		WebElement yearElement=driver.findElement(By.className("react-datepicker__year-select"));
	    select=new Select(yearElement);
	    select.selectByVisibleText(year);
	    
	    
	    List<WebElement> daysElemenet=driver.findElements(By.cssSelector("div.react-datepicker__day"));
	    for(WebElement dayElement:daysElemenet) {
	    	
	    	String text=dayElement.getText();
	    	if(text.equals(day)) {
	    		dayElement.click();
	    		break;
	    		
	    	}
	    }
	}
	
	
}
