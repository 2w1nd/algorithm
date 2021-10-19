package com.w1nd.algorithm.list;

/**
 * 环形链表，快慢指针
 */
public class CycleList {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) return true;
        }
        return false;
    }
}
