/*
 * HAPPYMETER is a happiness measurement gimmick inspired by Nick Winter's amazing book "Motivation Hacker"
 * Just measure your happiness levels daily and save your results to JSON or text file.
 */

// TODO: Refactor and document this class

package happymeter;

import java.io.*;
import java.util.Scanner;
import java.util.Date;

public class Main {

	private static Scanner stringScanner;
	public static Date date;
	static String newRate;
	private static int rateToInt;
	static String newComment;

	// You need to configure this first
	static File log = new File("P:\\happiness.txt");

	public static void main(String[] args) throws IOException {

		date = new Date();
		stringScanner = new Scanner(System.in);

		System.out.println("New entry timestamped " + date.toString() + "\n");

		// TODO: Print info on average happiness so far
		System.out.println("Add rate");
		newRate = stringScanner.nextLine();

		asess();
		cheer();
		printToFile();

		// System.out.println("\nEntry saved to " + log.toString() + "\n");

	}

	private static void asess() {

		// TODO: Make it accept decimals
		// http://stackoverflow.com/questions/1014284/regex-to-match-2-digits-optional-decimal-two-digits
		// http://stackoverflow.com/questions/3059333/validating-input-using-java-util-scanner
		if (!newRate.matches("^([1-9]|10)$")) {
			System.out.println("You need to enter value between 1 and 10.\nPlease take another run, Master.");
			System.exit(1);
		} else {
			rateToInt = Integer.parseInt(newRate);
		}
	}

	private static void cheer() {
		System.out.println("Add comment");
		newComment = stringScanner.nextLine();

		if (rateToInt > 7) {
			System.out.println("Oh sweet success, Master!");
		} else {
			System.out.println("It's going to get a lot better, Master.");
		}
	}

	public static void printToFile() throws IOException {

		PrintWriter out = new PrintWriter(new FileWriter(log, true));
		out.append("- " + date.toString() + "  ---  " + newRate + "  ---  " + newComment + System.lineSeparator());
		out.close();

	}

}
