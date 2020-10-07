package com.vaibhav1.codingexercise.company.facebook;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 */
public class SerializeDeserializeBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();

    }

    private void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
            return;
        }

        sb.append(root.val);
        sb.append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        LinkedList<String> list = new LinkedList<String>(Arrays.asList(data.split(",")));
        return buildTree(list);
    }

    private TreeNode buildTree(LinkedList<String> list){

        String node = list.removeFirst();
        if("#".equals(node)){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = buildTree(list);
        root.right = buildTree(list);

        return root;

    }

}
