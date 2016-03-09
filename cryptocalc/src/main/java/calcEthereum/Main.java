package calcEthereum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import com.google.gson.Gson;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import java.io.File;
//import java.net.URLConnection
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.Date;
////import org.json.JSONException;
//import org.json.JSONObject;
//import java.net.MalformedURLException;
//import org.apache.commons.io.IOUtils;

/*
 * PARSE .JSON DATA ON ETHER AND CALCULATE YOUR PORTFOLIO
 */

public class Main {

	public static void main(String[] args) throws IOException {

		// HOW MUCH ETHER DO YOU OWN?
		double ownedEther = 10.58033;

		
		/* So I should either try to 
		 * 1) overcome the PKIX path building failure
		 * 2) get file address right to parse it as such
		 * 3) hack it with selenium, marking all the text and copying it
		 */
		
		 URL url = new URL("https://www.cryptonator.com/api/ticker/eth-eur");
		 File file = new File("A:\\dev\\_data\\etherPrice.json");
		
		 FileUtils.copyURLToFile(url, file);

		calculateEtherPortfolio(ownedEther);

	}

	private static void calculateEtherPortfolio(double owned) {

		Gson gson = new Gson();

		try {

			BufferedReader br = new BufferedReader(new FileReader(
					"A:\\dev\\_data\\etherPrice.json"));

			Ethereum eth = gson.fromJson(br, Ethereum.class);

			// System.out.println("Price: " +
			// eth.getEthereumTicker().getPrice());

			System.out.println(eth.getEthereumTicker().getBase() + "/"
					+ eth.getEthereumTicker().getTarget() + ": "
					+ eth.getEthereumTicker().getPrice());

			float price = Float.parseFloat(eth.getEthereumTicker().getPrice());

			System.out
					.println("Current portfolio: " + (owned * price) + " EUR");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}