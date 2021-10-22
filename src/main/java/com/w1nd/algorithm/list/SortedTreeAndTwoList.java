package com.w1nd.algorithm.list;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表：定义双指针，cur指针先走（中序遍历）
 *
 */
public class SortedTreeAndTwoList {

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

    class Solution {
        Node pre, head;
        int cnt;
        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            dfs(root);
            pre.right = head;
            head.left = pre;
            return head;
        }

        public void dfs(Node cur) {
            if (cur == null) return ;
            dfs(cur.left);
            if (pre != null) pre.right = cur;
            else head = cur;  // 初始化链表头
            cur.left = pre;
            pre = cur;
            dfs(cur.right);
        }
    }
}
