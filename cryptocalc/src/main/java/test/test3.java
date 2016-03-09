package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// TODO either go through security or use webdriver

public class test3 {

	public static void main(String[] args) {
		
		  System.setProperty("webdriver.chrome.driver", "A://dev//_webdrivers//chromedriver.exe");
		  WebDriver driver = new ChromeDriver();

		  String url = "https://www.cryptonator.com/api/ticker/eth-eur";
		  
		  driver.get(url);
		  
		  List<WebElement> body = driver.findElements(By.tagName("pre"));		  
		  
		  System.out.println(body);
		  
//		  driver.close();
//		  driver.quit();		  
		
	}
}