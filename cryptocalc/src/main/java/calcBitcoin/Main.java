/*
 * Calculate your BTC portfolio based on price data in .JSON format
 */

package calcBitcoin;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import com.google.gson.Gson;
import calcBitcoin.JSON.Bitcoin;

public class Main {

	public static void main(String[] args) throws IOException {

		double ownedBitcoin = 0.0;

		downloadJson();
		calcBtcPortfolio(ownedBitcoin);

	}

	private static void downloadJson() throws IOException {

		/*
		 * Copy Coindesk's .JSON file content to local file
		 */

		URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
		File file = new File("P:\\calcBitcoin.json");
		FileUtils.copyURLToFile(url, file);

	}

	private static void calcBtcPortfolio(double ownedBitcoin) {

		/*
		 * Parse .JSON file to get data and calculate portolio
		 */

		Gson gson = new Gson();

		try {

			BufferedReader br = new BufferedReader(new FileReader(
					"P:\\calcBitcoin.json"));

			Bitcoin btc = gson.fromJson(br, Bitcoin.class);

			System.out.println("BPI USD: " + btc.getBpi().getUsd().getRate());
			System.out.println("Updated: " + btc.getTime().getUpdated());

			float intedShowRate = Float.parseFloat(btc.getBpi().getUsd()
					.getRate());
			System.out.printf("\nCurrent USD worth of your " + ownedBitcoin
					+ " BTC is " + "%.2f", (intedShowRate * ownedBitcoin));

			System.out.println("\n\n" + btc.getDisclaimer());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
