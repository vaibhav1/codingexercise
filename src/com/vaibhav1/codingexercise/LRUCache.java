package com.vaibhav1.codingexercise;


import java.util.HashMap;
import java.util.Map;

class Node {

    String key;
    String value;

    Node next;
    Node prev;

    public Node(String key, String value){
        this.value = value;
        this.key = key;
    }

}

public class LRUCache {

    Map<String, Node> lruCache;
    int capacity;

    Node head;
    Node tail;

    public LRUCache(int capacity){
        this.lruCache = new HashMap<String, Node>();
        this.capacity = capacity;
    }


    public String get(String key){

        if(!lruCache.containsKey(key)){
            return null;
        }
        Node cached = lruCache.get(key);
        removeNode(cached);
        setHead(cached);
        return cached.value;
    }


    public  void put(String key, String value){

        if(lruCache.containsKey(key)){
            Node cached = lruCache.get(key);
            cached.value  = value;
            removeNode(cached);
            setHead(cached);
        } else {

            if (lruCache.size() == capacity) {
                lruCache.remove(tail.key);
                removeNode(tail);

            }

            Node node = new Node(key, value);
            lruCache.put(key, node);
            setHead(node);

        }
    }

    public void setHead(Node node){
        if(head == null){
            head  = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;
        }
    }

    public void removeNode(Node n){
        if(n.prev!=null){
            n.prev.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next!=null){
            n.next.prev = n.prev;
        }else{
            tail = n.prev;
        }
    }

    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.put("A", "A");
        cache.print();
        cache.put("B", "B");
        cache.print();
        cache.put("C", "C");
        cache.print();
        cache.put("D", "D");
        cache.print();

        cache.get("A");
        cache.print();
        cache.put("E", "E");
        cache.print();
        cache.get("C");
        cache.print();
        cache.get("E");
        cache.print();
        cache.put("B", "B");
        cache.print();
        cache.get("D");
        cache.print();

    }
}
