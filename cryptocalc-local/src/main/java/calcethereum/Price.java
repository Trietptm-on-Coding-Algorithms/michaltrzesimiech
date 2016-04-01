/*
 * Checks current price of ETH, returns it as double
 */

package calcethereum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.google.gson.Gson;

public class Price {

	public static double priceEth() {

		/*
		 * Initialize Chrome WebDriver to launch ETH-EUR chart on cryptowat.ch
		 */

		System.setProperty("webdriver.chrome.driver", "A:\\dev\\_webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://cryptowat.ch/kraken/etheur");

		/*
		 * Find price, parse it to a double, then return its value
		 */

		double priceEth = Double
				.parseDouble(driver.findElement(By.xpath("//*[@data-reactid='.1.1']")).getText().replaceAll("[€]", ""));

		return priceEth;

	}

	// OR USE PHANTOMJS (NOT READY YET):

	public static String priceEthPhantom() {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				"A:\\dev\\_webdrivers\\phantomjs.exe");
		WebDriver driver = new PhantomJSDriver(caps);
		return null;

	}

	// OR USE LOCAL JSON FILE TO PARSE ETH/EUR PRICE

	public static double priceEthJson() throws FileNotFoundException {

		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader("A:\\dev\\calcEther.txt"));
		json.Ethereum eth = gson.fromJson(br, json.Ethereum.class);

		double priceEth = Double.parseDouble(eth.getEthereumTicker().getPrice());
		return priceEth;

	}

}