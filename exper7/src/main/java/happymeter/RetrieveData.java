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

	public static double average() throws FileNotFoundException, IOException {

		/*
		 * This class retrieves log file defined in Main.class, breaks it in
		 * parts and calculates your average happiness.
		 */

		File file = Main.log;

		List<String> lines = new ArrayList<String>();
		List<String> scores = new ArrayList<String>();
		List<Integer> scoresAsInts = new ArrayList<Integer>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			/*
			 * Add every line in the file to an array
			 */

			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);

				/*
				 * Split parts of lines that are scores and trim them nicely
				 */

				for (String l : lines) {

					String[] part = l.replaceAll("\\s", "").split("---");
					scores.add(part[1]);

					/*
					 * Turn scores into an array of integers
					 */

					for (String s : scores) {
						scoresAsInts.add(Integer.parseInt(s));
					}
				}

			}

		}

		/*
		 * Calculate and print average happiness
		 */

		int sum = 0;
		for (int sc : scoresAsInts) {
			sum += sc;
		}

		double average = sum / scoresAsInts.size();

		return average;

	}

}