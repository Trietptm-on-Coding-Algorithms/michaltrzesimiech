/* 
 * Exper7 is a basic expert system built to aid decision-making of the powerful mage that created it out of abstract objects.
 */

package exper7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Main {

	protected static String question;
	static Scanner s = new Scanner(System.in);
	static Scanner i = new Scanner(System.in);

	protected static List<String> criteria = new ArrayList<>();
	protected static List<String> options = new ArrayList<>();
	protected static HashMap<String, Object> map = new HashMap<>();
	protected static Multimap<Object, Object> multimap = ArrayListMultimap.create();
	protected static List<Integer> results2 = new ArrayList<>();
	protected static List<Integer> results1 = new ArrayList<>();
	protected static List<Integer> temp = new ArrayList<>();

	public static void main(String[] args) {

		formulateQuestion();
		newCriterion();
		newOption();
		System.exit(0);

	}

	public static String formulateQuestion() {

		/*
		 * Ask the question
		 */

		System.out.printf("I am Exper7, your expert at most things quantifiable. "
				+ "%nFormulate the question and I shall formulate a solution, Master! %n>");
		question = s.nextLine();
		return question;

	}

	public static void newCriterion() {

		/*
		 * Add criteria
		 */

		while (criteria.isEmpty()) {
			System.out.println(
					"Let's see /n/nThere are currently no criteria to consider. We have to have at least one (i.e. \"Fame\").\n>");
			criteria.add(s.nextLine());
			System.out.println("\nWondrous! Would you like to add more? (type 0 or 1)\n>");

			while (i.nextInt() != 0) {
				System.out.println("\nAdd another one: \n>");
				criteria.add(s.nextLine());
				System.out.println("\nWould you like to add another one? (type 0 or 1)\n>");

			}

		}

		assignWeights();

	}

	public static void assignWeights() {

		/*
		 * Add weights to criteria
		 */

		System.out.println("\nYour criteria: " + criteria.toString());
		System.out.println("Assign values 1-10 in a proper order: \n>");

		for (String c : criteria) {
			map.put(c, i.nextInt());

		}

		System.out.println("\nWeights for criteria: " + map);

	}

	public static void newOption() {

		/*
		 * Add new option
		 */

		while (options.isEmpty()) {
			System.out.println(
					"\nThere are currently no options to consider. We have to have at least one \n(i.e. \"Become a powerful mage.\").\n>");
			options.add(s.nextLine());
			System.out.println("\nWondrous! Would you like to add more options? (type 0 or 1)\n>");

			while (i.nextInt() != 0) {
				System.out.println("\nAdd another option: \n>");
				options.add(s.nextLine());
				System.out.println("\nWould you like to add another option? (type 0 or 1)\n>");

			}
		}

		// System.out.println("\n=====CONTROL=====");
		// System.out.println("Criteria + weights: " + map);
		// System.out.println("Criteria: " + criteria);
		// System.out.println("Options: " + options);
		// System.out.println("=====/CONTROL====\n");

		assignScores();

	}

	public static void assignScores() {

		/*
		 * Ask how well does option x go with criterion y
		 */

		for (String o : options) {
			System.out.println("\nHow does option " + o + " work with criterion ");
			for (String c : criteria) {
				System.out.println(c);
				multimap.put(c, i.nextInt());

			}
		}

		/*
		 * Alternatively: Ask how well does criterion x go with option y
		 */
		// for (String c : criteria) {
		// System.out.println("\nHow does criterion " + c
		// + " work with option ");
		// for (String o : options) {
		// System.out.println(o);
		// multimap.put(o, i.nextInt());
		// }}

		calculateOptions();

	}

	public static void calculateOptions() {

		List<Object> weights = new ArrayList<>(map.values());

		// System.out.println("\n=====CONTROL=====");
		// System.out.println("Scores: " + multimap);
		// System.out.println("Weights: " + weights);

		// // Iterate through entries (E=3, E=4, F=6, F=9)
		// for (Object key : multimap.entries()) {
		// System.out.println(key);
		// }
		//
		// // Iterate thorugh all values (3, 6, 4, 9)
		// for (Object value : multimap.values()) {
		// System.out.println(value);
		// }
		//
		// // Iterate through all keys (E, F)
		// for (Object key2 : multimap.keySet()) {
		// System.out.println(key2);
		// }
		//
		// // Iterate over collections ([3, 6], [4, 9])
		// for (Collection collection : multimap.asMap().values()) {
		// System.out.println(collection);
		// }

		/*
		 * Turn options values into an instance of ArrayList "intValues"
		 */

		List<Integer> intValues = new ArrayList<>();

		for (Object value : multimap.values()) {
			int i = (Integer) value;
			intValues.add(i);
		}

		// System.out.println("Integer values: " + intValues);

		/*
		 * Turn criteria weights into an instance of ArrayList "intWeights"
		 */

		List<Integer> intWeights = new ArrayList<>();

		for (Object weight : weights) {
			int i = (Integer) weight;
			intWeights.add(i);
		}

		// System.out.println("Integer weights: " + intWeights);

		/*
		 * Create answers set set1 for an option 1"
		 */

		List<Integer> set1 = new ArrayList<>();

		for (int i = 0; i < intValues.size(); i += 2) {
			set1.add(intValues.get(i));
		}

		// System.out.println("Answers for " + options.get(0) + ":" + set1);

		/*
		 * Create answers set set2 for an option 2"
		 */

		List<Integer> set2 = new ArrayList<>();

		for (int i = 1; i < intValues.size(); i += 2) {
			set2.add(intValues.get(i));
		}

		// System.out.println("Answers for " + options.get(1) + ": " + set2);

		/*
		 * Create temporary array to hold relations between scores from set1 and
		 * weights
		 */

		for (int i : set1) {
			for (int j : intWeights) {
				temp.add(i * j);
			}
		}

		/*
		 * Take the first and the last element from temp and add it to results1,
		 * then clean temp
		 */

		results1.add(temp.get(0));
		results1.add(temp.get(temp.size() - 1));
		temp.clear();
		// System.out.println("Results for " + options.get(0) + ": " +
		// results1);

		/*
		 * Create temporary array to hold relations between scores from set2 and
		 * weights
		 */

		for (int i : set2) {
			for (int j : intWeights) {
				temp.add(i * j);
			}
		}

		/*
		 * Take the first and the last element from temp and add it to results1,
		 * then clean temp and present results
		 */

		results2.add(temp.get(0));
		results2.add(temp.get(temp.size() - 1));
		temp.clear();
		// System.out.println("Results for " + options.get(1) + ": " +
		// results2);

		// System.out.println("=====/CONTROL=====\n");

		compare();

	}

	public static void compare() {

		double sum1 = 0;
		for (int i : results1)
			sum1 += i;

		double sum2 = 0;
		for (int i : results2)
			sum2 += i;

		System.out.println("\nResults for " + options.get(0) + ": " + sum1 + " " + results1);
		System.out.println("Results for " + options.get(1) + ": " + sum2 + " " + results2 + "\n");

		if (sum1 > sum2) {
			System.out.println(options.get(0) + "is better.");
		} else {
			System.out.println(options.get(1) + " is better.");
		}

	}

}