/**
 * 
 */
package com.vaibhav1.codingexercise;

import java.util.Arrays;

/**
 * @author vshukla Problem: A valid password is one which contains at least one
 *         upper case letter and does not contain any digit. Given a String S
 *         containing N alphanumeric characters. Find the longest substring of S
 *         that is a valid password. For example: Given "a0Ba", method should
 *         return 2 as "Ba" is the valid password. Given "a0bb", method should
 *         return -1 as there is no substring satisfying the above condition.
 */
public class LongestSubStringWithValidPassword {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String input = "a0bb";

		String answer = solutionInJava8(input);

		if (answer.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(answer.length());
		}
	}

	/**
	 * A solution with Java 8 features.
	 * 
	 * Arrays.stream(input.split("[0-9]+")) splits the original string into an array of strings. 
	 * The separator is any sequence of numbers (numbers aren't allowed so they serve as separators). 
	 * Then, a stream is created so I can apply functional operations and transformations.
	 *
	 * .filter(s -> s.matches("(.+)?[A-Z](.+)?")) keeps into the stream only strings that have at least one upper-case letter.
	 *
	 * .sorted((s1, s2) -> s2.length() - s1.length()) sorts the stream by length (desc).
	 * 
	 * .findFirst() tries to get the first string of the stream.
	 * 
	 * .orElse("") returns an empty string if no string was found.
	 * 
	 * @param input
	 * @return
	 */
	private static String solutionInJava8(String input) {
		String answer = Arrays.stream(input.split("[0-9]+")).filter(s -> s.matches("(.+)?[A-Z](.+)?"))
				.sorted((s1, s2) -> s2.length() - s1.length()).findFirst().orElse("");
		return answer;
	}
	
	/**
	 * Manipulating index variables for input String to find the solution.
	 * @param s
	 * @return
	 */
	public static String method1(String s){
		int i = 0;
		int longestStart = 0;
		int longestEnd = 0;
		while (i < s.length()) {
			
			// Skip past all the digits.
			while (i < s.length() && Character.isDigit(s.charAt(i))) {
				++i;
			}

			// i now points to the start of a substring
			// or one past the end of the string.
			int start = i;

			// Keep a flag to record if there is an uppercase character.
			boolean hasUppercase = false;

			// Increment i until you hit another digit or the end of the string.
			while (i < s.length() && !Character.isDigit(s.charAt(i))) {
				hasUppercase |= Character.isUpperCase(s.charAt(i));
				++i;
			}

			// Check if this is longer than the longest so far.
			if (hasUppercase && i - start > longestEnd - longestStart) {
				longestEnd = i;
				longestStart = start;
			}
		}
		
		String validPassword = s.substring(longestStart, longestEnd);
		return validPassword;
	}

}
