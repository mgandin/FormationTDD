package com.octo.ocr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class OcrTest {

	private Ocr ocr;
	
	@Before
	public void setUp()
	{
		ocr = new Ocr();
	}
	
	private void verifyResultEqualsExpected(String input, String expected) {
		// When
		String result = ocr.read(input);		
		// Then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void shouldReturnEmptyIfInputIsEmpty() {
		// Given
		String s = "";
		verifyResultEqualsExpected(s, "");
	}
	@Test
	public void shouldReturnZeroIfInputIsZero() {
		// Given
		String input = //
				" _ \n" + //
				"| |\n" + //
				"|_|\n"; //
		verifyResultEqualsExpected(input, "0");
	}
	@Test
	public void shouldReturnOneIfInputIsOne() {
		// Given
		String input = //
				"   \n" + //
				"  |\n" + //
				"  |\n"; //
		verifyResultEqualsExpected(input, "1");
	}

	@Test
	public void shouldReturnTwoIfInputIsTwo() {
		// Given
		String input = //
			" _ \n" + //
			" _|\n" + //
			"|_ \n"; //
		verifyResultEqualsExpected(input, "2");
	}
	@Test
	public void shouldReturnThreeIfInputIsThree() {
		// Given
		String input = //
			" _ \n" + //
			" _|\n" + //
			" _|\n"; //
		verifyResultEqualsExpected(input, "3");
	}
	
	@Ignore
	@Test
	public void shouldReturn01WhenInputIs01()
	{
		// Given
		String input = //
			" _    \n" + //
			"| |  |\n" + //
			"|_|  |\n"; //
		verifyResultEqualsExpected(input, "01");
	}
}
