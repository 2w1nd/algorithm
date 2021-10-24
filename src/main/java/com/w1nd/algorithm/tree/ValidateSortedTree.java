package com.w1nd.algorithm.tree;

/**
 * 98. 验证二叉搜索树
 */
public class ValidateSortedTree {

     // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    class Solution {

        long min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;

        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;

            return dfs(root, min, max);
        }

        public boolean dfs(TreeNode root, long min, long max) {
            if (root == null) return true;

            if (root.val < min || root.val > max) return false;

            return dfs(root.left, min, root.val - 1L) && dfs(root.right, root.val + 1L, max);
        }
    }
}
