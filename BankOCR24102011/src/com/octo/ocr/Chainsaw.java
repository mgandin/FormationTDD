package com.octo.ocr;

import java.util.ArrayList;
import java.util.List;

public class Chainsaw {

	private static final String EOL = "\n";
	private static final int BLOCK_LEN = 3;

	public List<String> split(String input) {
		List<String> numbers;
		numbers = new ArrayList<String>();

		String[] lines = input.split(EOL);
		StringBuilder block = new StringBuilder();

		for (int index = 0; index < lines[0].length() / BLOCK_LEN; index++) {

			block.delete(0, block.length());
			for (String line : lines) {

				block.append(line.substring(index * BLOCK_LEN, (index + 1)
						* BLOCK_LEN));
				block.append(EOL);
			}
			numbers.add(block.toString());
		}

		return numbers;
	}

}
