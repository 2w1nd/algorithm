package com.w1nd.algorithm.list;

/**
 * 链表排序：使用归并排序的思想
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        int n = 0;
        for (ListNode k = head; k != null; k = k.next) n ++;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (int i = 1; i < n; i *= 2) {
            ListNode cur = dummy;
            for (int j = 0; j + i < n; j += i * 2) {
                ListNode first = cur.next, second = cur.next;
                for (int k = 0; k < i; k ++) second = second.next;
                int f = 0, s = 0;
                while (f < i && s < i && second != null) {
                    if (first.val < second.val) {
                        cur = cur.next = first;
                        first = first.next;
                        f ++;
                    }
                    else {
                        cur = cur.next = second;
                        second = second.next;
                        s ++;
                    }
                }
                while (f < i) {
                    cur = cur.next = first;
                    first = first.next;
                    f ++;
                }
                while (s < i && second != null)  {
                    cur = cur.next = second;
                    second = second.next;
                    s ++;
                }
                cur.next = second;
            }
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}