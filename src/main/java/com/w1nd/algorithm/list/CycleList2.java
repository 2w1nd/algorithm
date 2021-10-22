package com.w1nd.algorithm.list;

/**
 * 142. 环形链表 II：找出入口结点，先让快慢指针开始走（快指针夺走一步），相遇后将其中一个指针
 * 放到头部，再同时走，再次相遇的点就是入口结点
 */
public class CycleList2 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while (slow != null && fast != null) {
                slow = slow.next;
                fast = fast.next;
                if (fast != null) fast = fast.next;
                else return null;
                if (slow == fast) {
                    slow = head;
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return slow;
                }
            }
            return null;
        }
    }
}
