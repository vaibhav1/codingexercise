/**
 * 
 */
package com.vaibhav1.codingexercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author vshukla
 *
 */
public class CheckPolygon {
	
	
	public static void findPolygons(List<String> sidesList){
		int squares = 0;
		int rectangles = 0;
		int others = 0;
		
		for(String sides: sidesList ){
			String [] side = sides.split(" ");
			int A = Integer.parseInt(side[0]);
			int B = Integer.parseInt(side[1]);
			int C = Integer.parseInt(side[2]);
			int D = Integer.parseInt(side[3]);
			
            if(A<=0||B<=0||C<=0||D<=0) {
				others++;
			}
            else if(A==B && B==C && C==D){
				squares++;
			}
			
			else if(A==C && B==D && A!=B){
				rectangles++;
			} else{
                others++;
            }
			
			
		}
		
		System.out.println(squares+" "+rectangles+" "+others);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		List<String> sides = new ArrayList<String>();
		while(in.hasNext()){
			sides.add(in.nextLine());
		}
		findPolygons(sides);
	}

}
