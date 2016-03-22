/*
 * I use this to calculate my Ethereum portfolio. The price is parsed based on this data: https://www.cryptonator.com/api/ticker/eth-eur
 */

package calcEthereum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import calcEthereum.JSON.Ethereum;

import com.google.gson.Gson;

public class Main {

	protected static NumberFormat f = new DecimalFormat("#0.00");

	public static void main(String[] args) throws IOException {

		/*
		 * Update data on owned Ether and initial investment.
		 */

		double ownedEther = 38.34702;
		double initInvestment = 1516.85;

//		calculateFromCryptowatch(ownedEther, initInvestment);
		 calculateFromJson(ownedEther, initInvestment);

	}

	private static void calculateFromCryptowatch(double owned,
			double initInvestment) {

		/*
		 * Run Chrome WebDriver to look up price and calculate portfolio
		 */

		double price = Price.priceEth();
		calculatePortfolio(owned, initInvestment, price);

	}

	private static void calculateFromJson(double owned, double initInvestment) {

		/*
		 * Read local JSON file to look up price and calculate portfolio
		 */

		Gson gson = new Gson();

		try {

			BufferedReader br = new BufferedReader(new FileReader(
					"P:\\calcEther.txt"));

			Ethereum eth = gson.fromJson(br, Ethereum.class);

			System.out.println(eth.getEthereumTicker().getBase() + "/"
					+ eth.getEthereumTicker().getTarget() + ": "
					+ eth.getEthereumTicker().getPrice());

			double price = Float.parseFloat(eth.getEthereumTicker().getPrice());

			calculatePortfolio(owned, initInvestment, price);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void calculatePortfolio(double owned, double initInvestment,
			double price) {

		double portfolioEur = (owned * price);
		double portfolioPln = (portfolioEur * 4.33);

		System.out.printf("\nYour " + f.format(owned) + " Ether is worth "
				+ f.format(portfolioEur) + " EUR");
		System.out.printf("\nwhich is " + f.format(portfolioPln)
				+ " PLN. \nGiven that initial investment was "
				+ f.format(initInvestment) + "\n\nyour profit/loss is "
				+ f.format(portfolioPln - initInvestment) + " PLN.");

	}
}