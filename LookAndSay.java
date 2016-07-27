/**
 * 
 */
package com.expedia.code;

/**
 * @author vshukla
 *
 */
public class LookAndSay {
	
	
	public static String lookAndSay(int start, int n){
		
		String num = String.valueOf(start);
		for(int i=1;i<=n;i++){
			num = lookAndSayString(num);
		}
		
		return num;
	}
	

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
