package com.octo.ocr;

import java.util.HashMap;
import static com.octo.ocr.OcrConstantes.*;

public class Ocr {

	private static HashMap<String, String> convertingTable = new HashMap<String, String>();	

	static {
		mapFiller();
	}

	public String read(String input) {
		
		
		return convertingTable.get(input);
	}

	private static void mapFiller() {
		convertingTable.put(EMPTY, EMPTY);
		convertingTable.put(ZERO_STR, ZERO);
		convertingTable.put(ONE_STR, ONE);
		convertingTable.put(TWO_STR, TWO);
		convertingTable.put(THREE_STR, THREE);
	}

}
