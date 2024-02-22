package tests;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksImages {

public static void main(String [] args) throws IOException {
	
	
	    // HttpClient ile bir URL adresine request atarak, dönen response değerini değerlendirmek.
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/broken");
		
		HttpClient client=HttpClientBuilder.create().build();
	    //HttpGet request=new HttpGet("https://demoqa.com/");          Çıktı:200 kod düzgün link
		
		// Çıktı:500 kod broken link
		HttpGet request=new HttpGet("https://the-internet.herokuapp.com/status_codes/500");
		
		HttpResponse response=client.execute(request);
		int statusCode=response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		
		
		
		//Broken Image
		WebElement brokenImage=driver.findElement(By.xpath("//div/img[2]"));
		String brokenImageUrl=brokenImage.getAttribute("src");
		System.out.println(brokenImageUrl);
		
		HttpClient client2=HttpClientBuilder.create().build();
		HttpGet request2=new HttpGet(brokenImageUrl);
		HttpResponse response2=client2.execute(request2);
		int statusCode2=response2.getStatusLine().getStatusCode();
		System.out.println(statusCode2);
		
		if(statusCode==200) {
			System.out.println("Valid Image");
		}else if(statusCode==500) {
			System.out.println("Broken Image");
		}
		
		
}
}
