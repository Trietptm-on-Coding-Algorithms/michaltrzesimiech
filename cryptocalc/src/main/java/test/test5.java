package test;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

public class test5 {

	public static void main(String[] args) throws IOException, URISyntaxException {

		String url = "http://www.cryptonator.com/api/ticker/eth-eur";
		URL url1 = new URL("http://www.cryptonator.com/api/ticker/eth-eur");

		
		System.out.println(url);
		System.out.println(url1.getHost());
		System.out.println(url1.getPath());
		System.out.println(url1.getContent());
		System.out.println(url1.getFile());
		
		//System.out.println(Paths.get(url1.toURI()));

		InputStream input = new URL(url).openStream();
		System.out.println(input);
		
		
	}
}
