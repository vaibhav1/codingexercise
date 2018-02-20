/**
 * 
 */
package com.vaibhav1.codingexercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author vshukla
 * Problem: A queue of people standing on ground floor given with their weights and floor they need to go.
 * 			An elevator can take up to X people at a time with weight limit Y. There are total 0 to M floors.
 * 			Write a program to find how many times the elevator stops till there is nobody left on ground floor.
 */
public class ElevatorStopProblem {

	
	/*	A = Weights array
     *	B = Target floor
     *	M = No of floors
     *	X = Max capacity
     *	Y = Max weight
    */
	public static int numberOfElevatorStops(int []A, int []B, int M, int X, int Y){
		int stops = 0;
		
		if(A.length!=B.length){
			return 0;
		}
		
		int i = 0;
		while(i<A.length){
			
			int totalWeight = 0;
			int cap = 0;
			Set<Integer> uniqueFloors = new HashSet<Integer>();
			while(i<A.length && totalWeight+A[i] <= Y && cap<X){
				totalWeight +=A[i];
				uniqueFloors.add(B[i]);
				i++;
				cap++;
			}
			stops += uniqueFloors.size()+1;
		}
		
		return stops;
	}
	
	public static void main(String[] args) {
		
		int A[] = {40,40,100,80,20};
		int B[] = {3,3,2,2,3};
		int M = 3;
		int X = 5;
		int Y = 200;
		
		int stops = numberOfElevatorStops(A, B, M, X, Y);
		System.out.println(stops);
	}
	
}