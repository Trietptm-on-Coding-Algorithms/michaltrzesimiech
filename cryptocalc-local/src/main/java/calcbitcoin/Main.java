/*
 * Calculate your BTC portfolio based on price data in .JSON format
 */

package calcbitcoin;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.apache.commons.io.FileUtils;
import com.google.gson.Gson;
import json.Bitcoin;

public class Main {

	public static void main(String[] args) throws IOException {

		double ownedBitcoin = 10.32;
		calculate(ownedBitcoin);

	}

	private static void calculate(double ownedBitcoin) throws IOException {

		/*
		 * Copy Coindesk's .JSON content to local file
		 */

		NumberFormat f = new DecimalFormat("#0.00");
		URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
		File file = new File("A:\\dev\\calcBitcoin.json");
		FileUtils.copyURLToFile(url, file);

		/*
		 * Parse .JSON file to get data and calculate portfolio
		 */

		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader("A:\\dev\\calcBitcoin.json"));
		Bitcoin btc = gson.fromJson(br, json.Bitcoin.class);

		double intedShowRate = Double.parseDouble(btc.getBpi().getUsd().getRate());
		double value = intedShowRate * ownedBitcoin;

		System.out.printf("=== %s === USD/BTC: %s %nCurrent USD worth of your %s BTC is %s USD",
				btc.getTime().getUpdated(), btc.getBpi().getUsd().getRate(), f.format(ownedBitcoin), f.format(value));

		System.out.println("\n\n" + btc.getDisclaimer());

	}

}