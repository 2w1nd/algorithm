package com.w1nd.algorithm.tree;

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
            else head = cur;
            cur.left = pre;
            pre = cur;
            dfs(cur.right);
        }
    }
}
