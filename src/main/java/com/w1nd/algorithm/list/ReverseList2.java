package com.w1nd.algorithm.list;

/**
 * 92.反转链表2：翻转某区间的链表，先将该区间内的指针反转，在将头指针尾指针指好
 */
public class ReverseList2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode a = dummy;
            for (int i = 0; i < left - 1; i ++) a = a.next;
            ListNode b = a.next;
            ListNode c = b.next;
            for (int i = 0; i < right - left; i ++) {
                ListNode tmp = c.next;
                c.next = b;
                b = c;
                c = tmp;
            }
            a.next.next = c;
            a.next = b;
            return dummy.next;
        }
    }
}
