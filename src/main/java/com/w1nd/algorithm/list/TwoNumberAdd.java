package com.w1nd.algorithm.list;

/**
 * 2. 两数相加：将两个链表对应的数相加，模拟下就好，注意进位
 */
public class TwoNumberAdd {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            int sum = 0;
            boolean carry = false;
            while (l1 != null || l2 != null) {
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                if (carry) sum += 1;
                p.next = new ListNode(sum % 10);
                if (sum > 9) carry = true;
                else carry = false;
                sum = 0;
                p = p.next;
            }
            if (carry) p.next = new ListNode(1);
            return dummy.next;
        }
    }
}
