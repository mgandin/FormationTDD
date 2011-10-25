package com.octo.ocr;

import java.util.List;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import static com.octo.ocr.OcrConstantes.*;


public class ChainSawTest {
	@Test
	public void shouldReturnStringListWhenInputBlock()
	{
		//Given
		String input = ZERO_STR;
		Chainsaw chainsaw = new Chainsaw();
		//When
		List <String> actual = chainsaw.split(input);
		//Then
		Assert.assertEquals(ZERO_STR, actual.get(0));
	}
	
	@Test
	public void shouldReturn01ListWhenInputBlockis01string()
	{
		//Given
		String input = //
			" _    \n" + //
			"| |  |\n" + //
			"|_|  |\n"; //
		Chainsaw chainsaw = new Chainsaw();
		//When
		List <String> actual = chainsaw.split(input);
		//Then
		Assert.assertEquals(ZERO_STR, actual.get(0));
		Assert.assertEquals(ONE_STR, actual.get(1));
	}
}
