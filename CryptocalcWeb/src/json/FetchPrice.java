package json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import json.Ethereum;

import com.google.gson.Gson;

public class FetchPrice {

	public static double FetchPrice() throws FileNotFoundException {

		Gson gson = new Gson();

		BufferedReader br = new BufferedReader(new FileReader(
				"P:\\calcEther.txt"));

		Ethereum eth = gson.fromJson(br, Ethereum.class);
		
		double price = Float.parseFloat(eth.getEthereumTicker().getPrice());
		
		return price;
		
	}
		
}
