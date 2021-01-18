package com.algo;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class TestMinimumPlatforms extends TestCase{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testFindPlatform() {
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
		int n = 6;
		assertEquals(3, MinimumPlatforms.findPlatform(arr, dep, n));
	}

}
