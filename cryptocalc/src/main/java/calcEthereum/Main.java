/*
 * I use this to calculate my Ethereum portfolio. The price is parsed based on this data: https://www.cryptonator.com/api/ticker/eth-eur
 */

package calcEthereum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.text.NumberFormat;

import com.google.gson.Gson;
//import java.net.URL;
//import java.net.URLConnection;
//import java.io.InputStream;
//import java.io.InputStreamReader;
import java.io.IOException;
//import java.util.Date;
////import org.json.JSONException;
//import org.json.JSONObject;
//import java.io.File;
//import java.net.MalformedURLException;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.IOUtils;

public class Main {

	public static void main(String[] args) throws IOException {

		double ownedEther = 38.34702;
		double initInvestment = 1516.85;

		// URL url = new URL("https://www.cryptonator.com/api/ticker/eth-eur");
		// File file = new File("P:\\calcEther.txt");
		
		// FileUtils.copyURLToFile(url, file);

		calculateEtherPortfolio(ownedEther, initInvestment);

	}

	private static void calculateEtherPortfolio(double owned,
			double initInvestment) {

		Gson gson = new Gson();

		try {

			BufferedReader br = new BufferedReader(new FileReader(
					"P:\\calcEther.txt"));

			Ethereum eth = gson.fromJson(br, Ethereum.class);

			// System.out.println("Price: " +
			// eth.getEthereumTicker().getPrice());

			System.out.println(eth.getEthereumTicker().getBase() + "/"
					+ eth.getEthereumTicker().getTarget() + ": "
					+ eth.getEthereumTicker().getPrice());

			double price = Float.parseFloat(eth.getEthereumTicker().getPrice());
			
			double portfolioEur = (owned * price);
			System.out.printf(portfolioEur + " EUR");

			System.out.printf("\n\nWhich is " + ((portfolioEur * 4.33))
					+ " PLN");

			System.out.printf("\nWhich is "
					+ ((portfolioEur * 4.33) - initInvestment)
					+ " PLN profit/loss");

			System.out.printf("\nGiven initial investment was "
					+ initInvestment + " PLN");

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}