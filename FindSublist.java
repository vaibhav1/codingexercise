/**
 * PROBLEM :
 * 
 * Given two lists : mainList and subList, return the index of subList present in mainList. 
 * In other words, given two lists, return the starting index where the second list is present as sublist in first list.
 * Return -1 is sublist is not present.
 * 
 * Example:
 * 1.  mainList = {1,2,3,4,5}
 *     subList =  {3,4,5}      .... returns 2
 * 
 * 2.  mainList = {a,b,c,d,e}
 *     subList =  {c,c,d,e}   .... returns -1 because no sublist found
 */
package com.demo.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/**
 * @author vshukla
 *
 */
public class FindSublist {
	
	public static LinkedListNode head1 ;
	public static LinkedListNode head2 ;
	
	/**
	 * Helper methods to add nodes in first list. Used for demonstration.
	 */
	static void addNodeH1(String val){
		LinkedListNode node = new LinkedListNode(val);
		if(head1 == null){
			head1 = node;
		} else {
			LinkedListNode temp = head1;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
	/**
	 * Helper method to add nodes to second list.
	 */
	static void addNodeH2(String val){
		LinkedListNode node = new LinkedListNode(val);
		if(head2 == null){
			head2 = node;
		} else {
			LinkedListNode temp = head2;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
	/**
	 * helper method to print the content of the list.
	 */
	static void print(LinkedListNode head){
		LinkedListNode temp = head;
		while(temp!=null){
			System.out.print(temp.val+"-->");
			temp = temp.next;
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		addNodeH1("1");
		addNodeH1("2");
		addNodeH1("3");
		addNodeH1("4");
		addNodeH1("5");
//		addNodeH1("15");
		
		print(head1);
		
		addNodeH2("3");
		addNodeH2("3");
		addNodeH2("4");
		addNodeH2("5");
		
		print(head2);
		
		int isFound = find(head1, head2);
		
		
		if(isFound != -1){
			System.out.println("sub list found");
		} else{
			System.out.println("NOT FOUND");
		}
		
		System.out.println("index is:"+isFound);
	}

	
	
	/**
	 * Method converts the given LinkedLists to ArrayLists. 
	 * Then uses Collections API to find starting index of second list present in first.
	 */ 
	private static int find(LinkedListNode node1, LinkedListNode node2) {
			
		List<String> mainList = new ArrayList<String>();
		List<String> subList = new ArrayList<String>();
		
		while(node1!=null){
			mainList.add(node1.val);
			node1=node1.next;
		}
		
		while(node2!=null){
			subList.add(node2.val);
			node2=node2.next;
		}
		
		System.out.println(mainList.containsAll(subList));
		int index = Collections.indexOfSubList(mainList, subList);
		
		return index;
	}



	/**
	 * Inner node class.
	 */ 
	static class LinkedListNode{
		String val;
		LinkedListNode next;
		
		LinkedListNode(String node_value){
			val=node_value;
			next = null;
		}
		
		
	};
	
	
}
