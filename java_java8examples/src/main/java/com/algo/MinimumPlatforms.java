package com.algo;

public class MinimumPlatforms {
	public static int findPlatform(int arr[], int dep[], int n) {
		int plat_needed = 1, result = 1;
		int i = 1, j = 0;

		// Similar to merge in merge sort to process all events
		while (i < n && j < n) {
			if (arr[i] < dep[j]) {
				plat_needed++;
				i++;
				if (plat_needed > result) // Update result if needed
					result = plat_needed;
			} else // Else decrements count of platforms needed
			{
				plat_needed--;
				j++;
			}
		}

		return result;
	}

}
