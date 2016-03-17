/*
 * HAPPYMETER is a happiness measurement gimmick inspired by Nick Winter's amazing book "Motivation Hacker"
 * Measure your happiness levels daily and save your results to JSON or text file.
 */

package happymeter;

import java.io.*;
import java.util.Scanner;
import java.util.Date;
import org.json.simple.JSONObject;

public class Main {

	static File log = new File("P:\\happiness.txt");
	private static Date date = new Date();
	private static String newComment;
	private static String newRate;

	public static void main(String[] args) throws IOException {

		gatherInput();
		assessThenCheer();
		printToFile();

	}

	private static void gatherInput() throws FileNotFoundException, IOException {

		/*
		 * Print out average happiness
		 */

		System.out.println("Average happiness so far is "
				+ RetrieveData.average());

		/*
		 * Enter new record based on keyboard input
		 */

		Scanner s = new Scanner(System.in);

		System.out.println("New entry timestamped " + date.toString() + ":\n");

		System.out.println("Add rate");
		newRate = s.nextLine();

		System.out.println("Add comment");
		newComment = s.nextLine();
	}

	private static void assessThenCheer() {

		/*
		 * See whether the entry is between 1 and 10, then show support
		 */

		if (!newRate.matches("^([1-9]|10)$")) {
			System.out.println("You need to enter value between 1 and 10."
					+ "\nPlease take another run, Master.");
			System.exit(1);
		} else {

			/*
			 * Cheer based on rate
			 */

			int rateToInt = Integer.parseInt(newRate);
			if (rateToInt > 7) {
				System.out.println("Oh sweet success, Master!");
			} else {
				System.out.println("It's going to get a lot better, Master.");
			}
		}

	}

	public static void printToFile() throws IOException {

		/*
		 * Save results to a text file
		 */

		PrintWriter out = new PrintWriter(new FileWriter(log, true));

		out.append("- " + date.toString() + "  ---  " + newRate + "  ---  "
				+ newComment + System.lineSeparator());
		out.close();

		Process display = new ProcessBuilder("cmd", "/c", "P:\\happiness.txt")
				.start();
		
		// System.out.println("\nEntry saved to " + log.toString() + "\n");

	}

	private static void printToJson() throws IOException {

		/*
		 * Save results to a JSON file
		 */

		File json = new File("P:\\happiness-json.json");

		JSONObject obj = new JSONObject();
		obj.put("Datestamp:", Main.date.toString());
		obj.put("Rate:", Main.newRate);
		obj.put("Comment:", Main.newComment);

		/*
		 * TODO: Consider organising data into arrays: JSONArray JSONarray = new
		 * JSONArray(); JSONarray.add("1"); JSONarray.add("2");
		 * JSONarray.add("3"); obj.put("object", JSONarray);
		 */

		try (FileWriter file = new FileWriter(json)) {
			file.write(obj.toJSONString());
			System.out.println("Works great! \n\n" + obj);

		}

	}

}
