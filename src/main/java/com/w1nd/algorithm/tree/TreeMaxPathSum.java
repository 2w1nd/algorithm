package com.w1nd.algorithm.tree;

/**
 * 124. 二叉树中的最大路径和：
 */
public class TreeMaxPathSum {
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

        int res = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return res;
        }

        public int dfs(TreeNode root) {
            if (root == null) return 0;

            int left = dfs(root.left);
            int right = dfs(root.right);

            res = Math.max(res, root.val + left + right); // 当前子树内部的最大路径和
            return Math.max(0, root.val + Math.max(left, right));  // 当前子树对外提供的最大和
        }
    }
}
