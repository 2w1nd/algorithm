package com.w1nd.algorithm.list;

/**
 * 234.回文链表：构建快慢指针，遍历时反转前半部分链表，再同时反向遍历比较
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode pre = null; // 前置结点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null && pre != null) {
            if (slow.val != pre.val) return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
