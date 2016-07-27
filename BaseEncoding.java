/**
 * 
 */
package com.expedia.code;

/**
 * @author vshukla
 *
 */
public class BaseEncoding {

	public static final int BASE = 7;

	public static String convert(long input){
		String convertedStr = convertToBase7(input, BASE);
		return encode(convertedStr);
	}
	
	
	public static String convertToBase7(long number, long base) {
		
		long quotient = number / base;
		long remainder = number % base;

		if (quotient == 0) // base case
		{
			return Long.toString(remainder);
		} else {
			return convertToBase7(quotient, base) + Long.toString(remainder);
		}
	}

	private static String encode(String num) {
		StringBuilder encoding = new StringBuilder("");

		for (char numChar : num.toCharArray()) {

			switch (numChar) {
				case '0': {
					encoding.append("0");
					break;
				}
				case '1': {
					encoding.append("a");
					break;
				}
				case '2': {
					encoding.append("t");
					break;
				}
				case '3': {
					encoding.append("l");
					break;
				}
				case '4': {
					encoding.append("s");
					break;
				}
				case '5': {
					encoding.append("i");
					break;
				}
				case '6': {
					encoding.append("n");
					break;
				}
			}
		}

		return encoding.toString();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(convert(7792875));
		
			
	}

}
