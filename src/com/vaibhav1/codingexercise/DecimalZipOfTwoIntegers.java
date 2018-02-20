/**
 * 
 */
package com.vaibhav1.codingexercise;

/**
 * @author vshukla
 * Problem: Decimal zip C of two integers A and B is the combination of alternate digits of A and B.
 * 			If one number runs out of digits, all the other digits of other numbers is appended as zip.
 * 			For example: Decimal zip of 12 and 56 will be 1526.
 * 						 Decimal zip of 23 and 691 will be 26391
 * 			Return -1 if the result exceeds 1,00,000,000
 */
public class DecimalZipOfTwoIntegers {

	
	public static void main(String[] args) {
		int a = 12345;
		int b = 0000;
		
		System.out.println(findDecimalZip(a, b));
	}
	
	public static int findDecimalZip(int a, int b){
		String A = String.valueOf(a);
		String B = String.valueOf(b);
		
		int i=0, j=0;
		StringBuilder sb = new StringBuilder("");
		while(i<A.length() && j<B.length()){
			sb.append(A.charAt(i++));
			sb.append(B.charAt(j++));
		}
		
		if(i<A.length()){
			sb.append(A.substring(i));
		}
		
		if(j<B.length()){
			sb.append(B.substring(j));
		}
		
		if(sb.toString().length() >= "100000000".length()){
			return -1;
		}
		
		return Integer.parseInt(sb.toString());
	}
}
