package com.visa.prj.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void testGetSum() {
		int[] data = {5, 6, 4};
		assertEquals(15, ArrayUtil.getSum(data));
		
		int[] elmns = {-1, 0, 1};
		assertEquals(0, ArrayUtil.getSum(elmns));
	}

	@Test
	public void testGetCount() {
		int[] elmns = {53, 67, 2, 67, 74, 67};
		assertEquals(3, ArrayUtil.getCount(elmns, 67));
	}

	@Test
	public void testSort() {
		int[] elmns = {53, 67, 2, 67, 74, 67};
		ArrayUtil.sort(elmns);
		int[] expect = {2, 53, 67, 67, 67, 74};
		assertArrayEquals(expect, elmns);
	}

}
