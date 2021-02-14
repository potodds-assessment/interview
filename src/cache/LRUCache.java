package cache;

import java.util.HashMap;

/*
 * Least Recently Used Cache
 * Internally cache uses a hashmap to store values.
 * Each node is linked to previous node and to next node.
 * To remove a current node, point current node's previous node to current node's next node.
 * There is also a pointer to the head node and the tail node.  
 * 
 * least recently used is achieved by moving recently used items to the tail.
 * 
 */

public class LRUCache {
    NNode head;
    NNode tail;
    HashMap<Integer, NNode> map = null;
    int cap = 0;
 
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
    }
 
    public int get(int key) {
        if (map.get(key)==null) {
            return -1;
        }
 
        //move to tail
        NNode t = map.get(key);
 
        removeNNode(t);
        offerNNode(t);
 
        return t.value;
    }
 
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            NNode t = map.get(key);
            t.value = value;
 
            //move to tail
            removeNNode(t);
            offerNNode(t);
        } else {
            if (map.size()>=cap) {
                //delete head
                map.remove(head.key);
                removeNNode(head);
            }
 
            //add to tail
            NNode NNode = new NNode(key, value);
            offerNNode(NNode);
            map.put(key, NNode);
        }
    }
 
    private void removeNNode(NNode n){
        if (n.prev != null) {
            n.prev.next = n.next;
        } else {
            head = n.next;
        }
 
        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            tail = n.prev;
        }
    }
 
    private void offerNNode(NNode n){
        if (tail != null) {
            tail.next = n;
        }
 
        n.prev = tail;
        n.next = null;
        tail = n;
 
        if (head == null) {
            head = tail;   
        }
    }
}

class NNode {
    int key;
    int value;
    NNode prev;
    NNode next;
 
    public NNode(int key, int value){
        this.key=key;
        this.value=value;
    }
}