package com.w1nd.algorithm.tree;

/**
 *  剑指 Offer 55 - II. 平衡二叉树
 */
public class BalanceTree {
     // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    class Solution {
        boolean res = true;
        public boolean isBalanced(TreeNode root) {
            dfs(root);
            return res;
        }

        public int dfs(TreeNode root) {
            if (root == null) return 0;
            int left = dfs(root.left);
            int right = dfs(root.right);
            if (Math.abs(left - right) > 1) res = false;
            return Math.max(left, right) + 1;
        }
    }
}
