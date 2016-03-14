package calcBitcoin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import com.google.gson.Gson;
//import java.net.URL;
//import java.net.URLConnection;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.Date;
////import org.json.JSONException;
//import org.json.JSONObject;
//import java.io.File;
//import java.net.MalformedURLException;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.IOUtils;

public class Main {

	/*
	 * PARSE .JSON DATA ON BITCOIN AND CALCULATE YOUR PORTFOLIO
	 */

	public static void main(String[] args) throws IOException {

		// HOW MUCH BITCOIN DO YOU OWN?
		double ownedBitcoin = 0.0; //0.2408511
		
		// URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
		// File file = new File("P:\\calcBitcoin.txt");
		//
		// FileUtils.copyURLToFile(url, file);

		calculateBitcoinPortfolio(ownedBitcoin);

	}

	private static void calculateBitcoinPortfolio(double ownedBitcoin) {
		Gson gson = new Gson();

		try {

			BufferedReader br = new BufferedReader(new FileReader(
					"P:\\calcBitcoin.txt"));

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
