package com.vaibhav1.codingexercise.company.facebook;

import java.util.HashMap;
import java.util.Map;


/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 *
 *
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {

        if(head == null){
            return null;
        }

        Map<Node, Node> map = new HashMap<Node, Node>();

        return copyRandomUtil(head, map);
    }

    private Node copyRandomUtil(Node head, Map<Node, Node> map){

        if(head == null){
            return null;
        }

        if(map.containsKey(head)){
            return map.get(head);
        }

        Node copy = new Node(head.val, null, null);
        map.put(head, copy);

        copy.next = copyRandomUtil(head.next, map);
        copy.random = copyRandomUtil(head.random, map);

        return copy;

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}


