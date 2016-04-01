/*
 * Calculate PLN worth of owned ETH based on current ETH/EUR rate.
 */

package calcethereum;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {

	public static void main(String[] args) throws IOException {

		calculate();

	}

	private static void calculate() throws FileNotFoundException {

		NumberFormat f = new DecimalFormat("#0.00");

		// Your ether
		double ownedEther = 38.34702;

		// Your initial investment in PLN
		double initInvestment = 1516.85;

		// Get price from cryptowat.ch (uses webdriver) or local JSON file
		double price = Price.priceEth(); // Price.priceEthJson()

		double portfolioEur = ownedEther * price;
		double portfolioPln = portfolioEur * 4.24;

		System.out.printf(
				"%nYour %s Ether is worth %s EUR or %s PLN. %n"
						+ "Given that initial investment was %s, your profit/loss is %s PLN.",
				f.format(ownedEther), f.format(portfolioEur), f.format(portfolioPln), f.format(initInvestment),
				f.format(portfolioPln - initInvestment));
	}

	// TODO: ALERTS MODULE

}