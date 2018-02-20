/**
 * PROBLEM:
 * 
 * LookAndSay : Define a function as follows: Read of the digits of input counting the number of digits in groups of same digit.
 * 
 * Example:
 *    	lookAndSay(1) 	- 	"11"  	Because it reads "one 1" or 11
 * 	lookAndSay(11) 	-	"21"  	Because it reads "two 1s" or 21
 * 	lookAndSay(21)	-	"1211"	Because it reads off as "one 2 one 1" or 1211
 * 
 * In similar way we generate the LookAndSay String for any given number. 
 * Now, given a number 'start' and iteration 'n' , calculate the nth number in LookAndSay sequence starting with 'start'.
 * 
 * Using the above example : if start = 11 and n=2 then lookAndSay(11,2) = lookAndSay(lookAndSay(11)) = "1211"
 * 
 * 
 */
package com.vaibhav1.codingexercise;

/**
 * @author vshukla
 *
 */
public class LookAndSay {
	
	
	/**
	 * Methods takes in a start and iteration n and returns the nth string in LookandSay sequence starting with start.
	 */ 
	public static String lookAndSay(int start, int n){
		
		String num = String.valueOf(start);
		for(int i=1;i<=n;i++){
			num = lookAndSayString(num);
		}
		
		return num;
	}
	

	/**
	 * Method converts a given string into its lookandsay string.
	 */ 
	private static String lookAndSayString(String number) {
		StringBuilder result= new StringBuilder();
		 
		char repeat= number.charAt(0);
		number= number.substring(1) + " ";
		int times= 1;
	 
		for(char actual: number.toCharArray()){
			if(actual != repeat){
				result.append(times + "" + repeat);
				times= 1;
				repeat= actual;
			}else{
				times+= 1;
			}
		}
		return result.toString();
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(lookAndSay(11, 2));

	}

}
