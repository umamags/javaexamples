package com.interview.arrays_and_strings;

/*
 * Given a string, write a function to check if it is a permutation of
a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
permutation is a rearrangement of letters. The palindrome does not need to be limited to just
dictionary words.

What does it take to be able to write a set of characters the same way forwards and backwards? We need to
have an even number of almost all characters, so that half can be on one side and half can be on the other
side. At most one character (the middle character) can have an odd count.

 */
public class CheckPalindromePermutation {
	boolean isPermutationOfPalindrome(String phrase) {
		int[] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}

	/* Check that no more than one character has an odd count. */
	boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}

	/*
	 * Map each character to a number. a -> 0, b -> 1, c -> 2, etc. This is case
	 * insensitive. Non-letter characters map to -1.
	 */
	int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}

	/* Count how many times each character appears. */
	int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x]++;
			}
		}
		return table;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = { "Odomama", "Lion", "elephant", "tiger", "Malayalam" };

		for (String elem : str) {
			System.out.println(elem + "::is permutation palindrome:: " + new CheckPalindromePermutation().isPermutationOfPalindrome(elem));
		}

	}

}
