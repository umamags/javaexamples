package com.interview.arrays_and_strings;

public class CheckIfUniqueChars {
	boolean isUniqueChars(String str) {
		if (str.length() > 128)
			return false;

		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {// Already found this char in string
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	boolean isUniqueChars2(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}

	public static void main(String[] args) {
		CheckIfUniqueChars obj = new CheckIfUniqueChars();
		String[] str = { "Elephant", "Lion", "elephant", "tiger", "Malayalam" };

		for (String elem : str) {
			System.out.println(elem + "::Has unique chars:: " + obj.isUniqueChars2(elem));
		}

	}
}
