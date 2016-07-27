/** 
 *  PROBLEM :
 * 
 *  Convert a given number to base 7 String using following encoding :
 *  0  1  2  3  4  5  6
 *  0  a  d  r  t  i  s
 */
package com.demo.code;

/**
 * @author vshukla
 *
 */
public class BaseEncoding {

	public static final int BASE = 7;

	/**
	 * Method to convert given long number to String with specfied encoding 
	 */
	public static String convert(long input){
		String convertedStr = convertToBase7(input, BASE);
		return encode(convertedStr);
	}
	
	/**
	*  Converts a given long number to the given base
	*/
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

	/**
	 *  Takes in a base converted String and encodes it with given encoding 
	 */
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
					encoding.append("d");
					break;
				}
				case '3': {
					encoding.append("r");
					break;
				}
				case '4': {
					encoding.append("t");
					break;
				}
				case '5': {
					encoding.append("i");
					break;
				}
				case '6': {
					encoding.append("s");
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
