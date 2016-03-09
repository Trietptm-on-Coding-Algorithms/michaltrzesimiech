package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class test {

	public static void main(String[] args) {

		try {

			URL url = new URL("http://www.cryptonator.com/api/ticker/eth-eur");
			File file = new File("A:\\dev\\_data\\test.txt");
			// FileUtils.copyURLToFile(url, file);

			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
			in.close();

		} catch (MalformedURLException e) {
			System.out.println("Malformed URL: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("I/O Error: " + e.getMessage());
		}

	}

}
