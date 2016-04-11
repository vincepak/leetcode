package algorithms;

import java.util.ArrayList;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 * @author I047020
 *
 */
public class ExcelColumnTitle {
	int N = 26;
	char A = 'A';

	public String convertToTitle(int i) {
		/*
		 * 1~26, A~Z
		 * 
		 * >26 eg 27 i mod N = 1 / 1 AA
		 * 
		 * 701 i mod N = 26 25
		 */

		if (i < 1) {
			throw new IllegalArgumentException();
		}

		
		ArrayList<String> charList = new ArrayList<String>();
		int yu = i % N;// 余数
		charList.add("" + convertInt2Alphabeta(yu));
		int mod = i / N; // 商
		while (mod > 0) {
			i = mod;
			yu = i % N;// 余数
			charList.add("" + convertInt2Alphabeta(yu));
			mod = i / N; // 商
		}

		StringBuilder b = new StringBuilder();
		for(int j = 0; j<charList.size(); j++){
			b.append(charList.get(charList.size() -1 - j));
		}
		return b.toString();
	}

	private char convertInt2Alphabeta(int i) {
		return (char) (A + i - 1);
	}

}
