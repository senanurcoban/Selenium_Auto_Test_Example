package tests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadAndDownload {

public static void main(String [] args) {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/upload-download");
		
		WebElement downloadButton=driver.findElement(By.id("downloadButton"));
		downloadButton.click();
		
		String path="C:\\Users\\ASUS\\Downloads";
		String fileName="sampleFile.jpeg";
		
		try {
		    Thread.sleep(2000);
		} catch(InterruptedException e) {
			 e.printStackTrace();
		}
		
		boolean isDownloaded=isFileDownloaded(path, fileName);
		System.out.println(isDownloaded);
		
		
		/********************************************************************************/
		
		WebElement uploadButton=driver.findElement(By.id("uploadFile"));
		uploadButton.sendKeys("C:\\Users\\ASUS\\Desktop\\Capture.PNG");
		
			
}

public static boolean isFileDownloaded(String downloadPath,String fileName) {
	File file=new File(downloadPath);
	File [] files=file.listFiles();
	
	for(int i=0;i<files.length;i++) {
		if(files[i].getName().equals(fileName)) {
			files[i].delete();
			return true;
		}
	}
	return false;
}
}
