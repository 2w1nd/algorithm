package com.w1nd.algorithm.list;

import java.util.HashMap;
import java.util.Map;

/**
 *146. LRU 缓存机制（重点）：双向链表+哈希表
 */
public class LRU {
    class LRUCache {

        class Node {
            int key, val;
            Node prev, next;
            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Map<Integer, Node> map = new HashMap<>();
        int n ;
        Node L = new Node(-1, -1);
        Node R = new Node(-1, -1);

        public LRUCache(int capacity) {
            L.next = R;
            R.prev= L;
            n = capacity;
        }

        public void insert_node(Node p) {
            p.next = L.next;
            L.next.prev = p;
            L.next = p;
            p.prev = L;
        }

        public void delete_node(Node p) {
            p.prev.next = p.next;
            p.next.prev = p.prev;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node p = map.get(key);
                delete_node(p);
                insert_node(p);
                return p.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node p = map.get(key);
                p.val = value;
                delete_node(p);
                insert_node(p);
            } else {
                if (map.size() == n) {
                    Node p = R.prev;
                    delete_node(p);
                    map.remove(p.key);
                }
                Node p = new Node(key, value);
                map.put(key, p);
                insert_node(p);
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
