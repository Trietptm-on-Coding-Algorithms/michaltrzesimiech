/*
 * HAPPYMETER is a happiness measurement gimmick inspired by Nick Winter's amazing book "Motivation Hacker"
 * Just measure your happiness levels daily and save your results to JSON or text file.
 */

package happymeter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RetrieveData {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {

		// You need to configure this first
		File file = new File("P:\\happiness.txt");

		/*
		 * Add every line in the file to an array
		 */
		
		List<String> lines = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}

		}

		/*
		 * Split parts of lines that represent scores and trim them nicely
		 */
		
		List<String> scores = new ArrayList<String>();

		for (String l : lines) {

			String[] part = l.replaceAll("\\s", "").split("---");
			scores.add(part[1]);
		}

		/*
		 * Turn scores into an array of integers
		 */
		
		List<Integer> scoresAsInts = new ArrayList<Integer>();

		for (String s : scores) {
			scoresAsInts.add(Integer.parseInt(s));
		}

		/*
		 * Calculate and print average happiness
		 */
		
		int sum = 0;
		for (int sc : scoresAsInts) {
			sum += sc;
		}

		double average = sum / scoresAsInts.size();

		System.out.println("Your average happiness level is " + average);

	}

}