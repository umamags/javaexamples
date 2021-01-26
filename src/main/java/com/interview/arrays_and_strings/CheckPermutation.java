package com.interview.arrays_and_strings;

/* Check Permutation: Given two strings, write a method to decide if one is a permutation of the other. */
/* If two strings are permutations, then we know they have the same characters, but in different orders. Therefore,
sorting the strings will put the characters from two permutations in the same order. We just need to
compare the sorted versions of the strings
*/
public class CheckPermutation {
	static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}

	static boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}

	static boolean permutation2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] letters = new int[128]; // Assumption
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			letters[c]++;
		}
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			letters[c]--;
			if (letters[c] < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] str1 = { "Elephant", "Lion", "elephant", "tiger", "Malayalam" };
		String[] str2 = { "elEhpatn", "Line", "elelkant", "rgit", "Mlaaylaam" };

		int i = 0;
		for (String elem1 : str1) {
			String elem2 = str2[i++];
			System.out.println(elem1 + " and " + elem2 + " are permutations:: " + permutation2(elem1, elem2));
		}
	}
}