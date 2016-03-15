/* 
 * Exper7 is a basic expert system built to aid decision-making of the powerful mage that created it out of abstract objects.
 */

/*
 * 1. Formulate question by keyboard input, store in a static String	
 * 2. Feed with next criterion (make method A that 1) adds new criterion to an array of criteria and assign weight points to it or 2) breaks the method)
 * 3. After method A breaks, formulate option 1, store it in a static String (make method B that 1) adds new option with points to criteria, or 2) breaks the method) 
 * 4. After method B breaks, calculate best option
 */

package expert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Main {

	protected static String question;
	static Scanner s = new Scanner(System.in);
	static Scanner i = new Scanner(System.in);

	protected static List<String> criteria = new ArrayList<String>();
	protected static List<String> options = new ArrayList<String>();
	protected static HashMap<String, Object> map = new HashMap<String, Object>();
	protected static Multimap<Object, Object> multimap = ArrayListMultimap
			.create();

	public static void main(String[] args) {

		formulateQuestion();
		System.out.println("Let\'s see... \n");
		newCriterion();
		newOption();
		exit();

	}

	public static String formulateQuestion() {

		System.out
				.println("I am Exper7, your expert at most things quantifiable. "
						+ "\nFormulate the question and I shall formulate a solution, Master! \n>");
		question = s.nextLine();
		return question;

	}

	public static void newCriterion() {

		while (criteria.isEmpty()) {
			System.out
					.println("There are currently no criteria to consider. We have to have at least one (i.e. \"SURVIVAL\").\n>");
			criteria.add(s.nextLine());
			System.out
					.println("\nWondrous! Would you like to add more? (type 0 or 1)\n>");

			while (i.nextInt() != 0) {
				System.out.println("\nAdd another one: \n>");
				criteria.add(s.nextLine());
				System.out
						.println("\nWould you like to add another one? (type 0 or 1)\n>");

			}

		}

		assignWeights();

	}

	public static void assignWeights() {

		/*
		 * Map weights to criteria
		 */

		System.out.println("\nYour criteria: " + criteria.toString());
		System.out.println("Assign values 1-10 in a proper order: \n>");
		// TODO: .matches("^([1-9]|10)$")

		for (String c : criteria) {
			map.put(c, i.nextInt());

		}

		System.out.println("\nWeights for criteria: " + map);

	}

	public static void exit() {

		System.out.println("\nWHAYT THIS WORKS SO FAR RAIT????");
		System.exit(0);

	}

	public static void newOption() {

		while (options.isEmpty()) {
			System.out
					.println("\nThere are currently no options to consider. We have to have at least one \n(i.e. \"Don't attack the mother bear.\").\n>");
			options.add(s.nextLine());
			System.out
					.println("\nWondrous! Would you like to add more options? (type 0 or 1)\n>");

			while (i.nextInt() != 0) {
				System.out.println("\nAdd another option: \n>");
				options.add(s.nextLine());
				System.out
						.println("\nWould you like to add another option? (type 0 or 1)\n>");

			}
		}

		assignScores();

	}

	public static void assignScores() {

		/*
		 * iterate what over what How does option [Mage] work with criterion
		 * [Money] key? Assign value How does option [Mage] work with criterion
		 * [Fame] key? Assign value How does option [Dragon] work with criterion
		 * [Money] key? Assign value How does option [Dragon] work with
		 * criterion [Fame] key? Assign value ...
		 */

		System.out.println("\n=====CONTROL=====");
		System.out.println("Criteria + weights: " + map);
		System.out.println("Criteria: " + criteria);
		System.out.println("Options: " + options);
		for (Object value : map.values()) {
			System.out.println(value);
		}
		System.out.println("=====/CONTROL====\n");

		/*
		 * The problem with the below is that it does add just one set of
		 * entries (last one). Therefore, use multimap.
		 */

		for (String o : options) {
			System.out.println("\nHow does option " + o
					+ " work with criterion ");
			for (String c : criteria) {
				System.out.println(c);
				multimap.put(c, i.nextInt());

			}
		}

		calculateOptions();

	}

	public static void calculateOptions() {

		/*
		 * So HashMap map contains data on criteria-weights, map2 on
		 * criteria-scores Now you have to do weights*scores and then assign
		 * results to a HashMap<option, result> Then you have to sort that hash
		 * map and print the results. Voila!
		 */

		List<Object> weights = new ArrayList<Object>(map.values());

		System.out.println("\n=====CONTROL=====");
		System.out.println("\nScores are: " + multimap);
		System.out.println("Weights are: " + weights);

		/*
		 * 1) Take 1st value from 1st element of multimap, multiply it by 1st
		 * value of list weights 2) While it exists, take 2 value from 2 key of
		 * multimap, multiply it by second value of list weights 3) While it
		 * exists, take...
		 */

		// Iterate through entries (E=3, E=4, F=6, F=9)
		for (Object key : multimap.entries()) {
			System.out.println(key);
		}

		// Iterate thorugh all values (3, 6, 4, 9)
		for (Object value : multimap.values()) {
			System.out.println(value);
		}

		// Iterate through all keys (E, F)
		for (Object key2 : multimap.keySet()) {
			System.out.println(key2);
		}

		// Iterate over collections ([3, 6], [4, 9])
		for (Collection collection : multimap.asMap().values()) {
			System.out.println(collection);
		}

		System.out.println("=====/CONTROL====\n");

		/*
		 * This would work if these were integers. Cast to integers first.
		 */

		List<Integer> intValues = new ArrayList<Integer>();

		for (Object value : multimap.values()) {
			int i = (Integer) value;
			intValues.add(i);
		}

		List<Integer> intWeights = new ArrayList<Integer>();

		for (Object weight : weights) {
			int i = (Integer) weight;
			intWeights.add(i);
		}

		System.out.println("\n=====CONTROL=====");
		System.out.println("Integer values: " + intValues);
		System.out.println("Integer weights: " + intWeights);
		System.out.println("=====/CONTROL====\n");

		/*
		 * 1. Multiply first element of first collection by first element in
		 * intWeights 2. Multiply second element of first collection by second
		 * element in intWeights 3. Multiply first element of second collection
		 * by first element in intWeights 4. Multiply second element of second
		 * collection by second element in intWeights
		 */

		for (Collection collection : multimap.asMap().values()) {
			
			//Convert multimap to an array of integers
			Integer[] array = (Integer[]) (collection.toArray(new Integer[collection.size()]));

			//For every integer in that array 
			for (int a : array) {
				System.out.println(a);
				
			}
			
			
		}

	}

}
