package com.vaibhav1.codingexercise.company.facebook;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 *
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 *
 *
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 */
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class MergeKSortedLists {


    /**
     * Using Divide and Conquer. Start with first and last list and merge the pair.
     * After first iteration, there would be k/2 lists remaining. In second iteration, k/4, then k/8 and so on.
     *
     * Finally, there would be just one list left.
     *
     *
     * Total time complexity: Each outer iteration to pick up pairs take O(logK), merging two lists take O(N) and we do it for total K lists
     *
     * so time complexity is: O(n K logK)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0){
            return null;
        }

        if(lists.length == 1){
            return lists[0];
        }

        int last = lists.length - 1;

        while(last != 0){

            int i = 0;
            int j = last;

            while(i < j){

                lists[i]  = mergeTwo(lists[i++], lists[j--]);

                if(i >= j){
                    last = j;
                }

            }

        }

        return lists[0];


    }


    /**
     * Merge TWo LISTS
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwo(ListNode l1, ListNode l2){

        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while(l1 != null && l2 != null){

            if(l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }

            head = head.next;
        }

        if(l1!= null){
            head.next = l1;
        }

        if(l2!=null){
            head.next = l2;
        }

        return dummy.next;
    }
}
