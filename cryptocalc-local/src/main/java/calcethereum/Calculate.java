package calcethereum;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface Calculate {

	static void calculate(double ownedEther, double initInvestment, double rateEurPln) throws FileNotFoundException {

		NumberFormat f = new DecimalFormat("#0.00");

		double price = priceEth(); 
		
		double portfolioEur = ownedEther * price;
		double portfolioPln = portfolioEur * rateEurPln;

		System.out.printf(
				"%nYour %s Ether is worth %s EUR or %s PLN. %n"
						+ "Given that initial investment was %s PLN, your profit/loss is %s PLN.",
				f.format(ownedEther), f.format(portfolioEur), f.format(portfolioPln), f.format(initInvestment),
				f.format(portfolioPln - initInvestment));
	}


	public static double priceEth() {

		// initialize  webdriver, go to cryptowat.ch

		System.setProperty("webdriver.chrome.driver", "C:\\UBS\\dev\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://cryptowat.ch/kraken/etheur");

		// scrape price, parse it to a double, then return its value

		double priceEth = Double
				.parseDouble(driver.findElement(By.xpath("//*[@data-reactid='.1.1']")).getText().replaceAll("[€]", ""));

		return priceEth;

	}
	
	
}
