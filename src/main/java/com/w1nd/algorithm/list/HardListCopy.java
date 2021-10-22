package com.w1nd.algorithm.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制：1.哈希表 2. 在每个结点后面再创建一个结点
 */
public class HardListCopy {
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
    // 解法1
    class Solution1 {
        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap<>();
            Node cur = head;
            while (cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            return map.get(head);
        }
    }

    // 解法2
    class Solution {
        public Node copyRandomList(Node head) {
            Node cur = head;
            while (cur != null) {
                Node p = new Node(cur.val);
                Node tmp = cur.next;
                cur.next = p;
                p.next = tmp;
                cur = tmp;
            }
            cur = head;
            while (cur != null) {
                if (cur.random != null) cur.next.random = cur.random.next;
                cur = cur.next.next;
            }
            Node dummy = new Node(-1);
            dummy.next = head;
            cur = dummy;
            for (Node p = head; p != null; p = p.next) {
                cur.next = p.next;
                cur = cur.next;
                p.next = p.next.next;
            }
            return dummy.next;
        }
    }
}
