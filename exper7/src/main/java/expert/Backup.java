//package expert;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Scanner;
//
//public class Backup {
//	protected static String question;
//	static Scanner s = new Scanner(System.in);
//	static Scanner i = new Scanner(System.in);
//
//	protected static List<String> criteria = new ArrayList<String>();
//	protected static List<String> options = new ArrayList<String>();
//
//	public static void main(String[] args) {
//
//		formulateQuestion();
//		System.out.println("Let\'s see... \n");
//
//		newCriterion();
//
//		newOption();
//
//		exit();
//
//	}
//
//	public static String formulateQuestion() {
//
//		System.out
//				.println("I am Exper7, your expert at most things quantifiable. "
//						+ "\nFormulate the question and I shall formulate a solution, Master! \n>");
//		question = s.nextLine();
//		return question;
//
//	}
//
//	public static void newCriterion() {
//
//		while (criteria.isEmpty()) {
//			System.out
//					.println("There are currently no criteria to consider. We have to have at least one (i.e. \"SURVIVAL\").\n>");
//			criteria.add(s.nextLine());
//			System.out
//					.println("\nWondrous! Would you like to add more? (type 0 or 1)\n>");
//
//			while (i.nextInt() != 0) {
//				System.out.println("\nAdd another one: \n>");
//				criteria.add(s.nextLine());
//				System.out
//						.println("\nWould you like to add another one? (type 0 or 1)\n>");
//
//			}
//
//		}
//
//		assignWeights();
//
//	}
//
//	public static void assignWeights() {
//
//		/*
//		 * Map weights to criteria
//		 */
//
//		HashMap<String, Object> map = new HashMap<String, Object>();
//
//		// optional list:
//		// static List<String> weights = new ArrayList<String>();
//
//		System.out.println("\nYour criteria: " + criteria.toString());
//		System.out.println("Assign values 1-10 in a proper order: \n>");
//		// TODO: .matches("^([1-9]|10)$")
//
//		for (String c : criteria) {
//			map.put(c, i.nextInt());
//		}
//
//		System.out.println("\nWeights for criteria: " + map);
//
//	}
//
//	public static void exit() {
//
//		System.out.println("\nWHAYT THIS WORKS SO FAR RAIT????");
//		System.exit(0);
//	}
//
//	public static void newOption() {
//
//		while (options.isEmpty()) {
//			System.out
//					.println("\nThere are currently no options to consider. We have to have at least one \n(i.e. \"Don't attack the mother bear.\").\n>");
//			options.add(s.nextLine());
//			System.out
//					.println("\nWondrous! Would you like to add more options? (type 0 or 1)\n>");
//
//			while (i.nextInt() != 0) {
//				System.out.println("\nAdd another option: \n>");
//				options.add(s.nextLine());
//				System.out
//						.println("\nWould you like to add another option? (type 0 or 1)\n>");
//
//			}
//		}
//
//		assignScores();
//
//	}
//
//	public static void assignScores() {
//
//		/*
//		 * Map options to criteria by scores
//		 */
//
//		HashMap<String, Object> map2 = new HashMap<String, Object>();
//
//		System.out.println("\nSo your options are: " + options);
//		System.out.println("Assign scores 1-10 in a proper order: \n>");
//		// TODO: .matches("^([1-9]|10)$")
//		
//		for (String o : options) {
//			map2.put(o, i.nextInt());
//		}
//
//		
//		
//		System.out.println("\nWeights for criteria: " + map2);
//
//	}
//
//	public static void compare() {
//
//		/*
//		 * This is the hardest part. I'll calculate the option based on scores *
//		 * weights
//		 */
//
//		System.out.println("Criteria: " + criteria);
//		System.out.println("Options: " + options);
//		
//	}
//}
//
