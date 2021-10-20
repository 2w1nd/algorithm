package com.w1nd.algorithm.hash;

/**
 * 设计一个哈希表：使用拉链法
 */
public class DesignHashMap {
    class MyHashMap {
        class Node {
            int key, val;
            Node next;
            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Node[] data;
        static final int maxN = 1331;

        public MyHashMap() {
            data = new Node[maxN];
        }

        // 向哈希表中添加元素
        public void put(int key, int value) {
            int index = key % maxN;
            if (data[index] == null) {  // 增加一条链表
                data[index] = new Node(key, value);
            } else {  // 在该链表后添加或修改元素
                append(data[index], key, value);
            }
        }

        // 在某结点链表后添加或修改元素
        public void append(Node node, int key, int value) {
            Node pre = node;
            while (node != null) {
                if (node.key == key) {
                    node.val = value;
                    return ;
                }
                pre = node;
                node = node.next;
            }
            pre.next = new Node(key, value);
        }

        // 获得哈希表对应的元素
        public int get(int key) {
            int index = key % maxN;
            Node cur = data[index];
            if (cur == null) return -1;
            while (cur != null) {
                if (cur.key == key) return cur.val;
                cur = cur.next;
            }
            return -1;
        }

        // 删除哈希表中key对应的元素
        public void remove(int key) {
            int index = key % maxN;
            Node node = data[index];
            if (node == null) return ;
            Node pre = node;
            while (node != null) {
                if (node.key == key) {
                    if (pre == node) data[index] = node.next;
                    else pre.next = node.next;
                    return ;
                }
                pre = node;
                node = node.next;
            }
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
