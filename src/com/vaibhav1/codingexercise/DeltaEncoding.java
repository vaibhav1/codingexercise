/**
 * 
 */
package com.vaibhav1.codingexercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vshukla
 *
 */
public class DeltaEncoding {

	public static void deltaEncoding(List<Integer> input) {
		List<Integer> encodedResult = new ArrayList<Integer>();
		encodedResult.add(input.get(0));
		int prevValue = input.get(0);
		for (int i = 1; i < input.size(); i++) {

			int delta = input.get(i) - prevValue;
			if (delta < -127 || delta > 127) {
				encodedResult.add(-128);
			}
			encodedResult.add(delta);
			prevValue = input.get(i);

		}
		
		for(Integer i: encodedResult){
			System.out.print(i+" ");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(25626);
		list.add(25757);
		list.add(24367);
		list.add(24267);
		list.add(16);
		list.add(100);
		list.add(2);
		list.add(7277);
		deltaEncoding(list);
		
	}

}
