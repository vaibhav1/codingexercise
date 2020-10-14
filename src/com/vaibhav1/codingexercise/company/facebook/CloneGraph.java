package com.vaibhav1.codingexercise.company.facebook;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity sake, each node's value is the same as the node's index (1-indexed).
 * For example, the first node with val = 1, the second node with val = 2, and so on.
 * The graph is represented in the test case using an adjacency list.
 *
 * Adjacency list is a collection of unordered lists used to represent a finite graph.
 * Each list describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1.
 * You must return the copy of the given node as a reference to the cloned graph.
 *
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }

        Map<Integer, Node> map = new HashMap<Integer, Node>();

        return cloneGraphDFS(node, map);

    }

    private Node cloneGraphDFS(Node node, Map<Integer, Node> map) {

        if(map.containsKey(node.val)){
            return map.get(node.val);
        }

        Node copy = new Node(node.val);
        map.put(node.val, copy);

        for(Node neighbor: node.neighbors){

            copy.neighbors.add(cloneGraphDFS(neighbor, map));
        }

        return copy;
    }

}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

