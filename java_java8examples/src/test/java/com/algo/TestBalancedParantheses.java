package com.algo;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class TestBalancedParantheses extends TestCase {

	@Test
	public void testIsValid() {
		assertEquals(true, BalancedParantheses.isValid("[01 This is a test]"));
		assertEquals(true, BalancedParantheses.isValid("[02 This is a ()test]"));
		assertEquals(false, BalancedParantheses.isValid("[03 [This is a test]"));
		assertEquals(false, BalancedParantheses.isValid("[04 (This is a test])"));
		assertEquals(true, BalancedParantheses.isValid("[05 This {is a } test]"));
	}

}
