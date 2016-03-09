package test;

import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class test4 {
	public static void main(String[] argv) throws Exception {

		/**
		 * 443 is the network port number used by the SSL https: URi scheme.
		 */
		int port = 443;

		String hostname = "cryptonator.com";

		SSLSocketFactory factory = HttpsURLConnection.getDefaultSSLSocketFactory();

		System.out.println("Creating a SSL Socket For " + hostname + " on port " + port);

		SSLSocket socket = (SSLSocket) factory.createSocket(hostname, port);

		socket.startHandshake();
		System.out.println("Handshaking Complete");

		Certificate[] serverCerts = socket.getSession().getPeerCertificates();
		System.out.println("Retreived Server's Certificate Chain");

		System.out.println(serverCerts.length + "Certifcates Foundnnn");
		for (int i = 0; i < serverCerts.length; i++) {
			Certificate myCert = serverCerts[i];
			System.out.println("====Certificate:" + (i + 1) + "====");
			System.out.println("-Public Key-n" + myCert.getPublicKey());
			System.out.println("-Certificate Type-n " + myCert.getType());

			System.out.println();
		}

		socket.close();
	}

}
