/*
 * Checks current price of ETH, returns it as double
 */

package calcEthereum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Price {

	public static double priceEth() {

		/*
		 * Initialize Chrome WebDriver to launch ETH-EUR chart on cryptowat.ch
		 */

		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver",
				"C:\\UBS\\Dev\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://cryptowat.ch/kraken/etheur");

		/*
		 * Find price, parse it to a double, then return its value
		 */

		double priceEth = Double.parseDouble(driver
				.findElement(By.xpath("//*[@data-reactid='.1.1']")).getText()
				.replaceAll("[€]", ""));

		// TODO: Make it alarm if price > 11 (SMSlib or email)

		return priceEth;

	}
}