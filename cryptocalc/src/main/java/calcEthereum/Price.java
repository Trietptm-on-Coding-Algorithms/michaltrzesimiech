package calcEthereum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Price {

//	public static void main(String[] args) throws InterruptedException {

	
	public static double priceEth(){
	
		/*
		 * Initialize Chrome WebDriver to launch ETH-EUR chart on cryptowat.ch
		 */
		
		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver",
				"C:\\UBS\\Dev\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://cryptowat.ch/kraken/etheur");

		/*
		 * Find element representing price, parse it to a double, return
		 */
		
		double priceEth = Double.parseDouble(driver
				.findElement(By.xpath("//*[@data-reactid='.1.1']")).getText()
				.replaceAll("[€]", ""));
		
		return priceEth;
		
	}
}